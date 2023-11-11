import java.util.*;

public class Video_55_Helper_Largest_Area_in_Histogram {
    public static void main(String[] args){
        int[] arr = {2,1,5,6,2,3,1};
        int ans = getLargestAreaOfHistogram(arr);
        System.out.println(ans);
    }
    public static int getLargestAreaOfHistogram(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] rightSmaller = new int[arr.length];
        int[] leftSmaller = new int[arr.length];

        // finding leftSmallerElements
        int i=0;
        while(i < arr.length){
            if(stack.isEmpty()){
                leftSmaller[i] = 0;
                stack.push(i);
                i++;
            }
            else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                leftSmaller[i] = stack.peek()+1;
                stack.push(i);
                i++;
            }
        }
        // finding rightSmallerElement
        while(!stack.isEmpty()){
            stack.pop();
        }
        i = arr.length-1;
        while(i>=0){
            if(stack.isEmpty()){
                rightSmaller[i] = arr.length-1;
                stack.push(i);
                i--;
            }else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                rightSmaller[i] = stack.peek() - 1;
                stack.push(i);
                i--;
            }else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        int[] areasOfHistogram = new int[arr.length];
        for(int j=0; j<arr.length; j++){
            areasOfHistogram[j] = (rightSmaller[j] - leftSmaller[j] + 1)*arr[j];
            maxi = Math.max(maxi, areasOfHistogram[j]);
        }

        return maxi;
    }
}
