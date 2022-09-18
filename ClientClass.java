import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ClientClass {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "MP1.csv";
		
		try {
		Scanner fileScnr = new Scanner(new FileReader(fileName));
		String firstName;
		String lastName;
		String title;
		int year;
		String genre;
		String publisher;
		double rating;
		double price;
		
		BookDatabase bookLog = new BookDatabase();	
		
		String firstLine = fileScnr.nextLine();
		String[] titles = firstLine.split(",");
		String titleLine = String.format("%-14s %-18s %-105s %-5s %-32s %-45s %-6s %-12s %n",titles[0],titles[1],titles[2],titles[3],titles[4],titles[5],titles[6],titles[7]);
		String border = String.format("%-14s %-18s %-105s %-5s %-32s %-45s %-6s %-12s %n","----- ----","---- ----","------" ,"----","-----","--------","------","------","-----");
		
		while (fileScnr.hasNext()) {
			String fileLine = fileScnr.nextLine();
			String[] line = fileLine.split(",");
			firstName = line[0];
			lastName = line[1];
			title = line[2];
			year = Integer.valueOf(line[3]);
			genre = line[4];
			publisher = line[5];
			rating = Double.valueOf(line[6]);
			price = Double.valueOf(line[7].replace("$", ""));
			
			Author author = new Author(firstName, lastName);
			Book book = new Book(author, title, year, publisher, genre, rating, price);
			bookLog.addBook(book);
			}
		
			System.out.println("All Books in Database :\n");
			System.out.print(titleLine);
			System.out.print(border);
			System.out.println(bookLog.toString());
			System.out.println("\n_____Search Examples______\n");
			
			System.out.println("== Books Published by Dave Eggers in DataBase ==\n");
			//author search example, Dave Eggers has 2 books
			Author authorSearch = new Author();
			authorSearch.setFirstName("Dave");
			authorSearch.setLastName("Eggers");
			ArrayList<Book> authorsBooks = bookLog.search(authorSearch);
			String toPrint = authorsBooks.toString().replace("[", "").replace("]","").replace(", ", "\n");
			System.out.println(toPrint);
			
			System.out.println("Books Removed: \n");
			//remove both books by Jon Stewart
			Author AuthorRemoved = new Author("Jon", "Stewart");
			ArrayList<Book> booksToBeRemoved = bookLog.search(AuthorRemoved);
			for(Book book: booksToBeRemoved) {
				System.out.println("Book Name: " + book.getTitle() + " by " + book.getAuthor()+"\n");
				bookLog.removeBook(book);
			}
			
			System.out.println("== Books Published by Jon Stewart in DataBase ==\n");
			//print all by Jon Stewart which is none left
			Author authorCheck = new Author("Jon", "Stewart");
			ArrayList<Book> booksToBeFound = bookLog.search(authorCheck);
			for(Book book: booksToBeFound) {
				System.out.println(book);
			}
			
			System.out.println("== Books from 1997 to 2000 in DataBase ==\n");
			//year search example from 1997 to 2000 
			ArrayList<Book> booksInTimeSpan = bookLog.search(1997, 2000);
			for(Book book: booksInTimeSpan) {
				System.out.println(book);
			}

			System.out.println("== Books with the genre: Social Sciences in DataBase ==\n");
			//search example all books with the genre Social Sciences
			ArrayList<Book> booksInGenre = bookLog.search("Social Sciences");
			for(Book book: booksInGenre) {
				System.out.println(book);
			}
			
			System.out.println("***********************");
		fileScnr.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
