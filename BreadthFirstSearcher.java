import java.util.LinkedList;
import java.util.Queue;

/**
 * BreadthFirstSearcher.java - a simple implementation of
 * breadth-first search.
 *
 * @author Todd Neller
 * @version 1.1
 *

Copyright (C) 2006 Todd Neller

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

Information about the GNU General Public License is available online at:
  http://www.gnu.org/licenses/
To receive a copy of the GNU General Public License, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
02111-1307, USA.

 */

public class BreadthFirstSearcher extends Searcher {

	/**
	 * <code>search</code> - given an initial node, perform
	 * breadth-first search.
	 *
	 * @param rootNode a <code>SearchNode</code> value - the initial node
	 * @return a <code>boolean</code> value - whether or not goal node
	 * was found */
	public boolean search(SearchNode rootNode) {

		// IMPLEMENT:
		Queue<SearchNode> q = new LinkedList<>();
		q.add(rootNode);
		// Initialize search variables.
		nodeCount = 0;
		// Main search loop:
		while (true) {

			// If the search queue is empty, return with failure
			// (false).
			if(q.isEmpty())
			{
				return false;
			}
			// Otherwise get the next search node from the front of
			// the queue and increment the nodeCount.
			
			SearchNode node = q.poll();
			++nodeCount;
			
			// If the search node is a goal node, store it and return
			// with success (true).
			if(node.isGoal())
			{
				goalNode = node;
				return true;
			}
			// Otherwise, expand the node and insert each of its
			// children into the queue.  
			
			for(SearchNode child : node.expand())
			{
				if(nodeCount == 1)
				{
					q.add(child);
				}
				else if(!node.parent.equals(child) )
				{
						q.add(child);
				}
//				SearchNode parent = node.parent;
//				boolean dup = false;
//				for(int i = 0;i < 10;++i)
//				{
//					if(parent != null && parent.equals(child))
//					{
//						dup = true;
//						parent = parent.parent;
//						if(parent == null)
//						{
//							break;
//						}
//					}
//					
//				}
//				if(!dup)
//				{
//					q.add(child);
//				}
//				q.add(child);
			}

		}

	}    

}// BreadthFirstSearcher