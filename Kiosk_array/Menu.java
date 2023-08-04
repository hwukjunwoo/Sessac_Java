package Kiosk_array;

import interface_Kiosk.KioskException;

public class Menu {
	protected String[] menuArray = {"������Ʈ", "ī���", "��ũƼ", "�Ƹ޸�ī��"};
	protected String menu;
	private int menu_price;
	
	public Menu(String menu) throws KioskException {
		
		
		
		if (menu.equals("������Ʈ")){
			menu_price = 4500;
		} else if (menu.equals("ī���") || menu.equals("��ũƼ")){
			menu_price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")){
			menu_price = 2000;
		} 
		else {
			
			throw new KioskException("�޴��� �����ϴ�.", 102);	
		}
	
		this.menu = menu;
		
	}

	@Override
	public String toString() {
		return "Menu [menu=" + menu + ", menu_price=" + menu_price + "]";
	}

	public int getMenu_price() {
		return menu_price;
	}

	
	
}
