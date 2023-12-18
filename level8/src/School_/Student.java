package School_;

public class Student {
	int stuNo;
	String stuName;
	String stuId;
	
	public Student(int stuNo, String stuName ,String stuId ) {
		this.stuNo = stuNo;
		this.stuId = stuId;
		this.stuName = stuName;
	}
	
	@Override
	public String toString() {
		String data = stuNo + "\t" + stuName + "\t" + stuId ;
		return data;
	}
	String saveToData(){
		return "%d/%s/%s\n".formatted(stuNo,stuName,stuId);
	}

}
