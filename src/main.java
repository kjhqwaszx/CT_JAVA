import javax.sound.sampled.DataLine;
import java.lang.reflect.Array;
import java.util.*;

public class main {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5,6};
        int[] a2 = Arrays.copyOfRange(a1, 0, 2);

        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }

    }

}


