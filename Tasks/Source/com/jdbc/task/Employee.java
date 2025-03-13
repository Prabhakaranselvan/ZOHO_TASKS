package com.jdbc.task;

public class Employee 
{
	private int employeeId;
    private String name;
    private String mobile;
    private String email;
    private String department;
 
//Getter Setter Methods for EmployeeID
	public int getEmployeeId() 
	{
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}
	
//Getter Setter Methods for Name
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
//Getter Setter Methods for Mobile No
	public String getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	
//Getter Setter Methods for Email	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
//Getter Setter Methods for Department
	public String getDepartment() 
	{
		return department;
	}
	
	public void setDepartment(String department) 
	{
		this.department = department;
	}

}
