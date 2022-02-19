import javax.sound.sampled.DataLine;
import java.lang.reflect.Array;
import java.util.*;

public class main {



    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);

        System.out.println(que.peek());
        que.remove();
        System.out.println(que.peek());

    }
}