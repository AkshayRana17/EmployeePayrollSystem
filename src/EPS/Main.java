package EPS;

import java.util.ArrayList;

// employee payroll system package 

abstract class Employee{  // abstraction: 
	public String Name;  // employee name
	public int Id;      // employee id 
	
	public Employee(String name, int id) {  //constructor for employee class
		this.Name = name;  //this keyword for providing reference to variable of the class
		this.Id = id;
	}
	
	public String getName() {  //getter method : use of encapsulation 
		return Name;
	}
	public int getId() {      //setter method
		return Id; 
	}
	
	public abstract  double calculateSalary();  // abstract method without implementation
	
	@Override    //overriding method , way to implement polymorphism ;
	public String toString() {
		return " Employee [name=" + Name + "Id=" + Id + "Salary= "+ calculateSalary()+"]";
	}
	
}

class FullTimeEmployee extends Employee {   //Fulltimeemployee child class inheriting properties from super class employee;
	public double monthlySalary;  //variable of PTE
	
	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name,id);  //super keyword : used for calling constructor of parent class
		this.monthlySalary = monthlySalary;
	}
	
	@Override
	public double calculateSalary() {  //abstract class implementation 
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee {
	public int workingHours;
	public double hourlyWage;
	
	public PartTimeEmployee(String Name, int Id, int WorkingHours, double hourlyWage) {
		super(Name,Id);
		this.workingHours = WorkingHours;
		this.hourlyWage = hourlyWage;
	}
	
	@Override
	public double calculateSalary() {
		return hourlyWage*workingHours;
	}

}
class EmployeePayrollSystem {  //key imporatant class in this project
	
	private ArrayList<Employee>  EmployeeList;  // creating a arraylist coz we dont know the nos of employees
	
	public EmployeePayrollSystem() {  //constructor
		EmployeeList = new ArrayList<>();
	}
	
	public void EmployeeAdd(Employee employee) {  //employee adding class
		EmployeeList.add(employee);
	}
	
	public void EmployeeToRemove(int id) {   // remove employee from the employeeList
		Employee EmployeeToRemove = null;
		for(Employee employee : EmployeeList) {
			if(employee.getId()==id) {
				EmployeeToRemove = employee;
				break;
			}
		}
		if(EmployeeToRemove != null) {
			EmployeeList.remove(EmployeeToRemove);
		}
		
	}
	public void DisplayEmployee() {  // displaying employees 
		for(Employee employee : EmployeeList ) {
			System.out.println(employee);
		}
	}
}


public class Main {  //main class
	public static void main(String args[])  // main method
	{
		EmployeePayrollSystem pay = new EmployeePayrollSystem();   //creating object of the eps class
		FullTimeEmployee emp1 = new FullTimeEmployee("akshay",001,80000.0); //creating employee object for fulltime
		PartTimeEmployee emp2 = new PartTimeEmployee("rahul",002,80,200);
		
		pay.EmployeeAdd(emp1);
		pay.EmployeeAdd(emp2);
		
		System.out.println("Employees list :");
		pay.DisplayEmployee();
		
		System.out.println("Removing the parttime employee: ");
		pay.EmployeeToRemove(002);

		System.out.print("Employees list :");
		pay.DisplayEmployee();
	}
}
