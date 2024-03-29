package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager implements CRUD {
	
	private Scanner scan = new Scanner(System.in);
	
	private ArrayList<Board> boardList;
	private UserManager userManager;

	public BoardManager(UserManager userManager) {
		this.userManager = userManager;
		boardList = new ArrayList<>();
	}

	@Override
	public void create(User user) {
		String title = inputString("title");
		String body = inputString("content");
		Board board = new Board(title, body, user);
		
		boardList.add(board);
		userManager.addUserBoard(user, board);
		System.out.println("작성이 완료되었습니다.");
	}

	@Override
	public void read(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}
	
	private String inputString(String message) {
		System.out.println(message + " : ");
		System.out.println("[.] 완료(문장에 끝에 .을 붙이면 종료)");
		
		String data = "";
		while(true) {
			String line = scan.nextLine();
			data += line + "\n";
			
			if(line.charAt(line.length()-1) == '.') {
				data = data.substring(0, data.length()-1);
				break;
			}
		}
		
		return data;
	}
	
	public void printBoardAll() {
		for(Board board : boardList) {
			System.out.println(board);
		}
	}
	
}
