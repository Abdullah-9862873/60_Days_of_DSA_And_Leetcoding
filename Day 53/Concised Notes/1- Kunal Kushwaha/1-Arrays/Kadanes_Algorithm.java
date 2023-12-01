/*
----> Kadane algorithm is bascically used to find the maximum sum subarray... 

----> If you have to find all the subarrays and have some sort of work with them then you can use this algorithm.

----> You can memorize this algorithm with the question "Maximum Sum Subarray" in which you have to find sum of all the subarrays and then return the maximum of all of the sums

----> This involves three steps:
1) Take sum = 0
2) Take maxi to Integer.MIN_VALUE
3) make a for loop and do the following operations

3.1) Consider the element in sum i-e sum += arr[i]
3.2) Update the maxi, i-e maxi = max(sum, maxi);
3.3) Do not consider the negative values in the sum... i-e If i is at negative value then sum will be stopped... sum = 0
 */

//________________________________________
// Question solved is Find the maximum sum subarray
// Problem_8_Find_Largest_Sum_Continguous_Subarray

public class Kadanes_Algorithm{
    public static void main(String[] args) {
        int[] arr = {1,2,-4,2,3};
        long sum = 0;
        long maxi = arr[0];
    
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
    
        System.out.println(maxi);
    }
}

/*
Tip ---- > When to Use
Description ----> If you have to find a subarray's sum, product, subtraction or division sort of problem then you can use this
 */