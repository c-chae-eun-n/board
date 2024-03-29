package board;

public class Board {
	String title;
	String body;
	
	public Board(String title, String body) {
		this.title = title;
		this.body = body;
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
