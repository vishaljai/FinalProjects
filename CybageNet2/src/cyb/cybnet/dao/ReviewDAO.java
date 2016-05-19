package cyb.cybnet.dao;

import java.sql.SQLException;
import java.util.List;

import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.Review;
import cyb.cybnet.exception.ReviewDAOException;

public interface ReviewDAO {
	public void addReview(Review Review) throws SQLException,ReviewDAOException;
	//public Review updateReview(Review Review);
	//public Review deleteReview(Review Review);
	public List<Review> getReviewListByBook(Book book) throws SQLException,ReviewDAOException;
}	
