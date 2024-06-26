package board;

import java.util.Scanner;

public class BoardSystem {
	
	private final int JOIN = '1';
	private final int LEAVE = '2';
	private final int LOGIN = '3';
	private final int LOGOUT = '4';
	private final int POST = '5';
	private final int VIEW = '6';
	private final int MYPAGE = '7';
	private final int EXIT = '0';
	
	private final int VIEW_MYPOST = 1;
	private final int UPDATE_MYPOST = 2;
	private final int DELETE_MYPOST = 3;
	private final int EXIT_MYPOST = 0;
	
	private final int TYPE_OUT = 1;
	private final int TYPE_IN = 2;
	
	private final char PREVIOUS = 'a';
	private final char NEXT = 'd';
	
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager;
	private BoardManager boardManager;
	
	private int pageSize = 5;			// 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1;			// 현재 페이지 번호
	private int pageCount = 1;			// 전체 페이지 개수
	private int startRow = 0;			// 현재 페이지의 게시글 시작 번호
	private int endRow = 0;				// 현재 페이지의 게시글 마지막 번호
	private int count;
	
	private User log;
	private boolean isExit;
	
	public BoardSystem() {
		userManager = UserManager.getInstance();
		boardManager = BoardManager.getInstance();
		log = null;
		isExit = false;
	}
	
	private void paging() {
		// paging
		count = boardManager.boardListSize();
		
		startRow = (curPageNum - 1) * pageSize;
		endRow = startRow + pageSize - 1;
		endRow = endRow >= count ? count - 1 : endRow;
		
		pageCount = count / pageSize;
		pageCount = count % pageSize > 0 ? ++ pageCount : pageCount;
		
		System.out.println("--------------------------");
		for(int i=startRow; i<=endRow; i++) {
			System.out.printf(" %d) %s\n", i+1, boardManager.getBoardTitle(i));
		}
		System.out.println("--------------------------");
		System.out.printf("  ◀ 이전(a)  %d/%d  다음(d) ▶\n", curPageNum, pageCount);
	}
	
	private void printMainMenu() {
		System.out.println("\n======== 콘솔 게시판 ========");
		paging();
		System.out.println("==========================");
		System.out.println(" [1] 회원가입");
		System.out.println(" [2] 회원탈퇴");
		System.out.println(" [3] 로그인");
		System.out.println(" [4] 로그아웃");
		System.out.println(" [5] 게시물 작성");
		System.out.println(" [6] 게시글 조회");
		System.out.println(" [7] 마이페이지");
		System.out.println(" [0] 종료");
		System.out.println("==========================");
	}
	
	private void printMypageMenu() {
		System.out.println("\n======== 마이 페이지 ========");
		System.out.println(" [1] 내 게시글 조회");
		System.out.println(" [2] 내 게시글 수정");
		System.out.println(" [3] 내 게시글 삭제");
		System.out.println("==========================");
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
	
	private void runMainMenu(char select) {
		if(select == PREVIOUS) {
			previous();
		}
		else if(select == NEXT) {
			next();
		}
		else if(select == JOIN && checkLog(TYPE_OUT)) {
			join();
		}
		else if(select == LEAVE && checkLog(TYPE_IN)) {
			leave();
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
		else if(select == VIEW && checkLog(TYPE_IN)) {
			view();
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
			viewMyPost();
		}
		else if(sel == UPDATE_MYPOST) {
			updateMyPost();
		}
		else if(sel == DELETE_MYPOST) {
			deleteMyPost();
		}
	}
	
	private void previous() {
		if(curPageNum == 1) 
			return;
		curPageNum --;
	}
	
	private void next() {
		if(curPageNum == pageCount) 
			return;
		curPageNum ++;
	}
	
	private void join() {
		String id = inputString("id");
		String password = inputString("password");
		User user = new User(id, password);
		
		userManager.create(user);
	}
	
	private void leave() {
		String password = inputString("password");
		if(!password.equals(log.getPassword())) {
			System.err.println("회원정보가 일치하지 않습니다.");
			return;
		}
		
		for(int i=0; i<userManager.myBoardSize(log); i++) {
			Board board = userManager.findBoardByIndex(log, i);
			if(board == null)
				continue;
			boardManager.delete(board);
		}
		userManager.delete(log);
		
		logout();
		System.out.println("탈퇴가 완료되었습니다.");
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
		String title = boardManager.inputString("Title");
		String body = boardManager.inputString("Content");
		Board board = new Board(title, body, log);
		boardManager.create(board);
		userManager.addUserBoard(log, board);
	}
	
	private void view() {
		int sel = inputNumber("조회할 게시글 번호 입력");
		if(sel < 1 || sel > count) 
			return;
		System.out.print("\n"+boardManager.getBoard(sel-1));
	}
	
	private void viewMyPost() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			userManager.read(log);
			int sel = inputNumber("\n조회할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT_MYPOST) {
				break;
			}
			
			Board board = userManager.findBoardByIndex(log, sel-1);
			boardManager.read(board);
		}
	}
	
	private void updateMyPost() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			userManager.read(log);
			int sel = inputNumber("\n수정할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT_MYPOST) {
				break;
			}
			
			Board board = userManager.findBoardByIndex(log, sel-1);
			boardManager.update(board);
			System.out.println("수정이 완료되었습니다.");
		}
	}
	
	private void deleteMyPost() {
		if(userManager.myBoardSize(log) == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		while(true) {
			userManager.read(log);
			int sel = inputNumber("\n삭제할 게시물 번호 입력(종료 : 0번)");
			if(sel == EXIT_MYPOST) {
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
			printMainMenu();
			char select = inputString("메뉴 번호 입력").charAt(0);
			runMainMenu(select);
		}
	}
}
