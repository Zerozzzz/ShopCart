package shopcart;

public class GoodsInCart {
	private Goods goods;//��Ʒ��Ϣ
	private int numberOfGoods;//���ﳵ�еĵ�����Ʒ����
	
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
