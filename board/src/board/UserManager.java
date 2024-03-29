package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager implements CRUD {
	
	private Map<User, ArrayList<Board>> userList;
	
	public UserManager(){
		userList = new HashMap<>();
	}

	@Override
	public void crate(User user) {
		if(isValid(user).getId() == null) {
			System.err.println("이미 존재하는 아이디입니다.");
			return;
		}
		ArrayList<Board> userBoard = new ArrayList<>();
		userList.put(user, userBoard);
	}
	
	private User isValid(User user) {
		if(userList.containsKey(user)) {
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

	
	
}
