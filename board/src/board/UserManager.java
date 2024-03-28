package board;

import java.util.ArrayList;

public class UserManager {
	private ArrayList<User> userList;
	
	private UserManager() {
		userList = new ArrayList<>();
	}
	
	private static UserManager instance = new UserManager(); 
	
	public static UserManager getInstance() {
		return instance;
	}

	// Create
	public User createUser(String id, String password) {
		if(isValidId(id)) {
			User user = new User(id, password);
			userList.add(user);
			return user.clone();
		}
		return new User();
	}
	
	private boolean isValidId(String id) {
		User user = findUserById(id);
		if(user.getId() == null)
			return true;
		return false;
	}
	
	public User findUserById(String id) {
		for(User user : userList) {
			if(user.getId().equals(id))
				return user;
		}
		return new User();
	}
	
}
