package _03객체지향_실습;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Node{
	private String front;
	private String back;
	public Node(String front, String back) {
		this.front = front;
		this.back = back;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}

	public String print() {
		return back == ""? "[ ]":"[" + back +"]"; 
	}
	
	
}
// 접근 제어자는 클래스,메서드,맴버변수(전역변수)에만 붙일 수 있다.
class MemoryGame{
	private Random read;
	private Scanner scan;
	private ArrayList<Node> list;
	final private int SIZE;
	MemoryGame(int size){
		this.SIZE = size;
		list = new ArrayList<Node>();
		scan = new Scanner(System.in);
		read = new Random();
	}
	private void init() {
		int number = 1;
		for(int i = 0; i < SIZE; i+=1) {
			if(number == 6) {
				number = 1;
			}
			Node n = new Node(number+"","");
			list.add(n);
			number+=1;
		}
	}
	private void suffle() {
		for(int i = 0; i < 50; i+=1) {
			int rd = read.nextInt(SIZE);
			
			Node temp = list.get(0);
			list.set(0,list.get(rd));
			list.set(rd,temp);
		}
	}
	private int getValue(String msg,int start,int end) {
		int num = 0;
		while(true) {
			System.out.println(msg);
			try {
				num = scan.nextInt();
				if(num < start || num > end) {
					System.out.println("입력 오류");
					continue;
				}
				return num;
			}catch(Exception e) {
				System.out.println("숫자만 이용해주세요.");
			}finally {
				scan.nextLine();
			}
		}
	}
	private void gameMap() {
		for(Node n : list) {
			System.out.print(n.print());
		}
		System.out.println();
		System.out.println("-------------------------------");
	}
	private void trysleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void gamePlay() {
		int gameCnt = 0;
		while(true) {
			gameMap();
			
			int idx1 = getValue("인덱스1 0~9 입력하세요 : ",0,9);
			int idx2 = getValue("인덱스2 0~9 입력하세요 : ",0,9);
			if(idx1 == idx2) {
				System.out.println("같은 숫자입력 불가능");
				continue;
			}
			String str1 = list.get(idx1).getBack();
			String str2 = list.get(idx2).getBack();
			if(!str1.equals("") || !str2.equals("")) {
				System.out.println("이미 뒤집어진 카드입니다.");
				continue;
			}
			trysleep();
			str1 = list.get(idx1).getFront();
			str2 = list.get(idx2).getFront();
			list.get(idx1).setBack(str1);
			list.get(idx2).setBack(str2);
			gameMap();
			if(!str1.equals(str2)){
				list.get(idx1).setBack("");
				list.get(idx2).setBack("");
				continue;
			}
			gameCnt +=1;
			
			if(gameCnt == 5) {
				System.out.println("게임 종료...");
				break;
			}
			
		}
	}
	public void run() {
		init();
		suffle();
		gamePlay();
		scan.close();
	}
}
public class _02기억력게임 {

	public static void main(String[] args) {
		MemoryGame game = new MemoryGame(10);
		game.run();
	}

}
