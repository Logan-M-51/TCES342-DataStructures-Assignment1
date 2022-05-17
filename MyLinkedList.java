//Logan Miller
//Assignment 1



//LinkedList

//import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> {


   private class Node {
      public T data;
      public Node next;
   
      public String toString() {
            return  data.toString();
      }
      
      public Node(T newData, Node newNext) {
          next = newNext;
          data = newData;
     }   
   }

   public Node first;
   public Node current;
   public Node last;
   
   public MyLinkedList() {
      first = null;
      current = null;
      last = null;
   } 
   
  
   public void add(T newData) {
      if (first == null) {
         Node newNode = new Node(newData, last);
         first = newNode;
      }
      else {
         Node temp = first;
         int index = this.size();
         while (temp.next != null) {
            temp = temp.next;
         }
         temp.next = new Node(newData, last);
      }
   }
   
   public void add(T node, int index) {
      if (first == null) {
         Node newNode = new Node(node, last);
         first = newNode;
      }
      else if(index > this.size()) {
         this.add(node);
      }
      else if (index == 0) {
         this.first = new Node(node, first);
      }
      else {
      
         Node temp = first;
         for (int i = 0; i < index-1; i++) {
            temp = (Node) temp.next;
         }
         temp.next = new Node(node, temp.next);
      }
      
   }
   
   public void removeHalf() {
      for (int i = 0; i < 50; i++) {
         remove(50);
      }
   }
   
   public void remove(int index) {        
      if (index == 0) {
          if(first != null) {
            first = first.next;
          }
      }
      else {
      
         Node temp = first;
         for (int i = 0; i < index - 1; i++) {
            temp = (Node) temp.next;
         }
         if (temp.next == null) {
            temp = last;
         }
         else if (temp.next.next == null) {
            temp.next = last;
         }
         else {
            temp.next = temp.next.next;
         }
      }
      
   }
   
   public void set(T node, int index) {
      Node temp = first;
      if (index == 0) {
         this.first = new Node(node, first);
      }
      else {
         for (int i = 0; i < index; i++) {
            temp = (Node) temp.next;
         }
         if ( node != null || temp.data != null) {
             temp.data = node;
         }
      }
   }
   
   public T get(int index) {
      Node temp = first;
      for (int i = 0; i < index; i++) {
         temp = (Node) temp.next;
      }
      return temp.data; 
   }
   
   public Iterator<T> iterator() {
      return new Iterator<T>() {
    
       @Override public boolean hasNext() {
         Node temp = first;
         boolean flag = false;
      
         if (temp.next != null) {
            flag = true;
         }
         return flag;
       }

       @Override public T next() {
         Node temp = current;
         current = current.next;
    
         return (T) current.data;
      }
    };

   
   }
   
   public int size() {
      int var = 0;
      if (first != null) {
         Node temp = first;
         if (temp != null) {
            var++;
            while (temp.next != null) {
               var++;
               temp = (Node) temp.next;
            }
         }
         
      }
      return var;
   }
   
   public void sort() {
      //bubble sort
      boolean flag = true;
      int swapCounter = 0;
      while (flag) {
         
         Node temp = this.first;
  
         swapCounter = 0;
         for (int i = 0; i < 98; i++) {
            Genome gene1 = (Genome) temp.data;
            Genome gene2 = (Genome) temp.next.data;
            if (gene1.compareTo(gene2) > 0) {
               T holder1 = temp.data;
               T holder2 = temp.next.data;
               temp.data = holder2;
               temp.next.data = holder1;
               swapCounter++;    
               temp = temp.next;              
               
            }
            else {
               temp = temp.next;
            } 
         }
         
         if (swapCounter == 0) {
           flag = false;
         }
         else {
            flag = true;
         }
         
           
      }
   }
        
   
   
   public boolean isEmpty() {
      boolean flag = true;
      Node temp = first; 
      int index = this.size();
      for (int i = 0; i < index; i++) {
         if( temp != null) {
            return false;
         }
         temp = (Node) temp.next;
      }
      
      return flag;
   }
   
   public String toString() {
      String ret = "";
      
      if (!(this.isEmpty())) {    
         int index = this.size();
         Node temp = first;
         for (int i = 0; i < index; i++){
              ret = ret + temp.data;
              temp = (Node) temp.next;
                      
         }
      }
   
   
      return ret;
   }
 

}
      
   

  