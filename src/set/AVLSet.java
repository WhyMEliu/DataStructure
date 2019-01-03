package set;

import tree.avltree.AVLTree;

public class AVLSet<K extends Comparable<K>> implements Set<K> {
	
	private AVLTree<K, Object> avl;
	
	public AVLSet(){
		avl = new AVLTree<>();
	}

	@Override
	public void add(K e) {
		avl.add(e, null);
	}

	@Override
	public void remove(K e) {
		avl.remove(e);
	}

	@Override
	public boolean contains(K e) {
		return avl.contains(e);
	}

	@Override
	public int getSize() {
		return avl.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty();
	}
	
	
}
