//Logan Miller
//main class for calling and testind the functionalities of Population.java, Genome.java, MyLinkedList.java

import java.util.Iterator;

public class Main<T> extends MyLinkedList{

   public static void main(String[] args) {

      int evolutions = 0;
      Population pop = new Population();
      //CHRISTOPHER PAUL MARRIOTT      
      String mostFitString = "";
      String targetString = pop.target.toString();
      long stime = System.nanoTime();
      while (pop.mostFit == null || !(pop.mostFit.toString().equals(pop.target.toString()))) {
         evolutions++;
         pop.nextGeneration();
         System.out.println("[ " + pop.mostFit.toString() + " ] " + pop.mostFit.fitness() +  " Evolution count: " + evolutions );   
      } 
      long etime = System.nanoTime();
      double time = (etime - stime) / 1000000.0;
      System.out.print("Operation Time: " + time);          
      
      
   }
}