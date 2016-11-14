import java.util.*;

class City implements Comparable {
    int population;
    int clinic;
    int load;

    City(int numberOfPeople) {
        population = numberOfPeople;
        clinic = 1;
        load = getLoad();
    }

    public int compareTo(Object o) {
        City temp = (City)o;
        return load - temp.load;
    }

    int getLoad() {
        if(population % clinic == 0) return (population / clinic);
        else return (population / clinic) + 1;
    }

    void addClinic() {
        clinic++;
        load = getLoad();
    }

}

public class Priority {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //number of elements.
        int C = scan.nextInt() - N;
        PriorityQueue<City> pq = new PriorityQueue<>(N, Collections.reverseOrder()); //Max priority queue.

        for(int i = 0; i < N; i++) {
            pq.add(new City(scan.nextInt()));
        }

        while(C-- != 0) {
            City temp = pq.poll();
            temp.addClinic();
            pq.add(temp);
        }

        System.out.println(pq.poll().load);
    }

}
