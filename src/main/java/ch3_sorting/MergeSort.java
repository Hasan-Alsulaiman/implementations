package ch3_sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    private static <T extends Comparable<T>> void merge(T[] first, int firstLeft, int firstRight,
                                                 int secondLeft, int secondRight,
                                                 ArrayList<T> third) {
        int firstPos = firstLeft, secondPos = secondLeft;
        for (int i = 0; i <= firstRight-firstLeft+secondRight-secondLeft+1; i++) {
            if(firstPos > firstRight) {
                third.add(first[secondPos++]);
                continue;
            }
            if(secondPos > secondRight) {
                third.add(first[firstPos++]);
                continue;
            }

            third.add(first[firstPos].compareTo(first[secondPos]) > 0 ? first[firstPos++] : first[secondPos++]);
        }
    }
    private static <T extends Comparable<T>> void sort(T[] array, int left, int right) {
        if (right > left) {
            var mid = (right + left) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            var B = new ArrayList<T>();
            merge(array, left, mid, mid+1, right, B);
            for (int i = 0; i < right - left + 1; i++)
                array[left + i] = B.get(i);
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array,0, array.length -1);
    }

    public static void main(String[] args) {
        var testArray = new String[]{"a", "c", "b", "z"};
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
