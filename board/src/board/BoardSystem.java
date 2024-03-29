package board;

public class BoardSystem {
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int POST = 5;
	private final int DELETE = 6;
	private final int VIEW = 7;
	
	private UserManager userManager = UserManager.getInstance();
	
	private int log;
	
	public BoardSystem() {
		log = -1;
	}
	
	
	public void run() {
		
	}
}
