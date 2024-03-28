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
	
	public int findUserindexById(String id) {
		for(int i=0; i<userList.size(); i++) {
			User user = userList.get(i);
			if(user.getId().equals(id))
				return i;
		}
		return -1;
	}
	
	// Read
	public User getUser(int index) {
		User user = userList.get(index);
		return user;
	}
	
}
