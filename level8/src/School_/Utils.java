package School_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	
	final String CUR_PATH = System.getProperty("user.dir") + "\\src\\School_박연미\\";
	Scanner sc = new Scanner(System.in);
	
	// 예외처리 정수만 입력해주세요 
	int getValue(String msg, int start, int end) {
		while (true) {
			System.out.printf("▶ %s[%d-%d] 입력: ", msg, start, end);
			try {
				int num = sc.nextInt();
				sc.nextLine();
				if (num < start || num > end) {
					System.out.println(start + " ~ " + end + " 값 입력해주세요");
					continue;
				}
				return num;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("숫자값을 입력해주세요");
			}
		}
	}

	String getValue(String msg) {
		System.out.printf("▶ %s 입력: ", msg);
		return sc.next();
	}
	
	void closeScanner() {
		sc.close();
	}
	
	

	String loadData(String fileName) {
		String data ="";
		try (FileReader fr = new FileReader(CUR_PATH + fileName)) {
			while (true) {
				int str = fr.read(); 
				if (str ==-1) {
					break;
				}
				data += (char)str;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	void loadFromFile(StudentDAO stuDAO , SubjectDAO subDAO) {
		String stuData = loadData("student.txt");
		String subData = loadData("subject.txt");
		stuDAO.addStuFromData(stuData);
		subDAO.addSubFromData(subData);
		System.out.println("데이터 로드 완료");
	}
	
	
	
	void saveToFile(StudentDAO stuDAO , SubjectDAO subDAO) {
		String stuData =stuDAO.saveAsFileData();
		String subData=subDAO.saveAsFileData();
		
		save("student.txt", stuData);
		save("subject.txt",subData);
		
	}
	
	void save(String fileName, String data) {
		try (FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
			fw.write(data);
			System.out.println(fileName +" 저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
