package _01콜렉션백터_이론;

import java.util.Arrays;
import java.util.Vector;

public class _04백터주의사항 {

	public static void main(String[] args) {
		
		int[] arr = {1,1,3,2,2,3,3,4,4,5,5,4};
		
		Vector<Integer> list = new Vector<Integer>();
		
		for(int num : arr) {
			list.add(num);
		}
		for(int i =0; i < list.size(); i+=1) {
			if(list.get(i) == 3) {
				list.remove(i);
				i-=1;
			}
		}
		
		System.out.println(list.toString());

	}

}
