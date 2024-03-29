package board;

import java.util.Scanner;

public class BoardSystem {
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int POST = 5;
	private final int DELETE = 6;
	private final int VIEW = 7;
	private final int EXIT = 0;
	
	private Scanner scan = new Scanner(System.in);
	
	private UserManager userManager = UserManager.getInstance();
	
	private int log;
	private boolean isExit;
	
	public BoardSystem() {
		log = -1;
		isExit = false;
	}
	
	private void printMainMenu() {
		System.out.println("=== 콘솔 게시판 ===");
		System.out.println("================");
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]게시물 작성");
		System.out.println("[6]게시물 삭제");
		System.out.println("[7]게시물 조회");
		System.out.println("[0]종료");
		System.out.println("================");
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		try {
			System.out.print(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요.");
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
	}
	
	private void runMainMenu(int select) {
		if(select == JOIN) {
			
		}
		else if(select == LEAVE) {
			
		}
		else if(select == LOGIN) {
			
		}
		else if(select == LOGOUT) {
			
		}
		else if(select == POST) {
			
		}
		else if(select == DELETE) {
			
		}
		else if(select == VIEW) {
			
		}
		else if(select == EXIT) {
			isExit();
		}
	}
	
	private void isExit() {
		isExit = true;
	}
	
	public void run() {
		while(!isExit) {
			printMainMenu();
			int select = inputNumber("메뉴 번호 입력");
			runMainMenu(select);
		}
	}
}
