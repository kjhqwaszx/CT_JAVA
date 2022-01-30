import java.util.ArrayList;
import java.util.Collections;

public class binarySearch {
    public static boolean searchFnc(ArrayList<Integer> dataList, int searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int mid = dataList.size() /2 ;

        if (dataList.get(mid) == searchItem) {
            return true;
        }else{
            if (dataList.get(mid) > searchItem) {
                return searchFnc(new ArrayList<Integer>(dataList.subList(0,mid)),searchItem);
            }else {
                return searchFnc(new ArrayList<Integer>(dataList.subList(mid+1,dataList.size())),searchItem);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100) );
        }
        Collections.sort(testData);
        System.out.println(testData);
        System.out.println(searchFnc(testData,1));
        System.out.println(searchFnc(testData,2));

        System.out.println(searchFnc(testData,4));
        System.out.println(searchFnc(testData,5));
        System.out.println(searchFnc(testData,6));
        System.out.println(searchFnc(testData,7));
        System.out.println(searchFnc(testData,8));

    }
}
