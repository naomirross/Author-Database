
public class Author {
	private String firstName;
	private String lastName;
	
	public Author() {
		this.setFirstName(" ");
		this.setLastName(" ");
	}
	
	public Author(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Author(first, last) : " + getFirstName() + " " + getLastName(); 
	}
}