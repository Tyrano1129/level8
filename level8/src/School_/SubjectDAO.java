package School_;

import java.util.Random;
import java.util.ArrayList;

public class SubjectDAO {

	ArrayList<Subject> subList;
	Utils sc;
	SubjectDAO() {
		sc = new Utils();
		subList = new ArrayList<Subject>();
	}
	
	boolean hasData(ArrayList<Subject> list) {
		if (list.size() == 0) {
			System.out.println("[no subject data ]");
			return false;
		}
		return true;
	}
	void addSubFromData(String data) {
		if(data.isEmpty()) return;
		String[] temp = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String info[] = temp[i].split("/");
			subList.add(new Subject(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
		}
	}
	
	void printAllSubjects() {
		if(!hasData(subList)) return;
		for(Subject s : subList) {
			System.out.println(s);
		}
	}
	
	ArrayList<Subject> getSubjectsByAStudent(Student stu){
		if(subList.size() == 0 ) return new ArrayList<Subject>();
		ArrayList<Subject> list = new ArrayList<Subject>();
		for(Subject s : subList) {
			if(stu.stuNo == s.stuNo) {
				list.add(s);
			}
		}
		return list;
	}
	
	void deleteAllSubjectFromAStudent(Student stu) {
		ArrayList<Subject> list = getSubjectsByAStudent(stu);
		if(!hasData(list)) return;
		for(Subject s : list) {
			deleteOneSubject(s);
		}
	}
	
	void deleteOneSubject(Subject sub) {
		subList.remove(sub);
	}
	
	void printAStudentSubjects(Student stu) {
		ArrayList<Subject> list = getSubjectsByAStudent(stu);
		if(list.size()==0) return; 
		for(Subject s : list) {
			System.out.print(s +" ");
		}
		System.out.println();
	}
	
	boolean addOneSubject(Student stu) {
		ArrayList<Subject> list = getSubjectsByAStudent(stu);
		String name = sc.getValue("신규 과목 이름");
		Subject sub = getAsubjectByName(list, name);
		if (sub != null) {
			System.out.println("해당 과목은 이미 존재합니다");
			return false;
		}
		Random rd = new Random();
		subList.add(new Subject(stu.stuNo, name, rd.nextInt(51) + 50));

		return true;
	}
	
	Subject getAsubjectByName(ArrayList<Subject> list, String name) {
;
		if(list.size() == 0 ) return null;
		for(Subject s : list) {
			if(s.subName.equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	boolean deleteASubject(Student stu) {
		ArrayList<Subject> list = getSubjectsByAStudent(stu);
		if(!hasData(list)) return false;
		String name = sc.getValue("삭제 과목 이름");
		Subject sub = getAsubjectByName(list,name);
		if (sub == null) {
			System.out.println("해당 과목 이름이 없습니다");
			return false;
		}
		subList.remove(sub);
		System.out.println(sub +"과목 삭제 완료");
		return true;
	}
	double getScoreAvgByStudent(Student stu) {
		ArrayList<Subject> list = getSubjectsByAStudent(stu);
		if(list.size() == 0 ) return 0;
		double avg = 0;
		for(Subject s : list) {
			avg+=s.score;
		}
		return avg/list.size();
		
	}
	
	void getStuListByASubject(StudentDAO stuDAO) {
		if(!hasData(subList)) return;
		String name = sc.getValue("찾을 과목 이름");

		ArrayList<Integer> stuNoList = new ArrayList<Integer>();
		for (Subject sub : subList) {
			if (sub.subName.equals(name)) {
				stuNoList.add(sub.stuNo);
			}
		}
		if (stuNoList.size() == 0) {
			System.out.println("해당 과목은 학생 데이터가 없습니다");
			return;
		}


		stuDAO.getStudentsBySubjectName(stuNoList);

	}
	String saveAsFileData() {
		if (subList.size() == 0)
			return "";
		String data = "";
		for (Subject s : subList) {
			data += s.saveToData();
		}
		return data;
	}

	
}
