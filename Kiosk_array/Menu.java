package Kiosk_array;

import interface_Kiosk.KioskException;

public class Menu {
	protected String[] menuArray = {"딸기요거트", "카페라떼", "밀크티", "아메리카노"};
	protected String menu;
	private int menu_price;
	
	public Menu(String menu) throws KioskException {
		
		
		
		if (menu.equals("딸기요거트")){
			menu_price = 4500;
		} else if (menu.equals("카페라떼") || menu.equals("밀크티")){
			menu_price = 3500;
		} else if (menu.equals("아메리카노")){
			menu_price = 2000;
		} 
		else {
			
			throw new KioskException("메뉴가 없습니다.", 102);	
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
