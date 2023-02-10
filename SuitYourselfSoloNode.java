import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SuitYourselfSoloNode extends SearchNode implements Cloneable{
	public static ArrayList<Stack<Integer>> columns;
	public static int numSuits, numColumns;
	
	int[] topIndicies;
	public SuitYourselfSoloNode(int numSuits, int numRanks, int numColumns, long seed)
	{
		columns = SuitYourselfSoloGenerator.generate(numSuits, numRanks, numColumns, seed);
		this.numSuits = numSuits;
		this.numColumns = numColumns;
		topIndicies = new int[numColumns];
		for(int i = 0;i < numColumns;++i)
		{
			topIndicies[i] = columns.get(i).size() -  1;
		}
	}
	
	
	public String toString()
	{
		String res = "";
		for(Stack<Integer> st : columns)
		{
			Iterator<Integer> it = st.iterator();
			while(it.hasNext())
			{
				res = res+  it.next() + " ";
			}
			res += "\n";
		}
		return null;
	}
	@Override
	public boolean isGoal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SearchNode> expand() {
		// TODO Auto-generated method stub
		ArrayList<SearchNode> children = new ArrayList<SearchNode>();
		boolean[] checked = new boolean[numSuits];
		for(int i = 0;i < numColumns;++i)
		{
			int suit = columns.get(i).get(topIndicies[i]);

			if(topIndicies[i] < 0)
			{
				continue;
			}
			
			if(checked[suit])
			{
				continue;
			}
			checked[suit] = true;
			SuitYourselfSoloNode node = (SuitYourselfSoloNode) this.childClone();
			
			

		}
		return null;
	}
	

}
