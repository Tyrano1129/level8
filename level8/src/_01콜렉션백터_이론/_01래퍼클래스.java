package _01콜렉션백터_이론;

/*
 	래퍼클래스(wrapper class)
 	
 	기본 자료형을 클래스로 만들어 놓은것!
 
 	기본 자료형(원시타입) 클래스타입(참조타입) 의 차이점
 	원시타입 순수하게 값을 가지고 있다 : byte short int long float double char boolean
 	참조타입 : 주소값 : 여러자료형 타입 갯수를 사용자가 원하는데로 설정이 가능하고 + 여러 기능을 추가한(메서드) 를 가질 수 있다.
 */

public class _01래퍼클래스 {

	public static void main(String[] args) {
	
		int num = 10;
		Integer num2 = 100;
		
		double dnum = 1;
		Double dnum2 = 1.0; // new double(1.0)
		
		String value = "10";
		
		// 문자 -> 숫자
		System.out.println(Integer.parseInt(value));
		System.out.println(Integer.valueOf(value));
		
	}

}
