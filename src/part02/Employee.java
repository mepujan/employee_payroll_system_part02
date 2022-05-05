package part02;

//Pujan Gautam - c0842623
//Project Part-02
//Submission Date: 4/19/2022

public abstract class Employee {
	protected String firstName;
	protected String lastName;
	protected Employee managedBy;
	protected String sinNumber;
	
	public static int numEmployee;
	
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param sinNumber
	 * @throws InvalidSinException 
	 */
	public Employee(String fName, String lName, String sinNumber) throws InvalidSinException {
		this.firstName = fName;
		this.lastName = lName;
		this.setSinNumber(sinNumber);
		Employee.numEmployee++;
	}
	
	/**
	 * 
	 * @return number of employees in the system
	 */
	
	public static int count() {
		return numEmployee;
	}
	
	
	//abstract earning method
	public abstract double earnings();
	
	
	/**
	 * @return true if sin number of both object are equal otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Employee) {
			Employee empToCompare = (Employee) obj;
			return this.sinNumber == empToCompare.sinNumber;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Name: "+ this.firstName + " "+ this.lastName + "\n"+
				"SIN Number: "+ this.sinNumber;
	}
	
	//getter and setter

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null || firstName == "")
			throw new IllegalArgumentException("Error: Invalid First Name Provided.");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null || lastName == "")
			throw new IllegalArgumentException("Error: Invalid Last Name Provided.");
		this.lastName = lastName;
	}

	public String getSinNumber() {
		return sinNumber;
	}

	public void setSinNumber(String sinNumber) throws InvalidSinException {
		String evenPlaceDigit = "";
		String oddPlaceDigit = "";
		int sumEvenPlaceDigit = 0;
		int sumOddPlaceDigit = 0;
		int totalSum = 0;
		int nearestMultipleOf10=0;
		
		if(sinNumber == null)
			throw new InvalidSinException();
		else if(sinNumber.length() != 9)
			throw new InvalidSinException();
		else {
			int checkDigit = Character.getNumericValue(sinNumber.charAt(8));
			for(int i = 0;i<sinNumber.length() - 1;i++) {
				if( i%2 == 0) 
					oddPlaceDigit += Character.getNumericValue(sinNumber.charAt(i));
				else
					evenPlaceDigit += 2*Character.getNumericValue(sinNumber.charAt(i));	
			}
			for(int i=0;i<evenPlaceDigit.length();i++)
				sumEvenPlaceDigit += Character.getNumericValue(evenPlaceDigit.charAt(i));
			
			for(int i=0;i<oddPlaceDigit.length();i++)
				sumOddPlaceDigit += Character.getNumericValue(oddPlaceDigit.charAt(i));
			
			totalSum = sumEvenPlaceDigit + sumOddPlaceDigit;
			
			
			//rounding totalSum to nearest multiple of 10
			int remainder = totalSum%10;
			nearestMultipleOf10 = totalSum + (10 - remainder);
			
			// difference of nearestMultipleOf10 and total sum
			
			int difference = nearestMultipleOf10 - totalSum;
			
			if(difference == checkDigit)
				this.sinNumber = sinNumber;
			else
				throw new InvalidSinException();
		}
	}
	
	public Employee getManager() {
		return this.managedBy;
	}
	
	public void setManager(Employee mgr) {
		this.managedBy = mgr;
	}

	
}
