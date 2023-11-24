public class Video_44_Print_Encoding {
    public static void main(String[] args) {

        String num = "123";

        printEncoding(num, "");
    }

    public static void printEncoding(String num, String ans) {

        if(num.length() == 0){
            System.out.println(ans);
            return;
        }else if(num.length() == 1){
            char ch = num.charAt(0);        // "1"
            if(ch == '0'){
                return;
            }else{
                int val = ch - '0';                     // 1
                char actualChar = (char)('a' + val-1);      // 'a'
                ans += actualChar;
                System.out.println(ans);
                return;
            }
        }else{
            // If the num.length() is greater than 1

            // Then we'll make two calls

            char firstChar = num.charAt(0);     // "1"
            String restOfFirstString = num.substring(1);      // "23"
            
            if(firstChar == '0'){
                return;
            }else{
                int firstCharValue = firstChar - '0';       // 1
                char code = (char)('a' + firstCharValue - 1);
                printEncoding(restOfFirstString, ans + code);
            }

            // I am done with one recursion call.. I have to do the second one now

            String char12 = num.substring(0,2);       // "12"
            int char12Value = Integer.parseInt(char12);                     // 12
            String restOfSecondString = num.substring(2);                   // "3"

            if(char12Value <= 26){
                char code = (char)('a' + char12Value - 1);
                printEncoding(restOfSecondString, ans + code);
            }

        }

    }
}
