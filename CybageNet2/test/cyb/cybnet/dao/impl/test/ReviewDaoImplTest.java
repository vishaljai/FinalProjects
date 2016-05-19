package cyb.cybnet.dao.impl.test;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dao.ReviewDAO;
import cyb.cybnet.dao.impl.ReviewDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.Review;
import cyb.cybnet.util.DBUtility;

public class ReviewDaoImplTest {
	public static void main(String[] args) throws Exception{
		ReviewDAO reviewDAO = new ReviewDAOImpl(DBUtility.getConnection());
		//reviewDAO.addReview(new Review(1, "very nice", 2));
		
		for(Review r : reviewDAO.getReviewListByBook(new Book(0))){
			System.out.println(r);
		}
		
		
	}
}
