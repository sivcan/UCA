import java.util.*;

public class JavaUtil {
    public static void main(String args[]) {
        System.out.println("Project Setup");

        // Integer x = 1000;
        // Integer y = 1000;
        // x = y;
        // if(x == y) { //References are compared thus the refrences are not same and this statement won't execute
        //     System.out.println("x == y");
        // }
        //
        // if(x.equals(y)) { //The Integer wrapper class implements a intValue() comparison in the equals method thus this gets executed.
        //     System.out.println("x.equals(y)");
        // }

        ArrayList<String> x = new ArrayList<>();
        x.add("Deadmau5");
        x.add("Alesso");
        x.add("TheFray");
        x.add("OneRepublic");

        System.out.println("Before sorting : "  + x);
        Collections.sort(x); //Using inbuilt sort to sort the collections.
        System.out.println("After sorting : " + x);

    }
}
