package _03객체지향_실습;
// DTO(data transfer object)
// DTO 순수하게 데이터를 담아서 계층간에 전달하는 객체 : getter, setter, toString;
// VO (valus object) : 값 자체의 객체 : 로직을 포함할 수 있다.
import java.util.ArrayList;

class Member {
	private int custno;				// 회원번호
	private String custname;		// 회원성명
	private String phone;			// 회원전화
	private String address;			// 통신사
	private String joindate;		// 가입일자
	private String grade;			// 고객등급
	private String city;			// 거주도시
	
	public Member(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public int getCustno() {
		return custno;
	}

	public String getCustname() {
		return custname;
	}
	
}

class Money{
	 private int custno;			// 회원번호
	 private int saleno; 			// 판매번호
	 private int pcost;				// 단가
	 private int amount;			// 수량
	 private int price;				// 가격(매출)
	 private String pcode;			// 상품코드
	 private String sdate;			// 판매일자
	 public Money() {}
	 
	 public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}

	public int getCustno() {
		return custno;
	}
	public int getPrice() {
		return price;
	}

	 
}

class Manager{
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private ArrayList<Money> moneyList = new ArrayList<Money>(); 	
	
	public void init() {
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));
		
		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
	}
	public int priceSum(int number) {
		int sum = 0;
		for(int k = 0; k < moneyList.size(); k+=1) {
			if(number == moneyList.get(k).getCustno()) {
				sum += moneyList.get(k).getPrice(); 
			}
		}
		return sum;
	}
	public void descendingOrder(ArrayList<Member> temp,ArrayList<Integer> sumList) {
		for(int i =0; i < sumList.size(); i+=1) {
			int max = sumList.get(i);
			for(int k = i; k < sumList.size(); k+=1) {
				if(max < sumList.get(k)) {
					max = sumList.get(k);
					
					Member mtemp = temp.get(i);
					temp.set(i,temp.get(k));
					temp.set(k, mtemp);
					
					Integer sum = sumList.get(i);
					sumList.set(i, sumList.get(k));
					sumList.set(k, sum);
				}
			}
		}
	}
	public void print() {
		ArrayList<Member> temp = new ArrayList<Member>();
		ArrayList<Integer> sumList = new ArrayList<Integer>();
		for(int i = 0; i < memberList.size(); i+=1) {
			int sum = priceSum(memberList.get(i).getCustno());
			if(sum > 0) {
				temp.add(memberList.get(i));
				sumList.add(sum);
			}
		}
		descendingOrder(temp,sumList);
		int idx = 0;
		for(Member m : temp) {
			System.out.println(m.getCustno() + " " + m.getCustname() + "    " + sumList.get(idx++));
			System.out.println("---------------------------------------");
		}
	}
	public void totalPrint() {
		ArrayList<Total> total = new ArrayList<Total>();
		for(int i = 0; i < memberList.size(); i+=1) {
			int sum = priceSum(memberList.get(i).getCustno());
			if(sum > 0) {
				total.add(new Total(memberList.get(i).getCustno(),memberList.get(i).getCustname(),sum));
			}
		}
		for(int i = 0; i < total.size(); i+=1) {
			int max = total.get(i).getSum();
			for(int k = i; k < total.size(); k+=1) {
				if(max < total.get(k).getSum()) {
					max = total.get(k).getSum();
					
					Total temp = total.get(i);
					total.set(i, total.get(k));
					total.set(k, temp);
				}
			}
		}
		for(Total t : total) {
			System.out.println(t);
		}
	}
}
class Total {
	private int custNo;
	private String custName;
	private int sum;
	public Total(int custNo, String custName, int sum) {
		this.custNo = custNo;
		this.custName = custName;
		this.sum = sum;
	}
	public int getSum() {
		return sum;
	}
	@Override
	public String toString() {
		return "Total [" + custNo + ", " + custName + ", " + sum + "]";
	}
	
	
}
public class _01캡슐화실습 {

	public static void main(String[] args) {
		Manager mg = new Manager();
		mg.init();
		mg.totalPrint();
		/*
		 * [문제]
		 * 		아래와 같이 매출(price)의 합계를 내림차순으로 정렬해 출력하시오.
		 * 		100001 김행복    8000
		 * 		---------------------------------------
		 * 		100004 최사랑    4900
		 * 		---------------------------------------
		 * 		100003 장믿음    3000
		 * 		---------------------------------------
		 * 		100002 이축복    2500
		 */
		

	}

}
