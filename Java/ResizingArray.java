class ResizingArray {
    String[] s;
    int N = 0;
    public ResizingArray() {
        s = new String[1];
    }

    public void push(String item) {
        if(N == s.length)
            resize(2*s.length);  //Doubling the capacity of the array everytime we are about to insert an element at the end.
        s[N++] = item;
    }

    public void resize(int capacity) {
        String[] copy = new String[capacity];
        System.out.println("The new capacity for the dynamic array is : " + capacity + "\n");
        for(int i = 0; i < N; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    public void display() {
        for(int i = 0; i < N; i++) {
            System.out.println(s[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        System.out.println("Amortized Analysis to obtain the Dynamic Array with time complexity : 3N\n");
        System.out.println("Breaking it down : 2N to resize and copy and N for normal insert.\n");

        ResizingArray obj = new ResizingArray();

        obj.push("Artifical Intelligence");
        obj.push("Machine Learning");
        obj.display();
        obj.push("Dynamic Programming");
        obj.push("Deep Learning");
        obj.display();
        obj.push("Augmented Reality");
        obj.display();

    }
}
