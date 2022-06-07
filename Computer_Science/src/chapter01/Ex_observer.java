package chapter01;

import java.util.ArrayList;
import java.util.List;

interface Subject {
	public void follow(Observer obj);

	public void unfollow(Observer obj);

	public void notifyObj();

	public Object getUpdate(Observer obj);
}

interface Observer {
	public void update();
}

class Topic implements Subject {
	private List<Observer> observers;
	private String msg;

	public Topic() {
		this.observers = new ArrayList<>();
		this.msg = "";
	}

	@Override
	public void follow(Observer obj) {
		if (!observers.contains(obj))
			observers.add(obj);
	}

	@Override
	public void unfollow(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObj() {
		this.observers.forEach(Observer::update);
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.msg;
	}

	public void sendMsg(String msg) {
		System.out.println("Message sended to Topic: " + msg);
		this.msg = msg;
		notifyObj();
	}
}

class TopicFollower implements Observer {
	private String name;
	private Subject topic;

	public TopicFollower(String name, Subject topic) {
		this.name = name;
		this.topic = topic;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		System.out.println(name + ":: got message >> " + msg);
	}
}

public class Ex_observer {
	public static void main(String[] args) {
		Topic topic = new Topic();

		Observer a = new TopicFollower("a", topic);
		Observer b = new TopicFollower("b", topic);
		Observer c = new TopicFollower("c", topic);

		topic.follow(a);
		topic.follow(b);
		topic.follow(c);

		topic.sendMsg("Hello followers!!"); // Message sended to Topic: Hello followers!!

		// a:: got message >> Hello followers!!
		// b:: got message >> Hello followers!!
		// c:: got message >> Hello followers!!
	}
}
