package shopcart;

import java.util.HashSet;
import java.util.Set;

public class GoodsManage {
	private Set<Goods> set = new HashSet<Goods>();//存放商品信息
	
	//Constructor
	public GoodsManage(){
		
	}

	public GoodsManage(Set<Goods> set) {
		super();
		this.set = set;
	}

	public Set<Goods> getSet() {
		return set;
	}

	public void setSet(Set<Goods> set) {
		this.set = set;
	}
	
	/**
	 * 创建商品信息并添入set集合
	 */
	public void importGoods(){
		Goods phone = new Goods("s01","手机",2000,"小米手机打电话上网和暖手");
		Goods refrigerator = new Goods("s02","冰箱",3000,"家用电器，夏天冰西瓜存冷饮");
		Goods computer = new Goods("s03","电脑",5000,"敲代码，打游戏，看美剧");
		set.add(phone);
		set.add(refrigerator);
		set.add(computer);
		
	}
	
	/**
	 * 显示所有商品的信息
	 */
	public void displayAllGoods(){
		for(Goods u:set){
			System.out.println(u);
		}
	}
}
