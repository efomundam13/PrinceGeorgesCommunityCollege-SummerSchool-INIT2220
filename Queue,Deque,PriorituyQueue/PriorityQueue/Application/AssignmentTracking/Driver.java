import java.sql.Date;
/** 
   A driver that demonstrates the classes Assignment and AssignmentLog.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver 
{
	public static void main(String[] args) 
	{
		Assignment Ex2 = new Assignment("CSC211", "Exercise 2", Date.valueOf("2020-10-15"));
		Assignment Ex4 = new Assignment("CSC212", "Exercise 4", Date.valueOf("2020-09-15"));
		Assignment Ex6 = new Assignment("CSC213", "Exercise 6", Date.valueOf("2020-09-30"));
		Assignment Ex8 = new Assignment("CSC214", "Exercise 8", Date.valueOf("2020-10-01"));
		
		AssignmentLog myHomework = new AssignmentLog();
		
		System.out.println("Adding these entries:");
		System.out.println(Ex2);
		System.out.println(Ex4);
		System.out.println(Ex6);
		System.out.println(Ex8);
		System.out.println();
		
		myHomework.addProject(Ex2);
		myHomework.addProject(Ex4);
		myHomework.addProject(Ex6);
		myHomework.addProject("CSC214", "Exercise 8", Date.valueOf("2020-10-01")); // Same as the above object Ex8 
		
		System.out.println("First entry should be " + Ex4);
		System.out.println(myHomework.getNextProject());
		
		System.out.println("Log contains");
		Assignment nextAssignment = myHomework.removeNextProject();
      
		while (nextAssignment != null)
		{
			System.out.println(nextAssignment);
			nextAssignment = myHomework.removeNextProject();
		} // end while
		
		System.out.println("Done!!");
	}  // end main
}  // end Driver

/*
 Adding these entries:
 2020-10-15 CSC211 Exercise 2
 
 2020-09-15 CSC212 Exercise 4
 
 2020-09-30 CSC213 Exercise 6
 
 2020-10-01 CSC214 Exercise 8
 
 
 First entry should be 2020-09-15 CSC212 Exercise 4
 
 2020-09-15 CSC212 Exercise 4
 
 Log contains
 2020-09-15 CSC212 Exercise 4
 
 2020-09-30 CSC213 Exercise 6
 
 2020-10-01 CSC214 Exercise 8
 
 2020-10-15 CSC211 Exercise 2
 
 Done!!
*/
