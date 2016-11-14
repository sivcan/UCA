import java.util.*;



public class BinaryInbuilt {
    static class RevSort implements Comparator<String> {

        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
    
    public static void main(String args[]) {
        BinaryInbuilt b = new BinaryInbuilt();
        System.out.println("Inbuilt BinarySearch");
        String x[] = {"Bl3nd", "Maroon5", "Daughtry", "BrokenSmile", "SheWillBeLoved"};
        Arrays.sort(x); //Why not Collections.sort(x) ? Tried but giving error. Must test.
        System.out.println("Search result : (" + Arrays.binarySearch(x, "Daughtry") + ") If > 0 then found at that brackitified-index.");
        System.out.println("Search result : (" + Arrays.binarySearch(x, "D") + ") If > 0 then found at that brackitified-index.");
        //The negative result shows the count that it reached, that is the closest index that it possibly reached.
        //Here search for "Sivcan" string gives -6 whereas search for "D" results in a -3.

        System.out.println();
        RevSort rs = new RevSort();
        Arrays.sort(x, rs);
        System.out.println("After reverse Sorting using comparator : ");
        for(String a : x) {
            System.out.print(a + "  ");
        }
    }
}
