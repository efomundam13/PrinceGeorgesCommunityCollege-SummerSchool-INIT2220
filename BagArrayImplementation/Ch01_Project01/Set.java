import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A adapter class that implements a set of objects.
 
   @author Frank M. Carrano, Timothy M. Henry
   @version 5.0
*/
public class Set<T> extends HashSet<T> implements SetInterface<T>
{
   private Iterator<T> removeIterator;
   
	/** Creates an empty set whose initial capacity is 16. */
	public Set()
	{
      super();
      removeIterator = this.iterator();
	} // end default constructor

	/** Creates an empty set having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public Set(int initialCapacity)
	{
      super(initialCapacity);
      removeIterator = this.iterator();
   } // end constructor

   /** Adds a new entry to this set.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
	public boolean add(T anEntry)
	{
      return super.add(anEntry);
	} // end add

   /** Removes the given entry from this set.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
/*   public boolean remove(T anEntry)
   {
       return super.remove(anEntry);
   } // end remove
*/
   /** Removes one unspecified entry from this set, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
   public T remove()
   {
      T result;
      try
      {
         result = removeIterator.next();
      }
      catch (NoSuchElementException e)
      {
         result = null;
      }
      return result;
   } // end remove
   
   /** Removes all entries from this set. */
   public void clear()
   {
      super.clear();
   } // end clear

   /** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() 
	{
      int numberOfEntries = getCurrentSize();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      Iterator<T> iter = this.iterator();
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = iter.next();
      } // end for
      
      return result;
	} // end toArray
   
	/** Sees whether this set is empty.
       @return  True if this set is empty, or false if not. */
	public boolean isEmpty()
	{
      return super.isEmpty();
	} // end isEmpty
   
	/** Gets the current number of entries in this set.
       @return  The integer number of entries currently in this set. */
	public int getCurrentSize()
	{
      return super.size();
	} // end getCurrentSize
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
/*   public boolean contains(T anEntry)
	{
      return super.contains(anEntry);
	} // end contains
 */
} // end Set
