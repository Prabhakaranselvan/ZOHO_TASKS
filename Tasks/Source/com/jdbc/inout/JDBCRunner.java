package com.jdbc.inout;

import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidException;
import com.jdbc.task.Dependent;
import com.jdbc.task.Employee;
import com.jdbc.task.JDBCTask;
import com.utilshub.UtilsScan;
import com.utilshub.UtilsSize;

public class JDBCRunner 
{
	JDBCTask task = new JDBCTask();
	
	private void exercise1() throws InvalidException
	{
		System.out.println("EXERCISE 1: Create Employee Table");
		
		task.createTable();
		System.out.println("Employee table created successfully.");
	}
	
	private void exercise2() throws InvalidException
	{
		System.out.println("EXERCISE 2: Insert Employee Records");
		
		System.out.print("Enter the No Employes To be Added");
		int num = UtilsScan.getInteger();
		List<Employee> list = new ArrayList<>();
		for (int i=1; i<=num ; i++)
		{
			Employee ee = new Employee();
			System.out.println("\nEnter details for Employee-" + i + ":");
			System.out.print("Name: ");
            ee.setName(UtilsScan.getString());
            System.out.print("Mobile: ");
            ee.setMobile(UtilsScan.getString());
            System.out.print("Email: ");
            ee.setEmail(UtilsScan.getString());
            System.out.print("Department: ");
            ee.setDepartment(UtilsScan.getString());
            list.add(ee);
		}
		task.addEmployees(list);
		System.out.println("Employees Added Succesfully");
	}
	
	private void exercise3() throws InvalidException
	{
		System.out.println("EXERCISE 3: Fetch Employee by Name");
		
		System.out.print("Enter Employee Name: ");
        String Name = UtilsScan.getString();
        List<Employee> list = task.getEmployeeByName(Name);
        int size = UtilsSize.getSize(list);
        if (size==0)
        {
        	System.out.println("No employees found with the given name.");
        }
        else
        {
        	System.out.println("Number of matching employees: " + size);
        	for (Employee ee : list)
        	{	
        		System.out.println("\n=== Employee Details (Employee ID: " + ee.getEmployeeId() + ") ==="
        				+ "\nName: " + ee.getName()
                        + "\nMobile: " + ee.getMobile()
                        + "\nEmail: " + ee.getEmail()
                        + "\nDepartment: " + ee.getDepartment());
            }
    	}     
	}
	
	private void exercise4() throws InvalidException
	{
		System.out.println("EXERCISE 4: Update Employee Details");
		
		System.out.print("Enter Employee ID to update: ");
        int employeeId = UtilsScan.getInteger();

        System.out.print("What do you want to update?"
        		+ "\n1. Department"
        		+ "\n2. Mobile"
        		+ "\n3. Email"
        		+ "\nEnter your choice (1-3): ");
        int choice = UtilsScan.getInteger();

        String fieldToUpdate;

        switch (choice) 
        {
            case 1:
                fieldToUpdate = "DEPARTMENT";
                System.out.print("Enter new Department: ");
                break;
            case 2:
                fieldToUpdate = "MOBILE";
                System.out.print("Enter new Mobile: ");
                break;
            case 3:
                fieldToUpdate = "EMAIL";
                System.out.print("Enter new Email: ");
                break;
            default:
                System.out.println("Invalid choice. Update operation aborted.");
                return;
        }
        String newValue = UtilsScan.getString();
        task.updateEmployeeDetails(employeeId, fieldToUpdate, newValue);
        System.out.println("Employee Details Updated Succesfully");

	}
	
	private void exercise5() throws InvalidException
	{
		System.out.println("EXERCISE 5 Print N Employees");
		System.out.print("Enter the number of employees to display: ");
        int num = UtilsScan.getInteger();
        List<Employee> list = task.getFirstNEmployees(num);
        int size = UtilsSize.getSize(list);
        if (size==0)
        {
        	System.out.println("No employees found.");
        }
        else
        {
        	System.out.println("List of First " + size +" employees: ");
        	for (Employee ee : list)
        	{	
        		System.out.println("\n=== Employee Details (Employee ID: " + ee.getEmployeeId() + ") ==="
        				+ "\nName: " + ee.getName()
                        + "\nMobile: " + ee.getMobile()
                        + "\nEmail: " + ee.getEmail()
                        + "\nDepartment: " + ee.getDepartment());
            }
    	}
	}
	
	private void exercise6() throws InvalidException
	{
		System.out.println("EXERCISE 6: Sort & Print Employees");
		System.out.print("Enter the number of employees to display: ");
        int num = UtilsScan.getInteger();
        
        System.out.print("Select the column to sort by:\n"
        		+ "1. EMPLOYEE_ID\n"
        		+ "2. NAME\n"
        		+ "3. MOBILE\n"
        		+ "4. EMAIL\n"
        		+ "5. DEPARTMENT\n"
        		+ "Enter your choice (1-5): ");
        int columnChoice = UtilsScan.getInteger();
        String column;
        switch (columnChoice) 
        {
            case 1:
                column = "EMPLOYEE_ID";
                break;
            case 2:
                column = "NAME";
                break;
            case 3:
                column = "MOBILE";
                break;
            case 4:
                column = "EMAIL";
                break;
            case 5:
                column = "DEPARTMENT";
                break;
            default:
                System.out.println("Invalid choice. Fetch operation aborted.");
                return;
        }
        
        System.out.print("Specify the sorting order:\n"
        		+ "1. Ascending\n"
        		+ "2. Descending\n"
        		+ "Enter your choice (1 or 2): ");
        int orderChoice = UtilsScan.getInteger();
        String order;
        switch (orderChoice) 
        {
            case 1:
                order = "ASC";
                break;
            case 2:
                order = "DESC";
                break;
            default:
                System.out.println("Invalid choice. Fetch operation aborted.");
                return;
        }
        
        List<Employee> list = task.getFirstNEmployeesInOrder(num, column, order);
        int size = UtilsSize.getSize(list);
        if (size==0)
        {
        	System.out.println("No employees found.");
        }
        else
        {
        	System.out.println("List of First " + size +" employees(Sorted): ");
        	for (Employee ee : list)
        	{	
        		System.out.println("\n=== Employee Details (Employee ID: " + ee.getEmployeeId() + ") ==="
        				+ "\nName: " + ee.getName()
                        + "\nMobile: " + ee.getMobile()
                        + "\nEmail: " + ee.getEmail()
                        + "\nDepartment: " + ee.getDepartment());
            }
    	}
		
	}
	
	private void exercise7() throws InvalidException
	{
		System.out.println("EXERCISE 7: Delete Employee");
		System.out.print("Enter Employee ID to Delete: ");
        int employeeId = UtilsScan.getInteger();
        task.deleteEmployeeById(employeeId);
        System.out.println("Employee removed Succesfully");
	}
	
	private void exercise9() throws InvalidException
	{
		System.out.println("EXERCISE 9: Create Dependent Table");
		task.createDependentTable();
		System.out.println("Dependent table created successfully.");
	}
	
	private void exercise10() throws InvalidException
	{
		System.out.println("EXERCISE 10: Insert Dependent Details");
		System.out.print("Enter Employee ID: ");
		int id = UtilsScan.getInteger();
		
		System.out.print("Enter the No of Dependents to add: ");
		int num = UtilsScan.getInteger();
		List<Dependent> list = new ArrayList<>();
		for (int i=1; i<=num ; i++)
		{
			Dependent dep = new Dependent();
			dep.setEmployeeId(id);
			System.out.println("\nEnter details for Dependent " + i + ":");
			System.out.print("Name: ");
            dep.setName(UtilsScan.getString());
            System.out.print("Age: ");
            dep.setAge(UtilsScan.getString());
            System.out.print("Relationship: ");
            dep.setRelationship(UtilsScan.getString());
            list.add(dep);
		}
		task.addDependent(list);
		System.out.println("Dependents Added Succesfully");
	
	}
	
	private void exercise11a() throws InvalidException
	{
		System.out.println("EXERCISE 11a: Fetch Dependents for an Employee by EmployeeID");

        System.out.print("Enter Employee ID to fetch dependents: ");
        int employeeId = UtilsScan.getInteger();
        List<Dependent> list = task.getDependentsByEmployeeId(employeeId);
        if (list==null)
        {
        	System.out.println("No dependents found.");
        }
        else
        {	
        	int i=1;
        	for (Dependent dep : list)
        	{	
        		System.out.println("\n=== Dependent-" + i++ + "  Of Employee: " + dep.getEmployeeName() +" (Employee ID: " + employeeId + ") ==="
        				+ "\nName: " + dep.getName()
        				+ "\nAge: " + dep.getAge()
        				+ "\nRelationship: " + dep.getRelationship());
            }
    	}
        
	}
	
	private void exercise11b() throws InvalidException
	{
		System.out.println("EXERCISE 11b: Fetch Dependents for an Employee by EmployeeName");
		
		System.out.print("Enter Employee Name to fetch dependents: ");
        String name = UtilsScan.getString();
        List<Dependent> list = task.getDependentsByEmployeeName(name);
        if (list==null)
        {
        	System.out.println("No dependents found.");
        }
        else
        {	
        	int i = 1;
        	int prevEmployeeId = -1;
        	int employeeId;
        	for (Dependent dep : list)
        	{	
        		employeeId = dep.getEmployeeId();
        		i = ( employeeId == prevEmployeeId) ? ++i : 1;
        		prevEmployeeId = employeeId;
        		System.out.println("\n=== Dependent-" + i++ + "  Of Employee: " + dep.getEmployeeName() +" (Employee ID: " + employeeId + ") ==="
        				+ "\nName: " + dep.getName()
        				+ "\nAge: " + dep.getAge()
        				+ "\nRelationship: " + dep.getRelationship());
            }
    	}
        
	}
	
	private void exercise12() throws InvalidException
	{
		System.out.println("EXERCISE 12: Display Dependents for First N Employees (Sorted by Name)");
		
		System.out.print("Enter the number of employees to display: ");
        int limit = UtilsScan.getInteger();
        
        List<Dependent> list = task.getDependentsForFirstNEmployees(limit);
        if (list==null)
        {
        	System.out.println("No employees found.");
        }
        else
        {
        	int i = 1;
        	int prevEmployeeId = -1;
        	int employeeId;
        	for (Dependent dep : list)
        	{	
        		employeeId = dep.getEmployeeId();
        		i = ( employeeId == prevEmployeeId) ? ++i : 1;
        		prevEmployeeId = employeeId;
        		System.out.println("\n=== Dependent-" + i++ + "  Of Employee: " + dep.getEmployeeName() +" (Employee ID: " + employeeId + ") ==="
        				+ "\nName: " + dep.getName()
        				+ "\nAge: " + dep.getAge()
        				+ "\nRelationship: " + dep.getRelationship());
            }
    	}
	}
	
	public static void main(String[] args)
	{
		JDBCRunner runner = new JDBCRunner();
		String exercise;
		boolean isContinue = true;
		System.out.println("TASK : JDBC\n"
				+ "1. Create Employee Table\n"
				+ "2. Insert Employee Records\n"
				+ "3. Fetch Employee by Name\n"
				+ "4. Update Employee Details\n"
				+ "5. Print N Employees\n"
				+ "6. Sort & Print Employees\n"
				+ "7. Delete Employee & Reprint\n"
				+ "9. Create Dependent Table\n"
				+ "10. Insert Dependent Details\n"
				+ "11a. Fetch Dependents for an Employee by EmployeeID\n"
				+ "11b. Fetch Dependents for an Employee by EmployeeName\n"
				+ "12. Display Dependents for First N Employees (Sorted by Name)");
		
		while(isContinue)
		{
			try
			{
				System.out.print("\nEnter the Excercise to carry out : ");
				exercise = UtilsScan.getString();
				switch (exercise)
				{		
				case "1":
					runner.exercise1();
					break;
					
				case "2":
					runner.exercise2();
					break;
				
				case "3":
					runner.exercise3();
					break;
					
				case "4":
					runner.exercise4();
					break;
				
				case "5":
					runner.exercise5();
					break;
					
				case "6":
					runner.exercise6();
					break;
					
				case "7":
					runner.exercise7();
					break;
					
				case "9":
					runner.exercise9();
					break;
					
				case "10":
					runner.exercise10();
					break;
				
				case "11a":
					runner.exercise11a();
					break;
					
				case "11b":
					runner.exercise11b();
					break;
					
				case "12":
					runner.exercise12();
					break;
					
				case "0":
					isContinue = false;
					break;
					
				default:
					System.out.print("Invalid Input\n");
					break;
				}
					
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
