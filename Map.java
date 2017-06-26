public class Map {
	boolean map[][];

	public Map(boolean[][] map) {
		if (map == null) {
			throw new IllegalArgumentException();
		}
		this.map = new boolean[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				this.map[i][j] = map[i][j];
			}
		}
	}

	public int countIslands() {
		int helperMap[][] = new int[map.length][map[0].length];
		int count = 0;

		// Rough estimation of connected components
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j]) {
					if (upperTile(helperMap, i, j) > 0) {
						helperMap[i][j] = upperTile(helperMap, i, j);
					} else if (leftTile(helperMap, i, j) > 0) {
						helperMap[i][j] = leftTile(helperMap, i, j);
					} else {
						count++;
						helperMap[i][j] = count;
					}
				}
			}
		}

		// Merge all connected components
		DisjointSet set = new DisjointSet(count);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j]) {
					int up = upperTile(helperMap, i, j);
					int left = leftTile(helperMap, i, j);
					if (up > 0 && left > 0 && up != left) {
						set.union(up, left);
					}
				}
			}
		}

		return set.countDisjointSets();
	}

	private int leftTile(int[][] map, int i, int j) {
		return i > 0 ? map[i - 1][j] : 0;
	}

	private int upperTile(int[][] map, int i, int j) {
		return j > 0 ? map[i][j - 1] : 0;
	}
}
