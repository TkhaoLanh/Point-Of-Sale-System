import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DrinkList {
    // List of beverage
    private ArrayList<Drink> _list;  

    // Fields for passing information between windows
    private int _quantity;      // Drink Details window to Bill Confirmation window
    private String _note;

    //getter and setters
     
    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    // Load the list from a file.
    public void load(String file) {
        _list = new ArrayList<Drink>();
        Scanner reader = null;
        try {
            if(file=="Hot"){
                reader = new Scanner(new File("drink_list.txt"));
            }
            else{
                reader = new Scanner(new File("drink_cold.txt"));
            }

            while (reader.hasNext()) {
                String record = reader.nextLine();
                // Now split the string and parse each field
                String[] fields = record.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double priceSmall = Double.parseDouble(fields[2]);
               String image = fields[3];
               double priceMed= Double.parseDouble(fields[4]);
               double priceLar= Double.parseDouble(fields[5]);

                // Create a new object for each record
                Drink obj = new Drink(id, name,priceSmall,image,priceMed,priceLar);
                _list.add(obj);    // Add object to list
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    // Save the list to a file.
    public void save(String file) {
        PrintWriter writer = null;
        try {
            File fileHot = new File("drink_list.txt");
            File fileCold = new File("drink_cold.txt");
            if(file=="Hot"){
                writer = new PrintWriter(fileHot);
            }
            else{
                writer = new PrintWriter(fileCold);
            }
            
            for (int index = 0; index < _list.size(); index++) {
                Drink dr = _list.get(index);
                writer.println(dr.getDrinkID() + "," +
                               dr.getDrinkName()+ "," +
                               dr.getDrinkSmall()+ "," +
                               dr.getPriceMed()+ "," +
                               dr.getPriceLar());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(); // Add error recovery here if needed
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    // Get a list item
    public Drink getDrink(int index) {
        return _list.get(index);
    }

    // Get the number of drinks in the list
    public int getSize() {
        return _list.size();
    }
}