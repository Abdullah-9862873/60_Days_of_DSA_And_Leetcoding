public class Video39_Coin_Change_Problem39{
    public static void main(String[] args){
        int[] coins = {2,3,5,6,7};
        int totalAmount = 12;
        int amountSoFar = 0;
        String answerSoFar = "";
        printCoins(0,coins,totalAmount,amountSoFar,answerSoFar);
    }
    public static void printCoins(int i, int[] coins, int totalAmount, int amountSoFar,String answerSoFar){
        if(i == coins.length){
            if(amountSoFar == totalAmount){
                System.out.println(answerSoFar.substring(0, answerSoFar.length()-1));
            }
            return;
        }

        for(int j=totalAmount/coins[i]; j>=0; j--){
            String part = "";
            for(int k=0; k<j; k++){
                part = part + coins[i] + "-";
            }
            printCoins(i+1, coins, totalAmount, amountSoFar + (coins[i] * j), answerSoFar+part);
        }
        printCoins(i+1, coins, totalAmount, amountSoFar, answerSoFar);
    }
}