import java.util;
public class Calculator {
    public static void main(String[] args){

        //Algorithm for Task 1
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

        //Algorithm for Task 4
        String evaluatePostfix(postfix){
            Stack <char> valueStack = new Stack <char> ();
            for(char nextCharacter : postfix){
                switch (nextCharacter){
                    case 'a': case 'b': case 'c': case 'd': case 'e':
                        valueStack.push() //INPUT VALUE OF NEXTCHARACTER
                        break;
                    case '+': case '-': case '*': case '/': case '^':
                        operandTwo = valueStack.pop();
                        operandOne = valueStack.pop();
                        result  = //INPUT OPERATION OF NEXTCHARACTER AND OPERANDTWO AND OPERANDONE
                        valueStack.push();
                        break;
                    default: break;
                }
            }
            return valueStack.peek();
        }
    }
}
