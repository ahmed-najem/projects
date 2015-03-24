import java.util.Scanner;

public class Lab10
{
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);

		System.out.println("Enter the company name: ");
		// Take the user's input and assign it to the String variable companyName
		String companyName = scan.nextLine();

		System.out.println("Enter the 1st employee name: ");
		// Take the user's input and assign it to the String variable employeeName
		String employeeName = scan.nextLine();

		System.out.println("Enter the 1st employee appraisal score (within 1-100): ");
		// Take the user's input and assign it to the double variable appraisalScore
		double appraisalScore = scan.nextDouble();

		scan.nextLine();

		Employee emp1= new Employee(employeeName);
		// Set the appraisalScore for emp1
		emp1.setAppraisalScore(appraisalScore);

		System.out.println("Enter the 2nd employee name: ");
		employeeName= scan.nextLine();
		System.out.println("Enter the 2nd employee appraisal score (within 1-100): ");
		appraisalScore= scan.nextDouble();
		scan.nextLine();
		// Create an object emp2 of the Class Employee with the employeeName as the input
		Employee emp2= new Employee(employeeName);

		emp2.setAppraisalScore(appraisalScore);

		System.out.println("Enter the 3rd employee name: ");
		// Take the user's input and assign it to the String variable employeeName
		employeeName= scan.nextLine();
		System.out.println("Enter the 3rd employee appraisal score (within 1-100): ");
		// Take the user's input and assign it to the double variable appraisalScore
		appraisalScore= scan.nextDouble();
		// Create an object emp3 of the Class Employee with the employeeName as the input
		Employee emp3 = new Employee(employeeName);

		emp3.setAppraisalScore(appraisalScore);

		// What comes at ??? Employee/emp1/emp2/emp3 ?
		Employee.calculateAvgAppScore();

		// print out the company name
		System.out.println("Company Name: "+ companyName);
		// print out the number of employees. HINT: Call a static method in the Employee class
		System.out.println("Num of Employees: "+ Employee.getEmpoyeesCount() );
		// print out the average appraisal score of the company. HINT: Call a static method in the Employee class
		System.out.println("Average Appraisal Score: "+ Employee.getCompanyAvgAppScore() +"\n");
		// print the details of emp1
		emp1.printEmployeeDetails();
		// print the details of emp2
		emp2.printEmployeeDetails();
		// print the details of emp3
		emp3.printEmployeeDetails();

	}
}