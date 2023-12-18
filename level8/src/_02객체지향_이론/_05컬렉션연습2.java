package _02객체지향_이론;

import java.util.ArrayList;

public class _05컬렉션연습2 {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int size = 3;
		int num = 1;
		for(int i = 0; i < size;i+=1) {
			list.add(new ArrayList<Integer>());
			for(int k = 0; k < size; k+=1) {
				list.get(i).add(num++);
			}
		}
		
		for(int i = 0; i < size; i+=1) {
			for(int k = 0; k < size; k+=1) {
				System.out.print(list.get(i).get(k)+" ");
			}
			System.out.println();
		}
	}

}
