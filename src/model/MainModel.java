package model;

public class MainModel {

	private static MainModel instance = null;
	
	static {
		if(instance == null) {
			instance = new MainModel();
		}
	}
	
	private Employee user;
	
	private MainModel() {
		user = null;
	}
	
	public static void setUser(Employee user) {
		instance.user = user;
	}

	public static Employee getUser() {
		return instance.user;
	}
}
