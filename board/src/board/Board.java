package board;

public class Board {
	String title, body;
	User user;
	
	public Board(String title, String body, User user) {
		this.title = title;
		this.body = body;
		this.user = user;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public User getUser() {
		return this.user;
	}
	
	@Override
	public String toString() {
		String info = "";
		
		info += "================\n";
		info += " " + this.title + "\n";
		info += "================\n";
		info += " " + this.body + "\n";
		info += "================\n";
		
		return info;
	}
}
