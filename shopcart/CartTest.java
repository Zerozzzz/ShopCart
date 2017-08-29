package shopcart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CartTest {

	public static void main(String[] args) {
		//Create object of Scanner
				Scanner console = new Scanner(System.in);
				
		//�������󣬵���displayGoodsManageMenu()
		CartTest cart = new CartTest();
		boolean hasImport = false;
		int controlMenu = 1;//�������˵���ָ��
		//סѭ����
		do{
			cart.displayMenu();
			System.out.println("�������Ӧ�����ֽ��в���");
			try{
				controlMenu = console.nextInt();
			}catch(InputMismatchException e){
				System.out.println("��������ֵ��");
				String str = console.next();
				continue;
			}
			if(controlMenu==1){
				int contolGoodsMenu = 0;//������Ʒ�����ָ��
				GoodsManage gm = new GoodsManage();
				
				//��Ʒ����ѭ����
				while(contolGoodsMenu!=9){
					cart.displayGoodsManageMenu();
					System.out.println("�������Ӧ�����ֽ��в���");
					
					try{
						contolGoodsMenu = console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("��������ֵ��");
						String str = console.next();
						continue;
					}
					if(contolGoodsMenu==1){
						gm.importGoods();
						hasImport = true;
						System.out.println("��Ʒ��Ϣ����ɹ�\n");
					}else if(contolGoodsMenu==2){
						if(hasImport){
							gm.displayAllGoods();
						}else{
							System.out.println("���ȵ�����Ʒ��Ϣ\n");
						}
					}else if(contolGoodsMenu==9){
						
					}else{
						System.out.println("�������������밴��ʾ����\n");
						continue;
					}
				}
				continue;//������Ϊ9ʱ��������ѭ��
				
			}else if(controlMenu==2){
				if(!hasImport){
					System.out.println("��������Ʒ�����е�����Ʒ��Ϣ\n");
					continue;
				}
				int controlCartMenu = 0;
				ShoppingCart sc = new ShoppingCart();//����ShoppingCart�Ķ���sc
				
				//���ﳵ�����ѭ����
				while(controlCartMenu!=9){
					cart.displayShoppingCartMenu();
					System.out.println("�������Ӧ�����ֽ��в���");
					
					try{
						controlCartMenu = console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("��������ֵ��");
						String str = console.next();
						continue;
					}
					String goodsId;
					int numOfGoods;
					if(controlCartMenu==1){
						System.out.println("������Ҫ���빺�ﳵ����Ʒ���");
						goodsId = console.next();
						System.out.println("������Ҫ��ӵ���Ʒ����");
						
						try{
							numOfGoods = console.nextInt();
						}catch(InputMismatchException e){
							System.out.println("��������ֵ��");
							String str = console.next();
							continue;
						}
						sc.addGoodsToCart(goodsId, numOfGoods);
					}else if(controlCartMenu==2){
						if(sc.getCartMap().isEmpty()){
							System.out.println("���ﳵΪ�գ����������Ʒ\n");
							continue;
						}else{
							System.out.println("������Ҫ�޸���������Ʒ���");
							goodsId = console.next();
							System.out.println("������Ҫ�޸ĵ�����");
							
							try{
								numOfGoods = console.nextInt();
							}catch(InputMismatchException e){
								System.out.println("��������ֵ��");
								String str = console.next();
								continue;
							}
							sc.updateNumOfCart(goodsId, numOfGoods);
						}
					}else if(controlCartMenu==3){
						if(sc.getCartMap().isEmpty()){
							System.out.println("���ﳵΪ�գ����������Ʒ\n");
							continue;
						}else{
							sc.displayAllInCart();
						}
					}else if(controlCartMenu==4){
						if(sc.getCartMap().isEmpty()){
							System.out.println("���ﳵΪ�գ����������Ʒ");
							continue;
						}else{
							sc.settleAccounts();
						}
					}else if(controlCartMenu==9){
						
					}else{
						System.out.println("�������������밴��ʾ����\n");
						continue;
					}
				}
				continue;//������Ϊ9ʱ��������ѭ��
			}else if(controlMenu==0){
				break;
			}else{
				System.out.println("�������������밴��ʾ����\n");
				continue;
			}
		}while(controlMenu!=0);
		console.close();
		System.out.println("�������н���");
	}
	
	public void displayMenu(){
		System.out.println("**************************************\n"+
							"            ***���˵�***\n"+
							"              1--��Ʒ����\n"+
							"              2--���ﳵ\n"+
							"              0--�˳�\n"+
							"**************************************\n");
	}
	
	public void displayGoodsManageMenu(){
		System.out.println("**************************************\n"+
							"            ***��Ʒ����***\n"+
							"              1--��Ʒ��Ϣ����\n"+
							"              2--��ʾ������Ʒ��Ϣ\n"+
							"              9--������һ��\n"+
							"**************************************\n");
	}
	
	public void displayShoppingCartMenu(){
		System.out.println("**************************************\n"+
							"            ***���ﳵ����***\n"+
							"              1--�����Ʒ�����ﳵ\n"+
							"              2--�޸Ĺ��ﳵ����Ʒ����\n"+
							"              3--��ʾ���ﳵ�е���Ʒ��Ϣ\n"+
							"              4--����\n"+
							"              9--������һ��\n"+
							"**************************************\n");
	}

}
