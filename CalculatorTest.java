public class CalculatorTest {
    public static void main(String[] args){
        ResizableArrayStack<Integer> Stack = new ResizableArrayStack<>();
        String result1 = Stack.evaluatePostfix("53-2*6+");
        System.out.println(result1);
    }
}