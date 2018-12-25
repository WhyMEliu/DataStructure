package arraylist;


public class ArrayList<E> {
    //数组
    private E[] data;
    //下标，数组的真实数量
    private int size;

    /**
     * 构造函数，传入数组容量capacity构造Array
     *
     * @param capacity
     */
    public ArrayList(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public ArrayList(E[] arr){
    	
    	data = (E[])new Object[arr.length];
    	for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
    	size = data.length;
    }
    /**
     * 无参构造函数，默认容量为10
     */
    public ArrayList() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(E e) {
		/*if(size==data.length){
			throw new IllegalArgumentException("超出数组容量~");
		}
		data[size] = e;
		size++;*/
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("超出数组容量~ index >= 0|| index <= size");
        }

        if (size == data.length) {
            //throw new IllegalArgumentException("超出数组容量~");
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引的位置元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Get failed . index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    /**
     * 修改index索引的位置元素为e
     * @param index
     * @param e
     */
    public void set(int index , E e){
        if (index<0||index>=size){
            throw new IllegalArgumentException("Get failed . index is illegal");
        }
        data[index]=e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains (E e){
        for (int i= 0; i<size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find (E e){
        for (int i= 0; i<size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove (int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("remove failed . index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size ; i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        if(size<=data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组删除元素e
     * @param e
     */
    public void removeElement (E e){
        int index = find(e);
        if (index!=-1){
            remove(index);
        }
    }


    private void resize(int newCapacity){
        E[] newdata = (E[]) new Object[newCapacity];
        for (int i=0; i<size ; i++){
            newdata[i]=data[i];
        }
        data=newdata;

    }

    public void swap(int i,int j){
    	
    	if(i < 0 || i >= size || j < 0 || j >= size ){
    		throw new IllegalArgumentException("Index is illegal");
    	}
    	
    	E t = data[i];
    	data[i] = data[j];
    	data[j] = t;
    }
    
    @Override
    public String toString (){
        StringBuilder res =new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i <size ; i++) {
            res.append(data[i]);
            if(i != size -1){
                res.append(",");
            }else {
                res.append(']');
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        /*数组测试*/
        ArrayList<Integer> arr = new ArrayList<Integer>(20);
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

        ArrayList<Student> arrs= new ArrayList<Student>(3);
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


class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}


