import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {

            boolean swap = false;

            for (int j = 0; j < dataList.size() - i - 1; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
//          한번도 swap이 발생하지 않으면 정렬되어 있는 배열이다.
            if (swap == false) {
                break;
            }
        }

        return dataList;
    }
}
