/**
   A driver that demonstrates the sequential searches of
   unsorted and sorted chains by using the class ChainSearcher.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver  {
   public static void main(String[] args) {
      Integer[] unsortedArray = {20, 24, 4, 12, 8, 14};
      ChainSearcher<Integer> unsortedChain = new ChainSearcher<>();
      fillChain(unsortedChain, unsortedArray);
      
      System.out.println("Recursive sequential search of an unsorted chain: ");
      unsortedChain.display();
      System.out.println("Is 4 in the chain? "  + unsortedChain.contains(04));
      System.out.println("Is 24 in the chain? " + unsortedChain.contains(24));
      System.out.println("Is 14 in the chain? " + unsortedChain.contains(14));
      System.out.println("Is 10 in the chain? " + unsortedChain.contains(10));
   } // end main
   
   public static void fillChain(ChainSearcher<Integer> chain, Integer[] args) {
      for(int i = 0; i < args.length; i++)
         chain.addToEnd(args[i]);
   } // end fillChain
}  // end Driver
