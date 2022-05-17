//Logan Miller
//Assignment 1



//Genome

import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Math;

public class Genome implements Comparable<Genome> {

   public char[] baseSet;
   public MyLinkedList Genes;
   
   public Genome() {
     char[] baseSet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-', '\''};
     Genes = new MyLinkedList();
   
   }
   
   public void genomeCopy(Genome original) {
      Genome genomeCopy = new Genome();
      int index = original.size();
      if (original.Genes.first != null) {
         for (int i = 0; i < index; i++) {
            genomeCopy.Genes.add(original.Genes.get(i), i);
         }
       }
       
       this.Genes = genomeCopy.Genes;
      }
   
   
   public void mutate(double mutationRate, char[] baseSet) {
      
      int max = this.Genes.size();
      
      int initialSize = this.Genes.size();            
      double per1 = getRand(0, 100)/100.0;
      if (per1 <= mutationRate) {
            char newChr = baseSet[getRand(0,29)];
            int replace = getRand(0, (this.Genes.size() + 1));
            this.Genes.add(newChr, replace);
            per1 += 1;
                       
         }  
      double per2 = getRand(0, 100)/100.0;
      if (per2 <= mutationRate) {
            if (max != 0) {
               if (this.Genes.size() != 0) {
                  int remove = getRand(0, this.Genes.size());
                  this.Genes.remove(remove);
               }
            }
            per2 += 1;
                         
         }
      for (int i = 0; i < this.Genes.size(); i++) {     
         double per3 = getRand(0, 100)/100.0;
         if (per3 <= mutationRate) {
            char newChr = baseSet[getRand(0,29)];
            this.Genes.set(newChr, i);
               
         }
      } 
   }
   
   public int size() {
      return this.Genes.size();
   }
   
    
   public int getRand(int min, int max){
      return (int)(((Math.random() * (max - min)) + min));

   }
   
   public int fitness() {
      MyLinkedList target = new MyLinkedList();
      char[] name = { 'C', 'H', 'R', 'I', 'S', 'T', 'O', 'P', 'H', 'E', 'R', ' ', 'P', 'A', 'U', 'L', ' ', 'M', 'A', 'R', 'R', 'I', 'O', 'T', 'T'};
      for (int i = 0 ; i < name.length; i++) {
         target.add(name[i], i);
      }
      int genomeLength = this.Genes.size();
      int targetLength = target.size();
      int l = Math.abs(targetLength - genomeLength);
      int d = 0;
      int max;
      if (genomeLength > targetLength) {
         max = genomeLength;
      }
      else {
         max = targetLength;
      }
      
      for (int i = 0; i < max; i++) {
         if ( i < targetLength && i < genomeLength ) {
            if (target.get(i) != this.Genes.get(i) ) {
               d++;
            }
         }
         else {
            d++;
         }
      }
      int ret = -1 * (l + d);
      
      return ret;
    }  
  
      
   
   
   public void crossOver(Genome parent) {
         Genome baby = new Genome();
         int size1 = this.Genes.size();
         int size2 = parent.Genes.size();
         int maxLength = 0;
         int minLength = 0;
         if (size1 > size2) {
           minLength = size2;
           maxLength = size1;
         }
         else{
            minLength = size1;
            maxLength = size2;
         }
                  
         for (int k = 0; k < maxLength; k++) {
            int dominant = getRand(1, 3);
            if (dominant == 1) {
               if (k < size1) {
                  baby.Genes.add(this.Genes.get(k));
               }
               else {
                  break;
               }
            }
            else {
               if (k < size2) {
                  baby.Genes.add(parent.Genes.get(k));
               }
               else{
                  break;
               }
            }
            
         }
         this.Genes = baby.Genes;
      
   }
   
   @Override public int compareTo(Genome other) {
      int moreFit = 0;
      if (other == null && this == null) {
         return 0;
      }
      else if (this.Genes.first == null && other.Genes.first != null) {
        moreFit--;
      }
      else if (this.Genes.first != null && other.Genes.first == null) {
         moreFit++;
      }
      else if (this.fitness() > other.fitness()) {
         moreFit++;
      }
      else if (this.fitness() < other.fitness()) {
         moreFit--;
      }
      
      return moreFit;
   }
   
     
   public String toString() {
      if(Genes != null) {
        int geneSize = Genes.size();
          return Genes.toString();
       
      }
      else {
         return "";
      }
   }
   
   
}



