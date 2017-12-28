package chris.HackerRank;

public class HrIfElse {
    public String TestInput(int input) {
        if (input % 2 == 1) {
            return "Weird";
        } else if (input >= 2 && input <= 5) {
            return "Not Weird";
        } else if (input >= 6 && input <= 20) {
            return "Weird";
        } else
            return "Not Weird";
    }
}
