package shopping;


import shopping.core.Cart;
import shopping.core.Item;
import shopping.core.ItemType;
import shopping.core.Product;
import shopping.core.User;
import shopping.core.UserType;
import shopping.discount.DiscountPolicy;
import shopping.discount.ThresholdDiscount;

class Main {
    public static void main (String[] args)
    {
    	User employee = new User(UserType.EMPLOYEE, "Pawan");
        Item groceryItem = new Product("Refined oil", 20, ItemType.GROCERY);
        Item otherItem = new Product("Laptop", 222, ItemType.OTHER);
        DiscountPolicy discountPolicy = new ThresholdDiscount();
        
        Cart cart = new Cart(employee, discountPolicy);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        /*
         *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on grocery items = 968 still
         *  After 30% discount on 4 other items totalling 888 = 701.6
         *  After 35 dollars off due to price over $700 = 666.59999 or 666.6 
         */
        System.out.println(cart.total());        
    }
}