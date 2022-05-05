package part02;
import java.util.InputMismatchException;
import java.util.Scanner;

//Pujan Gautam - c0842623
//Project Part-02
//Submission Date: 4/19/2022

public class EmployeeExceptionTester {

	public static void main(String[] args) {
		
		//declaring the variables
		Scanner keyboard = new Scanner(System.in);
		String choice;
		int selection;
		String firstName;
		String lastName;
		String sin;
		boolean isValid = true;
		
		System.out.println("Welcome to Employee Exception Tester!\n");
		
		do {
			displayMenu();
			System.out.println("Please Enter Your Selection: ");
			selection = keyboard.nextInt();
			
			while(selection <= 0 || selection >3) {
				System.out.println("Invalid Choice. Try Again.");
				displayMenu();
				System.out.println("Please Enter Your Selection: ");
				selection = keyboard.nextInt();
			}
			/**
			 * displaying user input prompt as per the employee type
			 * and calling the respective constructor to build the object
			 * if any exception arises then it will re-prompt the user 
			 * to re-enter the data.
			 */
			
			switch(selection) {
				case 1:
					while(isValid) {
						SalariedEmployee salaryEmp;
						try {
							firstName = getFirstName();
							lastName = getLastName();
							sin = getSinNumber();
							System.out.println("Please Enter employee's weekly salary: ");
							double weeklySalary = keyboard.nextDouble();
							System.out.println("****************************************************************************");
							salaryEmp = new SalariedEmployee(firstName,lastName,sin,weeklySalary);
							System.out.println("\nEmployee Created Successfully.\n");
							isValid = false;
							System.out.println(salaryEmp.toString());
							break;
						} catch (InvalidSinException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch(InputMismatchException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}
						
					}
				case 2:
					while(isValid) {
						try {
							firstName = getFirstName();
							lastName = getLastName();
							sin = getSinNumber();
							System.out.println("Please enter employee's hourly rate: ");
							double hourlyRate = keyboard.nextDouble();
							System.out.println("Please enter employee's hour worked:: ");
							double hourWorked = keyboard.nextDouble();
							System.out.println("****************************************************************************");
							HourlyEmployee hourlyEmp = new HourlyEmployee(firstName,lastName,sin,hourlyRate,hourWorked);
							System.out.println("\nEmployee Created Successfully.\n");
							isValid = false;
							System.out.println(hourlyEmp.toString());
						}catch (InvalidSinException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch(InputMismatchException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}
					}
					
				case 3:
					while(isValid) {
						try {
							firstName = getFirstName();
							lastName = getLastName();
							sin = getSinNumber();
							System.out.println("Please enter employee's commission rate: ");
							double comissionRate = keyboard.nextDouble();
							System.out.println("Please enter employee's gross sales: ");
							double grossSales = keyboard.nextDouble();
							System.out.println("****************************************************************************");
							ComissionEmployee comissionEmp = new ComissionEmployee(firstName,lastName,sin,comissionRate,grossSales);
							System.out.println("\nEmployee Created Successfully.\n");
							isValid = false;
							System.out.println(comissionEmp.toString());
						}catch (InvalidSinException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}catch(InputMismatchException e) {
							System.out.println(e.getMessage());
							System.out.println("\nYou have entered incorrect information. We will now re-prompt you for all inputs.\n");
						}
					}
					
			}
			
			System.out.println("Do You Want To Add New User(Y/N): ");
			choice = keyboard.next();
		}while(choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("yes"));

		keyboard.close();
	}
	
	/**
	 * menu display function
	 */
	
	public static void displayMenu() {
		System.out.println("Which Of the following type of employees would you like to create:");
		System.out.println("1. Salaried");
		System.out.println("2. Hourly");
		System.out.println("3. Commission\n");
	}
	
	/**
	 * 
	 * @return firstName entered by user
	 */
	public static String getFirstName() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please Enter employee's first name: ");
		String	firstName = keyboard.next();
		return firstName;
	}
	
	/**
	 * 
	 * @return lastName entered by user
	 */
	public static String getLastName() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please Enter employee's last name: ");
		String	lastName = keyboard.next();
		return lastName;
	}
	
	/**
	 * 
	 * @return sin number entered by user
	 */

	public static String getSinNumber() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please Enter employee's SIN number: ");
		String sin = keyboard.next();
		return sin;
	}

}
