
public class LinkList 
{
	private Node head;
	public int count;
	public LinkList()
	{
		this.head = null;
		this.count = 0;
	}
	public int count()
	{
		int count = 0;
		if(head != null)
		{
			count++;

			Node currNode = head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
				count++;
			}
		}
		return count;
	}
	public String removeEnd()
	{
		if(head == null)
		{
			return head.getPayLoad();
		}
		else
		{
			this.count--;
			Node nodeToReturn = head;
			if(head.getNextNode() == null)
			{
				head = null;
				return nodeToReturn.getPayLoad();
			}
			else
			{

				Node currNode = head;
				while (currNode.getNextNode() != null && currNode.getNextNode().getNextNode() != null)
				{
					currNode = currNode.getNextNode();
				}

				nodeToReturn = currNode.getNextNode();
				currNode.setNextNode(null);
				return nodeToReturn.getPayLoad();
			}
		}
	}
	public String removeAtIndex(int index)
	{

		if(index < 0 || index >= this.count)
		{
			throw (new RuntimeException("Hey, that isn't a legal index! -> " + index));
			
		}
		else if(index == 0)
		{
			return this.removeFront();
		}
		else if(index == this.count-1)
		{
			return this.removeEnd();
		}
		else
		{
			this.count--;

			Node nodeBefore = head;
			Node nodeToRemove = null;
			Node nodeAfter = null;
			for(int i = 0; i < index-1; i++)
			{
				nodeBefore = nodeBefore.getNextNode();
			}
			nodeToRemove = nodeBefore.getNextNode();
			nodeAfter = nodeToRemove.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
			nodeToRemove.setNextNode(null);
			return nodeToRemove.getPayLoad();
		}
	}

	public String removeFront()
	{
		Node nodeToReturn = this.head;
		if(this.head != null)
		{
			this.head = this.head.getNextNode();
			nodeToReturn.setNextNode(null);
			this.count--;
		}

		return nodeToReturn.getPayLoad();
	}

	public void addAtIndex(String s, int index)
	{
		if(index == 0)
		{
			this.addFront(s);
		}
		else if(index == this.count)
		{
			this.addEnd(s);
		}
		else if(index < 0 || index > this.count)
		{
			throw (new RuntimeException("Hey, that isn't a legal index! -> " + index));
		}
		else
		{
			//do the hard part
			Node n = new Node(s);
			Node currNode = this.head;
			for(int i = 0; i < index-1; i++)
			{
				currNode = currNode.getNextNode();
			}
			
			//we have moved currNode into the position immediately before index
			n.setNextNode(currNode.getNextNode());
			currNode.setNextNode(n);
		}
	}

	public int indexOf(Node n)
	{
		if(this.head != null)
		{
			int pos = 0;
			Node currNode = this.head;
			do
			{
				if(currNode == n)
				{
					return pos;
				}
				else
				{
					pos++;
					currNode = currNode.getNextNode();
				}
			}
			while(currNode != null);
		}
		return -1;
	}


	public void display()
	{
		if(this.head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode != null)
			{
				System.out.print(currNode.getPayLoad() + " -> ");
				currNode = currNode.getNextNode();
			}
			System.out.println("null");
		}
	}

	public String getAtIndex(int index)
	{
		if(index < 0 || index >= this.count)
		{
			System.err.println("Hey, can't remove from the empty list! ->" + index);
			return null;
		}
		else
		{
			Node nodeToReturn = this.head;
			for(int i = 0; i < index; i++)
			{
				nodeToReturn = nodeToReturn.getNextNode();
			}
			return nodeToReturn.getPayLoad();
		}
	}


	public void addFront(String value)
	{

		Node n = new Node(value);
		n.setNextNode(this.head);
		this.head = n;
		this.count++;
	}


	public void addEnd(String value)
	{
		if(this.head == null)
		{
			this.addFront(value);
		}
		else
		{
			Node n = new Node(value);
			Node currNode = head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(n);
			this.count++;
		}
	}


}
