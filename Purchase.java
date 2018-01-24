import java.util.*;
import java.awt.*;

public class Purchase {
  private String itemName;
  private int unitsPurchased;
  private double pricePerUnit;
  
  public Purchase() {
      this("", 0, 0);
  }

  public Purchase(String itemName, double units) {
      this(itemName, 0, units);
  }

  public Purchase(String itemName, int unitsPurchased, double units) {
    this.pricePerUnit = units;
    this.itemName = itemName;
    this.unitsPurchased = unitsPurchased;   
  }
// accessor methods 
  public double getPrice() {
    return this.pricePerUnit;
  }

  public String getName() {
    return this.itemName;
  }

  public int getUnitsPurchased() {
    return this.unitsPurchased;
  }
// end accessors

// modifier methods
  public void setPricePerUnit(double units) {
    this.pricePerUnit = units;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setUnitsPurchased(int unitsPurchased) {
    this.unitsPurchased = unitsPurchased;
  }
// end modifiers

  
  public double getCost() {
    return unitsPurchased * pricePerUnit;
  }

  public String toString() {
    String s = "";
    // s = itemName + ", number of units: " + unitsPurchased + 
    
    return s.format("Name of product: %s, units purchased: %s, and price per unit: %s", itemName, unitsPurchased, pricePerUnit);
   }
}
