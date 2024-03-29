package board;

public class BoardSystem {
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int POST = 5;
	private final int DELETE = 6;
	private final int VIEW = 7;
	private final int EXIT = 0;
	
	private UserManager userManager = UserManager.getInstance();
	
	private int log;
	
	public BoardSystem() {
		log = -1;
	}
	
	private void printMainMenu() {
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]게시물 작성");
		System.out.println("[6]게시물 삭제");
		System.out.println("[7]게시물 조회");
		System.out.println("[0]종료");
	}
	
	public void run() {
		
	}
}
