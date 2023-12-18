package _02객체지향_이론;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Test05{
	private int a;
	private int b;
	private String c;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Test05 [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	
}
public class _09클래스정보 {

	public static void main(String[] args) {
		
		Test05 test = new Test05();
		
		System.out.println(test.getClass().getName());// 풀네임 : 패키지 + 클래스
		System.out.println(test.getClass().getSimpleName()); // 클래스 네임
		System.out.println(test.getClass().getPackageName());// 패키지 네임
		//? 컴파일에서 타입이 결정되는게 아니라 런타임에서 타입이 결정된다.
		Class<?> myClass;
		try {							//"_02객체지향_이론.Test05.java"
			myClass = Class.forName(test.getClass().getName());
			for(Method method : myClass.getDeclaredMethods()) {
				System.out.println(method.getName());
			}
			System.out.println("=========================");
			for(Field field : myClass.getDeclaredFields()) {
				System.out.println(field.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
