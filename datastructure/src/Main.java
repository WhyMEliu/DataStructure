import binarysearchtree.BST;

public class Main {

    public static void main(String[] args) {
        System.out.println("~~~tech otaku save the world~~~");
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num: nums) {
            bst.add(num);
        }

        bst.perOrder();
        System.out.println();
        //System.out.println(bst.toString());
        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.preOrderNR();
    }
}
