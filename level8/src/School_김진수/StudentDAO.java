package School_김진수;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentDAO {
	ArrayList<Student> stuList;
	int number;
	Util scan;
	StudentDAO(){
		stuList = new ArrayList<Student>();
		number = 1001;
		scan = new Util();
	}
	void init(String data) {
		String[] temp = data.split("\n");
		
		for(int i = 0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			
			stuList.add(new Student(Integer.parseInt(info[0]),info[1],info[2]));
		}
		number = maxNumber();
	}
	
	int maxNumber() {
		int max = 0;
		for(Student s : stuList) {
			if(max < s.stuNo) {
				max = s.stuNo;
			}
		}
		
		return max+1;
	}
	void numberprint(int number) {
		for(int i = 0; i < stuList.size(); i+=1) {
			if(number == stuList.get(i).stuNo)
			System.out.println(stuList.get(i));
		}
	}
	void print() {
		for(Student s : stuList) {
			System.out.println(s);
		}
	}
	
	Student subnumberprint(int number) {
		for(int i = 0 ; i < stuList.size(); i+=1) {
			if(stuList.get(i).stuNo == number) {
				return stuList.get(i);
			}
		}
		return null;
	}
	
	int checkIdx(String id) {
		for(int i = 0; i < stuList.size(); i+=1) {
			if(stuList.get(i).stuId.equals(id)) {
				return i;
			}
		}
		return -1;
	}
	void studentJoin() {
		String id = scan.getValueString("학생 id 입력 : ");
		int idx = checkIdx(id);
		if(idx != -1) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		stuList.add(new Student(this.number,scan.getValueString("이름 입력 : "),id));
		number +=1;
		print();
	}
	
	void studentDelete(SubjectDAO sub) {
		String id = scan.getValueString("학생 id 입력 : ");
		int idx = checkIdx(id);
		if(idx == -1) {
			System.out.println("입력 하신 학생은 없습니다.");
			return;
		}
		sub.stuOnesubjectDelete(stuList.get(idx).stuNo);
		numberprint(stuList.get(idx).stuNo);
		stuList.remove(idx);
		System.out.println("삭제완료");
	}
	
	int studentNumber() {
		int number = scan.getValue("학생 번호 입력 : ",1001,this.number-1);
		return number;
	}
	
	void studentAllprint(SubjectDAO sub) {
		ArrayList<Student> temp = new ArrayList<Student>();
		ArrayList<Double> avg = new ArrayList<Double>();
		for(int i = 0; i < stuList.size(); i+=1) {
			temp.add(stuList.get(i));
			avg.add(sub.stuAllprint(temp.get(i)));
		}
		for(int i =0; i < temp.size(); i+=1) {
			double max = avg.get(i);
			for(int k = i; k < temp.size(); k+=1) {
				if(max < avg.get(k)) {
					max = avg.get(k);
					
					Student stemp = temp.get(i);
					temp.set(i,temp.get(k));
					temp.set(k, stemp);
					
					Double score = avg.get(i);
					avg.set(i, avg.get(k));
					avg.set(k, score);
				}
			}
		}
		int idx = 0;
		for(Student stu : temp) {
			System.out.println(stu);
			sub.numberPrint(stu.stuNo);
			System.out.printf("평균점수 : %.2f%n",avg.get(idx++));
		}
	}
	//과목출력
	void subjectAllstuprint(ArrayList<Subject> temp,String name) {
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		for (int i = 0; i < temp.size(); i += 1) {
			Student e = subnumberprint(temp.get(i).stuNo);
			stuList.add(i,e);
		}

		for (int i = 0; i < temp.size(); i += 1) {
			for (int k = i; k < temp.size(); k += 1) {
				if (stuList.get(i).stuName.compareTo(stuList.get(k).stuName) > 0) {
					Subject stemp = temp.get(i);
					temp.set(i, temp.get(k));
					temp.set(k, stemp);

					Student tempname = stuList.get(i);
					stuList.set(i, stuList.get(k));
					stuList.set(k, tempname);
				}
			}
		}

		System.out.println(name + "의 학생과 점수");
		int idx = 0;
		for (Student s : stuList) {
			System.out.println(s);
			System.out.println(temp.get(idx++));
		}
	}
	String studata() {
		if(stuList == null) return null;
		String data = "";
		for(int i = 0; i < stuList.size(); i+=1) {
			data += stuList.get(i).data() + "\n";
		}
		return data;
	}
	
}
