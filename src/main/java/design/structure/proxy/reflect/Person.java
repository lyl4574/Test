package design.structure.proxy.reflect;

class Person {
	private String name;

	//每个JavaBean都应该实现无参构造方法
	public Person() {
	}

	public String getName() {
		return name;
	}

	private void say(String message) {
		System.out.println("You want to say : " + message);
	}
}
