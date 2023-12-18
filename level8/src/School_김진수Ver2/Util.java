package School_김진수Ver2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	
	private Scanner scan;
	final private String CUR_PATH;
	private static Util instance = new Util();
	
	public static Util getInstance() {
		return instance;
	}
	private Util(){
		scan = new Scanner(System.in);
		CUR_PATH = System.getProperty("user.dir") + "\\src\\" + this.getClass().getPackageName() + "\\";
	}

	public void scanClose(){
		scan.close();
	}
	
	public int getValue(String msg,int start,int end) {
		int num = 0;
		System.out.println(msg);
		while(true) {
			try {
				num = scan.nextInt();
				if(num < start || num > end) {
					System.out.printf("[%d] ~ [%d] 사이의 입력%n",start,end);
					continue;
				}
				return num;
			}catch(Exception e) {
				System.out.println("숫자만 입력해주세요.");
			}finally {
				scan.nextLine();
			}
		}
	}
	
	public String getValueString(String msg) {
		System.out.println(msg);
		return scan.next();
	}
	
	private String file(String fileName) {
		if(!fileCheck(fileName)) {
			return null;
		}
		String data = "";
		try(FileReader fr = new FileReader(CUR_PATH+fileName);
			BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String rd = br.readLine();
				if(rd == null) break;
				data += rd +"\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean fileCheck(String fileName) {
		File file = new File(CUR_PATH+fileName);
		if(file.exists()) {
			return true;
		}
		return false;
	}
	
	public void fileload(StudentDAO stu, SubjectDAO sub) {
		String studata = file("student.txt");
		String subdata = file("subject.txt");
		if(studata != null) {
			stu.init(studata);
		}
		if(subdata != null) {
			sub.init(subdata);
		}
	}
	private void save(String filename,String data) {
		try(FileWriter fw = new FileWriter(CUR_PATH + filename);){
			fw.write(data);
			System.out.printf("%s 파일 저장 성공%n",filename);
		} catch (IOException e) {
			System.out.printf("%s 파일 저장 실패%n",filename);
		}
	}
	public void fileSave(StudentDAO stu, SubjectDAO sub) {
		String studata = stu.studata();
		String subdata = sub.subdata();
		
		save("student.txt",studata);
		save("subject.txt",subdata);
	}
}
