/** A class that maintains a shopping cart for an online store.
@author Frank M. Carrano
Modified by Darina Dicheva
@version 4.0
*/
public class OnlineShopper {
	public static void main(String[] args) {
	// Define what products are sold in the store
		Item item1 = new Item("Sunflower seeds", 1295);
		Item item2 = new Item("Bird feeder", 2050);
		Item item3 = new Item("Squirrel guard", 1547);
		Item item4 = new Item("Bird bath", 4499);
		
		BagInterface<Item> shoppingCart = new ArrayBag<>();
		BagInterface<Item> groceryBag = new ArrayBag<>();
		int totalCost = 0;
		
		// Add to the shopping cart 2 bags of sunflower seeds
		shoppingCart.add(item1);
		shoppingCart.add(item1);
		
		// Add to the shopping cart 1 bird feeder, 1 squirrel guard and 2 birth baths
		
		shoppingCart.add(item2);
		shoppingCart.add(item3);
		shoppingCart.add(item4);
		shoppingCart.add(item4);
		
		// Check how many packages of Sunflower seeds are in the shopping car
		
		System.out.println("Sunflower seeds bags: "+shoppingCart.getFrequencyOf(item1));
		// Simulate checkout
		while (!shoppingCart.isEmpty()) {
			// Remove the item from the shopping cart
			Item nextItem = shoppingCart.remove();
			// Find the item's price and add it to the totalCost
			totalCost = totalCost+nextItem.getPrice();
			
			// Print item's description
			System.out.println(nextItem.toString());
			
			// Add the item to the shopper bag
			
			groceryBag.add(nextItem);
		}
		System.out.println();
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
		System.out.println();
		System.out.println();
		
		//Part 2 of the project
		Item item5 = new Item("Rome Tomatoes", 595);
		Item item6 = new Item("Oatmeal", 599);
		Item item7 = new Item("Watermelon", 999);
		Item item8 = new Item("Playstation 5 Console", 49999);
		Item item9 = new Item("Samsung TV", 12959);
		Item item10 = new Item("Toy Car", 2000);
		
		shoppingCart.add(item5);
		shoppingCart.add(item6);
		shoppingCart.add(item7);
		shoppingCart.add(item8);
		shoppingCart.add(item9);
		shoppingCart.add(item10);
		
		while (!shoppingCart.isEmpty()) {
			Item nextItem = shoppingCart.remove();
			totalCost = totalCost+nextItem.getPrice();
			System.out.println(nextItem.toString());
			groceryBag.add(nextItem);
		}
		
		System.out.println();
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
		
	} // end main
} // end OnlineShopper
