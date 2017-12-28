package chris.HackerRank;

import java.util.*;

public class HrStack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Character> matchOf = new HashMap<>();
        matchOf.put(')', '(');
        matchOf.put(']', '[');
        matchOf.put('}', '{');

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            for (Character c : input.toCharArray()) {
                if (!stack.empty() && stack.peek() == matchOf.get(c))
                    stack.pop();
                else
                    stack.push(c);
            }
            String msg = stack.empty() ? "true" : "false";
            System.out.println(msg);
        }
    }

    // just for getting a testing framework up and running
    public static Integer sumNums(Integer[] numbers) {
        return Arrays.stream(numbers).reduce(Integer::sum).orElse(0);
    }
}
