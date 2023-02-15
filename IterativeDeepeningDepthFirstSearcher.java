
//this is Iterative deepeing depth first search
public class IterativeDeepeningDepthFirstSearcher extends Searcher{

	@Override
	public boolean search(SearchNode rootNode) {
		// TODO Auto-generated method stub
		nodeCount = 0;
		int depth = 1;
		while(true)
		{
			DepthLimitedSearcher searcher = new DepthLimitedSearcher(depth);
			boolean found = searcher.search(rootNode);
			nodeCount += searcher.nodeCount;
			if(found)
			{
				goalNode = searcher.getGoalNode();
				return true;
			}
			++depth;
		}
	}
}
