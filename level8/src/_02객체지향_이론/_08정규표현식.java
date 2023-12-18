package _02객체지향_이론;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Reqular Expression

public class _08정규표현식 {

	public static void main(String[] args) {
		
		String acc = "1111-1111-1111";
		String accPattern = "^\\d{4}-\\d{4}-\\d{4}$"; //^ : 시작표현 $ : 끝표현
		Pattern p = Pattern.compile(accPattern);
		Matcher m = p.matcher(acc);
		
		System.out.println(m.matches()?"올바른 계좌번호" : "틀린 계좌번호");
	}

}
