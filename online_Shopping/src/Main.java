public class Main {
    public static void main(String[] args) {
        try {
            ShoppingCart cart = new ShoppingCart();

            // Add Electronics
            Electronics laptop = new Electronics("Laptop", 1, 999.99, 2, "BrandX", 2);
            Electronics phone = new Electronics("Phone", 2, 499.99, 5, "BrandY", 1);

            cart.addProduct(laptop);
            cart.addProduct(phone);

            // Add Clothing
            Clothing shirt = new Clothing("Shirt", 3, 29.99, 10, "M", "Cotton");
            Clothing jeans = new Clothing("Jeans", 4, 49.99, 5, "L", "Denim");

            cart.addProduct(shirt);
            cart.addProduct(jeans);

            cart.displayCartContents();
            System.out.println("Total Price: $" + cart.calculateTotalPrice());

            // Remove a product
            cart.deleteProduct(2);
            cart.displayCartContents();
            System.out.println("Total Price after removal: $" + cart.calculateTotalPrice());

        } catch (DuplicateProductIDException | ProductNotFoundException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
