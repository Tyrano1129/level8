package _02객체지향_이론;
//heap : new 한 모든 것 : GC(갈비지 콜렉터) 쓰레기값을 삭제를 자동으로 해준다
//stack : 메서드의 메모리방(지역변수) : 호출한 순으로 스텍 알고리즘을 사용해서 메모리 저장 : 맨 처음에 호출(main()) 한게 맨 마지막에 사라진다
//static : 프로그램이 시작하자마자 새성되고 프로그램이 종료되면 삭제된다 : 같은 클래스로 만든 인스턴스변수(객체)는 static 자원을 공유한다.

// 변수의 개념
// 지역변수	(local variable) : 클래스안에 메서드 안에서 생성된(선언된) 변수
// 멤버변수 - 인스턴스 변수(non-static variable) : new 할때마다 heap 메모리방에 생성되는 변수 : 인스턴스(객체)마다 생성된다. ==> 1. 인스턴스변수이름
//       - 클래스변수(static variable) : 미리 프로그램 시작할때 생성이 된다. 같은 인스턴스 객체들이 이 값을 공유한다. ==> 1. 인스턴스변수이름 , 2.클래스 이름

class Test01{ //설계도 new할때만 
	public int a; // 인스턴스 변수
	static public int b; // 클래스 변수(이탈릭체)
	
	public Test01(int a,int b) {
		this.b = b;
		this.a = a;
	}
	
	public void print1() {
		System.out.println(a + " " + b);
	}
	// static 메서드는 맴버변수 중에 스테틱 변수만 참조할 수 있다!!
	// 객체를 만들지 않고 클래스 이름으로  메서드
	static public void print2() {
		System.out.println(b);
	}
}

public class _06스테틱1 {

	public static void main(String[] args) {
		Test01 t1 = new Test01(10,20);
		t1.print1();
		t1.a = 100; // 객체를 생성 후에만 사용가능하다
		t1.b = 200;
		//인스턴스 이름(객체 이름)으로 호출
		t1.print2(); // 스테틱 메서드는 이탈리체(기울어짐체) 로 표시해준다
		System.out.println(t1.a);
		System.out.println(Test01.b);
	}

}
