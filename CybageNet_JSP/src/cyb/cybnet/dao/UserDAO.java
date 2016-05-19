package cyb.cybnet.dao;

import java.sql.SQLException;
import java.util.List;

import cyb.cybnet.dto.User;
import cyb.cybnet.exception.UserDAOException;

public interface UserDAO {
	//public User addUser(User user);
	//public User updateUser(User user);
	//public User deleteUser(User user);
	public User getUser(User user) throws SQLException,UserDAOException;
	public User getUserById(User user) throws SQLException,UserDAOException;
	//public List<User> getUserList();
}
