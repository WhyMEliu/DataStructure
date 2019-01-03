package queue;

import list.ArrayList;

public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> array;

    public ArrayQueue (int capacity){
        array = new ArrayList<>(capacity);
    }

    public ArrayQueue(){
        array= new ArrayList<>();
    }

    @Override
    public int  getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue (){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString (){
        StringBuilder res= new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0 ; i < array.getSize() ; i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        /**
         * 队列测试
         */
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for (int i = 0 ; i < 10 ; i++){
            aq.enqueue(i);
            System.out.println(aq);
            if (i % 3 == 2){
                aq.dequeue();
                System.out.println(aq);
            }
        }
    }
}
