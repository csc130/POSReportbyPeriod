package pointOfSale;

public class ReceiptStack 
{
  protected ReceiptNode top;   // reference to the top of this stack
  protected ReceiptNode current;
  protected ReceiptNode previous;
  private int count;
  
  public ReceiptStack()
  {
    top = null;
  }

  public void push(String element)
  // Places element at the top if this stack.
  { 
    ReceiptNode newNode = new ReceiptNode(element);
    newNode.setLink(top);
    top = newNode;
    count++;
  }     
  
  public int getCount (){
	  return count;
  }
  
  public String getTop()  {
		  return top.getInfo();
  }
  
  private void revPrint(ReceiptNode listRef)
  {
    if (listRef != null)
    {
      revPrint(listRef.getLink());
      System.out.println(" " + listRef.getInfo());
    }
  }
  
  public void printReversed()
  {
    revPrint(top);
  }

  public void setCurrentToTop() {
	  current=top;
  }
  
  public void removeCurrent() {
	  previous.setData("Gone");
  }
  
  public String getCurrentString(){
	  String x = current.getInfo();
	  previous = current;
	  current = current.getLink();
	  return x;
  }
  public ReceiptNode getCurrent() {
	  return current;
  }
  
 
  
  
  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (!isEmpty())
    {
      top = top.getLink();
    }
  }

 
  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    if (top == null) 
      return true;
    else
      return false;
  }
}