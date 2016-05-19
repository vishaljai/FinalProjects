package cyb.cybnet.dao;

import java.sql.SQLException;
import java.util.List;

import cyb.cybnet.dto.Book;
import cyb.cybnet.exception.BookDAOException;

public interface BookDAO {
	public void addBook(Book book) throws SQLException,BookDAOException;
	//public Book updateBook(Book book);
	public Book deleteBook(Book book) throws SQLException,BookDAOException;
	public Book getBook(Book book) throws SQLException,BookDAOException;
	public List<Book> getBookList() throws SQLException,BookDAOException;
	public List<Book> getBookListByName(String name) throws SQLException,BookDAOException;
}	
