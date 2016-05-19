package cyb.cybnet.dto;

public class Book {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private int bookISBN;
	private int bookNOP;
	private String bookPublication;
	private String bookDescription;
	private String bookGenre;
	private byte[] bookCover;
	
	public Book() {}
	
	
	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}


	public Book(String bookTitle, String bookAuthor, int bookISBN, int bookNOP, String bookPublication,
			String bookDescription, String bookGenre, byte[] bookCover) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookISBN = bookISBN;
		this.bookNOP = bookNOP;
		this.bookPublication = bookPublication;
		this.bookDescription = bookDescription;
		this.bookGenre = bookGenre;
		this.bookCover = bookCover;
	}


	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public int getBookISBN() {
		return bookISBN;
	}
	
	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	public int getBookNOP() {
		return bookNOP;
	}
	
	public void setBookNOP(int bookNOP) {
		this.bookNOP = bookNOP;
	}
	
	public String getBookPublication() {
		return bookPublication;
	}
	
	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public byte[] getBookCover() {
		return bookCover;
	}
	
	public void setBookCover(byte[] bookCover) {
		this.bookCover = bookCover;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookISBN="
				+ bookISBN + ", bookNOP=" + bookNOP + ", bookPublication=" + bookPublication + ", bookDescription="
				+ bookDescription + ", bookGenre=" + bookGenre + "]";
	}
	
}
