public class Video_38_Coin_Change_Problem {
    public static void main(String[] args) {
        int[] coins = {2,3,5,7};
        int target = 12;
        int initialCoins = 0;
        int totalCoins = coins.length-1;
        String answerSoFar = "";
        int amountSoFar = 0;
        printCoins(coins,initialCoins,totalCoins,amountSoFar, answerSoFar, target);
    }   
    public static void printCoins(int[] coins, int initialCoins, int totalCoins, int amountSoFar, String answerSoFar, int target){
        if(initialCoins == coins.length){
            if(amountSoFar == target){
                System.out.println(answerSoFar.substring(0, answerSoFar.length()-1));
            }
            return;
        }
        printCoins(coins, initialCoins+1, totalCoins, amountSoFar+coins[initialCoins], answerSoFar + coins[initialCoins] + "-", target);
        printCoins(coins, initialCoins+1, totalCoins, amountSoFar, answerSoFar, target);
    }
}
