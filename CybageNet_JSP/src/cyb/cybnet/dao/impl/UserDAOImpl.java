package cyb.cybnet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cyb.cybnet.dao.UserDAO;
import cyb.cybnet.dto.User;
import cyb.cybnet.exception.UserDAOException;
import cyb.cybnet.util.DBUtility;

public class UserDAOImpl implements UserDAO {

	Connection conn;
	PreparedStatement prtGetUser,prtGetUserById;
	
	public UserDAOImpl(){
		this.conn = DBUtility.getConnection();
		initializeStatements();
	}
	
	public UserDAOImpl(Connection conn) {
		this.conn = conn;
		initializeStatements();
	}
	
	private void initializeStatements(){
		try{
			prtGetUser = conn.prepareStatement("Select * from users where user_name = ?");
			prtGetUserById = conn.prepareStatement("Select * from users where user_id = ?");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public User getUser(User user) throws SQLException,UserDAOException{
		prtGetUser.setString(1,user.getUserName());
		ResultSet rs = prtGetUser.executeQuery();
		if(rs.next()){
			user.setUserId(rs.getInt("user_id"));
			user.setUserPass(rs.getString("user_pass"));
			user.setUserRole(rs.getString("user_role"));
			return user;
		}
		else{
			throw new UserDAOException("user not found");
		}
		
	}
	@Override
	public User getUserById(User user) throws SQLException, UserDAOException {
		prtGetUserById.setInt(1,user.getUserId());
		ResultSet rs = prtGetUserById.executeQuery();
		if(rs.next()){
			user.setUserName(rs.getString("user_name"));
			user.setUserPass(rs.getString("user_pass"));
			user.setUserRole(rs.getString("user_role"));
			return user;
		}
		else{
			throw new UserDAOException("user not found");
		}
	}

}
