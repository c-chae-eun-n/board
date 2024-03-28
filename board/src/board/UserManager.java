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

}
