import java.util.ArrayList;
import java.util.Collections;

public class insertSort {

        public static ArrayList<Integer> insSort(ArrayList<Integer> arr){
            int item;

            for (int i = 1; i < arr.size(); i++) {
                item = arr.get(i);
                for (int j = i - 1; j >= 0; j--) {
                    if (item < arr.get(j)) {
                        Collections.swap(arr,j,j+1);
                    }
                }
            }

            return arr;
        }

        public static void main(String[] args) {
            ArrayList<Integer> newArr = new ArrayList<Integer>();
            for (int i = 0; i < 100; i++) {
                newArr.add((int) (Math.random() * 100));
            }
            System.out.println("oldArr: " + newArr);
            System.out.println("newArr: " + insSort(newArr));

        }

}
