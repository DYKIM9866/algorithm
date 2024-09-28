package online.algorithm;

/**
 * 삽입정렬
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] intArr = {10,5,4,9,3,7,6,1,2,8};

        int[] intArr2 = {10,5,4,9,3,7,6,1,2,8};

        for(int i = 1; i < intArr2.length; i++){
            for(int j = i; j > 0; j--){
                if(intArr2[j] < intArr2[j-1]){
                    int temp = intArr2[j];
                    intArr2[j] = intArr2[j-1];
                    intArr2[j-1] = temp;
                } else {
                    // 기준 숫자의 왼쪽은 이미 정렬된 상태이기 때문에 중지
                    break;
                }
            }
        }

        for(int a : intArr){
            System.out.print(a + " ");
        }
    }
}
