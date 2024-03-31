package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager implements CRUD {
	
	private Map<User, ArrayList<Board>> userList;
	
	public UserManager(){
		userList = new HashMap<>();
	}

	@Override
	public void create(User user) {
		if(isValid(user).getId() == null) {
			System.err.println("이미 존재하는 아이디입니다.");
			return;
		}
		ArrayList<Board> userBoard = new ArrayList<>();
		userList.put(user, userBoard);
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	private User isValid(User user) {
		for(User key : userList.keySet()) {
			if(key.getId().equals(user.getId()))
				return new User();
		}
		return user;
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
	
	public User checkLog(String id, String password) {
		User user = null;
		for(User key : userList.keySet()) {
			if(key.getId().equals(id) && key.getPassword().equals(password))
				user = key;
		}
		return user;
	}
	
	public void addUserBoard(User user, Board board) {
		userList.get(user).add(board);
	}
	
	public void printMyBoardAll(User user) {
		System.out.println("=== 내 게시물 ===");
		if(userList.get(user).size() == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		for(int i=0; i<userList.get(user).size(); i++) {
			System.out.printf("[%d] ", i+1);
			System.out.println(userList.get(user).get(i).getTitle());
		}
	}
	
	public void printMyBoard(User user, int sel) {
		System.out.println(userList.get(user).get(sel));
	}

	// 검수용
	public void printUserAll() {
		List keySet = new ArrayList(userList.keySet());
		System.out.println(keySet);
	}
	
	public void printUserBoardAll(User user) {
		for(int i=0; i<userList.get(user).size(); i++) {
			Board board = userList.get(user).get(i);
			System.out.println(board);
		}
	}
	
}
