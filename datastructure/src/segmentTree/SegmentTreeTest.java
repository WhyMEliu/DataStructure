package segmentTree;

public class SegmentTreeTest {
	public static void main(String[] args) {
		Integer[] nums ={-2, 0, 3, -5, 2, -1};
		SegmentTree<Integer> segtree = new SegmentTree<Integer>(nums, (a, b) -> a + b);
		System.out.println(segtree);
		
		System.out.println(segtree.query(0, 2));
	}
}
