package cyb.cybnet.dto;

public class User {
	private int userId;
	private String userName;
	private String userPass;
	private String userRole;
	
	public User(int userId) {
		super();
		this.userId = userId;
	}
	
	public User(String userName) {
		super();
		this.userName = userName;
	}
	
	public User(int userId, String userName, String userPass, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPass() {
		return userPass;
	}
	
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userRole=" + userRole
				+ "]";
	}
}
