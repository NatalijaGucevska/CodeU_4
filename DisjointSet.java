
public class DisjointSet {
	int[] parent;
	int[] rank;

	public DisjointSet(int numElements) {
		parent = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			parent[i] = i + 1;
		}
		rank = new int[numElements];
	}

	public int find(int element) {
		if (element != parent[element - 1]) {
			parent[element - 1] = find(parent[element - 1]);
		}
		return parent[element - 1];
	}

	public void union(int element1, int element2) {
		int x = find(element1);
		int y = find(element2);
		if (x == y)
			return;
		if (rank[x - 1] > rank[y - 1]) {
			parent[y - 1] = x;
		} else {
			parent[x - 1] = y;
			if (rank[x - 1] == rank[y - 1])
				rank[y - 1] += 1;
		}
	}

	public int countDisjointSets() {
		if (parent.length == 0) {
			return 0;
		}
		int size = 1;
		for (int i = 0; i < parent.length - 1; i++) {
			if (parent[i] != parent[i + 1]) {
				size = size + 1;
			}
		}
		return size;
	}
}
