import java.util;
public class LinkedStack <T> implements StackInterface <T>{

    //Algorithm
    String convertToPostfix(infix){
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