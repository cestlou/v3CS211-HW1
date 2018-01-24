// * A field private Purchase[] as an array of purchases.
// * Another int field that tracks how many purchases actually made.
// * Accessor .length() method that returns your int field.
// * Accessor .get(int) for the Purchase array needs a parameter that will index the array. So get(0)
// returns the first element (a Purchase object) of the array.
// * Default constructor that creates a new array Purchase[100], and initializes number of purchases
// to zero.
// * add(Purchase, int) say we are purchasing an int number of that item. This is tricky, because if you already have that purchase in the basket, you must change it (or remove it) so the new quantity is correct for the second passed parameter. We do not just add more, it’s a replacement process.
// * add(Purchase) will leave the quantity purchased at whatever is already in the Purchase parameter.
// * A getTotalCost() method which is also a little tricky, as you need to go through the array of current purchases and add up the grand total of everything purchased so far. Be certain your totals match what I’ve shown in examples.
// Be particularly careful that the program user can add, subtract (change quantity to zero), replace, and modify quantity as many times as they want. And you program always displays the correct total. The trickiest part of this assignment is how to accommodate those changes while shopping. You might get the right total at first, but then change a purchase to zero, and change it back, and change, and change, and be certain you get back to the right totals (see examples).


public class MyBasket {
    private Purchase[] basket;
    private int purchasesMade;

    public MyBasket() {
        this.basket = new Purchase[100];
        this.purchasesMade = 0;
    }

    public void add(Purchase purchases, int y) {
        int count = 0;
        for (int i = 0; i < basket.length; i++) {   
            if (basket[i].getName() == purchases.getName()) {
                count++;
            }
        }
        // add to array IF the basket's index is null 
        if (count == 0) {
            for (int j = 0; j < basket.length; j++) {
                if (basket[j] == null) {
                    purchases.setUnitsPurchased(y);
                    basket[j] = purchases;
                }
            }
        }
    }
    
    public void add(Purchase purchases) {
        for (int j = 0; j < basket.length; j++) {
            if (basket[j] == null) {
                basket[j] = purchases;
            }
        }
    }

    public double getTotalCost() {
        double sum = 0;
        for (int j = 0; j < basket.length; j++) {
            int units = basket[j].unitsPurchased();
            double price = basket[j].getPrice();
            sum += units * price;
        }
        return sum;
    } 

    // accessor methods
    public int length() {
        return this.purchasesMade;
    }

    public Purchase get(int x) {
        return basket[x];
    }
    // end accessors

    public String toString() {
        String nameOf = "";
        int units = 0;
        double price = 0.0;
        double sum = 0.0;
        String s = "";
        for (int i=0; i < basket.length; i++) {
            nameOf = Purchase.get(basket[i]).getName();
            units = basket[i].unitsPurchased();
            price = basket[i].getPrice();
            sum = units * price;
            String x = String.format("name of product: %s, units purchased: %s, cost per unit: %s, total price: %s", nameOf, units, price, sum);
            System.out.println(x);
        }
        return s;
        // String s = String.format("name of product: %s, units purchased: %s, cost per unit: %s, total price: %s", nameOf, units, price, sum);
        // return s;
   }
}

