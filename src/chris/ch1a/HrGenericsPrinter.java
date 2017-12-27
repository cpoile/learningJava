package chris.ch1a;

public class HrGenericsPrinter {
    public <T> void printArray(T[] array) {
        for (T i : array) {
            System.out.println(i.toString());
        }
    }
}
