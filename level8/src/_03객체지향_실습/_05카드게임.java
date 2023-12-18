package _03객체지향_실습;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// 객체 
// static 변수(클래스변수) : 공통속성
// non-static 변수(인스턴스변수) : 개별속성
class Card{
	// 포커카드
	private int num;
	private String shape;
	
	private static String[] shapes = {"♡","◇","♣","♠"};
	
	public Card(int num, String shape) {
		this.num = num;
		this.shape = shape;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public static String[] getShapes() {
		return shapes;
	}
	public static void setShapes(String[] shapes) {
		Card.shapes = shapes;
	}
	@Override
	public String toString() {
		return  num + " : " + shape;
	}
	
	
}
class Player1{
	private String name;
	private Card[] card;
	public Player1(String name,Card[] card){
		this.name = name;
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Card[] getCard() {
		return card;
	}
	public void setCard(Card[] card) {
		this.card = card;
	}
	
	public int getCardsSum() {
		return card[0].getNum() + card[1].getNum();
	}
	public int getCardsMax() {
		return card[0].getNum() > card[1].getNum()? 0 : 1;
	}
}
class GameManager{
	private ArrayList<ArrayList<Card>> deck;
	private Random rd;
	private ArrayList<Player1> player;
	private void init() {
		deck = new ArrayList<ArrayList<Card>>();
		rd = new Random();
		player = new ArrayList<Player1>();
		for(int i =0; i < Card.getShapes().length; i+=1) {
			deck.add(new ArrayList<Card>());
			for(int k = 0; k < 10; k+=1) {
				deck.get(i).add(new Card(k+1,Card.getShapes()[i]));
			}
		}
		player.add(new Player1("1p",new Card[2]));
		player.add(new Player1("2p",new Card[2]));

		
	}
	private void print() {
		for(ArrayList<Card> arr : deck) {
			for(Card card : arr) {
				System.out.println(card + " ");
			}
			System.out.println("------------------");
		}
	}
	private Card[] playGame() {
		Card[] e = new Card[2];
		for(int i = 0; i < e.length; i+=1) {
			int rdy = rd.nextInt(deck.size());
			int rdx = rd.nextInt(deck.get(rdy).size());
			if(deck.get(rdy).get(rdx) == null) {
				i-=1;
				continue;
			}
			e[i] = deck.get(rdy).get(rdx);
			deck.get(rdy).set(rdx,null);
		}
		return e;
	}
	private void suffle() {
		for(int i = 0; i < 50; i+=1) {
			int rdy = rd.nextInt(deck.size());
			int rdx = rd.nextInt(deck.get(rdy).size());
			
			Card temp = deck.get(0).get(0);
			deck.get(0).set(0,deck.get(rdy).get(rdx));
			deck.get(rdy).set(rdx, temp);
		}
		print();
	}
	private boolean checkWinNum(int idx1,int idx2) {
		for(int i = 0; i < player.size(); i+=1) {
			int cnt = 0;
			for(int k = 0; k < player.size(); k+=1) {
				if(player.get(idx1).getCard()[i].getNum() >  player.get(idx2).getCard()[k].getNum()) {
					cnt +=1;
				}
			}
			if(cnt == 2) {
				return true;
			}
		}
		return false;
	}
	private boolean checkWinshape(int idx1, int idx2) {
		String sha1 = player.get(idx1).getCard()[player.get(idx1).getCardsMax()].getShape();
		String sha2 = player.get(idx2).getCard()[player.get(idx2).getCardsMax()].getShape();
		int shap1 = checkshape(sha1);
		int shap2 = checkshape(sha2);
		if(shap1 > shap2) {
			return true;
		}
		return false;
	}
	private void result() {
		for(int i =0; i < player.size(); i+=1) {
			System.out.print(player.get(i).getName() + " ");
			for(int k = 0; k < player.get(i).getCard().length; k+=1) {
				System.out.print(player.get(i).getCard()[k] + " ");
			}
			System.out.println();
		}
		checkWin();
	}
	private void checkWin() {
		int sum1 = player.get(0).getCardsSum();
		int sum2 = player.get(1).getCardsSum();
		if(sum1 > sum2) {
			System.out.printf("%s승리%n",player.get(0).getName());
			return;
		}else if (sum1 < sum2){
			System.out.printf("%s승리%n",player.get(1).getName());
			return;
		}
		if(sum1 == sum2) {
			if(checkWinNum(0,1)) {
				System.out.printf("%s승리%n",player.get(0).getName());
				return;
			}else if(checkWinNum(1,0)) {
				System.out.printf("%s승리%n",player.get(1).getName());
				return;
			}
			
			if(checkWinshape(0,1)) {
				System.out.printf("%s승리%n",player.get(0).getName());
				return;
			}else{
				System.out.printf("%s승리%n",player.get(1).getName());
				return;
			}
		}
	}
	private int checkshape(String shape) {
		for(int i = 0; i < Card.getShapes().length; i+=1) {
			if(Card.getShapes()[i].equals(shape)) {
				return i;
			}
		}
		return -1;
	}
	public void run() {
		init();
		suffle();
		player.get(0).setCard(playGame());
		player.get(1).setCard(playGame());
		result();
	}
}
public class _05카드게임 {

	public static void main(String[] args) {
		
		GameManager gm = new GameManager();
		gm.run();

	}

}
