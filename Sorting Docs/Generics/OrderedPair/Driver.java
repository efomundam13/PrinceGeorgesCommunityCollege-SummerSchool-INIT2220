/** 
   A driver that demonstrates the class OrderedPair.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver
{
	public static void main(String[] args) 
	{
		OrderedPair<String> fruit = new OrderedPair<>("apples", "oranges");
		System.out.println(fruit);
		fruit.changeOrder();
		System.out.println(fruit);

		Name tweedleDee = new Name("Tweedle", "Dee");
		Name tweedleDum = new Name("Tweedle", "Dum");
		OrderedPair<Name> namePair = new OrderedPair<>(tweedleDee, tweedleDum);
		System.out.println(namePair);
		namePair.changeOrder();
		System.out.println(namePair);
      
      System.out.println("\nDone.");
	} // end main
} // end Driver

/*
 (apples, oranges)
 (oranges, apples)
 (Tweedle Dee, Tweedle Dum)
 (Tweedle Dum, Tweedle Dee)
 
 Done.
*/
