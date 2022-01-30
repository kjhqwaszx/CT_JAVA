import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> myStack = new ArrayList<T>();

    public void push(T item) {
        myStack.add(item);
    }
    public T pop(){
        if (myStack.isEmpty()) {
            return null;
        }
        return myStack.remove(myStack.size() - 1);
    }
    public boolean isEmpty(){
        return myStack.isEmpty();
    }

    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
