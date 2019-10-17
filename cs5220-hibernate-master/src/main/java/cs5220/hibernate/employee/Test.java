package cs5220.hibernate.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import cs5220.hibernate.account.Account;
import cs5220.hibernate.account.Customer;

public class Test {

	public static void main(String args[]) throws SQLException {

		// Load the JDBC driver
		//    	  try {
		//    	    System.out.println("Loading driver...");
		//    	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//    	    System.out.println("Driver loaded!");
		//    	  } catch (ClassNotFoundException e) {
		//    	    throw new RuntimeException("Cannot find the driver in the classpath!", e);
		//    	  }
		//    	
		//	    Connection conn = DriverManager.getConnection("jdbc:sqlserver://cpham19db.clqrjhywbgfa.us-west-1.rds.amazonaws.com:1433;database=cpham19db;user=cpham19;password=tryingthis;");
		//	    Statement stmt = conn.createStatement();  
		//	    ResultSet rs = stmt.executeQuery("select * from employees");
		//	    while(rs.next()) {
		//	    	System.out.println(rs.getString("name"));
		//	    }

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-examples");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		System.out.println("Printing list of employees");
//
//		List<Employee> employees = entityManager
//				.createQuery("SELECT e from Employee e", Employee.class)
//				.getResultList();
//
//		printEmployees(employees);
//
//		// Find the employee whose id is 3.
//		Employee e3 = entityManager.find(Employee.class, 3);
//		System.out.println("Finding an employee whose id is 3: " + e3.getName() );
//
//		// Print employee #3's supervisor's supervisor's name.
//		System.out.println("Finding an supervisor of employee ID#3: " + e3.getSupervisor().getSupervisor().getName() );
//		System.out.println();
//
//		// Add a new employee who's going to be supervised by employee #3.
//		Employee employee = new Employee();
//		employee.setName("Jim");
//		employee.setSupervisor(e3);
//		
//		Employee employee2 = new Employee();
//		employee2.setName("Calvin");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(employee);
//		entityManager.persist(employee2);
//		entityManager.getTransaction().commit();
//
//		employees = entityManager
//				.createQuery("SELECT e from Employee e", Employee.class)
//				.getResultList();
//		System.out.println("List after adding an employee named Jim and Calvin");
//		printEmployees(employees);
//
//
//		// Deleting records with multiple parameters
//		try {
//			List<Employee> employeesToDelete = entityManager
//					.createQuery( "from Employee where name = :name OR name = :name2",
//							Employee.class )
//					.setParameter( "name","Jim" )
//					.setParameter("name2", "Calvin")
//					.getResultList();
//			entityManager.getTransaction().begin();
//			
//			for( Employee emp: employeesToDelete ) {
//				System.out.println("REMOVING " + emp.getName());
//				entityManager.remove(emp);
//			}
//				
//			entityManager.getTransaction().commit();
//			System.out.println();
//		}
//		catch (NoResultException nre) {
//			System.out.println("ERROR OCCURED!");
//		}
//
//		
//		employees = entityManager
//				.createQuery("SELECT e from Employee e", Employee.class)
//				.getResultList();
//		System.out.println("List after deleting Calvin and Jim");
//		printEmployees(employees);
//		
//		
//		System.out.println("Trying to find an employee named George and set his name to John");
//		try {
//			Employee e = entityManager.createQuery("SELECT e FROM Employee e where e.name = :name", Employee.class)
//					.setParameter("name", "George").getSingleResult();
//
//			entityManager.getTransaction().begin();
//			e.setName("John");
//			entityManager.getTransaction().commit();
//		}
//		catch (NoResultException nre) {
//			System.out.println("No one found named George!");
//		}
		
		System.out.println("LIST OF CUSTOMERS");
		List<Customer> customers = entityManager
				.createQuery("SELECT c from Customer c", Customer.class)
				.getResultList();

		printCustomers(customers);
		System.out.println();
		
		System.out.println("LIST OF ACCOUNTS");
		List<Account> accounts = entityManager
				.createQuery("SELECT a from Account a", Account.class)
				.getResultList();
		
		printAccounts(accounts);

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void printEmployees(List<Employee> employees) {
		for( Employee emp : employees )
			System.out.println( emp.getName() );
		System.out.println();
	}
	
	public static void printCustomers(List<Customer> customers) {
		for( Customer cust : customers) {
			System.out.println( cust.getName() + "'s Information");
			List<String> phoneNumbers = cust.getPhones();
			Set<Account> accounts = cust.getAccounts();
			// These phone numbers are in order because of #OrderColumn(phone_order)
			for (String phoneNum : phoneNumbers) {
				System.out.println("Phone Number: " + phoneNum);
			}
			for (Account acc : accounts) {
				System.out.println("Account id#" + acc.getId() + " Balance: $"+ acc.getBalance());
			}
			System.out.println();
		}
				
		System.out.println();
	}
	
	public static void printAccounts(List<Account> accounts) {
		for( Account acc : accounts) {
			System.out.println("ACCOUNT ID#" + acc.getId());
			System.out.println("Owner of Account: " + acc.getOwner().getName());
			System.out.println();
		}
	}
}
