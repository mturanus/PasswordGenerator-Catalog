package shopping;

public class Catalog {

	public static void main(String[] args) {
		Catalog catalog = new Catalog();
		System.out.println("-------getWholeCatalog-------");
		System.out.println(catalog.getWholeCatalog());

		System.out.println("-------getItemDetails-------");
		System.out.println(catalog.getItemDetails("MacbookPro"));

		System.out.println("-------getItemsLessThanAMonthlyPrice-------");
		System.out.println(catalog.getItemsLessThanAMonthlyPrice(10.99));

	}

	String[] items = { "iPhone 6s", "iPhone 6s Plus", "iPhone X", "MacbookPro", "ThumbDrive", "Beats HeadPhones",
			"Mouse", "Charger", "iPad", "Dyson Vacuum", "TV", "Apple Watch" };
	double[] prices = { 449, 549, 1149, 1499.99, 39.99, 349.99, 79.99, 39.99, 429, 399, 2199, 559 };
	double[] monthlyPayments = { 18.71, 22.88, 56.16, 79.49, 2.68, 15.12, 8.98, 4.56, 18.31, 16.25, 89.49, 21.18 };

	/**
	 * Write a method that reads values from above arrays and returns a
	 * stringbuilder with all item details: return format: iPhone 6s-449.0-18.71
	 * iPhone 6s Plus-549.0-22.88 ...
	 * 
	 */
	public StringBuilder getWholeCatalog() {

		StringBuilder whole = new StringBuilder();

		for (int i = 0; i < items.length; i++) {

			whole.append("\n" + items[i] + "-" + prices[i] + "-" + monthlyPayments[i]);
		}

		return whole;
	}

	/**
	 * write a method that an item name and returns all details for it. If item is
	 * not in the list then returns null ex: getItemDetails("ThumbDrive") -->
	 * ThumbDrive-39.99-2.68 getItemDetails("Charger") --> Charger-39.99-4.56
	 * getItemDetails("Potato") --> null
	 * 
	 * @param item
	 * @return
	 */

	public String getItemDetails(String item) {

		String details = "";

		for (int i = 0; i < items.length; i++) {
			if (items[i].equalsIgnoreCase(item)) {

				return details += items[i] + "-" + prices[i] + "-" + monthlyPayments[i];

			}
		}

		return null;
	}

	/**
	 * write a method that accepts a price and returns a Stringbuilder with items
	 * with less than or equal monthly payments
	 * 
	 * getItemsLessThanAMonthlyPrice(5.99) --> ThumbDrive-39.99-2.68
	 * Charger-39.99-4.56 getItemsLessThanAMonthlyPrice(1.99) --> ""
	 * 
	 * @param price
	 * @return stringBuilder
	 */

	public StringBuilder getItemsLessThanAMonthlyPrice(double price) {

		StringBuilder monthly = new StringBuilder();

		for (int i = 0; i < monthlyPayments.length; i++) {

			if (monthlyPayments[i] <= price) {

				monthly.append(items[i] + "-" + prices[i] + "-" + monthlyPayments[i]+"\n");

			} 
		}

		return monthly;
	}

}
