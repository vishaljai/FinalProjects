package cyb.cybnet.dao.impl;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dto.Book;
import cyb.cybnet.exception.BookDAOException;

public class BookDAOImpl implements BookDAO {

	PreparedStatement prtAddBook,prtDeleteBook,prtGetBook,prtGetBookList,prtGetBookListByName;
	public BookDAOImpl(Connection conn) {
		try{
			prtAddBook = conn.prepareStatement("INSERT INTO books(`bk_title`, `bk_author`, `bk_isbn`, `bk_nop`, `bk_publication`, `bk_description`, `bk_genre`,`bk_cover`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			//prtUpdateBook = conn.prepareStatement("UPDATE books SET bk_title=?, bk_author=?, bk_isbn=?, bk_nop=?, bk_publication=?, bk_description=?, bk_genre=?, bk_cover=? WHERE bk_id=?;");
			prtDeleteBook = conn.prepareStatement("DELETE FROM books WHERE bk_id=?;");
			prtGetBook = conn.prepareStatement("select * from books WHERE bk_id=?;");
			prtGetBookList = conn.prepareStatement("select * from books");
			prtGetBookListByName = conn.prepareStatement("select * from books where bk_title like ?");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void addBook(Book book) throws SQLException,BookDAOException{
		prtAddBook.setString(1, book.getBookTitle());
		prtAddBook.setString(2, book.getBookAuthor());
		prtAddBook.setInt(3, book.getBookISBN());
		prtAddBook.setInt(4, book.getBookNOP());
		prtAddBook.setString(5, book.getBookPublication());
		prtAddBook.setString(6, book.getBookDescription());
		prtAddBook.setString(7, book.getBookGenre());
		prtAddBook.setBytes(8, book.getBookCover());
		if(prtAddBook.executeUpdate()==0){
			throw new BookDAOException("Failed to add book");
		}
	}

	@Override
	public Book deleteBook(Book book) throws SQLException,BookDAOException {
		prtDeleteBook.setInt(1,book.getBookId());
		Book retBook = getBook(book);
		if(prtDeleteBook.executeUpdate()==0){
			throw new BookDAOException("Failed to delete book");
		}
		else{
			return retBook;
		}
	}

	@Override
	public Book getBook(Book book) throws SQLException,BookDAOException{
		prtGetBook.setInt(1, book.getBookId());
		ResultSet rs = prtGetBook.executeQuery();
		if(rs.next()){
			book.setBookId(rs.getInt("bk_id"));
			book.setBookTitle(rs.getString("bk_title"));
			book.setBookAuthor(rs.getString("bk_author"));
			book.setBookISBN(rs.getInt("bk_isbn"));
			book.setBookNOP(rs.getInt("bk_nop"));
			book.setBookPublication(rs.getString("bk_publication"));
			book.setBookDescription(rs.getString("bk_description"));
			book.setBookGenre(rs.getString("bk_genre"));
			book.setBookCover(rs.getBytes("bk_cover"));
			return book;
		}
		else{
			throw new BookDAOException("Book not found");
		}
	}

	@Override
	public List<Book> getBookList() throws SQLException,BookDAOException{
		List<Book> list = new LinkedList<>();
		ResultSet rs = prtGetBookList.executeQuery();
		if(rs.next()){
			do{
				Book book  = new Book();
				book.setBookId(rs.getInt("bk_id"));
				book.setBookTitle(rs.getString("bk_title"));
				book.setBookAuthor(rs.getString("bk_author"));
				book.setBookISBN(rs.getInt("bk_isbn"));
				book.setBookNOP(rs.getInt("bk_nop"));
				book.setBookPublication(rs.getString("bk_publication"));
				book.setBookDescription(rs.getString("bk_description"));
				book.setBookGenre(rs.getString("bk_genre"));
				book.setBookCover(rs.getBytes("bk_cover"));
				list.add(book);
			}
			while(rs.next());
		}
		else{
			throw new BookDAOException("No Book/s found");
		}
		return list;
	}
	
	@Override
	public List<Book> getBookListByName(String name) throws SQLException, BookDAOException {
		List<Book> list = new LinkedList<>();
		prtGetBookListByName.setString(1, ("%"+name+"%"));
		ResultSet rs = prtGetBookListByName.executeQuery();
		if(rs.next()){
			do{
				Book book  = new Book();
				book.setBookId(rs.getInt("bk_id"));
				book.setBookTitle(rs.getString("bk_title"));
				book.setBookAuthor(rs.getString("bk_author"));
				book.setBookISBN(rs.getInt("bk_isbn"));
				book.setBookNOP(rs.getInt("bk_nop"));
				book.setBookPublication(rs.getString("bk_publication"));
				book.setBookDescription(rs.getString("bk_description"));
				book.setBookGenre(rs.getString("bk_genre"));
				book.setBookCover(rs.getBytes("bk_cover"));
				list.add(book);
			}
			while(rs.next());
		}
		else{
			throw new BookDAOException("No Book/s found");
		}
		return list;
	}
}
