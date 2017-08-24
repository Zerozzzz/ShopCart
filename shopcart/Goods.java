package shopcart;

public class Goods {
	//商品属性
	private String goodsId;//商品编号
	private String goodsName;//商品名称
	private double price;//商品价格
	private String goodsDesp;//商品描述
	
	//Constructor
	public Goods(){
		
	}
	
	public Goods(Goods goods){
		this.goodsId = goods.getGoodsId();
		this.goodsName = goods.getGoodsName();
		this.price = goods.getPrice();
		this.goodsDesp = goods.getGoodsDesp();
	}

	public Goods(String goodsId, String goodsName, double price, String goodsDesp) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.goodsDesp = goodsDesp;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoodsDesp() {
		return goodsDesp;
	}

	public void setGoodsDesp(String goodsDesp) {
		this.goodsDesp = goodsDesp;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDesp == null) ? 0 : goodsDesp.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (goodsDesp == null) {
			if (other.goodsDesp != null)
				return false;
		} else if (!goodsDesp.equals(other.goodsDesp))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	public String toString(){
		return "商品的编号："+this.goodsId+"\t商品的名称："+this.goodsName+
				"\t商品的价格"+this.price+"\t"+this.goodsDesp;
	}
}
