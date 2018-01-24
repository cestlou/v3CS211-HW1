import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

// Original code from Stuart Reges (3/28/07)
// @author Reges and Stepp, Building Java Programs
// modified by W.P. Iverson, Bellevue College, 2016
// for CS210 class, final project
// 
@SuppressWarnings("serial")
public class BasketFrame extends JFrame {
    private MyBasket stuff;
    private JTextField total;

    public BasketFrame()      {
        // create frame and order list
        setTitle("CS210/211");
        stuff = new MyBasket();
        stuff.add(new Purchase("Peanut Butter", 3.95));
        stuff.add(new Purchase("Apple Jelly", 3.99));
        stuff.add(new Purchase("Bread", 3, 2.99));
        stuff.add(new Purchase("Cured Ham", 29.99));
        stuff.add(new Purchase("Mayonnaise", 1.99));
        stuff.add(new Purchase("Red Leaf Lettuce", 2.4));
        stuff.add(new Purchase("Mustard",  1.1));
        stuff.add(new Purchase("Picnic Basket with Wheels and Cooler", 195));
        stuff.add(new Purchase("Knife",  9));

        // set up text field with order total
        total = new JTextField("$0.00", 12);
        total.setEditable(false);
        total.setEnabled(false);
        total.setDisabledTextColor(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        JLabel l = new JLabel("ORDER TOTAL");
        l.setForeground(Color.YELLOW);
        p.add(l);
        p.add(total);
        add(p, BorderLayout.NORTH);

        p = new JPanel(new GridLayout(stuff.length(), 1));
        for (int i = 0; i < stuff.length(); i++)
            addItem(stuff.get(i), p);
        add(p, BorderLayout.CENTER);
        // adjust size to just fit
        pack();
        setVisible(true);
    }


    // adds a product to the panel, including a textfield for user input of
    // the quantity
    private void addItem(final Purchase product, JPanel p) {
        JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(new Color(0, 180, 0));
        final JTextField quantity = new JTextField(3);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        quantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateItem(product, quantity);
                quantity.transferFocus();
            }
        }); // anonymous ActionListener causes off indentation
        quantity.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                updateItem(product, quantity);
            }
        }); // anonymous Adapter created to track cursor focus
        sub.add(quantity);
        String label = new String(product.getName());
        label += " (" + NumberFormat.getCurrencyInstance().format(product.getPrice()) + ")";
        JLabel l = new JLabel(label);
        l.setForeground(Color.white);
        sub.add(l);
        p.add(sub);
    }

    // When the user types a new value into one of the quantity fields,
    // parse the input and update.  
    private void updateItem(Purchase product, JTextField quantity) {
        int number;
        String text = quantity.getText().trim();
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number <= 0 && text.length() > 0) {
            quantity.setText("");
            number = 0;
        }
        // number is now the correct quantity
        stuff.add(product,number);
        updateTotal();
    }

    // reset the text field for order total
    private void updateTotal() {
        double amount = stuff.getTotalCost();
        total.setText(NumberFormat.getCurrencyInstance().format(amount));
    }
    
    // Launch the constructor from a standard console configuration
    public static void main(String[] args) {
    	new BasketFrame();
    }
}
