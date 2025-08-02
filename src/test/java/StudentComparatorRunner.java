import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparatorRunner {

	public static void main(String[] args) {
		List<Student> student = new ArrayList<Student>();
		student.add(new Student(1, "Tanmoy"));
		student.add(new Student(5, "Ranga"));
		student.add(new Student(3, "Bosco"));

		// student.stream().forEach(e -> System.out.println(" Name : " + e.name + " Id :
		// " + e.id));
		// Collections.sort(student);
		// student.stream().forEach(e -> System.out.println(" Name : " + e.name + " Id :
		// " + e.id));
		Collections.sort(student, new DescendingComparator());
		student.stream().forEach(e -> System.out.println(" Name : " + e.name + " Id : " + e.id));

	}

}

class Student implements Comparable<Student> {
	public int id;
	public String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int compareTo(Student that) {
		return Integer.compare(this.id, that.id);
	}

}

class DescendingComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		return Integer.compare(student2.id, student1.id);
	}

}
