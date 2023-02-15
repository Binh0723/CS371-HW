import java.util.Stack;

//depth limited search using stack
public class DepthLimitedSearcher extends Searcher{
	private int maxDepth;
	public DepthLimitedSearcher(int depth)
	{
		this.maxDepth = depth;
	}
	@Override
	public boolean search(SearchNode rootNode) {
		// TODO Auto-generated method stub
		Stack<SearchNode> st = new Stack<>();
		st.add(rootNode);
		nodeCount = 0;
		while(true)
		{
			if(st.isEmpty())
			{
				return false;
			}
			SearchNode node = st.pop();
			++nodeCount;
			if(node.isGoal())
			{
				goalNode = node;
				return true;
			}
			for(SearchNode child : node.expand())
			{
				if(child.depth <=	 maxDepth)
				{
					if(nodeCount == 1)
					{
						st.add(child);
					}
					else if(!node.parent.equals(child) )
					{
							st.add(child);
					}
//					st.add(child);
				}
			}
			
			
		}
	}	
}
