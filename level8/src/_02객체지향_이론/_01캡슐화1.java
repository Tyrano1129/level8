package _02객체지향_이론;
class Test{
	private int a;//같은 클래스 내부에서만 보여준다
	int b; // 접근 제어자를 표시하지않는것은 권장하지않는다.
	
	Test(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	private void print() {
		System.out.println(a + " : " + b);
	}
}
public class _01캡슐화1 {

	public static void main(String[] args) {
		
		// 접근제어자
		// public , default(pakage), protected, private
		// 1. public(공동의) : 프로젝트 안에서 어디든 접근 가능
		// 2. default(기본) : 같은 패키지내부에서만 접근가능, 다른 패키지에서 접근 불가능
		// 3. protected : 부모 자식간에만 접근 가능
		// 4. private : 본인 클래스에서만 접근 가능
		
		Test t = new Test(10,20);
		//System.out.println(t.a); private 변수는 직접 접근(값을 꺼내오고, 값을 수정하고것)
		//t.print();
	}

}
