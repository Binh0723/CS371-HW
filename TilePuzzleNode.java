import java.util.ArrayList;
import java.util.Random;

public class TilePuzzleNode extends SearchNode{
	static final Random random = new Random(50);
	int size;
	int[][] tile;
	int zeroRow, zeroCol;
	
	public TilePuzzleNode(int size, int numShuffle) {
		this.size = size;
		int i = 0;
		tile = new int[size][size];
		
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				tile[r][c] = i++;
			}
		}
		
		//shuffle
		for (i = 0; i < numShuffle; i++) {
			while(!move(random.nextInt(4)));
		}
	}
	
	private boolean move(int dir) {
		
		// 0: right, 1: up, 2: left, 3: down
		final int[] dRow = {0, -1, 0, 1};
		final int[] dCol = {1, 0, -1, 0};
		int r2 = zeroRow + dRow[dir];
		int c2 = zeroCol + dCol[dir];
		
		if (r2 < 0 || r2 >= size || c2 < 0 || c2 >= size) {
			return false;
		}
		
		tile[zeroRow][zeroCol] = tile[r2][c2];
		tile[r2][c2] = 0;
		zeroRow = r2;
		zeroCol = c2;
		
		return true;
		
		
	}
	@Override
	public boolean isGoal() {
		int i = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (tile[r][c] != i++)
					return false;
			}
		}
		return true;
		
	}

	@Override
	public ArrayList<SearchNode> expand() {
		ArrayList<SearchNode> children = new ArrayList<SearchNode>();
		for (int dir = 0; dir < 4; dir++) {
			TilePuzzleNode child = (TilePuzzleNode) childClone();
			if (child.move(dir))
				children.add(child);	
		}
		
		return children;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int digits = ("" + (size * size - 1)).length();
		String fmt = "%" + digits + "d ";
		
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				sb.append(String.format(fmt, tile[r][c]));
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public TilePuzzleNode clone() {
		TilePuzzleNode copy = (TilePuzzleNode) super.clone();
		copy.tile  = new int[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				copy.tile[r][c] = tile[r][c];
			}
		}
		
		return copy;

	}
	
	public boolean equals(Object o) 
	{
		if (o instanceof TilePuzzleNode) { 
			TilePuzzleNode n = (TilePuzzleNode) o;
			// Check that all peg positions are identical.
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if(n.tile[r][c] != tile[r][c])
					{
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	
	// Repeated state detection:
	// - prohibit children equal to a node's parent
	// - check against most recent n ancestors
	// - check against all ancestors
	// - check against n most recently generated nodes
	//
	// Multiple runs, median node count
	
	public static void main(String[] args) {
		TilePuzzleNode root = new TilePuzzleNode(4,12);
		System.out.println(root);
		System.out.println();
		System.out.println("Children:");
		System.out.println(root.expand());
	}
}