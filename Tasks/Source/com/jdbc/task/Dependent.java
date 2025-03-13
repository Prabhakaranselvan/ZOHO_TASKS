package com.jdbc.task;

public class Dependent 
{
	private int dependentId;
	private int employeeId;
	private String employeeName;
    private String name;
    private String age;
    private String relationship;
    
//Getter Setter Methods for DependentID
	public int getDependentId() 
	{
		return dependentId;
	}
	
	public void setDependentId(int dependentId) 
	{
		this.dependentId = dependentId;
	}
	
//Getter Setter Methods for EmployeeID
	public int getEmployeeId() 
	{
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}
	
//Getter Setter Methods for Employee Name
	public String getEmployeeName() 
	{
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
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
	
//Getter Setter Methods for Age
	public String getAge() 
	{
		return age;
	}
	
	public void setAge(String age) 
	{
		this.age = age;
	}
	
//Getter Setter Methods for Relationship
	public String getRelationship() 
	{
		return relationship;
	}
	
	public void setRelationship(String relationship) 
	{
		this.relationship = relationship;
	}
}
