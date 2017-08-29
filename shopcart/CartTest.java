package shopcart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CartTest {

	public static void main(String[] args) {
		//Create object of Scanner
				Scanner console = new Scanner(System.in);
				
		//创建对象，调用displayGoodsManageMenu()
		CartTest cart = new CartTest();
		boolean hasImport = false;
		int controlMenu = 1;//控制主菜单的指令
		//住循环体
		do{
			cart.displayMenu();
			System.out.println("请输入对应的数字进行操作");
			try{
				controlMenu = console.nextInt();
			}catch(InputMismatchException e){
				System.out.println("请输入数值型");
				String str = console.next();
				continue;
			}
			if(controlMenu==1){
				int contolGoodsMenu = 0;//控制商品管理的指令
				GoodsManage gm = new GoodsManage();
				
				//商品管理循环体
				while(contolGoodsMenu!=9){
					cart.displayGoodsManageMenu();
					System.out.println("请输入对应的数字进行操作");
					
					try{
						contolGoodsMenu = console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("请输入数值型");
						String str = console.next();
						continue;
					}
					if(contolGoodsMenu==1){
						gm.importGoods();
						hasImport = true;
						System.out.println("商品信息导入成功\n");
					}else if(contolGoodsMenu==2){
						if(hasImport){
							gm.displayAllGoods();
						}else{
							System.out.println("请先导入商品信息\n");
						}
					}else if(contolGoodsMenu==9){
						
					}else{
						System.out.println("输入数字有误，请按提示输入\n");
						continue;
					}
				}
				continue;//当输入为9时，返回外循环
				
			}else if(controlMenu==2){
				if(!hasImport){
					System.out.println("请先在商品管理中导入商品信息\n");
					continue;
				}
				int controlCartMenu = 0;
				ShoppingCart sc = new ShoppingCart();//创建ShoppingCart的对象sc
				
				//购物车管理的循环体
				while(controlCartMenu!=9){
					cart.displayShoppingCartMenu();
					System.out.println("请输入对应的数字进行操作");
					
					try{
						controlCartMenu = console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("请输入数值型");
						String str = console.next();
						continue;
					}
					String goodsId;
					int numOfGoods;
					if(controlCartMenu==1){
						System.out.println("请输入要加入购物车的商品编号");
						goodsId = console.next();
						System.out.println("请输入要添加的商品数量");
						
						try{
							numOfGoods = console.nextInt();
						}catch(InputMismatchException e){
							System.out.println("请输入数值型");
							String str = console.next();
							continue;
						}
						sc.addGoodsToCart(goodsId, numOfGoods);
					}else if(controlCartMenu==2){
						if(sc.getCartMap().isEmpty()){
							System.out.println("购物车为空，请先添加商品\n");
							continue;
						}else{
							System.out.println("请输入要修改数量的商品编号");
							goodsId = console.next();
							System.out.println("请输入要修改的数量");
							
							try{
								numOfGoods = console.nextInt();
							}catch(InputMismatchException e){
								System.out.println("请输入数值型");
								String str = console.next();
								continue;
							}
							sc.updateNumOfCart(goodsId, numOfGoods);
						}
					}else if(controlCartMenu==3){
						if(sc.getCartMap().isEmpty()){
							System.out.println("购物车为空，请先添加商品\n");
							continue;
						}else{
							sc.displayAllInCart();
						}
					}else if(controlCartMenu==4){
						if(sc.getCartMap().isEmpty()){
							System.out.println("购物车为空，请先添加商品");
							continue;
						}else{
							sc.settleAccounts();
						}
					}else if(controlCartMenu==9){
						
					}else{
						System.out.println("输入数字有误，请按提示输入\n");
						continue;
					}
				}
				continue;//当输入为9时，返回外循环
			}else if(controlMenu==0){
				break;
			}else{
				System.out.println("输入数字有误，请按提示输入\n");
				continue;
			}
		}while(controlMenu!=0);
		console.close();
		System.out.println("程序运行结束");
	}
	
	public void displayMenu(){
		System.out.println("**************************************\n"+
							"            ***主菜单***\n"+
							"              1--商品管理\n"+
							"              2--购物车\n"+
							"              0--退出\n"+
							"**************************************\n");
	}
	
	public void displayGoodsManageMenu(){
		System.out.println("**************************************\n"+
							"            ***商品管理***\n"+
							"              1--商品信息导入\n"+
							"              2--显示所有商品信息\n"+
							"              9--返回上一级\n"+
							"**************************************\n");
	}
	
	public void displayShoppingCartMenu(){
		System.out.println("**************************************\n"+
							"            ***购物车管理***\n"+
							"              1--添加商品到购物车\n"+
							"              2--修改购物车中商品数量\n"+
							"              3--显示购物车中的商品信息\n"+
							"              4--结算\n"+
							"              9--返回上一级\n"+
							"**************************************\n");
	}

}
