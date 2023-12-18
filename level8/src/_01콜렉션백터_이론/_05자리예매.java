package _01콜렉션백터_이론;

import java.util.Scanner;
import java.util.Vector;

class Seat{
	int num;
	boolean check;
	Seat(int num,boolean check) {
		this.num = num;
		this.check = check;
	}
	@Override
	public String toString() {
		return check ? "■ " : "□ ";
	}
	
	
}

class SeatDAO{
	Scanner scan;
	Vector<Seat> list;
	int size;
	SeatDAO(int size){
		scan = new Scanner(System.in);
		list = new Vector<Seat>();
		this.size = size;
		for(int i = 0; i < size; i+=1) {
			list.add(new Seat(i+1,false));
		}
	}
	void print() {
		for(int i = 0; i < size; i+=1) {
			System.out.print(list.get(i).num + " ");
		}
		System.out.println();
		for(Seat s : list) {
			System.out.print(s);
		}
		System.out.println();
	}
	
	void run() {
		chooseSeat();
	}
	
	void chooseSeat() {
		while(true) {
			print();
			System.out.printf("번호 입력(%d ~ %d) : ",0,size-1);
			int idx = scan.nextInt();
			Seat e = new Seat(idx+1,true);
			list.set(idx,e);
			if(list.get(idx).check) {
				System.out.println("이미 좌석이 찾습니다.");
			}
			list.get(idx).check = true;
			System.out.println(idx+1 + "번 좌석 예매 완료");
		}
	}
	
	
}
public class _05자리예매 {

	public static void main(String[] args) {
		
		SeatDAO dao = new SeatDAO(10);
		dao.run();

	}

}
