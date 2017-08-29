package shopcart;

import java.util.HashSet;
import java.util.Set;

public class GoodsManage {
	private Set<Goods> set = new HashSet<Goods>();//�����Ʒ��Ϣ
	
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
	 * ������Ʒ��Ϣ������set����
	 */
	public void importGoods(){
		Goods phone = new Goods("s01","�ֻ�",2000,"С���ֻ���绰������ů��");
		Goods refrigerator = new Goods("s02","����",3000,"���õ�������������ϴ�����");
		Goods computer = new Goods("s03","����",5000,"�ô��룬����Ϸ��������");
		set.add(phone);
		set.add(refrigerator);
		set.add(computer);
		
	}
	
	/**
	 * ��ʾ������Ʒ����Ϣ
	 */
	public void displayAllGoods(){
		for(Goods u:set){
			System.out.println(u);
		}
	}
}
