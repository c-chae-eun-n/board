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

	// 검수용
	public void printUserAll() {
		List keySet = new ArrayList(userList.keySet());
		System.out.println(keySet);
	}
	
}
