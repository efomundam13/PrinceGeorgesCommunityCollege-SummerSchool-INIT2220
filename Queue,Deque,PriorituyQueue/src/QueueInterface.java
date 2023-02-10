/** An interface for the ADT queue.  */
public interface QueueInterface<T>
{
  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(T newEntry);
  
  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
  public T dequeue();
  
  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
  public T getFront();
  
  /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty();
  
  /** Removes all entries from this queue. */
  public void clear();
} // end QueueInterface

Computing the Capital Gain in a Sale of Stock
public class StockLedger
{
  private QueueInterface<StockPurchase> ledger;
  
  public StockLedger()
  {
     ledger = new LinkedQueue<>();
  } // end default constructor
  
  /** Records a stock purchase in this ledger.
      @param sharesBought   The number of shares purchased.
      @param pricePerShare  The price per share. */
  public void buy(int sharesBought, double pricePerShare)
  {
    while (sharesBought > 0)
    {
       StockPurchase purchase = new StockPurchase(pricePerShare);
       ledger.enqueue(purchase);
       sharesBought--;
    } // end while
  } // end buy
 /** Removes from this ledger any shares that were sold 
      and computes the capital gain or loss.
      @param sharesSold     The number of shares sold.
      @param pricePerShare  The price per share.
      @return  The capital gain (loss). */
  public double sell(int sharesSold, double pricePerShare)
  {
     double saleAmount = sharesSold * pricePerShare;
     double totalCost = 0;
    
     while (sharesSold > 0)
     {
        StockPurchase share = ledger.dequeue();
        double shareCost = share.getCostPerShare();
        totalCost = totalCost + shareCost;
        sharesSold--;
     } // end while
    
     return saleAmount - totalCost; // Gain or loss
  } // end sell
} // end StockLedger

/** An interface for the ADT priority queue. */
public interface PriorityQueueInterface<T extends Comparable<? super T>>
{
   /** Adds a new entry to this priority queue.
       @param newEntry  An object to be added. */
   public void add(T newEntry);

   /** Removes and returns the entry having the highest priority.
       @return  Either the object having the highest priority or, if the
                priority queue is empty before the operation, null. */
   public T remove();

   /** Retrieves the entry having the highest priority.
       @return  Either the object having the highest priority or, if the
                priority queue is empty, null. */
   public T peek();

   /** Detects whether this priority queue is empty.
       @return  True if the priority queue is empty, or false otherwise. */
   public boolean isEmpty();

   /** Gets the size of this priority queue.
       @return  The number of entries currently in the priority queue. */
   public int getSize();

   /** Removes all entries from this priority queue. */
   public void clear();
} // end PriorityQueueInterface
