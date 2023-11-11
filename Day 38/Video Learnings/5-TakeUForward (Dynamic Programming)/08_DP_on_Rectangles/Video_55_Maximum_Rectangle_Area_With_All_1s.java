import java.util.*;

public class Video_55_Maximum_Rectangle_Area_With_All_1s{
    public static void main(String[] args){
        int[][] arr = {
            {1,0,1,0,0},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}
        };
        int ans = getMaxRectangleArea(arr);
        System.out.println(ans);
    }
    public static int getMaxRectangleArea(int[][] arr){
        int maxArea = 0;
        int[] histogram = new int[arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == 1){
                    int val = histogram[j];
                    val += 1;
                    histogram[j] = val;
                }else{
                    histogram[j] = 0;
                }
            }
            int area = getLargestAreaOfHistogram(histogram);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
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

/*
This question is of Dynamic programming because somewhere in the stack we are remembering the past to write new values  and updating the maxArea
 */