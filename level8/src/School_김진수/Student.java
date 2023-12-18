package School_김진수;

public class Student {
	int stuNo;
	String stuName;
	String stuId;
	
	Student(int stuNo,String stuName,String stuId){
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "[" + stuNo + " " + stuName + " " + stuId + "]";
	}
	
	String data() {
		return stuNo+"/"+stuName+"/"+stuId;
	}
	
}
