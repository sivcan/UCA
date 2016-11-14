import java.util.*;

public class RunningMedian{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Finding the running median using a heap (PriorityQueue Implementation).");
        int q;
        int N = scan.nextInt();
        int l, r;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(N, Collections.reverseOrder());

        minHeap.add(Integer.MAX_VALUE);
        maxHeap.add(Integer.MIN_VALUE);
        for(int i = 0; i < N; i++) {
            q = scan.nextInt();
            r = minHeap.peek();
            l = maxHeap.peek();

            if(q < r) {
                minHeap.add(q);
            }
            else {
                maxHeap.add(q);
            }

            if(maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
            }
            else if(minHeap.size() - maxHeap.size() > 1) {
                    maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size()  > minHeap.size()) {
                System.out.println((float)maxHeap.peek());
            }

            else if(minHeap.size() > maxHeap.size()) {
                System.out.println((float)minHeap.peek());
            }

            else if(maxHeap.size() == minHeap.size()) {
                System.out.println(((float)maxHeap.peek() + (float)minHeap.peek())/2);
            }

        }
    }
}
