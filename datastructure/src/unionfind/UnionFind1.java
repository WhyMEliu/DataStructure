package unionfind;

public class UnionFind1 implements UF {

	private int[] id;
	
	public UnionFind1(int size){
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	@Override
	public int getSize() {
		return id.length;
	}

	/**
	 * 查看元素所对应的集合号
	 * @param p
	 * @return
	 */
	private int find(int p){
		if(p < 0 || p >= id.length){
			throw new IllegalArgumentException("p is out of bound.");
		}
		return id[p];
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
	 */
	@Override
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		for (int i = 0; i < id.length; i++) {
			if(id[i] == qID){
				id[i] = pID;
			}
				
		}
	}

}
