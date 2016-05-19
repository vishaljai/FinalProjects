package cyb.cybnet.dto;

public class Review {
	private int reviewId;
	private int reviewBy;
	private String reviewReview;
	private int reviewBook;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(int reviewBy, String reviewReview, int reviewBook) {
		super();
		this.reviewBy = reviewBy;
		this.reviewReview = reviewReview;
		this.reviewBook = reviewBook;
	}

	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getReviewBy() {
		return reviewBy;
	}
	
	public void setReviewBy(int reviewBy) {
		this.reviewBy = reviewBy;
	}
	
	public String getReviewReview() {
		return reviewReview;
	}
	
	public void setReviewReview(String reviewReview) {
		this.reviewReview = reviewReview;
	}
	
	public int getReviewBook() {
		return reviewBook;
	}
	
	public void setReviewBook(int reviewBook) {
		this.reviewBook = reviewBook;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewBy=" + reviewBy + ", reviewReview=" + reviewReview
				+ ", reviewBook=" + reviewBook + "]";
	}

}
