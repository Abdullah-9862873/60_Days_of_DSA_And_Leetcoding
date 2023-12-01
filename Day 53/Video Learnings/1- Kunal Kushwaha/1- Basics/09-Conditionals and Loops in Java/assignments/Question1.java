/*
Kunal is allowed to go out with his friends only on the even days of a given month. Write a program to count the number of days he can go out in the month of August.
*/
public class Question1 {
    public static void main(String[] args) {
        int totalDays = 31;
        int count = 0;
        
        for(int i=1; i<=totalDays; i++){
            if(i % 2 == 0){
                count += 1;
            }
        }
        System.out.println("The number of days Kunal is allowed to go out are: " + count);
    }   
}
