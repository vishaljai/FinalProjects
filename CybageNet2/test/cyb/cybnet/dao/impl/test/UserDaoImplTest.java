package cyb.cybnet.dao.impl.test;

import cyb.cybnet.dao.UserDAO;
import cyb.cybnet.dao.impl.UserDAOImpl;
import cyb.cybnet.dto.User;
import cyb.cybnet.util.DBUtility;

public class UserDaoImplTest {
	public static void main(String[] args) throws Exception{
		UserDAO userDao = new UserDAOImpl(DBUtility.getConnection());
		System.out.println(userDao.getUser(new User("admin")));
	}
}
