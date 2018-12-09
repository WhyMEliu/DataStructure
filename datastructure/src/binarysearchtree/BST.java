package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        }else if(e.compareTo(node.e) > 0){
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

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
            }

        }
    }
    /**
     * 层序遍历（广度优先遍历）
     */
    public void levelOrder(){
    	Queue<Node> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()){
    		Node cur= q.remove();
    		System.out.println(cur.e);
    		if(cur.left!=null){
    			q.add(cur.left);
    		}
    		if(cur.right!=null){
    			q.add(cur.right);
    		}
    	}
    	
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

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minmum(){
    	if(size == 0){
    		throw new IllegalArgumentException("BST is empty~");
    	}
    	return minmum(root).e;
    }
   
    /**
     * 返回以node为根的二分搜索树的最小值所在的节点 
     * @param node
     * @return
     */
    public Node minmum(Node node){
    	if(node.left == null){
    		return node;
    	}
    	return minmum(node.left);
    }
    
    
    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maxmum(){
    	if(size == 0){
    		throw new IllegalArgumentException("BST is empty~");
    	}
    	return maxmum(root).e;
    }
   
    /**
     * 返回以node为根的二分搜索树的最大值所在的节点 
     * @param node
     * @return
     */
    public Node maxmum(Node node){
    	if(node.right == null){
    		return node;
    	}
    	return maxmum(node.right);
    }
    
    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMin(){
    	E ret = minmum();
    	root = removeMin(root);
    	return ret;
    }
  
    /**
     * 删除掉以node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
    	if(node.left == null){
    		Node rightNode= node.right;
    		node.right=null;
    		size--;
    		return rightNode;
    	}
    	node.left=removeMin(node.left);
    	return node;
    }
    
    
    /**
     * 从二分搜索树中删除最大值所在节点，返回最大值
     * @return
     */
    public E removeMax(){
    	E ret = maxmum();
    	root = removeMax(root);
    	return ret;
    }
  
    /**
     * 删除掉以node为根的二分搜索树的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
    	if(node.right == null){
    		Node leftNode= node.left;
    		node.left=null;
    		size--;
    		return leftNode;
    	}
    	node.right=removeMax(node.right);
    	return node;
    }
    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
    	root = remove(root,e);
    }
    
    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){
    	
    	if(node == null){
    		return null;
    	}
    	
    	if(e.compareTo(e) < 0){
    		node.left = remove(node.left , e);
    		return node;
    	}else if(e.compareTo(e) > 0){
    		node.right = remove(node.right , e);
    		return node;
    	}else{//e == node.e
    		
    		//删除左子树节点为空的情况
    		if(node.left == null){
    			Node rightNode = node.right;
    			node.right = null;
    			size --;
    			return rightNode;
    		}
    		//删除右子树节点为空的情况
    		if(node.right == null){
    			Node leftNode = node.left;
    			node.left = null;
    			size --;
    			return leftNode;
    		}
    		
    		//代删除的节点左右子树都不为空的情况
    		//找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
    		//用这个节点顶替待删除节点的位置
    		Node successor = minmum(node.right);
    		successor.right = removeMin(node.right);
    		successor.left = node.left;
    		
    		node.left = node.right = null;
    		
    		return successor;
    	}
    	
    	
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
