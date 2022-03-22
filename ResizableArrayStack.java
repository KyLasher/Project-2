import java.util.EmptyStackException;
public class ResizableArrayStack<T> implements StackInterface<T> {
    private T[] stack;    // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;
      
    public ResizableArrayStack(){
        this(DEFAULT_CAPACITY);
    } // end default constructor
      
    public ResizableArrayStack(int initialCapacity){
        integrityOK = false;
        checkCapacity(initialCapacity);
          
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        ntegrityOK = true;
    } // end constructor

    private void checkIntegrity() {
        if (!integrityOK)
        throw new SecurityException("ArrayBag object is corrupt.");
    }// end checkIntegrity

 
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
        throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
    }// end checkCapacity

    public void push(T newEntry){
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    private void ensureCapacity(){
        if (topIndex >= stack.length - 1) {// If array is full, double its size
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    public T pop() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        }else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    public T peek() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        }else {
            return stack[topIndex];
        }
    } // end peek

    public boolean isEmpty() {
        return topIndex < 0;
    } // end isEmpty

    public void clear() {
        checkIntegrity();
      
        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        } // end while
        //Assertion: topIndex is -1
    } // end clear

    public String evaluatePostfix(String postfix){
        Stack <char> valueStack = new Stack <char> ();
        for(char nextCharacter : postfix) {
            switch (nextCharacter) {
                case 'a': case 'b': case 'c': case 'd': case 'e':
                    valueStack.push(nextCharacter) //NEED INPUT VALUE OF NEXTCHARACTER //Might be good now but not sure**
                    break;
                case '+': case '-': case '*': case '/': case '^':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result  = operandTwo + nextCharacter + operandOne; //NEED INPUT OPERATION OF NEXTCHARACTER AND OPERANDTWO AND OPERANDONE
                    valueStack.push(result);
                    break;
                default: break;
            }
        }
        return valueStack.peek();
    }
}
