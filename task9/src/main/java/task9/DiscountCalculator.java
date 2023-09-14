package task9;

public class DiscountCalculator {

  /**
   * Calculate the total cost after applying a discount and adding tax.
   *
   * @param originalPrice     The original price of the item.
   * @param discountPercentage The discount percentage (0 to 100).
   * @param taxRate           The tax rate percentage (0 to 100). Default is 0 if not provided.
   * @return The total cost after discount and including tax.
   * @throws IllegalArgumentException If the input types are invalid.
   * @throws IllegalArgumentException If the discount percentage is out of range (0 to 100).
   * @throws IllegalArgumentException If the tax rate is out of range (0 to 100).
   */
  public static double calculateDiscountedPriceWithTax(double originalPrice, double discountPercentage, double taxRate) {
    if (!(originalPrice >= 0) || !(discountPercentage >= 0 && discountPercentage <= 100) || !(taxRate >= 0 && taxRate <= 100)) {
      throw new IllegalArgumentException("Invalid input value");
    }

    double discount = originalPrice * (discountPercentage / 100);
    double afterDiscountPrice = originalPrice - discount;
    double tax = afterDiscountPrice * (taxRate / 100);

    return afterDiscountPrice + tax;
  }

  public static void main(String[] args) {
    try {
      double totalCost = calculateDiscountedPriceWithTax(100.0, 20.0, 10.0);
      System.out.println("Total cost after discount and tax: " + totalCost);
    } catch (IllegalArgumentException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}