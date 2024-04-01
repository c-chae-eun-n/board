package board;

import java.util.Scanner;

public class BoardSystem {
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int POST = 5;
	private final int MYPAGE = 6;
	private final int EXIT = 0;
	
	private final int VIEW_MYPOST = 1;
	private final int UPDATE_MYPOST = 2;
	private final int DELETE_MYPOST = 3;
	
	private final int TYPE_OUT = 1;
	private final int TYPE_IN = 2;
	
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager;
	private BoardManager boardManager;
	
	private int pageSize = 5;			// 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1;			// 현재 페이지 번호
	private int pageCount = 1;			// 전체 페이지 개수
	private int startRow = 0;			// 현재 페이지의 게시글 시작 번호
	private int endRow = 0;				// 현재 페이지의 게시글 마지막 번호
	
	private User log;
	private boolean isExit;
	
	public BoardSystem() {
		userManager = new UserManager();
		boardManager = new BoardManager(userManager);
		log = null;
		isExit = false;
	}
	
	private void printMainMenu() {
		System.out.println("=== 콘솔 게시판 ===");
		System.out.println("================");
		System.out.println(" [1] 회원가입");
		System.out.println(" [2] 회원탈퇴");
		System.out.println(" [3] 로그인");
		System.out.println(" [4] 로그아웃");
		System.out.println(" [5] 게시물 작성");
		System.out.println(" [6] 마이페이지");
		System.out.println(" [0] 종료");
		System.out.println("================");
	}
	
	private void printMypageMenu() {
		System.out.println("[1] 내 게시물 조회");
		System.out.println("[2] 내 게시물 수정");
		System.out.println("[3] 내 게시물 삭제");
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
	
	private boolean checkLog(int typeCode) {
		boolean result = false;
		
		if(typeCode == TYPE_OUT) {
			if(log == null)
				result = true;
			else
				System.err.println("로그아웃 후 사용 가능합니다.");
		}else if(typeCode == TYPE_IN) {
			if(log != null)
				result = true;
			else
				System.err.println("로그인 후 사용 가능합니다.");
		}
		
		return result;
	}
	
	private void runMainMenu(int select) {
		if(select == JOIN && checkLog(TYPE_OUT)) {
			join();
		}
		else if(select == LEAVE && checkLog(TYPE_IN)) {
			
		}
		else if(select == LOGIN && checkLog(TYPE_OUT)) {
			login();
		}
		else if(select == LOGOUT && checkLog(TYPE_IN)) {
			logout();
		}
		else if(select == POST && checkLog(TYPE_IN)) {
			post();
		}
		else if(select == MYPAGE && checkLog(TYPE_IN)) {
			printMypageMenu();
			int sel = inputNumber("메뉴 번호 입력");
			runMypageMenu(sel);
		}
		else if(select == EXIT) {
			isExit();
		}
	}
	
	private void runMypageMenu(int sel) {
		if(sel == VIEW_MYPOST) {
			view();
		}
		else if(sel == UPDATE_MYPOST) {
			update();
		}
		else if(sel == DELETE_MYPOST) {
			delete();
		}
	}
	
	private void join() {
		String id = inputString("id");
		String password = inputString("password");
		User user = new User(id, password);
		
		userManager.create(user);
	}
	
	private void login() {
		String id = inputString("id");
		String password = inputString("password");
		User user = userManager.checkLog(id, password);
		if(user == null) {
			System.err.println("회원정보를 다시 확인하세요.");
			return;
		}
		log = user;
		System.out.println("로그인이 완료되었습니다.");
	}
	
	private void logout() {
		log = null;
		System.out.println("로그아웃이 완료되었습니다.");
	}
	
	private void post() {
		boardManager.create(log);
		boardManager.printBoardAll();
	}
	
	private void view() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			userManager.read(log);
			int sel = inputNumber("조회할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT) {
				break;
			}
			
			userManager.printMyBoard(log, sel-1);
		}
	}
	
	private void update() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			boardManager.read(log);
			int sel = inputNumber("수정할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT) {
				break;
			}
			
			boardManager.updateMyPost(log, sel-1);
			System.out.println("수정이 완료되었습니다.");
		}
	}
	
	private void delete() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			userManager.read(log);
			int sel = inputNumber("삭제할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT) {
				break;
			}
			
			boardManager.deleteMyPost(log, sel-1);
			System.out.println("삭제가 완료되었습니다.");
		}
	}
	
	private void isExit() {
		isExit = true;
	}
	
	public void run() {
		while(!isExit) {
			userManager.printUserAll();
			printMainMenu();
			int select = inputNumber("메뉴 번호 입력");
			runMainMenu(select);
		}
	}
}
