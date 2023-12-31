package School_김진수Ver1;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentDAO {
	private ArrayList<Student> stuList;
	private int number;
	private Util scan;
	public StudentDAO(){
		stuList = new ArrayList<Student>();
		number = 1001;
		scan = new Util();
	}
	public void init(String data) {
		String[] temp = data.split("\n");
		
		for(int i = 0; i < temp.length; i+=1) {
			String[] info = temp[i].split("/");
			
			stuList.add(new Student(Integer.parseInt(info[0]),info[1],info[2]));
		}
		number = maxNumber();
	}
	
	public int maxNumber() {
		int max = 0;
		for(Student s : stuList) {
			if(max < s.getStuNo()) {
				max = s.getStuNo();
			}
		}
		
		return max+1;
	}
	public void numberprint(int number) {
		for(int i = 0; i < stuList.size(); i+=1) {
			if(number == stuList.get(i).getStuNo())
			System.out.println(stuList.get(i));
		}
	}
	public void print() {
		for(Student s : stuList) {
			System.out.println(s);
		}
	}
	
	public Student subnumberprint(int number) {
		for(int i = 0 ; i < stuList.size(); i+=1) {
			if(stuList.get(i).getStuNo() == number) {
				return stuList.get(i);
			}
		}
		return null;
	}
	
	private int checkIdx(String id) {
		for(int i = 0; i < stuList.size(); i+=1) {
			if(stuList.get(i).getStuId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	public void studentJoin() {
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
	
	public void studentDelete(SubjectDAO sub) {
		String id = scan.getValueString("학생 id 입력 : ");
		int idx = checkIdx(id);
		if(idx == -1) {
			System.out.println("입력 하신 학생은 없습니다.");
			return;
		}
		sub.stuOnesubjectDelete(stuList.get(idx).getStuNo());
		numberprint(stuList.get(idx).getStuNo());
		stuList.remove(idx);
		System.out.println("삭제완료");
	}
	
	public int studentNumber() {
		int number = scan.getValue("학생 번호 입력 : ",1001,this.number-1);
		return number;
	}
	
	public void studentAllprint(SubjectDAO sub) {
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
			sub.numberPrint(stu.getStuNo());
			System.out.printf("평균점수 : %.2f%n",avg.get(idx++));
		}
	}
	//과목출력
	public void subjectAllstuprint(ArrayList<Subject> temp,String name) {
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		for (int i = 0; i < temp.size(); i += 1) {
			Student e = subnumberprint(temp.get(i).getStuNo());
			stuList.add(i,e);
		}

		for (int i = 0; i < temp.size(); i += 1) {
			for (int k = i; k < temp.size(); k += 1) {
				if (stuList.get(i).getStuName().compareTo(stuList.get(k).getStuName()) > 0) {
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
	public String studata() {
		if(stuList == null) return null;
		String data = "";
		for(int i = 0; i < stuList.size(); i+=1) {
			data += stuList.get(i).data() + "\n";
		}
		return data;
	}
	
}
