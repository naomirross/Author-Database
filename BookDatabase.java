import java.util.*;
public class BookDatabase {
	private ArrayList<Book> books;
	
	public BookDatabase(){
		books = new ArrayList<>();
	}

	public BookDatabase(ArrayList<Book> books) {
			this.books = books;
	}
	public void addBook(Book Book){
		books.add(Book);
	}
	
	public void removeBook(Book book) {
		int indexToRemove = books.indexOf(book);
		books.remove(indexToRemove);
	}
	
	public ArrayList<Book> search(Author author){
		ArrayList<Book> booksByAuthor = new ArrayList<>();
		String givenFirst = author.getFirstName();
		String givenLast = author.getLastName();
		for(Book book:books) {
			Book tempBook = book;
			String tempFirst = tempBook.getAuthor().getFirstName();
			String tempLast = tempBook.getAuthor().getLastName();
			if(givenFirst.equals(tempFirst) && givenLast.equals(tempLast)) {
				booksByAuthor.add(tempBook);
			}
		}
		return booksByAuthor;
	}

	public ArrayList<Book> search(int startYear, int endYear){
		ArrayList<Book> booksInTimeSpan = new ArrayList<>();
		for(Book book: books) {
			Book tempBook = book;
			int tempYear = tempBook.getYear();
			if(tempYear >= startYear && tempYear <= endYear) {
				booksInTimeSpan.add(tempBook);
			}
		}
		return booksInTimeSpan;
	}
	
	public ArrayList<Book> search(String genre){
		ArrayList<Book> booksInGenre = new ArrayList<>();
		for(Book book: books) {
			Book tempBook = book;
			String tempGenre = tempBook.getGenre();
			if(genre.equals(tempGenre)) {
				booksInGenre.add(tempBook);
			}
		}
		return booksInGenre;
	}
	@Override
	public String toString() {
		String toPrint = "";
		for(Book book: books) {
			
			toPrint += String.format("%-14s %-18s %-105s %-5d %-32s %-45s %-6s %-12s\n",
					book.getAuthor().getFirstName(),book.getAuthor().getLastName(),book.getTitle(),book.getYear(),book.getGenre(),book.getPublisher(),book.getRating(), book.getPrice());
		}
		return toPrint;
	}
} 
