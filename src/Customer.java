import java.util.*;
/**
 * A Customer class that implements the Comparator interface. 
 * @author Irene Ong
 * @version 1.0
 */
public class Customer implements Comparator<Customer> {
	private String first_name;
	private String last_name;
	private String phone_number;
    
	/**
	 * Default constructor that initializes each variable to an empty string.
	 */
	public Customer() {
		this.first_name = "";
		this.last_name = "";
		this.phone_number = "";
	}
	
	/**
	 * Constructor that initializes each variable their respective local variables.
	 * @param  f    String that represents customer's first name  
	 * @param  l    String that represents customer's last name
	 */
	public Customer(String f, String l) {
		first_name = f;
		last_name = l;
		phone_number = null;
	}
	
	/**
	 * Constructor that initializes each variable their respective local variables.
	 * @param  f    String that represents customer's first name  
	 * @param  l    String that represents customer's last name
	 * @param  p    String that represents customer's phone number
	 */
	public Customer(String f, String l, String p) {
		first_name = f;
		last_name = l;
		phone_number = formatPhoneNumber(p);
	}
	
	/**
	 * A method that retrieves the customer's first name.
	 * @return          customer's first name
	 */
	public String getFirstName() {
		return first_name;
	}
	
	/**
	 * A method that changes the customer's first name to parameter f. 
	 * @param  f    String that represents customer's new first name
	 */
	public void setFirstName(String f) {
		this.first_name = f;
	}
	
	/**
	 * A method that retrieves the customer's last name.
	 * @return          customer's last name
	 */
	public String getLastName() {
		return last_name;
	}
	
	/**
	 * A method that changes the customer's last name to parameter l. 
	 * @param  l    String that represents customer's new last name
	 */
	public void setLastName(String l) {
		this.last_name = l;
	}
	
	/**
	 * A method that retrieves the customer's phone number.
	 * @return          customer's phone number
	 */
	public String getPhoneNumber() {
		return phone_number;
	}
	
	/**
	 * A method that changes the customer's phone number to parameter p. 
	 * @param  p    String that represents customer's new phone number
	 */
	public void setPhoneNumber(String p) {
		this.phone_number = formatPhoneNumber(p);
	}
	
	/**
	 * A method that returns the phone number in the correct format. i.e. (000)-000-0000
	 * @param  s    integer that indicates the location of an element
	 * @return      phone number in correct format
	 */
	public String formatPhoneNumber(String s) {
		return s.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
	}
	 
	/**
	 * A method that returns the customer's information. 
	 * @return      customer's first name, last name, and phone number
	 */
	public String toString() {
		return first_name + "    " + last_name + "    " + phone_number;
	}
	

	/**
	 * A method that compares the two objects. 
	 * @param  a    Object to be compared
	 * @param  b    Object to be compared
	 * @return      result of comparison
	 */
	@Override
	public int compare(Customer a, Customer b) {
		return a.getLastName().compareTo(b.getLastName());
	}
}
