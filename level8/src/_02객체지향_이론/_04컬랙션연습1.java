package _02객체지향_이론;

import java.util.ArrayList;

public class _04컬랙션연습1 {

	public static void main(String[] args) {
		
		// 클래스 ==> 참조형 자료타입 ==> 주소값을 가지고있다.
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		for(int i = 0; i < 3; i+=1) {
			list.add(new int[3]);
		}
		int num = 1;
		for(int i =0; i < 3; i+=1) {
			for(int k = 0; k < 3; k+=1) {
				list.get(i)[k] = num++;
			}
		}
		for(int i =0; i < 3; i+=1) {
			for(int k = 0; k < 3; k+=1) {
				System.out.print(list.get(i)[k] + " ");
			}
			System.out.println();
		}
	}

}
