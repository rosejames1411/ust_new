import java.util.HashMap;
import java.util.Map;

class DuplicateProductIDException extends Exception {
    public DuplicateProductIDException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class ShoppingCart {
    private Map<Integer, Product> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addProduct(Product product) throws DuplicateProductIDException {
        if (cart.containsKey(product.productId)) {
            throw new DuplicateProductIDException("Product ID " + product.productId + " already exists in the cart.");
        }
        cart.put(product.productId, product);
    }

    public void deleteProduct(int productId) throws ProductNotFoundException {
        if (!cart.containsKey(productId)) {
            throw new ProductNotFoundException("Product ID " + productId + " not found in the cart.");
        }
        cart.remove(productId);
    }

    public void displayCartContents() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (Product product : cart.values()) {
                product.displayDetails();
                System.out.println("-----------------------");
            }
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : cart.values()) {
            total += product.price * product.quantityInStock;
        }
        return total;
    }
}
