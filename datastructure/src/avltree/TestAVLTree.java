package avltree;

import java.util.ArrayList;
import java.util.Collections;

import map.BSTMap;
import map.FileOperation;

public class TestAVLTree {
	public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            Collections.sort(words);
            
            //AVL树 性能测试
            long startTimeAVL = System.nanoTime();
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            for (String world : words) {
				map.contains(world);
			}
            
            long endTimeAVL = System.nanoTime();
            
            double AVLTime = (endTimeAVL - startTimeAVL)/1000000000.0;
            
            System.out.println("AVLTime:"+AVLTime+"s");
            
            
            //BST树极限状态下的性能测试
            long startTimeBST = System.nanoTime();
            
            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                	bst.set(word, bst.get(word) + 1);
                else
                	bst.add(word, 1);
            }

            for (String world : words) {
            	bst.contains(world);
			}
            
            long endTimeBST = System.nanoTime();
            
            double BSTTime = (endTimeBST - startTimeBST)/1000000000.0;
            
            System.out.println("BSTTime:"+BSTTime+"s");
            
            
            /*System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("isBST: " + map.isBST());
            System.out.println("isBalanced: " + map.isBalanced());*/
        }
    }
}
