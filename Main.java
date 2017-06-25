
public class Main {

	public static void main(String[] args) {
		Map map = new Map(new boolean[][] {
			{false, true, false, false}, 
			{true, true, false, true}
		}); 

		System.out.println(map.countIslands());
	}

}
