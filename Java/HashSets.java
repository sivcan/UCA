import java.util.*;

public class HashSets {

    public static void main(String args[]) {
        System.out.println("HashSet implementation");
        boolean[] ba = new boolean[3];
        Set hs = new HashSet<>(); //Compiler gives warning that declaration is of raw type. Thus use -Xlint.
        //Now that we have specified String here thus it won't show the warning and compile successfully with 0 warnings.
        ba[0] = hs.add("a");
        ba[1] = hs.add("y");
        ba[2] = hs.add(new Integer(43));  //Here the add function returns false because the values already exists in the set.

        for(boolean a : ba) {
            System.out.println(a + " ");
        }
    }

}
