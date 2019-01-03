package hash.hashcode;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		
		int a = 42;
		System.out.println(((Integer)a).hashCode());
		
		int b = -42;
		System.out.println(((Integer)b).hashCode());
		
		double c = 3.1415196;
		System.out.println(((Double)c).hashCode());
		
		String d = "Hello World~";
		System.out.println(d.hashCode());
		
		Student student = new Student(3, 2, "peng", "liu");
		System.out.println(student.hashCode());
		
		Student student2 = new Student(3, 2, "Peng", "Liu");
		System.out.println(student2.hashCode());
		
		HashSet<Student> set = new HashSet<>();
		set.add(student);
		set.add(student2);
		System.out.println(set.size());
		
		HashMap<Student, Integer> hashMap = new HashMap<>();
		hashMap.put(student, 100);
		hashMap.put(student2, 200);
		System.out.println(hashMap.size());
	}
}
