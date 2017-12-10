package chris.ch1a;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        hrIfElseTests();
    }

    private static void hrIfElseTests() {
        HrIfElse hr = new HrIfElse();
        assert hr.TestInput(1).equals("Weird");
        assert hr.TestInput(3).equals("Weird");
        assert hr.TestInput(5).equals("Weird");
        assert hr.TestInput(19).equals("Weird");

        assert hr.TestInput(2).equals("Not Weird");
        assert hr.TestInput(4).equals("Not Weird");

        assert hr.TestInput(6).equals("Weird");
        assert hr.TestInput(10).equals("Weird");
        assert hr.TestInput(14).equals("Weird");

        assert hr.TestInput(20).equals("Not Weird");
        assert hr.TestInput(28).equals("Not Weird");
        assert hr.TestInput(36).equals("Not Weird");
        assert hr.TestInput(82).equals("Not Weird");
    }
}