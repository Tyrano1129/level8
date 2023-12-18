package School_김진수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SubjectDAO {
	ArrayList<Subject> subList;
	Util scan;
	SubjectDAO(){
		subList = new ArrayList<Subject>();
		scan = new Util();
	}
	void init(String data) {
		String[] temp = data.split("\n");
		
		for(int i =0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			subList.add(new Subject(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2])));
		}
		
	}
	
	void print() {
		for(Subject s : subList) {
			System.out.println(s);
		}
	}
	void numberPrint(int number) {
		for(Subject s : subList) {
			if(number == s.stuNo) {
				System.out.print(s);				
			}
		}
		System.out.println();
	}
	//학생삭제후 과목삭제
	void stuOnesubjectDelete(int num) {
		if(subList.size() == 1) {
			subList = null;
		}else {
			for(int i = 0; i < subList.size(); i+=1) {
				if(subList.get(i).stuNo == num) {
					subList.remove(i);
					i-=1;
				}
			}
		}
	}
	int stuOneSubjectCnt(int number) {
		int cnt = 0;
		for(int i = 0; i < subList.size(); i+=1) {
			if(number == subList.get(i).stuNo) {
				cnt+=1;
			}
		}
		return cnt;
	}
	int checkSubject(int number,String name) {
		for(int i = 0; i < subList.size(); i+=1) {
			if(subList.get(i).stuNo == number && subList.get(i).subName.equals(name)) {
				return i;
			}
		}
		return -1;
	}
	//과목 추가
	void subjectJoin(StudentDAO stu) {
		Random read = new Random();
		int number = stu.studentNumber();
		String subName = scan.getValueString("과목 입력 : ");
		int idx = checkSubject(number,subName);
		if(idx != -1) {
			System.out.println("중복된 과목입니다.");
			return;
		}
		subList.add(new Subject(number,subName,read.nextInt(50)+51));
		stu.numberprint(number);
		numberPrint(number);
	}
	//과목 삭제
	void subjectDelete(StudentDAO stu) {
		int number = stu.studentNumber();
		if(stuOneSubjectCnt(number) ==  0) {
			System.out.println("가지고 있는 과목이없습니다.");
			return;
		}
		String subName = scan.getValueString("과목 입력 : ");
		int idx = checkSubject(number,subName);
		if(idx == -1) {
			System.out.println("입력한 과목은 없습니다.");
			return;
		}
		subList.remove(idx);
		stu.numberprint(number);
		numberPrint(number);
	}
	//학생별 점수 평균계산
	double stuAllprint(Student stu) {
		double sum = 0;
		int cnt = 0;
		for(int i = 0; i < subList.size(); i+=1) {
			if(stu.stuNo == subList.get(i).stuNo) {
				sum += subList.get(i).score;
				cnt+=1;
			}
		}
		return sum == 0? 0 : (sum * 1.0)/cnt;
	}
	//입력후 과목있는지 확인후 담기
	ArrayList<Subject> subjectOneList(String name) {
		ArrayList<Subject> temp = new ArrayList<Subject>();
		for(int i = 0; i < subList.size(); i+=1) {
			if(subList.get(i).subName.equals(name)) {
				temp.add(subList.get(i));
			}
		}
		return temp;
	}
	//과목 입력후 학생데이터에 전달
	void subjectprint(StudentDAO stu) {
		String name = scan.getValueString("과목입력 : ");
		ArrayList<Subject> temp = subjectOneList(name);
		if (temp.size() == 0) {
			System.out.println("입력하신 과목은 없습니다.");
			return;
		}
		stu.subjectAllstuprint(temp, name);
	}
	

	String subdata() {
		if(subList == null) return null;
		String data = "";
		for(int i = 0; i < subList.size(); i+=1) {
			data += subList.get(i).data() + "\n";
		}
		return data;
	}
}
