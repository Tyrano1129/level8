package _03객체지향_실습;

import java.util.ArrayList;
import java.util.Scanner;

class Node3 {
	private String mark;

	public String getMark() {
		return mark;
	}

	public Node3(String mark) {
		this.mark = mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return mark.equals("") ? "[ ]" : mark;
	}

}

class Player {
	private String name;
	private String mark;

	public Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}

class TicTakToe {
	private ArrayList<Player> plist;
	private ArrayList<ArrayList<Node3>> list;
	private Player player;
	private final int SIZE = 3;
	private int cnt;
	private Scanner scan;
	private boolean win;

	// Value 값
	private int getValue(String msg) {
		int num = 0;
		while (true) {
			System.out.println(msg);
			try {
				num = scan.nextInt();
				if (num < 0 || num >= SIZE) {
					System.out.println("입력오류");
					continue;
				}
				return num;
			} catch (Exception e) {
				System.out.println("숫자만 입력");
			} finally {
				scan.nextLine();
			}
		}
	}

	// 게임 플레이
	private void gemePlay() {
		while (true) {
			printMap();
			if (win) {
				System.out.println(player.getName() + "승리!");
				return;
			}
			if (cnt == 9) {
				System.out.println("무승부!");
				return;
			}
			System.out.printf("%s %s%n", player.getName(), player.getMark());
			int y = getValue("Y 입력 : ");
			int x = getValue("X 입력 : ");
			if (!list.get(y).get(x).getMark().equals("")) {
				System.out.println("이미 들어간 자리입니다.");
				continue;
			}
			list.get(y).get(x).setMark(player.getMark());
			win = garosero();
			if (!win)
				win = diagonalLeft();
			if (!win)
				win = diagonalRight();
			if (!win) {
				player = player == plist.get(0) ? plist.get(1) : plist.get(0);
				cnt += 1;
			}

		}
	}

	// 대각선 \
	private boolean diagonalLeft() {
		int cnt = 0;
		for (int i = 0; i < SIZE; i += 1) {
			if (list.get(i).get(i).getMark().equals(player.getMark())) {
				cnt += 1;
			}
		}
		if (cnt == 3) {
			return true;
		}
		return false;
	}

	// 대각선 /
	private boolean diagonalRight() {
		int cnt = 0;
		for (int i = SIZE - 1; i >= 0; i -= 1) {
			for (int k = 0; k < SIZE; k += 1) {
				if (k + i == SIZE - 1 && list.get(i).get(k).getMark().equals(player.getMark())) {
					cnt += 1;
				}
			}
		}
		if (cnt == 3) {
			return true;
		}
		return false;
	}

	// 가로세로
	private boolean garosero() {
		for (int i = 0; i < SIZE; i += 1) {
			int cnt1 = 0;
			int cnt2 = 0;
			for (int k = 0; k < SIZE; k += 1) {
				if (list.get(i).get(k).getMark().equals(player.getMark())) {
					cnt1 += 1;
				}
				if (list.get(k).get(i).getMark().equals(player.getMark())) {
					cnt2 += 1;
				}
			}
			if (cnt1 == 3 || cnt2 == 3) {
				return true;
			}
		}
		return false;
	}

	// 초기값
	private void init() {
		plist.add(new Player("1P", "[O]"));
		plist.add(new Player("2P", "[X]"));
		scan = new Scanner(System.in);
		list = new ArrayList<ArrayList<Node3>>();
		for (int i = 0; i < SIZE; i += 1) {
			list.add(new ArrayList<Node3>());
			for (int k = 0; k < SIZE; k += 1) {
				list.get(i).add(new Node3(""));
			}
		}
		player = plist.get(0);
	}

	// map
	private void printMap() {
		for (ArrayList<Node3> map : list) {
			for (Node3 n : map) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	// run
	public TicTakToe() {
		plist = new ArrayList<Player>();
		init();
		gemePlay();
		scan.close();
	}
}

public class _04틱텍토 {

	public static void main(String[] args) {
		TicTakToe t = new TicTakToe();
	}

}
