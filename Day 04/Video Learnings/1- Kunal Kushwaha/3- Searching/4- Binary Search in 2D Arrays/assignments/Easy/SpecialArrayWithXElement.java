public class SpecialArrayWithXElement {
    public static void main(String[] args) {
        int[] arr = { 0,4,3,0,4 };
        int start = 1;
        int end = findMaxElement(arr);

        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int count = countOccurence(arr, mid);
            if(count == mid){
                ans = count;
                break;
            }else if(mid < count){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(ans);
        
    }
    public static int findMaxElement(int[] arr){
        if(arr.length == 0){
            return -1;
        }

        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int countOccurence(int[] arr, int num){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= num){
                count++;
            }
        }
        return count;
    }

}
