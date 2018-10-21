import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Phonedir directory = new Phonedir(); //Testing directory
		String prompts = "\n\na   Show all records"
				+ "\nd   Delete the current record"
				+ "\nf   Change the first name in the current record"
				+ "\nl   Change the last name in the current record"
				+ "\nn   Add a new record"
				+ "\np   Change the phone number in the current record"
				+ "\nq   Quit"
				+ "\ns   Select a record from the record list to become the current record"
				+ "\n\n\nEnter a command from the list above (q to quit): "; //Prompts 
		boolean run_program = true; //If true continue program, if false terminate.
		Scanner k = new Scanner(System.in);
		System.out.print("\nA program to keep a Phone Directory:" + prompts);
		
		do{
			String userinput = k.next();
			
			switch(userinput) {
				case "a":
					directory.displayAll();
					System.out.print(prompts);
					break;
				case "d":
					directory.deleteCurrentRecord();
					System.out.print(prompts);
					break;
				case "f":
					if(directory.currentRecordExists()) {
						System.out.print("\nEnter new first name: "); String fn1 = k.next();
						directory.changeFirstName(fn1);
						directory.displayCurrent();
						System.out.print(prompts);
					}else {
						System.out.println("\nNo current record.");
						System.out.print(prompts);
					}
					break;
				case "l":
					System.out.print("\nEnter new last name: "); String ln1 = k.next();
					directory.changeLastName(ln1);
					System.out.print("The current record is: "); directory.displayCurrent();
					System.out.print(prompts);
					break;
				case "n":
					System.out.print("\nEnter first name: "); String fn2 = k.next();
					System.out.print("Enter last name: "); String ln2 = k.next();
					System.out.print("Enter phone number: "); String pn = k.next();
					directory.addCustomer(new Customer(fn2,ln2,pn));
					directory.displayCurrent();
					System.out.print(prompts);
					break;
				case "p":
					System.out.print("Enter new phone number: "); String pn2 = k.next();
					directory.changePhoneNumber(pn2);
					directory.displayCurrent();
					System.out.print(prompts);
					break;
				case "q":
					run_program = false; break;
				case "s":
					System.out.print("\nEnter first name: "); String fn3 = k.next();
					System.out.print("Enter last name: "); String ln3 = k.next();
					if(directory.recordExists(fn3, ln3)) {
						directory.setCurrentRecord(fn3, ln3);
						directory.displayCurrent();
						System.out.print(prompts);
					}else {
						System.out.println("\nNo matching record.");
						System.out.print(prompts);
					}
					break;
				default: 
					System.out.println("\nIllegal command");
					System.out.print(prompts);
			}
			
			
			}while(run_program);
		
		k.close();
		
	}

}
