package Kiosk_array;

public class DeliveryOrder extends Order{
	private OnDelivery onDelivery;
	private String locate;
	
	interface OnDelivery{
		void successDelivery(String locate, Menu[] menuArray);
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public DeliveryOrder(Menu[] menuArray) {
		super(menuArray);
	}
	
	public void setLocate(String locate) {
		this.locate =locate;
	}
	
	
	@Override
	public void runOrder(int deposit) {
		int change = deposit - orderprice;
		if (change == 0) {
			onDelivery.successDelivery(locate, menu);
		} else {
			System.out.println("금액이 맞지 않습니다.");
		}
	}
	
	@Override
	public void setOrderprice(Menu[] menuArray) {
		for (int i = 0; i < menuArray.length; i++) {
			this.orderprice += menuArray[i].getMenu_price();
		}
		this.orderprice =  orderprice + 3000;
		System.out.print("배달비 3000원 추가되어 ");
		System.out.println(orderprice + "원 입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제해주세요");
	}

}