package cyb.cybnet.dao.impl.test;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.util.DBUtility;

public class BookDaoImplTest {

	public static void main(String[] args) throws Exception{
		BookDAO bookDao = new BookDAOImpl(DBUtility.getConnection());
		
		byte [] b = new byte[1];
		//bookDao.addBook(new Book("Java Programming", "James Gousling", 1234, 230, "Oracle","This is a good book", "Technical",b));
		
		//System.out.println("Book : "+ bookDao.getBook(new Book(3)));
		
		for(Book bk :bookDao.getBookListByName("Jav")){
			System.out.println(bk);
		}
		
		
		//bookDao.deleteBook(new Book(1));
		
	}

}
