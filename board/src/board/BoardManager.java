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
		int index = 1;
		for(int i=0; i<boardList.size(); i++) {
			Board board = boardList.get(i);
			if(board.getUser().equals(user)) {
				System.out.printf("[%d] %s\n", index++, board.getTitle());
			}
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		userManager.delete(user);
		
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).getUser().equals(user)) {
				boardList.remove(i);
			}
		}
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
	
	public void updateMyPost(User user, int index) {
		String target = userManager.findTitleByIndex(user, index);
		if(target == null)
			return;
		
		for(int i=0; i<boardList.size(); i++) {
			if(target.equals(boardList.get(i).getTitle())){
				String title = inputString("title");
				String body = inputString("content");
				boardList.get(i).setTitle(title);
				boardList.get(i).setBody(body);
			}
		}
	}
	
	
	public void deleteMyPost(User user, int index) {
		Board target = userManager.deleteMyPost(user, index);
		if(target == null)
			return;
		
		for(int i=0; i<boardList.size(); i++) {
			if(target.equals(boardList.get(i))){
				boardList.remove(i);
			}
		}
	}
	
	public int boardListSize() {
		return boardList.size();
	}
	
	public String getBoard(int index) {
		return boardList.get(index).getTitle();
	}
}
