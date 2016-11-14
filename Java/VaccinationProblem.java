import java.io.*;
import java.util.*;

class city implements Comparable  {

    int population;
    int clinic;
    int load;


    city(int val) {
        population = val;
        clinic = 1;
        load = getLoad();
    }

    int getLoad() {
        if(population % clinic == 0) return (population/clinic);  //if even, just need the number to be equal to pop/clinic.
        return (population/clinic) + 1; //integer arithmetic comes into play, we're one short of the clinic, thus we do pop/clinic + 1 (Because floor bro :) )
    }

    public int compareTo(Object o) {
        city temp = (city)o;  //Explicit Typcasting of Object to the City Class type object.c
        return load - temp.load;  //-1 if load < temp.load or  1 if load > temp.load. 0 if equal.
    }
    
    void addclinic() {
        clinic++;
        load = getLoad();
    }

}

public class VaccinationProblem {

    public static void main(String args[] ) throws Exception {

        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int C = scn.nextInt() - N;
        PriorityQueue<city> q = new PriorityQueue<>(N,Collections.reverseOrder());
        for(int i = 0 ; i < N ; i++)
            q.add(new city(scn.nextInt()));

        while(C-- != 0) {
            City temp = q.poll();
            temp.addclinic();
            q.add(temp);
        }

        System.out.println(q.poll().load);
    }
}
