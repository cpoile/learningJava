package chris.HackerRank;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!\nInput, if your class requires it:");

        //hrIfElseTests();

        //HrLoops1.main(null);
        //HrLoops2.main(null);
        //System.out.println(HrGetDay.getDay("10", "12", "2017"));
        //HrHourglass.GetBiggestSum();
        //HrArrayList.main(null);
        //HrArrayGame.main(true);
        //HrArrayGame2.main(true);
        //HrListQueriesWithFile.main(true);
        //HrStack.main(null);
        //HrStrings.main(null);
        //HrSubstrings.main(null);
        //HrPalandrome.main(null);
        //System.out.println(HrAnagrams.isAnagram("mapgrbm", "margpam"));
        //HrTokens.main(null);
        //HrPatternCompile.main(null);
        //HrIPPattern.main(null);
        //HrDuplicateWords.main(null);
        //HrBigDecimal.main(null);
        //HrBigIntegerPrime.main(null);
        //HrSHA256.main(null);
        //HrInnerClass.main(null);
        //HrVarargs.main(null);
        //HrTreeVisitor.main(null);
        //HrSets.main(null);
        //HrDeque.main(null);
        //LocalesMap.main(null);
        //Divsum.main(null);
        //HrBitSet2.main(null);
        HrPriorityQueue.main(null);
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