package design.structure.proxy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
/**
 * 用Java反射机制来调用private方法
 * @author WalkingDog
 *
 */
 
public class Reflect {
	
	public static void main(String[] args) throws Exception {
		
		//直接创建对象
		Person person = new Person();
		
		Class<?> personType = person.getClass();
		
		//访问私有方法
		//getDeclaredMethod可以获取到所有方法，而getMethod只能获取public
		Method method = personType.getDeclaredMethod("say", String.class);
		
		//压制Java对访问修饰符的检查
		method.setAccessible(true);
		
		//调用方法;person为所在对象
		method.invoke(person, "Hello World !");
		
		//访问私有属性
		Field field = personType.getDeclaredField("name");
		
		field.setAccessible(true);
		
		//为属性设置值;person为所在对象
		field.set(person, "WalkingDog");
		
		System.out.println("The Value Of The Field is : " + person.getName());
		
	}
}
