import java.util;
public class Calculator {
    public static void main(String[] args){

        //Algorithm for Task 1
        String convertToPostfix(infix){
            Stack <char> operatorStack = new Stack <char> ();
            String postfix = new String();
            for(char nextCharacter : infix){
                switch(nextcharacter){
                    case 'a': case 'b': case 'c': case 'd': case 'e':   //Different letter cases
                        postfix.append(nextCharacter);
                        break;
                    case '^':   //for cases where to the power of is used
                        operatorStack.push(nextCharacter);
                        break;
                    case '+': case '-': case '*': case '/': //for cases where add, sub, multiply, and divide are used
                        while(!operatorStack.isEmpty() && nextCharacter[] <= operatorStack.peek()){
                            postfix.append(operatorStack.peek());
                            operatorStack.pop();
                        }
                        operatorStack.push(nextCharacter);
                        break;
                    case '(':   //for cases where the left hand paranthesis is used
                        operatorStack.push(nextCharacter);
                        break;
                    case ')':   //for cases where the right hand paranthesis is used
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
    }
}
