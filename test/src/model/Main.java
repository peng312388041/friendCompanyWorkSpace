package model;

public class Main extends Person {
	public static final int a = 1;
	
	public static void main(String[] args) {
		System.out.println(new Main().getClass().getSuperclass().getName());
	}

	public String test() {
		return getClass().getName();
	}
}
