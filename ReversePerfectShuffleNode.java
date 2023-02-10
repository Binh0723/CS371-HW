import java.util.ArrayList;
import java.util.Arrays;

public class ReversePerfectShuffleNode extends SearchNode{
	public int[] cards;
	static final int MAX_CARDS = 52;
	public ReversePerfectShuffleNode()
	{
		cards = new int[MAX_CARDS];
		for(int i = 0;i < 52;++i)
		{
			cards[i] = i;
		}
	}
	
	@Override
	public boolean isGoal() {
		// TODO Auto-generated method stub
		
		
		return (cards[4] == 0) && (cards[9] == 1) && (cards[14] == 2) && (cards[19] == 3);
	}

	@Override
	public ArrayList<SearchNode> expand() {
		// TODO Auto-generated method stub
		ArrayList<SearchNode> children = new ArrayList<>();
		ReversePerfectShuffleNode node1 = (ReversePerfectShuffleNode) this.childClone();
		ReversePerfectShuffleNode node2 = (ReversePerfectShuffleNode) this.childClone();
		int[] cards1 = node1.cards;
		int[] cards2 = node2.cards;

		//out shuffle
		int startB1 = 0;
		int startM1 = 26;
		
		int startB2 = 0;
		int startM2 = 26;
		
		for(int i = 0;i < MAX_CARDS;++i)
		{
			int card = cards[i];
			if(i % 2 == 0)
			{
				cards1[startB1] = card;
				++startB1;
				
				cards2[startM2]= card;
				++startM2;
			}
			else
			{
				cards1[startM1] =  card;
				++startM1;
				
				cards2[startB2] = card;
				++startB2;
			}
		}
		children.add(node1);
		children.add(node2);
		
		return children;
		//in shuffle
	}
	
	public String toString()
	{
		String ans = Arrays.toString(cards);
		return ans.substring(1, ans.length() - 1);
	}
	
	public Object clone()
	{
		ReversePerfectShuffleNode newNode = (ReversePerfectShuffleNode) super.clone();
		newNode.cards = (int[]) cards.clone();
		
		return newNode;
	}
	
	public static void main(String[] args)
	{
		ReversePerfectShuffleNode root = new ReversePerfectShuffleNode();
		Searcher searcher = new BreadthFirstSearcher();
		searcher.search(root);
		
		searcher.printGoalPath();
	}

}
