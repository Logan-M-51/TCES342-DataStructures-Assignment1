//Logan Miller
//Assignment 1



//Population
import java.util.Random;
import java.util.Iterator;

public class Population<T>{

   public MyLinkedList population;
   public Genome target;
   public String targetString;
   public Genome mostFit;
   public double mutationRate;
   public int size;   

   public Population() {
      //Population
      Genome mostfit = new Genome();
   
      //target
      String targetString = "CHRISTOPHER PAUL MARRIOTT";
      
      target = new Genome();
      char[] name = {'C', 'H', 'R', 'I', 'S', 'T', 'O', 'P', 'H', 'E', 'R', ' ', 'P', 'A', 'U', 'L', ' ', 'M', 'A', 'R', 'R', 'I', 'O', 'T', 'T'};
      for (int i = 0 ; i < name.length; i++) {
         target.Genes.add(name[i], i);
      }
      
      //population list size
      int size = 100;
      
     
      
      population = new MyLinkedList();

      for (int i = 0; i < 100; i++) {
        Genome temp = new Genome();
        population.add(temp);
      }

      mostFit = (Genome) population.get(99);
   
      //mutation percentage rate
      mutationRate = 0.05;
   }
   public void nextGeneration() { 
      char[] baseSet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-', '\''};
      for (int j = 0; j < 50; j++) {
         population.remove(0);
      }

      //iterateing through population list
      Iterator itr = population.iterator();
      population.current = population.first;
      int i =0;
      while (i<50) {
         Genome gene = (Genome) itr.next(); 
         
         Genome geneMut = new Genome();
         int index = gene.size();
         //clone
         geneMut.genomeCopy(gene); 
                 
         //50/50 mutate or crossover
         int mutateChance = getRand(1, 3);
         
         if (mutateChance == 1) {
            geneMut.mutate(mutationRate, baseSet);
         }
         else {            
            geneMut.crossOver((Genome) population.get(getRand(0, 50)));
            geneMut.mutate(mutationRate, baseSet);
         }
         
         population.add(geneMut); 
         i++;  
      }
      
      population.sort();
      //System.out.println(population.toString());
      //change to 99
      mostFit = (Genome) population.get(99);

   }
   
   
   public String toString() {
      String ret = "";
      
      for (int i = 0; i < this.population.size(); i++) {
         Genome temp = new Genome();
         temp = (Genome) population.get(i);
         ret += "[" + temp.toString() + "]" + "\n";
        
      }
      return ret;
   }
   
    public int getRand(int min, int max){
      return (int)(((Math.random() * (max - min)) + min));

   }
}
