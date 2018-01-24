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
            int units = basket[j].getUnitsPurchased();
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

    
}