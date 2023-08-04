package Kiosk_array;

public class KioskException extends Exception{
	private int code;
	
	public int getErrorCode() {
		return this.code;
	}
	public KioskException(String message, int code) {
		super(message);
		this.code = code;
	}
	

}
