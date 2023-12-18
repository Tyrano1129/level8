package _02객체지향_이론;

import java.util.Calendar;

// 싱긅톤 패턴(코드 반복적인 규칙)이란

// 해당 클래스의 인스턴스를 단 한번만 생성하게 만드는 것

// (1) 생성자를 private 으로 만든다 -> 외부 클래스에서 객체 생성이 안된다.
// (2) 내부에서 객체를 한개 만든다 static 해당 클래스 변수를 만든다 => 해당 클래스 객체 외부 클래스에서 클래스 이름으로 접근가능
// (3) instance 객체를 캡슐화 한다
class Test06{
	private int num = 100;
	private Test06() {
	}
	public static Test06 instance = new Test06();
	public static Test06 getInstance() {
		return instance;
	}
	public int getNum() {
		return num;
	}
}

public class _10싱글톤객체 {

	public static void main(String[] args) {
		
//		Test06 t = new Test06();// 인스턴스 변수는 new를 하지않으면 접근이 불가능
		Test06 t = Test06.getInstance();
		System.out.println(t.getNum());
		
		Calendar calendar = Calendar.getInstance();
	}

}
