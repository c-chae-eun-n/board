package board;

public class User {
	private String id, password;
	
	public User() {
		
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public User clone() {
		return new User(this.id, this.password);
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", this.id, this.password);
	}
}
