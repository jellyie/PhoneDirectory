import java.util.*;
/**
 * A phone directory.
 * @author Irene Ong
 * @version 1.0
 */
public class Phonedir extends Customer{
	LinkedList<Customer> list;
	Customer current;
	
	/**
	 * Default constructor that initializes LinkedList.
	 */
	public Phonedir(){
		list = new LinkedList<Customer>();
	}
	
	/**
	 * A method that adds a Customer object to LinkedList and sets the current customer to this object.
	 * @param  c    Customer object to be added
	 */
	public void addCustomer(Customer c) {
		list.add(c);
		current = c;
		this.sort();
	}
	
	/**
	 * A method that changes the first name of the current customer to string parameter.
	 * @param  f    String that represents the new first name
	 */
	public void changeFirstName(String f) {
		current.setFirstName(f);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	/**
	 * A method that changes the last name of the current customer to string parameter.
	 * @param  l    String that represents the new last name
	 */
	public void changeLastName(String l) {
		current.setLastName(l);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	/**
	 * A method that changes the phone number of the current customer to string parameter.
	 * @param  p    String that represents the new phone number
	 */
	public void changePhoneNumber(String p) {
		current.setPhoneNumber(p);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	/**
	 * A method that selects a customer record as the current record. 
	 * @param  first_name    String that represents the customer's first name
	 * @param  last_name     String that represents the customer's last name
	 */
	public void setCurrentRecord(String first_name, String last_name) {
		int size = list.size()-1;
			while(size >= 0) {
				if(list.get(size).getFirstName().equalsIgnoreCase(first_name)  && list.get(size).getLastName().equalsIgnoreCase(last_name)) {
					current = list.get(size); break;
				}
				size--;
			}
	}
	
	/**
	 * A method that determines whether a specified customer record exists in this directory.  
	 * @param  first_name    String that represents the customer's first name
	 * @param  last_name     String that represents the customer's last name
	 * @return  			 true if customer record exists in this directory
	 */
	public boolean recordExists(String first_name, String last_name) {
		int size = list.size()-1;
		boolean exists = false;
		while(size >= 0) {
			if(list.get(size).getFirstName().equalsIgnoreCase(first_name)  && list.get(size).getLastName().equalsIgnoreCase(last_name)) {
				exists = true; break;
			}else {
				exists = false;
			}
			size--;
		}
		
		return exists;
	}
	
	/**
	 * A method that determines whether there is current record or not.   
	 * @return  			 true if a current customer record is selected
	 */
	public boolean currentRecordExists() {
		boolean exists = false;
		if(current != null) {
			exists = true;
		}else {
			exists = false;
		}
		return exists;
	}
	
	/**
	 * A method that removes the current record.  
	 */
	public void deleteCurrentRecord() {
		System.out.println("\nDeleted: "+ current.toString());
		list.remove(current);
		current = null;
		this.sort();
	}
	
	/**
	 * A method that sorts the directory.  
	 */
	public void sort() {
		Collections.sort(list, new Customer());
	}
	
	/**
	 * A method that prints the entire directory to console.  
	 */
	public void displayAll() {
		Iterator<Customer> itr = list.iterator();
		String first_line = "\nFirst Name   Last Name   Phone Number";
		String second_line ="----------   ---------   ------------";
		System.out.println(first_line + "\n\n" + second_line);  
		
		while(itr.hasNext()) {
			Customer temp = itr.next();
			System.out.println(temp.toString());
		}
	}
	
	/**
	 * A method that prints the current customer information to console.  
	 */
	public void displayCurrent() {
		if(currentRecordExists()) {
			System.out.print("\nThe current record is: " + current.toString());
		}else {
			System.out.println("NO CURRENT RECORD");
		}
	}
}
