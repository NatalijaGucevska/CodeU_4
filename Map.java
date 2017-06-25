import java.util.ArrayList;
import java.util.Collections;

public class Map {
	boolean map[][]; 
	
	public Map(boolean[][] map) {
		if(map == null) {
			throw new IllegalArgumentException(); 
		}
		this.map = new boolean[map.length][map[0].length]; 
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++){
				this.map[i][j] = map[i][j]; 
			}
		}
	}
	
	public int countIslands() {
		int helperMap[][] = new int[map.length][map[0].length]; 
		int count = 0; 
		boolean stable = false; 
		
		while(!stable) {
			stable = true; 
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++){
					ArrayList<Integer> neighbors = getNeighbors(helperMap, i, j); 
					if(map[i][j]) {
						if(!neighbors.isEmpty()) {
							int min = Collections.min(neighbors);
							if(helperMap[i][j] != 0 && min!=helperMap[i][j]) {
								stable = false;
							}
							helperMap[i][j] =  min;
						} else if(helperMap[i][j] == 0) {
							count++;
							helperMap[i][j] = count; 
							stable=false; 
						}
					}
				}
			}	
		}
		
		//TODO: change
		return count;  
	}
	
	private ArrayList<Integer> getNeighbors(int[][] map, int i, int j) {
		ArrayList<Integer> result = new ArrayList<>(); 
		int width = map[0].length; 
		
	    if (i > 0 && map[i-1][j]!=0) result.add(map[i-1][j]);
	    if (j > 0 && map[i][j-1]!=0) result.add(map[i][j-1]);
	    if (j < width - 1 && map[i][j+1]!=0) result.add(map[i][j + 1]);
	    
		return result; 
	}
}
