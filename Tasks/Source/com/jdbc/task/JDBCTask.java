package com.jdbc.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidException;
import com.utilshub.UtilsCheck;

public class JDBCTask 
{
	private static final String DB_URL = "jdbc:mysql://localhost/incubationDB";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	 private Connection getConnection() throws InvalidException 
	 {
        try 
        {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (SQLException e) 
        {
            throw new InvalidException("Database connection failed", e);
        }
	 } 
	
	public void createTable() throws InvalidException 
	{
		String sql = "CREATE TABLE IF NOT EXISTS Employee ("
	            + "EMPLOYEE_ID INT AUTO_INCREMENT PRIMARY KEY, "
	            + "NAME VARCHAR(100) NOT NULL, "
	            + "MOBILE VARCHAR(15) NOT NULL UNIQUE, "
	            + "EMAIL VARCHAR(100) NOT NULL UNIQUE, "
	            + "DEPARTMENT VARCHAR(50) NOT NULL"
	            + ")";
	
	    try (Connection conn = getConnection();
	         Statement stmt = conn.createStatement())
	    {
	        stmt.executeUpdate(sql);
	    } 
	    catch (SQLException e) 
	    {
	    	throw new InvalidException("Table Creation Failed", e);
	    }
	}
	
	public boolean addEmployees(List<Employee> list) throws InvalidException 
	{
		UtilsCheck.checkNull(list);
		String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			for (Employee ee : list)
	        {
	        	pstmt.setString(1, ee.getName());
	            pstmt.setString(2, ee.getMobile());
	            pstmt.setString(3, ee.getEmail());
	            pstmt.setString(4, ee.getDepartment());
	            pstmt.addBatch();
	        }
			int[] result = pstmt.executeBatch();
	        for (int res : result)
	        {
	        	int fail = Statement.EXECUTE_FAILED;
	            if (res == fail) 
	            {
	                return false;
	            }
	        }
		}
        catch (SQLException e) 
        {
            throw new InvalidException("Employees List Insertion Failed", e);
        }
		return true; 
    }
	
	public List<Employee> getEmployeeByName(String employeeName) throws InvalidException 
	{
		UtilsCheck.checkNull(employeeName);
        String sql = "SELECT * FROM Employee WHERE NAME = ?";
        List<Employee> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
            pstmt.setString(1, employeeName);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	        		Employee ee = new Employee();
	        		ee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
	        		ee.setName(rs.getString("NAME"));
	                ee.setMobile(rs.getString("MOBILE"));
	                ee.setEmail(rs.getString("EMAIL"));
	                ee.setDepartment(rs.getString("DEPARTMENT"));
//	        		setEmployeeField(ee, rs);
	                list.add(ee);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Employees Data", e);
        }
        return list;
    }

//	private void setEmployeeField(Employee ee, ResultSet rs) throws SQLException 
//	{
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int count = rsmd.getColumnCount();
//		String type;
//		String column;
//		
//		for (int i=1; i<=count; i++) 
//    	{
//			type = rsmd.getColumnTypeName(i);
//			column = rsmd.getColumnLabel(i);
//		
//		    if (type.equals("INT")) 
//		    { 
//		        int value = rs.getInt(i);
//		        switch (column) 
//		        {
//	            case "EMPLOYEE_ID":
//	            	ee.setEmployeeId(value);
//	            	break;
//		        }
//	        }
//		    
//		    else if (type.equals("VARCHAR")) 
//		    {
//		        String value = rs.getString(i);
//		        switch (column) 
//		        {
//		            case "NAME":
//		                ee.setName(value);
//		                break;
//		                
//		            case "MOBILE":
//		                ee.setMobile(value);
//		                break;
//		                
//		            case "EMAIL":
//		                ee.setEmail(value);
//		                break;
//		                
//		            case "DEPARTMENT":
//		                ee.setDepartment(value);
//		                break;
//		        }
//		    }
//        }
//	}
	
	public void updateEmployeeDetails(int employeeId, String fieldToUpdate, String newValue) throws InvalidException 
	{
		UtilsCheck.checkNull(fieldToUpdate);
		UtilsCheck.checkNull(newValue);
		String sql = "UPDATE Employee SET " + fieldToUpdate + " = ? WHERE EMPLOYEE_ID = ?";
		
        try (Connection conn = getConnection();
    		 PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
                pstmt.setString(1, newValue);
                pstmt.setInt(2, employeeId);
                pstmt.executeUpdate();
        }
		catch (SQLException e) 
        {
			throw new InvalidException("Unable to Update Employees Details", e);
        }
    }
	
	public List<Employee> getFirstNEmployees(int num) throws InvalidException 
	{
		String sql = "SELECT * FROM Employee LIMIT ?";
		List<Employee> list = new ArrayList<>();
	        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
        	pstmt.setInt(1, num);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	        		Employee ee = new Employee();
	        		ee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
	        		ee.setName(rs.getString("NAME"));
	                ee.setMobile(rs.getString("MOBILE"));
	                ee.setEmail(rs.getString("EMAIL"));
	                ee.setDepartment(rs.getString("DEPARTMENT"));
	                list.add(ee);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Employees Data", e);
        }
        return list;
    }
	
	
	public List<Employee> getFirstNEmployeesInOrder(int limit, String column, String order) throws InvalidException 
	{
		UtilsCheck.checkNull(column);
		UtilsCheck.checkNull(order);
		String sql = "SELECT * FROM Employee ORDER BY " + column + " " + order + " LIMIT ?";
		List<Employee> list = new ArrayList<>();
	        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
        	pstmt.setInt(1, limit);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	        		Employee ee = new Employee();
	        		ee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
	        		ee.setName(rs.getString("NAME"));
	                ee.setMobile(rs.getString("MOBILE"));
	                ee.setEmail(rs.getString("EMAIL"));
	                ee.setDepartment(rs.getString("DEPARTMENT"));
	                list.add(ee);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Employees Data", e);
        }
        return list;
    }
	
	public void deleteEmployeeById(int employeeId) throws InvalidException 
	{
	    String sql = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";

	    try (Connection conn = getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setInt(1, employeeId);
	        pstmt.executeUpdate();
	    }
	    catch (SQLException e) 
	    {
	    	throw new InvalidException("Unable to Delete", e);
	    }
	}
	
	public void createDependentTable() throws InvalidException 
	{
		String sql = "CREATE TABLE IF NOT EXISTS Dependents ("
	               + "DEPENDENT_ID INT AUTO_INCREMENT PRIMARY KEY, "
	               + "EMPLOYEE_ID INT, "
	               + "NAME VARCHAR(100) NOT NULL, "
	               + "AGE INT NOT NULL, "
	               + "RELATIONSHIP VARCHAR(50) NOT NULL, "
	               + "FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE"
	               + ")";
	
	    try (Connection conn = getConnection();
	         Statement stmt = conn.createStatement())
	    {
	        stmt.executeUpdate(sql);
	    } 
	    catch (SQLException e) 
	    {
	    	throw new InvalidException("Table Creation Failed", e);
	    }
	}
	
	public void addDependent(List<Dependent> list) throws InvalidException 
	{
		UtilsCheck.checkNull(list);
		String sql = "INSERT INTO Dependents (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
			for (Dependent dep : list)
			{
	        	pstmt.setInt(1, dep.getEmployeeId());
	            pstmt.setString(2, dep.getName());
	            pstmt.setString(3, dep.getAge());
	            pstmt.setString(4, dep.getRelationship());
	            pstmt.addBatch();
	        }
			pstmt.executeBatch();
        }
        catch (SQLException e)
        {
            throw new InvalidException("Dependent List Insertion Failed", e);
        }
    }
	
	
	public List<Dependent> getDependentsByEmployeeId(int employeeId) throws InvalidException 
	{
		String sql = "SELECT e.NAME AS EMPLOYEE_NAME, d.NAME AS DEPENDENT_NAME, d.AGE, d.RELATIONSHIP FROM Employee e "
				+ "JOIN Dependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID WHERE e.EMPLOYEE_ID = ?";
		
		List<Dependent> list = new ArrayList<>();   
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
        	pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	            	Dependent dep = new Dependent();
	        		dep.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
	        		dep.setName(rs.getString("DEPENDENT_NAME"));
	                dep.setAge(rs.getString("AGE"));
	                dep.setRelationship(rs.getString("RELATIONSHIP"));
	                list.add(dep);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Dependents Data", e);
        }
        return list;
    }
	
	public List<Dependent> getDependentsByEmployeeName(String employeeName) throws InvalidException 
	{
		UtilsCheck.checkNull(employeeName);
		String sql = "SELECT e.EMPLOYEE_ID, d.NAME, d.AGE, d.RELATIONSHIP FROM Employee e "
				+ "JOIN Dependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID WHERE e.NAME = ?";
		
		List<Dependent> list = new ArrayList<>();    
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
        	pstmt.setString(1, employeeName);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	            	Dependent dep = new Dependent();
	            	dep.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
	        		dep.setName(rs.getString("NAME"));
	                dep.setAge(rs.getString("AGE"));
	                dep.setRelationship(rs.getString("RELATIONSHIP"));
	                list.add(dep);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Dependents Data", e);
        }
        return list;
    }
	
	public List<Dependent> getDependentsForFirstNEmployees(int limit) throws InvalidException 
	{
		String sql = "SELECT e.EMPLOYEE_ID, e.NAME AS EMPLOYEE_NAME, d.NAME AS DEPENDENT_NAME, d.AGE, d.RELATIONSHIP "
				+ "FROM (SELECT EMPLOYEE_ID, NAME FROM Employee LIMIT ?) AS e "
				+ "JOIN Dependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID "
				+ "ORDER BY e.NAME, e.EMPLOYEE_ID, d.NAME";

		List<Dependent> list = new ArrayList<>();
	        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) 
        {
        	pstmt.setInt(1, limit);
            try (ResultSet rs = pstmt.executeQuery())
            {
	            while(rs.next())
	        	{
	            	Dependent dep = new Dependent();
	            	dep.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
	        		dep.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
	        		dep.setName(rs.getString("DEPENDENT_NAME"));
	                dep.setAge(rs.getString("AGE"));
	                dep.setRelationship(rs.getString("RELATIONSHIP"));
	                list.add(dep);
	        	}
            }
        } 
        catch (SQLException e) 
        {
        	throw new InvalidException("Unable to fetch Data", e);
        }
        return list;
	}
}


//SELECT e.EMPLOYEE_ID, e.NAME AS EMPLOYEE_NAME, d.NAME AS DEPENDENT_NAME, d.AGE, d.RELATIONSHIP FROM (SELECT EMPLOYEE_ID FROM Employee ORDER BY EMPLOYEE_ID LIMIT ?) AS emp_id JOIN Employee e ON emp_id.EMPLOYEE_ID = e.EMPLOYEE_ID JOIN Dependents d ON e.EMPLOYEE_ID = d.EMPLOYEE_ID ORDER BY e.NAME, d.NAME"
