/**
   Chapter 1, Project1.
 
   We do not talk about implementations for a bag and a set
   until the next two chapters, but this project could be done without implementations.
   However, you could give your students the classes for bags and sets included here.
 
   @author Frank M. Carrano
   @version 5.0
*/
public class Project1
{
	public static void main(String[] args) 
	{
		String[] contentsOfBag = {"A", "B", "C", "D", "A", "C", "B", "B"};
		BagInterface<String> aBag = new Bag<>(contentsOfBag);
 		displayBag(aBag);

		// We destroy the bag; to avoid doing so, make a copy of it
		SetInterface<String> aSet = new Set<>();
		while (!aBag.isEmpty())
			aSet.add(aBag.remove());
		displaySet(aSet);
	} // end main
	
	// Displays a bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
                         " string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
	
	// Displays a set.
	private static void displaySet(SetInterface<String> aSet)
	{
		System.out.println("The set contains " + aSet.getCurrentSize() +
						       " string(s), as follows:");		
		Object[] setArray = aSet.toArray();
		for (int index = 0; index < setArray.length; index++)
		{
			System.out.print(setArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displaySet
	
} // end Project1

/*
 The bag contains 8 string(s), as follows:
 A B C D A C B B
 The set contains 4 string(s), as follows:
 A B C D
*/
