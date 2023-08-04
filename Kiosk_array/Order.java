package Kiosk_array;

public abstract class Order {
	protected Menu[] menu;
	protected int orderprice;
	
	public Order(Menu[] menuArray) {
		this.menu = menuArray;
		this.setOrderprice(menuArray);
		
		//setOrderprice();
	}
	
	public abstract void runOrder(int deposit);
	
	
	public void setOrderprice(Menu[] menuArray) {
		//�޴� �迭���� �ϳ��� �޴� �ȿ� ������ ��� ���Ѵ�.
		for (int i = 0; i < menuArray.length; i++) {
			this.orderprice += menuArray[i].getMenu_price();
		}
		System.out.println(orderprice + "�� �Դϴ�.");
	}

	public int getOrderdrink_price() {
		return this.orderprice;
	}

}