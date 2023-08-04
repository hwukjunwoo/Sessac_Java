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
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key = scanner.nextInt();
		try {
			if (Kiosk.key == key) {
				System.out.println("������� �Է����ּ���");
				int inventory = scanner.nextInt();

				Kiosk kiosk = new Kiosk(inventory);

				System.out.println("1.��� 2.���� 3.���� �ֹ���� ��ȣ�� �Է����ּ���");
				int orderCode = scanner.nextInt();

				int count = 0;
				String[] arr = new String[10];

				for (int j = 0; j < 10; j++) {

					System.out.println("�޴� �Ǵ� �ֹ��� �Է����ּ���");
					menu = scanner.next();
					arr[j] = menu;
					

					if (menu.equals("����")) {
						System.out.println("���α׷��� ���� �մϴ�.");
						break;
					} else if (menu.equals("�ֹ�")) {
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
					System.out.println("�ּҸ� �Է����ּ���");
					String locate = scanner.next();
					((DeliveryOrder) order).setLocate(locate);
				} else if (orderCode == 2) {
					System.out.println("����ð��� �Է����ּ���");
					int time = scanner.nextInt();
					((TakeoutOrder) order).setTime(time);
				} else {
					System.out.println("�ֹ���ȣ�� �Է����ּ���");
					int orderNum = scanner.nextInt();
					((HereOrder) order).setOrderNum(orderNum);
				}
				order.runOrder(deposit);

			} else {
				System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
			}
		} catch (KioskException e) {
			System.out.println(e.getMessage() + e.getErrorCode());
		
		}
		scanner.close();
	}

}