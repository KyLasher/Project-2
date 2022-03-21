import java.util.EmptyStackException;
public class LinkedStack<T> implements StackInterface<T>{
    private Node topNode; // References the first node in the chain
  
    public LinkedStack()
    {
       topNode = null;
    } // end default constructor
 
     private class Node
     {
       private T    data; // Entry in stack
       private Node next; // Link to next node
       
       private Node(T dataPortion)
       {
          this(dataPortion, null);
       } // end constructor
       
       private Node(T dataPortion, Node linkPortion)
       {
          data = dataPortion;
          next = linkPortion;
       } // end constructor
       
       private T getData()
       {
          return data;
       } // end getData
       
       private void setData(T newData)
       {
          data = newData;
       } // end setData
       
       private Node getNextNode()
       {
          return next;
       } // end getNextNode
       
       private void setNextNode(Node nextNode)
       {
          next = nextNode;
       } // end setNextNode
     } // end Node
     
    public void push(T newEntry)
    {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
      //topNode = new Node(newEntry, topNode); // Alternate code
    } // end push

    public T pop()
    {
    T top = peek();  // Might throw EmptyStackException
    // Assertion: topNode != null
    topNode = topNode.getNextNode();
    return top;
    } // end pop

    public boolean isEmpty()
    {
   return topNode == null;
    } // end isEmpty

    public void clear()
    {
   topNode = null;
    } // end clear

    public T peek()
    {
   if (isEmpty())
      throw new EmptyStackException();
   else
      return topNode.getData();
    } // end peek


   public String convertToPostfix(String infix){
        Stack <char> operatorStack = new Stack <char> ();
        String postfix = new String();
        for(char nextCharacter : infix){
            switch(nextcharacter){
                case 'a': case 'b': case 'c': case 'd': case 'e':
                    postfix.append(nextCharacter);
                    break;
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while(!operatorStack.isEmpty() && nextCharacter[] <= operatorStack.peek()){
                        postfix.append(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    topOperator = operatorStack.pop();
                    while(topOperator != '('){
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default: break;
            }
        }
        while(!operatorStack.isEmpty()){
            topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
        return postfix;
    }
}