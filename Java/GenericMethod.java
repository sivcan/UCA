public class GenericMethod {
    public static <E> void printArray(E[] inputArray) {
        for(E element : inputArray) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String args[]) {
        Integer[] intArray = {1,3,4,5,6,7};
        Double[]  dblArray = {1.2,3.4,5.4,7.8};
        String[] strArray = {"DP","Algos","GraphTheory"};

        System.out.println("Integer array : ");
        printArray(intArray);

        System.out.println("Double array : ");
        printArray(dblArray);

        System.out.println("String array : ");
        printArray(strArray);

    }
}
