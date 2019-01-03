package list;

public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }



    /**
     * 在链表的index（0-based）位置添加新的元素
     * @param index
     * @param e
     */
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }

        /*Node node = new Node(e);
        node.next=prev.next;
        prev.next=node;*/
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表的末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在链表的头部添加新的元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 获取链表的第index(0-based)个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表中第index(0-based)个位置的值
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }else {
                cur=cur.next;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

    /**
     * 从链表中删除index(0-basea)位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        Node reNode = prev.next;
        prev.next=reNode.next;
        reNode.next=null;
        size --;
        return reNode.e;
    }

    /**
     * 从链表中删除第一个元素,返回删除的元素
     * @return
     */
    public E removeFrist (){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素,返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }
    
    /**
     * 从链表中删除元素e
     * @return
     */
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    public static void main (String[] args){
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0 ; i < 5 ; i++) {
            ll.addFirst(i);
            System.out.println(ll);
        }
        ll.add(2,777);
        System.out.println(ll);
        ll.remove(2);
        System.out.println(ll);
        ll.removeFrist();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
    }

}
