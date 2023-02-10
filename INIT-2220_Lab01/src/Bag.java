/**
   An interface that describes the operations of a bag of objects.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize();
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry);

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove();
   
	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
   public boolean remove(T anEntry);
	
	/** Removes all entries from this bag. */
	public void clear();
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bag is empty, the returned array is empty. */
	public T[] toArray();
} // end BagInterface

public class Bag<T> implements BagInterface<T> {
	private final T[] bag;
	private int numOfEntries;
	private static final int CAPACITY = 30;
	
	 //Constructor
	public Bag() {
		this(CAPACITY);
	}
	
	 //Constructor
	public Bag(int desiredCapacity) {
		T[] tempBag = (T[])new Object[desiredCapacity];
		bag = tempBag;
		numOfEntries = 0;
	}

	@Override
	//Return the current size of the bag
	public int getCurrentSize() {
		return numOfEntries;
	}

	@Override
	//Returns true if bag is empty, otherwise false
	public boolean isEmpty() {
		return numOfEntries == 0;
	}

	@Override
	//Adds a new entry to the bag
	public boolean add(T newEntry){
        //If the bag is full, do not insert 
        if(numOfEntries == bag.length ){
        	// return false;
            return false;
        }
        //Insert at the end
        bag[numOfEntries] = newEntry;
        // Increment the numOfEntries
        numOfEntries++;
        return true;
    }
	
	@Override
	public T remove() {
		//If bag is not empty
		if(!isEmpty()) { 
			//Remove the last element and decrement the numberOfEntries
			return bag[numOfEntries--];
		}
		//Return null if bag is already empty
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		 //Searches the bag with the desired value
		for(int i = 0; i < bag.length; i++) {
			 //If the value exist in the bag
			if(bag[i] == anEntry) {
				//Shift all of the values on the right side once to the left
				for(int j = i; j < bag.length - 1; j++) {
					bag[j] = bag[j + 1];
					//Decrement the numOfEntries
					numOfEntries--;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	//Makes the numOfEntries equal to 0
	public void clear() {
		numOfEntries = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
        // count the frequency of the given object
        for(int i = 0; i < bag.length; i++){
            if(bag[i] == anEntry){
                frequency++;
            }
        }
       //Returns the frequency
       return frequency;
    }

	@Override
	public boolean contains(T anEntry) {
		 //Checks for the presence of an entry in the bag
        for(int i = 0; i < bag.length; i++){
        	//If the entry is in the bag, return true
            if(bag[i] == anEntry){
                return true;
            }
        }
        //Otherwise return false
        return false;
    }

	@Override
	public T[] toArray() {
		//Returns a copy of the bag array
		return bag.clone();
	}

	//Main method
	public static void main(String[] args) {
		Bag<String> list = new Bag();
		
		System.out.println("Size of list = " + list.getCurrentSize());
		if(list.isEmpty())
			System.out.println("List is empty");
		else
			System.out.println("List is not empty");
		
		list.add("Yogurt");
		list.add("Tomatoes");
		list.add("Peanuts");
		list.add("Orange Juice");
		
		System.out.println("Size of list = " + list.getCurrentSize());
		if(list.isEmpty())
			System.out.println("List is empty");
		else
			System.out.println("List is not empty");
		
		list.add("Corn");
		list.add("Apple");
		list.add("Soup");
		list.add("Candy");
		
		System.out.println("Size of list = " + list.getCurrentSize());
		
		if(list.remove("Apple"))
			System.out.println("Apple removed from list");
		else
			System.out.println("Apple was not in the list");
		
		if(list.remove("Coconut"))
			System.out.println("Coconut removed from list");
		else
			System.out.println("Coconut was not in the list");
		
		System.out.println("There are " + list.getFrequencyOf("Coconut") + " of this item");
		System.out.println("There are " + list.getFrequencyOf("Candy") + " of this item");
		
		System.out.println("Size of list = " + list.getCurrentSize());
		
		if(list.contains("Okra"))
			System.out.println("The list contains Okra");
		else
			System.out.println("The list does not contain Okra");
	
		list.clear();
		System.out.println("Size of list = " + list.getCurrentSize());
		}	
	}
