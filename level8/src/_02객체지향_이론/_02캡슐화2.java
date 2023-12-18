package _02객체지향_이론;
//캡슐화 : 은닉화 : 숨긴다
//1. 변수는 private 키워드를 붙인다
//2. public getter() setter() 를 만들어서 해당 변수의 간접 접근 메서드를 만든다.
//alt + shift + s,r => 메서드 자동완성 단축키
class Test02{
	private int a;
	private int b;
	private int result;
	
	public Test02(int a, int b) {
		this.a = a;
		this.b = b;
	}
	// 다른 클래스에게 값을 줄때
	public int getA() {
		return a;
	}
	public void setA(int a) {
		if(a < 0) {
			System.out.println("a를 값을 0보다 큰값을 넣으세요");
			this.a = 1;
			return;
		}
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	public void addSum() {
		result = a+b;
	}
	
	
}
public class _02캡슐화2 {

	public static void main(String[] args) {
		
		Test02 t = new Test02(10,20);
		t.setA(-123123);
		t.addSum();
		System.out.println(t.getResult());

	}

}
