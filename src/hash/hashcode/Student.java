package hash.hashcode;

public class Student {
	
	int grade;
	int cls;
	String firstName;
	String lastName;
	
	public Student(int grade, int cls, String firstName, String lastName) {
		super();
		this.grade = grade;
		this.cls = cls;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int hashCode(){
		
		int B = 31;
		
		int hash = 0;
		hash = hash * B + this.grade;
		hash = hash * B + this.cls;
		hash = hash * B + this.firstName.toLowerCase().hashCode();
		hash = hash * B + this.lastName.toLowerCase().hashCode();
		
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		
		if(o == null){
			return false;
		}
		
		if(this.getClass() != o.getClass()){
			return false;
		}
		
		Student another = (Student)o;
		return this.grade == another.grade &&
			   this.cls == another.cls &&
			   this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
			   this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
	}
	
}
