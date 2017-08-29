package shopcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	private Map<String,GoodsInCart> cartMap = new HashMap<String, GoodsInCart>();//存放商品信息和数量
	
	//Constructor
	public ShoppingCart(){
		
	}

	public ShoppingCart(Map<String, GoodsInCart> cartMap) {
		super();
		this.cartMap = cartMap;
	}

	public Map<String, GoodsInCart> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, GoodsInCart> cartMap) {
		this.cartMap = cartMap;
	}
	
	
	/**
	 * 通过输入商品编号和商品数量将，商品按规定数量添加入购物车
	 * @param goodsId
	 * @param numOfGoods
	 */
	public void addGoodsToCart(String goodsId,int numOfGoods){
		GoodsManage gm = new GoodsManage();
		gm.importGoods();
		Goods[] goodsArr = new Goods[gm.getSet().size()];
		goodsArr =gm.getSet().toArray(goodsArr);
		
		boolean flag = true;//用于判断商品编号是否正确
		for(int i=0;i<goodsArr.length;i++){
			if(goodsId.equals(goodsArr[i].getGoodsId())){
				GoodsInCart goodsInCart = new GoodsInCart(goodsArr[i],numOfGoods);
				cartMap.put(goodsId, goodsInCart);
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("商品编号输入有误，请输入正确的商品编号");
		}else{
			this.displayAllInCart();
		}
		
		
		
	}
	
	/**
	 * 输入要修改数量的商品和数量，来修改该商品的数量
	 * @param goodsId
	 * @param numOfGoods
	 */
	public void updateNumOfCart(String goodsId,int numOfGoods){
		boolean exist = false;
		
		Set<String> idSet = new HashSet<String>();
		idSet = cartMap.keySet();
			
		for (String u : idSet) {
			if (goodsId.equals(u)) {
				exist = true;
				if(numOfGoods==0){
//					Map<String,GoodsInCart> map = new HashMap<String,GoodsInCart>();
					cartMap.remove(goodsId, cartMap.get(goodsId));
					System.out.println("该商品已经删除！");
					this.displayAllInCart();
				}else{
					GoodsInCart goodsInCart = cartMap.get(goodsId);
					goodsInCart.setNumberOfGoods(numOfGoods);
					cartMap.replace(goodsId, goodsInCart);
				}
			}
		}
		
		if(!exist){
			System.out.println("该商品不存在，请先加入购物车");	
		}
		
		
	}
	
	/**
	 * 显示购物车中的商品信息
	 */
	public void displayAllInCart(){
		Iterator<GoodsInCart> it = cartMap.values().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void settleAccounts(){
		Collection<GoodsInCart> goodsInCartSet = cartMap.values(); 
		double accounts = 0;
		
		for(GoodsInCart u:goodsInCartSet){	
			double temp = u.getNumberOfGoods() * u.getGoods().getPrice();
			System.out.println("购物车中"+u.getGoods().getGoodsName()+"的数量为"+
					u.getNumberOfGoods()+"\t总计："+temp);
			accounts +=temp;
		}
		
		
		System.out.println("共需支付："+accounts);
		cartMap.clear();
		System.out.println("购物车已清空，快来添加商品吧！");
	}
	
	
}
