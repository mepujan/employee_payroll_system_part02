package part02;

//Pujan Gautam - c0842623
//Project Part-02
//Submission Date: 4/19/2022

public class payrollTester {

	public static void main(String[] args){

		//creating the objects
		SalariedEmployee salaryEmp1;
		try {
			salaryEmp1 = new SalariedEmployee("Joe","Francis","046454286",2500);
			
			SalariedEmployee salaryEmp2 = new SalariedEmployee("Samantha","Hughes","444555668",1400);
			salaryEmp2.setManager(salaryEmp1);
			
			HourlyEmployee hourlyEmp = new HourlyEmployee("Kim","Adams","888997004",18.50,42);
			hourlyEmp.setManager(salaryEmp1);
			
			ComissionEmployee comissionEmp = new ComissionEmployee("Rayan","GoodAll","111222337",10,9000);
			comissionEmp.setManager(salaryEmp2);
			
			//making object arrays of type Employee
			Employee emp[] = {salaryEmp1,salaryEmp2,hourlyEmp,comissionEmp};
			//calling employeeInfo Function
			employeeInfo(emp);	
			
//			System.out.println(comissionEmp.toString());
		} catch (InvalidSinException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
				

	}
	
	/**
	 * Iterates through array of Employee objects and returns
	 * the employees informations and statistic summary of the employees.
	 * @param emp Array of Employees objects
	 */
	public static void employeeInfo(Employee[] emp) {
		
		//declaring the variables
		int index = 0;
		int salariedEmployeeCount = 0;
		int hourlyEmployeeCount = 0;
		int commissionEmployeeCount = 0;
		double maxSalary = 0;
		double minSalary = emp[0].earnings();
		int highestEarnerIndex = 0;
		int lowestEarnerIndex = 0;
		double totalPay = 0;
		
		for(Employee e: emp) {
			System.out.println(e.toString());
			System.out.print("Total: $"+e.earnings()+"\n\n");
			if(e instanceof SalariedEmployee) salariedEmployeeCount++;
			if(e instanceof HourlyEmployee) hourlyEmployeeCount++;
			if(e instanceof ComissionEmployee) commissionEmployeeCount++;
			
			if (e.earnings() > maxSalary) {
				maxSalary = e.earnings();
				highestEarnerIndex = index;
			}
			if(e.earnings() < minSalary) {
				minSalary = e.earnings();
				lowestEarnerIndex = index;
			}
			totalPay += e.earnings();
			index++;
		}	
		
		//displaying summary statistics
		System.out.println("SUMMARY STATISTICS\n");
		System.out.println("Highest Paid Employee: " + emp[highestEarnerIndex].lastName +
							", " + emp[highestEarnerIndex].firstName);
		System.out.println("Lowest Paid Employee: " + emp[lowestEarnerIndex].firstName +
				", " + emp[lowestEarnerIndex].lastName);
		System.out.println("Number of salaried employees: " + salariedEmployeeCount);
		System.out.println("Number of hourly employees: " + hourlyEmployeeCount);
		System.out.println("Number of comissioned employees: " + commissionEmployeeCount);
		System.out.println("Total for Pay Period: $" + totalPay);
		
		
	}

}
