package queue;

import java.util.Random;

public class TestMain {
    /**
     * 队列性能测试（ArrayQueue,LoopQueue）
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q , int opCount){
        long startTime = System.nanoTime();
        Random random= new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> Aq = new ArrayQueue<>();
        double time1= testQueue(Aq,opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s ");

        LoopQueue<Integer> Lq = new LoopQueue<>();
        double time2= testQueue(Lq,opCount);
        System.out.println("LoopQueue, time: " + time2 + " s ");

     }
}
