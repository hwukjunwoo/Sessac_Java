package Kiosk_array;

public class HereOrder extends Order{
	private OnHere onHere;
	private int orderNum;
	
	interface OnHere{
		void successHere(int change, int orderNum, Menu[] menuArray);
	}
	
	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public HereOrder(Menu[] menuArray) {
		super(menuArray);
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderprice;
		if (change >= 0) {
			onHere.successHere(change, orderNum, menu);
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
}