package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager implements CRUDManager<Board> {
	
	private Scanner scan = new Scanner(System.in);
	
	private ArrayList<Board> boardList;
	private UserManager userManager;

	private BoardManager(UserManager userManager) {
		this.userManager = userManager;
		boardList = new ArrayList<>();
	}
	
	private static BoardManager instance = new BoardManager(UserManager.getInstance());
	
	public static BoardManager getInstance() {
		return instance;
	}

	@Override
	public void create(Board board) {
		boardList.add(board);
		System.out.println("작성이 완료되었습니다.");
	}

	@Override
	public void read(Board board) {
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).equals(board)) {
				System.out.print("\n" + boardList.get(i));
			}
		}
	}

	@Override
	public void update(Board board) {
		if(board == null)
			return;
		
		for(int i=0; i<boardList.size(); i++) {
			if(board.equals(boardList.get(i))){
				String title = inputString("title");
				String body = inputString("content");
				boardList.get(i).setTitle(title);
				boardList.get(i).setBody(body);
			}
		}
	}

	@Override
	public void delete(Board board) {
		for(int i=0; i<boardList.size(); i++) {
			if(boardList.get(i).equals(board)) {
				boardList.remove(i);
				i--;
			}
		}
	}
	
	public String inputString(String message) {
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
	
	public String getBoardTitle(int index) {
		return boardList.get(index).getTitle();
	}
	
	public Board getBoard(int index) {
		return boardList.get(index);
	}
}
