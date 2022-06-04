package chapter01;

class Singleton {
	private static class singleInstanceHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static synchronized Singleton getInstance() {
		return singleInstanceHolder.INSTANCE;
	}
}

public class Ex_singleton {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		System.out.println(obj1 == obj2); // true
	}

}
