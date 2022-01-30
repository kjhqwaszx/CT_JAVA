import java.awt.print.PrinterGraphics;
import java.util.ArrayList;
import java.util.Collections;

public class SelSort {
    public ArrayList<Integer> selSort(ArrayList<Integer> dataList) {
        int lowest;
        for (int stand = 0; stand < dataList.size() - 1; stand++) {
            lowest = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {
                if (dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
                Collections.swap(dataList, stand, lowest);
            }
        }
        return dataList;
    }
}
