import java.util.ArrayList;

public class MyQueue<T>{
    private ArrayList<T> myQueue = new ArrayList<T>();

    public void enqueue(T item) {
        myQueue.add(item);
    }

    public T dequeue() {
        if (myQueue.isEmpty()) {
            return null;
        }
        return myQueue.remove(0);
    }

    public boolean isEmpty(){
        return myQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());

    }

}