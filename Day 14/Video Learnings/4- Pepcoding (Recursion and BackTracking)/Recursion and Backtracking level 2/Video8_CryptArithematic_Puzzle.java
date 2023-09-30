import java.util.*;

public class Video8_CryptArithematic_Puzzle {
    public static void main(String[] args) {
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";

        HashMap<Character, Integer> map = new HashMap<>();
        mapStringsUniquely(s1, s2, s3, map);
        boolean answerPossibility = isAnswerPossible(map);

        if (answerPossibility) {
            List<String> solutions = new ArrayList<>();
            solveCryptArithmatic(s1, s2, s3, map, solutions);
            displayAllSolutions(solutions);
        }
    }

    public static void solveCryptArithmatic(String s1, String s2, String s3, HashMap<Character, Integer> map, List<String> solutions) {
        Set<Character> unassignedChars = new HashSet<>(map.keySet());
        solve(s1, s2, s3, map, unassignedChars, solutions);
    }

    public static void solve(String s1, String s2, String s3, HashMap<Character, Integer> map, Set<Character> unassignedChars, List<String> solutions) {
        if (unassignedChars.isEmpty()) {
            if (conditionSatisfied(s1, s2, s3, map)) {
                solutions.add(mapToString(map));
            }
            return;
        }

        char ch = unassignedChars.iterator().next();
        unassignedChars.remove(ch);

        for (int i = 0; i <= 9; i++) {
            if (!map.containsValue(i)) {
                map.put(ch, i);
                solve(s1, s2, s3, map, unassignedChars, solutions);
                map.put(ch, -1); 
            }
        }

        unassignedChars.add(ch); 
    }

    public static String mapToString(HashMap<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map.containsKey(ch)) {
                sb.append(ch).append("=").append(map.get(ch)).append(" ");
            }
        }
        return sb.toString();
    }

    public static void displayAllSolutions(List<String> solutions) {
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ": " + solutions.get(i));
        }
    }

    public static void mapStringsUniquely(String s1, String s2, String s3, HashMap<Character, Integer> map) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s1.contains(String.valueOf(ch)) || s2.contains(String.valueOf(ch)) || s3.contains(String.valueOf(ch))) {
                map.put(ch, -1);
            }
        }
    }

    public static boolean isAnswerPossible(HashMap<Character, Integer> map) {
        return map.size() <= 10;
    }

    public static boolean conditionSatisfied(String s1, String s2, String s3, HashMap<Character, Integer> map) {
        String s1InNumbers = "";
        String s2InNumbers = "";
        String s3InNumbers = "";

        for (int i = 0; i < s1.length(); i++) {
            int val = map.get(s1.charAt(i));
            s1InNumbers += (char) ('0' + val);
        }
        for (int i = 0; i < s2.length(); i++) {
            int val = map.get(s2.charAt(i));
            s2InNumbers += (char) ('0' + val);
        }
        for (int i = 0; i < s3.length(); i++) {
            int val = map.get(s3.charAt(i));
            s3InNumbers += (char) ('0' + val);
        }

        int s1ToNumber = Integer.parseInt(s1InNumbers);
        int s2ToNumber = Integer.parseInt(s2InNumbers);
        int s3ToNumber = Integer.parseInt(s3InNumbers);

        return (s1ToNumber + s2ToNumber) == s3ToNumber;
    }
}
