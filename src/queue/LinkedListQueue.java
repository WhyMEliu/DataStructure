package queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node (E e){
            this(e,null);
        }

        public Node () {
            this(null,null);
        }
        @Override
        public String toString (){
            return e.toString();
        }
    }

    private Node head,tail;

    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next= new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");
        }
        Node reNode = head;
        head = head.next;
        reNode.next = null;
        if(head == null){
            tail = null;
        }
        size --;
        return reNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("Null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        /**
         * 队列测试
         */
        LinkedListQueue<Integer> aq = new LinkedListQueue<>();
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
