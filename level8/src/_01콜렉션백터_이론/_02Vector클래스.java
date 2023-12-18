package _01콜렉션백터_이론;

import java.util.Vector;

/*
 	배열의 한계
 	- 같은 자료형만 들어갈 수 있고, 한번 선언을 하면 그 크기가 고정이된다.
 	- 가변배열 수동으로 만들었다.
 	1. 주소값을 미리 복사해놓는다.(얕은 복사)
 	2. 새로운 길이의 주소값으로 새 배열을 만든다. ->
 	3. 새로운 배열주소에서 기존에 있는 값을 반복문으로 일일히 복제해온다. => 깊은 복사
 	
 	// 가변배열을 자동으로 해주는 클래스
 	4. 콜렉션 -> 데이터를 저장하는 여러가지의 알고리즘(방법론)을 구현한 여러 클래스들의 모음집
 	
 	<> 꺽쇠를 사용해서 콜랙션 객체를 만들어서 해당 자료구조를 구현한 클래스를 사용할 수 있다.
 	꺽쇠 사용하는 것을 제네릭(generic) 이라고 부른다.
 	제네릭 안에는 무조건 클래스만 들어간다. int, double 선언 못함, Integer,Double 이렇게 값이 들어와야한다.
 	
 	
 	# 주요 기능
 	1. 추가	: add(value)
 	2. 삭제	: remove(idx) , remove(value)
 	3. 삽입	: add(idx,value)
 	4. 수정 	: set(idx,value)
 	5. 갯수 	: size
 	6. 값읽기 : get(idx)
 	7. 전체 삭제 clear();
 */



public class _02Vector클래스 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50};
		
		Vector<Integer> vector1 = new Vector<Integer>();
		
		System.out.println(arr.length);
		System.out.println(vector1.size());
		System.out.println(vector1.capacity());// 10개가 들어갈수있는 공간을 만든다.
		
		for(int i = 1; i <= 11; i+=1) {
			vector1.add(i);
		}
		
		// size(실제 배열에 들어간 갯수)와 capacity(총 들어갈 수 있는 갯수)는 다른 개념
		System.out.println(vector1.size());
		System.out.println(vector1.capacity());
		
//		Vector<String> vector2 =  new Vector<String>();
		
		System.out.println(arr[2]);
		System.out.println(vector1.get(2));
		
		System.out.println(vector1.set(2,2000));

		System.out.println(vector1.get(2));
		
		vector1.clear();
		System.out.println(vector1.size());
		System.out.println(vector1.capacity());
	}

}
