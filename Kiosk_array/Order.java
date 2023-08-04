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
		//메뉴 배열에서 하나의 메뉴 안에 가격을 모두 더한다.
		for (int i = 0; i < menuArray.length; i++) {
			this.orderprice += menuArray[i].getMenu_price();
		}
		System.out.println(orderprice + "원 입니다.");
	}

	public int getOrderdrink_price() {
		return this.orderprice;
	}

}