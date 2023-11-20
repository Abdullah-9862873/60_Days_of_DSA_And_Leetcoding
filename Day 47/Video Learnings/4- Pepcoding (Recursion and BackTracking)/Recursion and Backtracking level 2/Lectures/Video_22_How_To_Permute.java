// Make permutation from combination
public class Video_22_How_To_Permute {
    public static void main(String[] args) {
        int currentBox = 1;
        int totalBox = 3;
        boolean[] itemsUsed = new boolean[2];
        String answerSoFar = "";
        int selectionSoFar = 0;
        int totalSelections = 2;

        permutation(currentBox, totalBox, itemsUsed, selectionSoFar, totalSelections, answerSoFar);
    }
    public static void permutation(int cb, int tb, boolean[] itemsUsed, int ssf, int ts, String asf){
        if(cb > tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }

        for(int i=0; i<ts; i++){
            if(itemsUsed[i] == false){
                itemsUsed[i] = true;
                permutation(cb+1, tb, itemsUsed, ssf+1, ts, asf + " " + (i+1));
                itemsUsed[i] = false;
            }
        }
        permutation(cb+1, tb, itemsUsed, ssf, ts, asf + " " + 0);
    }
}

/*
-----Combination-----
---->Combination basically resresents how many ways to put identical items in the boxes
---->For examples there are four boxes and the items are 2

Boxes ---> 000     ---> n
Items --->11        ---> r

There are total n!/r!(n-r)! ways to do so

110
101
011
----> So we can say that the combination is basically the ways to represent

-----Permutation-----
---->Permutation basically represents how any ways to put unidentical items in boxes

----> ---->For examples there are four boxes and the items are 2

Boxes ---> 000     ---> n
Items --->12        ---> r

There are total n!/(n-r)! ways to do so
120
210
102
201
012
021

----> So we can say that the permutation is the way to represent + arrangement of representation

Example--- > Look in combination as the items were identical so there was no point to place [firstOne,SecondOne,blank] as [SecondOne,firstOne,blank] because they are both the same but in permutation it is necessary to do so because the items are not identical...



----------------NOTE------------> 
We can make the combinations by using the formula

2^n = nC0 + nC1 + nC2 + ..... nCr



So the tree for the combination can be made as starting from the --- it has two options either take 1 or leave 1... Then it will move up till n... so for 2^4 it will print 16 answers... And from those 16 we can pick whatever we need... For example, if question demands to put two items in 4 boxes then we can pick all the answers in which only 2 items are being putted in the four boxes...

Now the thing to observe from here is that we can make the permutations from the combinations by knowing the formulas of both

Formula of permutation ----> nPr = n!/(n-r)!
Formula of combination ----> nCr = n!/r!(n-r)!

so nPr = nCr * r!

So we can do something like get the ways to represent the items in the boxes then take r! possibilities from each answer


For Example for boxes=3 and items=2

Combinatioins ---> 
11-
1-1
-11


11-      Gets spliited to 12-  and 21-
1-1      Gets splitted to 1-2  and 2-1
-11      Gets splitted to -12  and -21 because r is 2 in this case

 */
