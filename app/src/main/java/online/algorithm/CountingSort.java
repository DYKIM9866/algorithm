package online.algorithm;

/**
 * 계수정렬
 */
public class CountingSort {
    public static void main(String[] args) {

        int[] data = { 6, 3, 5, 4, 8, 4, 0, 3, 4, 8, 0, 5, 3, 2, 5, 7, 8, 3, 1, 2, 4 };
        int[] arr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            arr[data[i]] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                System.out.print(i + " ");
                arr[i]--;
            }
        }
    }
}
