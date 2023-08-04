package Kiosk_array;

import Kiosk_array.DeliveryOrder.OnDelivery;
import Kiosk_array.HereOrder.OnHere;
import Kiosk_array.TakeoutOrder.OnTakeout;;

public class Kiosk implements OnDelivery, OnHere, OnTakeout{
	public static int key = 3;
	private int inventory;
	
	
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	public Order initOrder(Menu[] menuArray, int orderType) {
		
	
		if (orderType == 1) {
			DeliveryOrder order = new DeliveryOrder(menuArray);
			order.setOnDelivery(this);
			return order;
		} else if (orderType == 2){
			TakeoutOrder order = new TakeoutOrder(menuArray);
			order.setOnTakeout(this);
			return order;
		} else {
			HereOrder order = new HereOrder(menuArray);
			order.setOnHere(this);
			return order;
		}
	}
	
	private boolean isInventory(int count) {
		if (inventory >= count) {
			return true;
		} else {
			return false;
		}
	}
		
	public void subInventory(int count) {
		inventory -= count;
	}
	
	@Override
	public void successDelivery(String locate, Menu[] menuArray) {
		System.out.print(locate + " 주소로 ");
		System.out.println(" 배달 주문이 완료 되었습니다.");
		System.out.print("주문 내역 : ");
		for(int i = 0; i < menuArray.length; i++) {
			System.out.print(menuArray[i].menu + " ");
		}
	}
	@Override
	public void successHere(int change, int orderNum, Menu[] menuArray) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.print(orderNum+ " 주문번호로 ");
		System.out.println(" 주문 완료되었습니다.");
		System.out.print("주문 내역 : ");
		for(int i = 0; i < menuArray.length; i++) {
			System.out.print(menuArray[i].menu + " ");
		}
	}
	@Override
	public void successTakeout(int change, int time, Menu[] menuArray) {
		System.out.println("잔돈 "+change+"입니다. ");
		System.out.print(time+ " 분후 ");
		System.out.println(" 포장주문 완료되었습니다.");
		System.out.print("주문 내역 : ");
		for(int i = 0; i < menuArray.length; i++) {
			System.out.print(menuArray[i].menu + " ");
		}
	}
	
}