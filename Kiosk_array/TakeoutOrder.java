package Kiosk_array;

public class TakeoutOrder extends Order{
	private OnTakeout onTakeout;
	private int time;
	
	interface OnTakeout{
		void successTakeout(int change, int time, Menu[] menuArray);
	}
	
	public void setOnTakeout(OnTakeout onTakeout) {
		this.onTakeout = onTakeout;
	}
	
	public TakeoutOrder(Menu[] menuArray) {
		super(menuArray);
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderprice;
		if (change >= 0) {
			onTakeout.successTakeout(change, time, menu);
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
		}
	}
	
	@Override
	public void setOrderprice(Menu[] menuArray) {
		for (int i = 0; i < menuArray.length; i++) {
			this.orderprice += menuArray[i].getMenu_price();
		}
		this.orderprice = orderprice + -500;
		System.out.print("����ũ �ƿ��� 500�� ���εǾ� ");
		System.out.println(orderprice + "�� �Դϴ�.");
	}
}