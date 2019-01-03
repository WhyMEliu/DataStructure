package stack;


import java.util.Random;


public class TestMain {
    /**
     * 栈性能测试（ArrayStack,LinkedListStack）
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack , int opCount){
        long startTime = System.nanoTime();
        Random random= new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayStack<Integer> As = new ArrayStack<>();
        double time1= testStack(As,opCount);
        System.out.println("ArrayStack, time: " + time1 + " s ");

        LinkedListStack<Integer> Ls = new LinkedListStack<>();
        double time2= testStack(Ls,opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s ");

     }
}
