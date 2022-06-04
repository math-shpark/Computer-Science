package chapter01;

abstract class Car {
	public abstract int getPrice();

	@Override
	public String toString() {
		return "This car is " + this.getPrice();
	}
}

class CarFactory {
	public static Car getCar(String type, int price) {
		if ("Hyundai".equalsIgnoreCase(type))
			return new Hyundai(price);
		else if ("Kia".equalsIgnoreCase(type))
			return new Kia(price);
		else
			return new Bmw();
	}
}

class Bmw extends Car {
	private int price;

	public Bmw() {
		this.price = 100;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}

class Hyundai extends Car {
	private int price;

	public Hyundai(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}

class Kia extends Car {
	private int price;

	public Kia(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}

public class Ex_factory {

	public static void main(String[] args) {
		Car hCar = CarFactory.getCar("Hyundai", 5000);
		Car kCar = CarFactory.getCar("Kia", 3000);

		System.out.println("Hyundai Car : " + hCar); // Hyundai Car : This car is 5000
		System.out.println("Kia Car : " + kCar); // Kia Car : This car is 3000
	}

}
