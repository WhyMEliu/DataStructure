package unionfind;

import java.util.Random;

public class TestUnionFind {
	private static double testUF (UF uf, int m){
		int size = uf.getSize();
		Random random = new Random();
		
		long startTime = System.nanoTime();
		
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.unionElements(a, b);
		}
		
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.isConnected(a, b);
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime)/ 1000000000.0; 
	}
	
	public static void main(String[] args) {
		int size = 20000000;
		int m = 20000000;
/*		//UF1
		UnionFind1 uf1 = new UnionFind1(size); 
		double uf1Time = testUF(uf1,m);
		System.out.println("UnionFind1："+uf1Time);
		//UF2
		UnionFind2 uf2 = new UnionFind2(size); 
		double uf2Time = testUF(uf2,m);
		System.out.println("UnionFind2："+uf2Time);*/
		//UF3
		UnionFind3 uf3 = new UnionFind3(size); 
		double uf3Time = testUF(uf3,m);
		System.out.println("UnionFind3："+uf3Time);
		//UF4
		UnionFind4 uf4 = new UnionFind4(size); 
		double uf4Time = testUF(uf4,m);
		System.out.println("UnionFind4："+uf4Time);
		//UF5
		UnionFind5 uf5 = new UnionFind5(size); 
		double uf5Time = testUF(uf5,m);
		System.out.println("UnionFind5："+uf5Time);
		//UF6
		UnionFind6 uf6 = new UnionFind6(size); 
		double uf6Time = testUF(uf6,m);
		System.out.println("UnionFind6："+uf6Time);
	}
}
