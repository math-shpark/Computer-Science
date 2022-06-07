package chapter01;

import java.util.ArrayList;
import java.util.List;

interface Card {
	public void pay(int amount);
}

class HanaCard implements Card {
	private String name, cardNumber, cvv, dateOfExpire;

	public HanaCard(String name, String cardNumber, String cvv, String dateOfExpire) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpire = dateOfExpire;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid by HanaCard");
	}

}

class KbCard implements Card {
	private String name, cardNumber, cvv, dateOfExpire;

	public KbCard(String name, String cardNumber, String cvv, String dateOfExpire) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpire = dateOfExpire;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid by KbCard");
	}

}

class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

class Pocket {
	List<Item> items;

	public Pocket() {
		this.items = new ArrayList<Item>();
	}

	public void inputItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calPrice() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}

		return sum;
	}

	public void pay(Card card) {
		int amount = calPrice();
		card.pay(amount);
	}
}

public class Ex_strategy {

	public static void main(String[] args) {
		Pocket pocket = new Pocket();

		Item apple = new Item("Apple", 10000);
		Item peach = new Item("Peach", 15000);

		pocket.inputItem(apple);
		pocket.inputItem(peach);

		pocket.pay(new HanaCard("hong", "11111111", "777", "01/01")); // 25000 paid by HanaCard
		pocket.pay(new KbCard("hong", "22222222", "777", "01/01")); // 25000 paid by KbCard
	}
}
