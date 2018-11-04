package binarysearchtree;

public class BST<E extends Comparable<E> > {
    private class Node{
        public E e;
        public Node left , right;

        public Node (E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size (){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 向二分搜索树中添加新的元素e
     * @param e
     */
    public void add (E e){
        root = add(root,e);
    }

    /**
     * 向node为根的二分搜索树中插入元素E,递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     */
    private Node add(Node node, E e){

        if (node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left , e);

        }else{
            node.right = add(node.right , e);
        }

        return node;
    }


    /**
     * 看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root , e);
    }


    /**
     * 看以node为根的二分搜索树中是否包含元素e,递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e)<0){
            return contains(node.left, e);
        }else {
            return  contains(node.right,e);
        }
    }

    /**
     * 二叉搜索树的前序遍历
     */
    public void perOrder(){
        perOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉搜索树，递归算法
     * @param node
     */
    private void perOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.e);
        perOrder(node.left);
        perOrder(node.right);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 二分搜索树中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二叉搜索树，递归算法
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    /**
     * 二分搜索树后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 中序遍历以node为根的二叉搜索树，递归算法
     * @param node
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }



/*    *//**
     * 向二分搜索树中添加新的元素e
     * @param e
     *//*
    public void add (E e){

        if (root == null) {
            root = new Node (e);
            size++;
        }else{
            add(root, e);
        }
    }

    *//**
     * 向node为根的二分搜索树中插入元素E,递归算法
     * @param node
     * @param e
     *//*
    private void add(Node node, E e){
        //判断该值是否重复（重复不做处理）
        if(e.equals(node.e)){
            return;
            //如果值小于根值在左边并且没有值，则直接插入
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
            //如果值大于根值在右边并且没有值，则直接插入
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        //如果值已经存在则进行再次递归
        //如果值小于根值则在左边
        if (e.compareTo(node.e) < 0){
            add(node.left , e);
            //如果值大于于根值则在左边
        }else{
            add(node.right , e);
        }
    }*/
}
