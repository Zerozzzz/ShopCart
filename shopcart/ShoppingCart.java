package shopcart;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	private Map<String,GoodsInCart> cartMap = new HashMap<String, GoodsInCart>();//�����Ʒ��Ϣ������
	
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
	 * ͨ��������Ʒ��ź���Ʒ����������Ʒ���涨��������빺�ﳵ
	 * @param goodsId
	 * @param numOfGoods
	 */
	public void addGoodsToCart(String goodsId,int numOfGoods){
		GoodsManage gm = new GoodsManage();
		gm.importGoods();
		Goods[] goodsArr = new Goods[gm.getSet().size()];
		goodsArr =gm.getSet().toArray(goodsArr);
		
		boolean flag = true;//�����ж���Ʒ����Ƿ���ȷ
		for(int i=0;i<goodsArr.length;i++){
			if(goodsId.equals(goodsArr[i].getGoodsId())){
				GoodsInCart goodsInCart = new GoodsInCart(goodsArr[i],numOfGoods);
				cartMap.put(goodsId, goodsInCart);
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("��Ʒ�������������������ȷ����Ʒ���");
		}
		
		
		
	}
	
	/**
	 * ����Ҫ�޸���������Ʒ�����������޸ĸ���Ʒ������
	 * @param goodsId
	 * @param numOfGoods
	 */
	public void updateNumOfCart(String goodsId,int numOfGoods){
		Set<String> idSet = new HashSet<String>();
		idSet = cartMap.keySet();
		for(String u:idSet){
			if(goodsId.equals(u)){
				GoodsInCart goodsInCart = cartMap.get(goodsId);
				goodsInCart.setNumberOfGoods(numOfGoods);
				cartMap.replace(goodsId, goodsInCart);
			}
		}
	}
	
	/**
	 * ��ʾ���ﳵ�е���Ʒ��Ϣ
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
			System.out.println("���ﳵ��"+u.getGoods().getGoodsName()+"������Ϊ"+
					u.getNumberOfGoods()+"\t�ܼƣ�"+temp);
			accounts +=temp;
		}
		
		
		System.out.println("����֧����"+accounts);
		
	}
	
	public static void main(String[] args){
		ShoppingCart one = new ShoppingCart();
		GoodsManage gm = new GoodsManage();
		gm.importGoods();
		gm.displayAllGoods();
		one.addGoodsToCart("s01",2);
		one.addGoodsToCart("s02",2);
		one.addGoodsToCart("s03",4);
		one.updateNumOfCart("s01", 3);
		one.displayAllInCart();
		one.settleAccounts();
	}
}
