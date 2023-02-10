
public class Student {
	private String firstName, lastName;
	private double gpa;
	
	Student(String firstName, String lastName, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public String toString() {
		return firstName + " " + lastName + ": " + gpa;
	}
}
