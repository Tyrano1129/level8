package _02객체지향_이론;

import java.util.ArrayList;
import java.util.Random;

class Monster{
	public static final int DEFAULT = 10; // final + static 붙으면 기울어진 굵은 글씨체
	
	private String name;//몬스터이름
	private int num;///몬스터번호
	private int hp;//몬스터체력
	private static int cnt; // 몬스터 갯수
	private boolean dead;
	public Monster(String name, int num) {
		this.name = name;
		this.num = num;
		this.hp = DEFAULT;
		this.cnt +=1;
	}
	
	public void getDamaged(int damage) {
		System.out.printf("%s가 [-%d] %n",this,damage);
		if(!dead) this.hp-=damage;
		if(this.hp <= 0) {
			this.hp = 0;
			dead = true;
			cnt-=1;
		}
	}
	// boolean 값을 리턴할때는 보통 is , has + 형용사/동사 붙여서 표시한다.
	public boolean isDead() {
		return this.dead;
	}

	@Override
	public String toString() {
		return "(%d) %s(%d/%d)".formatted(num,name,hp,DEFAULT);
	}
	public static void printMonsterCnt() {
		System.out.println(cnt + "마리");
	}
}
public class _07스테틱2 {

	public static void main(String[] args) {
		Random rd = new Random();
		
		Monster orc1 = new Monster("오크",1);
		orc1.printMonsterCnt();
		Monster orc2 = new Monster("오크",2);
		orc2.printMonsterCnt();
		Monster orc3 = new Monster("오크",3);
		orc3.printMonsterCnt();
		
		ArrayList<Monster> list = new ArrayList<Monster>();
		list.add(orc1);
		list.add(orc2);
		list.add(orc3);
		while(true) {
			for(Monster orc : list) {
				if(orc.isDead() && orc == orc1) break;
				if(orc.isDead()) continue;
				int damage = rd.nextInt(3);// 0-2
				orc.getDamaged(damage);
			}
			if(list.get(0).isDead()) break;
		}
		
		System.out.println("공격종료");
		for(Monster orc : list) {
			System.out.println(orc);
		}
		orc1.printMonsterCnt();

	}

}
