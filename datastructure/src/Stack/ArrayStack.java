package stack;


import arraylist.ArrayList;

public class ArrayStack<E> implements Stack<E>{

    ArrayList<E> array;

    public ArrayStack (int capacity){
        array=new ArrayList<>(capacity);
    }

    public ArrayStack (){
        array=new ArrayList<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty (){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0 ; i < array.getSize() ; i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(',');
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        /**
         * 栈测试
         */
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0 ; i < 5 ; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

    }
 }
