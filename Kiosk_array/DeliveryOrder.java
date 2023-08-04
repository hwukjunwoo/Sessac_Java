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
			System.out.println("�ݾ��� ���� �ʽ��ϴ�.");
		}
	}
	
	@Override
	public void setOrderprice(Menu[] menuArray) {
		for (int i = 0; i < menuArray.length; i++) {
			this.orderprice += menuArray[i].getMenu_price();
		}
		this.orderprice =  orderprice + 3000;
		System.out.print("��޺� 3000�� �߰��Ǿ� ");
		System.out.println(orderprice + "�� �Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� �������ּ���");
	}

}