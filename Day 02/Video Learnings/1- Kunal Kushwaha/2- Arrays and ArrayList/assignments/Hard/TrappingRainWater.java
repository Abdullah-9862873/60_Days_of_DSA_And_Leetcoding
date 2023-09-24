
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int[] ansArray = new int[height.length];
        int ans = 0;

        for(int i=0; i<height.length; i++){
            if(i==0){
                left[i] = height[i];
            }else{
                left[i] = Math.max(left[i-1], height[i]);
            }
        }

        for(int i=height.length-1; i>=0; i--){
            if(i == height.length-1){
                right[i] = height[i];
            }else{
                right[i] = Math.max(height[i], right[i+1]);
            }
        }

        for(int i=0; i<height.length; i++){
            ansArray[i] = Math.min(left[i],right[i]) - height[i];
        }

        for(int i=0; i<ansArray.length; i++){
            ans += ansArray[i];
        }

        System.out.println(ans);
    }
}
