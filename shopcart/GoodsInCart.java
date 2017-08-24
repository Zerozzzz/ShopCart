package shopcart;

public class GoodsInCart {
	private Goods goods;//商品信息
	private int numberOfGoods;//购物车中的单种商品数量
	
	//Constructor
	public GoodsInCart(){
		
	}

	public GoodsInCart(Goods goods, int numberOfGoods) {
		super();
		this.goods = goods;
		this.numberOfGoods = numberOfGoods;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getNumberOfGoods() {
		return numberOfGoods;
	}

	public void setNumberOfGoods(int numberOfGoods) {
		this.numberOfGoods = numberOfGoods;
	}

	@Override
	public String toString() {
		return "GoodsInCart [goods=" + goods + ", numberOfGoods=" + numberOfGoods + "]";
	}
	
}
