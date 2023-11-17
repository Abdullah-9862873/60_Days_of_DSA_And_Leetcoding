public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};

        int ans = -1;
        if(arr.length == 1){
            ans = arr[0];
            System.out.println(ans);
        }else{
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if((mid>0 && mid<arr.length) && (mid!=0 && mid != arr.length-1)){
                    if(arr[mid] == arr[mid+1]){
                        if(mid % 2 == 0){
                            start = mid + 1;
                        }else{
                            end = mid-1;
                        }
                    }else if(arr[mid] == arr[mid-1]){
                        if((mid-1) % 2 == 0){
                            start = mid + 1;
                        }else{
                            end = mid - 1;
                        }
                    }else{
                        ans = arr[mid];
                        System.out.println(ans);
                        break;
                    }
                }else if(mid == arr.length-1){
                    if(arr[mid] != arr[mid-1]){
                        ans = arr[mid];
                        System.out.println(ans);
                        break;
                    }
                }else if(mid == 0){
                    if(arr[mid] != arr[mid+1]){
                        ans = arr[mid];
                        System.out.println(ans);
                        break;
                    }
                }
            }
        }
    }
}