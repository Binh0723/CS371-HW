import java.util.ArrayList;

public class RecursiveDepthFirstSearcher extends Searcher{

	@Override
	public boolean search(SearchNode node) {
		// TODO Auto-generated method stub
		++nodeCount;
		if(node.isGoal())
		{
			goalNode = node;
			return true;
		}
		for(SearchNode child : node.expand())
		{
			boolean found = search(child);
			if(found)
			{
				return true;
			}
		}
		return false;
	}

}
