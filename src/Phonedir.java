import java.util.*;
/**
 * A phone directory.
 * @author Irene Ong
 * @version 1.0
 */
public class Phonedir extends Customer{
	LinkedList<Customer> list;
	Customer current;
	
	public Phonedir(){
		list = new LinkedList<Customer>();
	}
	
	public void addCustomer(Customer c) {
		list.add(c);
		current = c;
		this.sort();
	}
	
	public void changeFirstName(String f) {
		current.setFirstName(f);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	public void changeLastName(String l) {
		current.setLastName(l);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	public void changePhoneNumber(String p) {
		current.setPhoneNumber(p);
		list.set(list.indexOf(current), current);
		this.sort();
	}
	
	public void setCurrentRecord(String first_name, String last_name) {
		int size = list.size()-1;
			while(size >= 0) {
				if(list.get(size).getFirstName().equalsIgnoreCase(first_name)  && list.get(size).getLastName().equalsIgnoreCase(last_name)) {
					current = list.get(size); break;
				}
				size--;
			}
	}
	
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
	
	public boolean currentRecordExists() {
		boolean exists = false;
		if(current != null) {
			exists = true;
		}else {
			exists = false;
		}
		return exists;
	}
	
	public void deleteCurrentRecord() {
		System.out.println("\nDeleted: "+ current.toString());
		list.remove(current);
		current = null;
		this.sort();
	}
	
	public void sort() {
		Collections.sort(list, new Customer());
	}
	
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
	
	public void displayCurrent() {
		if(currentRecordExists()) {
			System.out.print("\nThe current record is: " + current.toString());
		}else {
			System.out.println("NO CURRENT RECORD");
		}
	}
}
