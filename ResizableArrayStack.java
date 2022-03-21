public class ResizableArrayStack <T> implements StackInterface <T>{
 //Algorithm for Task 4
 String evaluatePostfix(postfix){
    Stack <char> valueStack = new Stack <char> ();
    for(char nextCharacter : postfix)
    {
        switch (nextCharacter)
        {
            case 'a': case 'b': case 'c': case 'd': case 'e':
                valueStack.push(nextCharacter) //NEED INPUT VALUE OF NEXTCHARACTER
                break;
            case '+': case '-': case '*': case '/': case '^':
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result  = //NEED INPUT OPERATION OF NEXTCHARACTER AND OPERANDTWO AND OPERANDONE
                valueStack.push();
                break;
            default: break;
        }
    }
    return valueStack.peek();
}
