package board;

import java.util.ArrayList;

public class BoardManager implements CRUD {
	private ArrayList<Board> boardList;
	private UserManager userManager;

	public BoardManager(UserManager userManager) {
		this.userManager = userManager;
		boardList = new ArrayList<>();
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
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
	
	
}
