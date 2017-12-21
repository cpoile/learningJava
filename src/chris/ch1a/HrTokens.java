package chris.ch1a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HrTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        List<String> tokens = Arrays.asList(s.split("[ !,\\?\\._'@]+"));
        //tokens = tokens.stream().filter(t -> !t.equals("")).collect(Collectors.toList());
        //System.out.println(tokens.toString());
        System.out.println(tokens.size());
        tokens.forEach(System.out::println);
        scan.close();
    }
}
