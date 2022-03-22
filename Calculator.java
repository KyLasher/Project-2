import java.util;
public class Calculator {
    public static void main(String[] args){
        evaulateInfix(infix){
            Stack <char> operatorStack = new Stack <char> ();
            Stack <char> valueStack = new Stack <char> ();

            while (char nextCharacter : infix){
                switch (nextCharacter) {
                    case variable:
                        valueStack.push(nextCharacter); //Needs to get value of nextCharacter **
                        break;
                    case '^' :
                        operatorStack.push(nextCharacter);
                        break;
                    case '+' : case '-' : case '*' : case '/' :
                        while (!operatorStack.isEmpty() && nextCharacter <= operatorStack){
                            // Execute operator at top of operatorStack
                            topOperator = operatorStack.pop();
                            operandTwo = valueStack.pop();
                            operandOne = valueStack.pop();
                            result = operandOne + topOperator + operandTwo;
                            valueStack.push(result);
                        }
                        operatorStack.push(nextCharacter);
                        break;
                    case '(' :
                        operatorStack.push(nextCharacter);
                        break;
                    case ')' : // Stack is not empty if infix expression is valid
                        topOperator = operatorStack.pop();
                        while (topOperator != '(') {
                            operandTwo = valueStack.pop();
                            operandOne = valueStack.pop();
                            result = operandOne + topOperator + operandTwo;
                            valueStack.push(result);
                            topOperator = operatorStack.pop();
                        }
                        break;
                    default: break // Ignore unexpected characters
                }
            }
            while (!operatorStack.isEmpty()) {
                topOperator = operatorStack.pop();
                operandTwo = valueStack.pop();
                operandOne = valueStack.pop();
                result = operandOne + topOperator + operandTwo;
                valueStack.push(result);
            }
            return valueStack.peek();
        }
    }
}