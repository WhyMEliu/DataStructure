import array.Array;
import array.Student;

public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);

        Array<Student> arrs= new Array<Student>(3);
        arrs.addLast(new Student("aa",1));
        arrs.addLast(new Student("bb",2));
        arrs.addLast(new Student("cc",3));
        arrs.addLast(new Student("dd",4));
        System.out.println(arrs);
        arrs.removeFirst();
        arrs.removeFirst();

        System.out.println(arrs);
    }
}
