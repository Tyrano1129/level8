package _03객체지향_실습;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Node2 {
	private int num;

	public Node2(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return num != 0 ? "[%-2d]".formatted(num) : "[%-2s]".formatted(" ");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

class Game1to50 {
	private ArrayList<ArrayList<Node2>> listfront;
	private ArrayList<ArrayList<Node2>> listback;
	final private int SIZE = 5;
	private Scanner scan;
	private int cnt;

	private void init() {
		cnt = 1;
		scan = new Scanner(System.in);
		listfront = new ArrayList<ArrayList<Node2>>();
		listback = new ArrayList<ArrayList<Node2>>();

		int num = 1;

		for (int i = 0; i < SIZE; i += 1) {
			listfront.add(new ArrayList<Node2>());
			for (int k = 0; k < SIZE; k += 1) {
				listfront.get(i).add(new Node2(num++));
			}
		}

		for (int i = 0; i < SIZE; i += 1) {
			listback.add(new ArrayList<Node2>());
			for (int k = 0; k < SIZE; k += 1) {
				listback.get(i).add(new Node2(num++));
			}
		}
	}

	private void print() {
		for (ArrayList<Node2> a : listfront) {
			for (Node2 a1 : a) {
				System.out.print(a1);
			}
			System.out.println();
		}
	}

	private void suffle() {
		Random read = new Random();
		for (int i = 0; i < 50; i += 1) {
			int rd1 = read.nextInt(SIZE);
			int rd2 = read.nextInt(SIZE);

			Node2 temp = listfront.get(0).get(0);
			listfront.get(0).set(0, listfront.get(rd1).get(rd2));
			listfront.get(rd1).set(rd2, temp);

			temp = listback.get(0).get(0);
			listback.get(0).set(0, listback.get(rd1).get(rd2));
			listback.get(rd1).set(rd2, temp);
		}
	}

	private int getValueY() {
		while (true) {
			for (int i = 0; i < SIZE; i += 1) {
				for (int k = 0; k < SIZE; k += 1) {
					if (listfront.get(i).get(k).getNum() == cnt) {
						return i;
					}
				}
			}
		}
	}

	private int getValueX() {
		while (true) {
			for (int i = 0; i < SIZE; i += 1) {
				for (int k = 0; k < SIZE; k += 1) {
					if (listfront.get(i).get(k).getNum() == cnt) {
						return k;
					}
				}
			}
		}
	}

	private String cheatkey() {
		for (int i = 0; i < SIZE; i += 1) {
			for (int k = 0; k < SIZE; k += 1) {
				if (listfront.get(i).get(k).getNum() == cnt) {
					return "Y = %d X = %d".formatted(i, k);
				}
			}
		}
		return null;
	}

	private void gamePlay() {
		while (true) {
			print();
			if (cnt > (SIZE * SIZE) * 2) {
				System.out.println("게임종료...");
				return;
			}
			System.out.println(cheatkey());
			System.out.println("다음숫자 : " + cnt);
			int y = getValueY();
			int x = getValueX();
			if (listfront.get(y).get(x).getNum() == 0) {
				System.out.println("이미 입력한 값습니다.");
				continue;
			}

			if (listfront.get(y).get(x).getNum() == cnt) {
				if (listback.get(y).get(x).getNum() == 0) {
					listfront.get(y).get(x).setNum(0);
				} else {
					listfront.get(y).get(x).setNum(listback.get(y).get(x).getNum());
					listback.get(y).get(x).setNum(0);
				}
				cnt += 1;
			} else {
				System.out.println("틀렸습니다.");
				continue;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
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

public class _03게임1to50 {

	public static void main(String[] args) {
		Game1to50 game = new Game1to50();
		game.run();

	}

}
