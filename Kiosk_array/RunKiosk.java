package Kiosk_array;

import java.util.Arrays;
import java.util.Scanner;

import interface_Kiosk.KioskException;

public class RunKiosk {
	public static void main(String[] args) {
		String menu = null;
		Menu[] menuArray;
		String temp = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("키오스크 키를 입력해주세요");
		int key = scanner.nextInt();
		try {
			if (Kiosk.key == key) {
				System.out.println("재고개수를 입력해주세요");
				int inventory = scanner.nextInt();

				Kiosk kiosk = new Kiosk(inventory);

				System.out.println("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요");
				int orderCode = scanner.nextInt();

				int count = 0;
				String[] arr = new String[10];

				for (int j = 0; j < 10; j++) {

					System.out.println("메뉴 또는 주문을 입력해주세요");
					menu = scanner.next();
					arr[j] = menu;
					

					if (menu.equals("종료")) {
						System.out.println("프로그램을 종료 합니다.");
						break;
					} else if (menu.equals("주문")) {
						break;
					}
					Menu menus = new Menu(menu);
					count++;
				}
				menuArray = new Menu[count];

				System.out.println(Arrays.toString(arr));
		
				for (int i = 0; i < count; i++) {
					Menu menus = new Menu(arr[i]);
					menuArray[i] = menus;
				}

				System.out.println(count);
				System.out.println(menuArray.length);
				for (int i = 0; i < menuArray.length; i++) {
					System.out.println(menuArray[i].toString() + " ");

				}

				Order order = kiosk.initOrder(menuArray, orderCode);

				int deposit = scanner.nextInt();
				if (orderCode == 1) {
					System.out.println("주소를 입력해주세요");
					String locate = scanner.next();
					((DeliveryOrder) order).setLocate(locate);
				} else if (orderCode == 2) {
					System.out.println("포장시간을 입력해주세요");
					int time = scanner.nextInt();
					((TakeoutOrder) order).setTime(time);
				} else {
					System.out.println("주문번호를 입력해주세요");
					int orderNum = scanner.nextInt();
					((HereOrder) order).setOrderNum(orderNum);
				}
				order.runOrder(deposit);

			} else {
				System.out.println("키오스크 키가 맞지 않습니다.");
			}
		} catch (KioskException e) {
			System.out.println(e.getMessage() + e.getErrorCode());
		
		}
		scanner.close();
	}

}