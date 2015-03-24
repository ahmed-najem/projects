/*---------------------------------------------------------------------------
// AUTHOR:		Brandon Lacquement
// FILENAME:	Employee.java
// SPECIFICATION: Calculates and stores info related to employees
// INSTRUCTIONS: Provided in code
// LAB LETTER:I
//-------------------------------------------------------------------------*/
public class Employee{

	//Define a String variable  name. Decide if it is static or not
	private String name;
	// Define a double variable appraisalScore. Decide if it is static or not
	private double appraisalScore;
	// Define a double variable companyAvgAppScore. Decide if it is static or not
	private static double companyAvgAppScore;
	// Define an integer variable employeesCount. Decide if it is static or not
	private static int employeesCount;

	public Employee(String nm)
	{
		name= nm;
		employeesCount++;
	}

	// Define a static method getEmployeesCount that returns employeesCount
	public static int getEmpoyeesCount()
	{
		return employeesCount;
	}

	// Decide if this method can be static or not
	public void setAppraisalScore(double appScore)
	{
		// assign the input parameter to the variable appraisalScore
		appraisalScore = appScore;
		// increment the variable companyAvgAppScore by appraisalScore
		companyAvgAppScore += appraisalScore;
	}

	// Decide if this method can be static or not
	public static void calculateAvgAppScore()
	{
		// calculate the companyAvgAppScore by dividing companyAvgAppScore by employeesCount
		companyAvgAppScore = companyAvgAppScore/employeesCount;
	}

	// Decide if this method can be static or not
	public static double getCompanyAvgAppScore()
	{
		return companyAvgAppScore;
	}

	// Define a method printEmployeeDetails that prints the employee details
	public void printEmployeeDetails()
	{
		System.out.println("Employee Name: "+ name);
		System.out.println("Appraisal Score: "+ appraisalScore + "\n");

	}
}