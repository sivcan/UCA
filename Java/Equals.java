class X {
    int y;

    X(int val) {
        y = val;
    }

    public int getValue() {
        return y;
    }

    public boolean equals(Object o){
        if((o instanceof X) && ((X)o).getValue() == this.y) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Equals{
    public static void main(String args[]) {
        Equals eq = new Equals();
        X test = new X(5);
        X test2 = new X(7);

        if(test.equals(test2)) {
            System.out.println("Values are equal!");
        } else {
            System.out.println("Values are not equal");
        }
    }
}
