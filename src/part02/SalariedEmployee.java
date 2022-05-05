package part02;

//Pujan Gautam - c0842623
//Project Part-02
//Submission Date: 4/19/2022

public class SalariedEmployee extends Employee  {
	private double weeklySalary;
	
	public SalariedEmployee(String fName, String lName, String sinNumber,double weeklySalary) throws InvalidSinException {
		super(fName,lName,sinNumber);
		this.setWeeklySalary(weeklySalary);
	}
	
	
	@Override
	public double earnings() {
		return this.weeklySalary;
	}
	
	@Override
	public String toString() {
		return "Type: Salaried\n"+
				"Name: "+this.firstName+ " "+this.lastName+"\n"+
				"SIN: "+this.sinNumber+"\n"+
				"Weekly Salary: $"+this.weeklySalary+"\n";
	}

	
	//getter and setter

	public double getWeeklySalary() {
		return weeklySalary;
	}


	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary < 0)
			throw new IllegalArgumentException("Error: Weekly Salary Cannot Be Negative Value.");
		this.weeklySalary = weeklySalary;
	}
	
	
	

	
}
