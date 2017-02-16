
public class LinkList 
{
	private Node first;
	// AddFront method
	public void addFront(String val)
	{
		Node n = new Node(val);
		n.setNextNode(this.first);
		this.first = n;
	}
	
	//addEnd Method
	public void addEnd(String val)
	{
		if(this.first == null)
		{
			this.addFront(val);
		}
		else 
		{
			Node n = new Node(val);
			Node currentNode = first;
			while(currentNode.getNextNode()!=null)
			{
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(n);
		}
	}
	public void display()
	{
		System.out.println("List item from first to end :");
		Node currentNode = first;
		while(currentNode.getNextNode()!=null)
		{
			currentNode = currentNode.getNextNode();
		}
		System.out.println("");
		
	}
}
