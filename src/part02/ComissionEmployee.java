package part02;

//Pujan Gautam - c0842623
//Project Part-01
//Submission Date: 4/19/2022

public class ComissionEmployee extends Employee {
	private double comissionRate;
	private double grossSales;
	
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param sinNumber
	 * @param comissionRate
	 * @param grossSales
	 * @throws InvalidSinException 
	 */
	
	public ComissionEmployee(String fName, String lName, String sinNumber,double comissionRate, double grossSales) throws InvalidSinException {
		super(fName,lName,sinNumber);
		this.setComissionRate(comissionRate);
		this.setGrossSales(grossSales);
	}
	
	//copy constructor
	public ComissionEmployee(ComissionEmployee emp) throws InvalidSinException {
		super(emp.firstName,emp.lastName,emp.sinNumber);
		this.comissionRate = emp.comissionRate;
		this.grossSales = emp.grossSales;
	}
	
	/**
	 * returns the earnings of the employee
	 */
	
	@Override
	public double earnings() {
		return (this.comissionRate / 100)* this.grossSales;
	}
	
	
	/**
	 * return string representation of ComissionEmployee Class
	 */
	@Override
	public String toString() {
		return "Type: Comission\n"+
				"Name: "+this.firstName+ " "+this.lastName+"\n"+
				"SIN: "+this.sinNumber+"\n"+
				"Comission Rate: "+this.comissionRate/100+"\n"+
				"Gross Sales: $"+this.grossSales+"\n";
	}

	
	//getter and setter
	public double getComissionRate() {
		return comissionRate;
	}

	public void setComissionRate(double comissionRate) {
		if(comissionRate < 0 || comissionRate > 100)
			throw new IllegalArgumentException("Error: Commission Rate Should Be In Between 0% and 100%.");
		this.comissionRate = comissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if(grossSales < 0)
			throw new IllegalArgumentException("Error: Gross Sales must be value of 0 or greater.");
		this.grossSales = grossSales;
	}
	
	
}
