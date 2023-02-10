import java.util.ArrayList;

public class StudentRecords {
	public static void main(String[] args) {
		Student student1 = new Student("Emmanuel", "Fomundam", 3.8);
		Student student2 = new Student("Oriole", "DeTchappi", 3.5);
		Student student3 = new Student("Casey", "Fomundam", 2.9);
		
		BagInterface<Student> studentDatabase = new ArrayBag();
		BagInterface<Student> studentRoster = new ArrayBag();
		double avgGPA = 0;
		
		studentDatabase.add(student1);
		studentDatabase.add(student2);
		studentDatabase.add(student3);
		
		System.out.println("FirstName LastName: GPA");
		while(!studentDatabase.isEmpty()) {
			Student nextStudent = studentDatabase.remove();
			avgGPA += nextStudent.getGPA() / 3;
			System.out.println(nextStudent.toString());
			studentRoster.add(nextStudent);
		}
		System.out.println();
		System.out.println("Total number of students in class = " + studentRoster.getCurrentSize());
		System.out.println("The average GPA is " + avgGPA);
	}
}
