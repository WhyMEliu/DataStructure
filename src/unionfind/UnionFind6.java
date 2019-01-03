package unionfind;

public class UnionFind6 implements UF {

	private int[] parent;
	private int[] rank;
	
	public UnionFind6(int size){
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	@Override
	public int getSize() {
		return parent.length;
	}

	/**
	 * 查看元素所对应的集合号
	 * O(h)复杂度，h为树的高度
	 * @param p
	 * @return
	 */
	private int find(int p){
		if(p < 0 || p >= parent.length){
			throw new IllegalArgumentException("p is out of bound.");
		}
		if(p != parent[p]){
			//路径压缩
			parent[p] = find(parent[p]);
		}
		return parent[p];
	}
	
	/**
	 * 查看元素p和元素q是不是在同一个集合
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	
	/**
	 * 合并元素p和元素q所属的集合
	 * O(h)复杂度，h为树的高度
	 */
	@Override
	public void unionElements(int p, int q) {
		
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot){
			return;
		}
		//根据两个元素所在的树的rank不同判断合并的方向
		//将rank低的集合合并到rank高的集合上
		if(rank[pRoot] < rank[qRoot]){
			parent[pRoot] = qRoot;
		}else if(rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		}else{
			parent[qRoot] = pRoot;
			rank[pRoot] +=1;
		}
	}

}
