public class Video_10_Print_ZigZag {
    public static void main(String[] args) {
        printZigZag(2);
    }
    public static void printZigZag(int n){
        if(n == 0){
            return;
        }
        System.out.println("Pre " + n);
        printZigZag(n-1);
        System.out.println("In " + n);
        printZigZag(n-1);
        System.out.println("Post " + n);
    }
}

/*
If we have only one recursion call in the code then there will be only two regions of the code... One is the upper region and one is the lower region... Upper region is the region that is written above the recursion call and lower region is the region that is written below the recursion call... The direction of upper region is from bottom to top... And the direction of lower region is from top to bottom...

Example----> 1) Print Increasing numbers
-----------> 2) Print Decreasing numbers

You can make a stack in this case and visualize the recursion


//____________________________________________________________
If we have two recursion calls in the code then the code is split into two halves... One is Left and one is Right...

Making recursion tree is prefferable in this case

Following is the recursion tree for this code...


                        0  0 0  0
                         \ /  \ / 
                          1    1
                           \  /
                            2

Pre Section ----> The section that is at the left side of the Left section... You can say that the code written above the first recursion call...
Left Section ----> The left line that is coming out of two 
In Section ----> The section in between the left section and right section... You can say that the code written between the left and right section
Right Section ----> The right line coming out of two
Post Section ----> The section that is at the right side of the right section... You can say that the code written after the second recursion call...

The order of execution of recursion tree is 
Pre Section ---> Left Section ---> In Section ---> Right Section ---> Post Section
 */