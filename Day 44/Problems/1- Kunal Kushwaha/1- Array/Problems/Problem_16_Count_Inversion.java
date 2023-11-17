public class Problem_16_Count_Inversion {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int ans = countInversions(arr);
        System.out.println(ans);
    }

    public static int countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    public static int mergeSort(int[] arr, int[] temp, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, temp, low, mid);
            count += mergeSort(arr, temp, mid + 1, high);
            count += merge(arr, temp, low, mid, high);
        }
        return count;
    }

    public static int merge(int[] arr, int[] temp, int low, int mid, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        return count;
    }
}
