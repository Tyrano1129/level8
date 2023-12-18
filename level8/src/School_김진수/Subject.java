package School_김진수;

public class Subject {
	int stuNo;
	String subName;
	int score;
	
	Subject(int stuNo,String subName,int score){
		this.score = score;
		this.stuNo = stuNo;
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "["+ subName + " " + score + "]";
	}
	

	String data() {
		return stuNo+"/"+subName+"/"+score;
	}
}
