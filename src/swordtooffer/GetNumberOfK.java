package swordtooffer;

public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }

    private int biSearch(int[] arr, double k) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        System.out.println(new GetNumberOfK().GetNumberOfK(a, 3));
    }
}
