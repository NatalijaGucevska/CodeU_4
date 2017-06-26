
public class Main {

	public static void main(String[] args) {

		// Test with no islands
		Map map = new Map(new boolean[][] { { false, false, false, false }, { false, false, false, false },
				{ false, false, false, false } });

		System.out.println("Expected number 0, result: " + map.countIslands());

		// Test with no water
		map = new Map(
				new boolean[][] { { true, true, true, true }, { true, true, true, true }, { true, true, true, true } });

		System.out.println("Expected number 1, result: " + map.countIslands());

		// Test with chess board of islands
		map = new Map(new boolean[][] { { true, false, true, false }, { false, true, false, true },
				{ true, false, true, false } });

		System.out.println("Expected number 6, result: " + map.countIslands());

		// Test with connected tiles
		map = new Map(new boolean[][] { { true, true, false, false }, { false, true, true, false },
				{ false, false, false, false } });

		System.out.println("Expected number 1, result: " + map.countIslands());

		// Test with connected tiles in row
		map = new Map(new boolean[][] { { true, true, true, true }, { false, false, false, false },
				{ false, false, false, false } });

		System.out.println("Expected number 1, result: " + map.countIslands());

		// Test with connected tiles in column
		map = new Map(new boolean[][] { { true, false, false, false }, { true, false, false, false },
				{ true, false, false, false } });

		System.out.println("Expected number 1, result: " + map.countIslands());

		// Test with chess board of islands on big matrix
		boolean tiles[][] = new boolean[100][100];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				tiles[i][j] = (i + j) % 2 == 0;
			}
		}

		map = new Map(tiles);
		System.out.println("Expected number 5000, result: " + map.countIslands());

	}

}
