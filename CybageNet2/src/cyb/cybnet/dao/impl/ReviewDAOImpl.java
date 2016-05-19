package cyb.cybnet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cyb.cybnet.dao.ReviewDAO;
import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.Review;
import cyb.cybnet.exception.ReviewDAOException;

public class ReviewDAOImpl implements ReviewDAO {

	PreparedStatement prtAddReview,prtReviewList;
	public ReviewDAOImpl(Connection conn) {
		try{
			prtAddReview = conn.prepareStatement("INSERT INTO `cybnet_db`.`reviews` (`review_by`, `review_review`, `review_book`) VALUES (?, ?, ?);");
			prtReviewList = conn.prepareStatement("select * from reviews where review_book = ?");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	public void addReview(Review review) throws SQLException,ReviewDAOException{
		prtAddReview.setInt(1, review.getReviewBy());
		prtAddReview.setString(2, review.getReviewReview());
		prtAddReview.setInt(3, review.getReviewBook());
		if(prtAddReview.executeUpdate()==0){
			throw new ReviewDAOException("Unable to add book");
		}
	}

	@Override
	public List<Review> getReviewListByBook(Book book) throws SQLException,ReviewDAOException{
		List<Review> list = new LinkedList<>();
		prtReviewList.setInt(1, book.getBookId());
		ResultSet rs = prtReviewList.executeQuery();
		if(rs.next()){
			do{
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setReviewBy(rs.getInt("review_by"));
				review.setReviewReview(rs.getString("review_review"));
				review.setReviewBook(rs.getInt("review_book"));
				list.add(review);
			} 
			while(rs.next());
		}
		else{
			throw new ReviewDAOException("no books found");
		}
		return list;
		
	}

}
