package School_김진수Ver1;
/*
 	무조건 파일 업로드 먼저
 	
 	처음부터 우리 데이터가 연결된 상태
 */
public class Controller {

	private StudentDAO stuDAO;
	private SubjectDAO subDAO;
	private Util scan;
	public Controller(){
		stuDAO = new StudentDAO();
		subDAO = new SubjectDAO();
		scan = new Util();
	}
	private void mainMenu() {
		while(true) {
			System.out.println("[1]학생추가"); // 학번(1001) 자동증가 : 학생id 중복 불가
			System.out.println("[2]학생삭제"); // 학생 id 입력후 삭제 과목도 같이 삭제
			System.out.println("[3]학생의과목추가"); // 점수 랜덤 50 - 100 : 과목이름 중복 저장 불가능
			System.out.println("[4]학생의과목삭제"); // 학번 입력후 과목 이름 받아서 해당 과목 에서 학생1명 삭제
			System.out.println("[5]전체학생목록"); // 점수로 (오름차순) 출력
			System.out.println("[6]과목별학생목록"); // 과목이름 입력 받아서 해당 과목 학생 이름과 과목점수 출력 (오름차순)4
			System.out.println("[7] 파일 저장");
			System.out.println("[8] 파일 로드");
			System.out.println("[0] 종    료");
			
			int sel = scan.getValue("메뉴선택 : ",0,8);
			if(sel == 1) {
				System.out.println("[학생추가]");
				stuDAO.studentJoin();
			}else if(sel == 2) {
				System.out.println("[학생삭제]");
				stuDAO.studentDelete(subDAO);
			}else if(sel == 3) {
				System.out.println("[학생의과목추가]");
				subDAO.subjectJoin(stuDAO);
			}else if(sel == 4) {
				System.out.println("[학생의과목삭제]");
				subDAO.subjectDelete(stuDAO);
			}else if(sel == 5) {
				System.out.println("[전체학생목록]");
				stuDAO.studentAllprint(subDAO);
			}else if(sel == 6) {
				System.out.println("[과목별학생목록]");
				subDAO.subjectprint(stuDAO);
			}else if(sel == 7) {
				System.out.println("[파일 저장]");
				scan.fileSave(stuDAO, subDAO);
			}else if(sel == 8) {
				System.out.println("[파일 로드]");
				scan.fileload(stuDAO, subDAO);
			}else if(sel == 0) {
				System.out.println("종료...");
				break;
			}
		}
		
	}
	public void run() {
		mainMenu();
		scan.scanClose();
	}

}
