/**
 * This class represents one item in the list.
 */
public class Drink{
    //Field variables
    private int _drinkID;
    private String _drinkName;
    private double _drinkSmall;
    private double _priceMed;
    private double _priceLar;
    private String _imagePath;
    private double _price;
 
    //getter and setter
    public int getDrinkID() {
        return _drinkID;
    }
    public void setDrinkID(int drinkID) {
        _drinkID = drinkID;
    }
    public String getDrinkName() {
        return _drinkName;
    }
    public void setDrinkName(String drinkName) {
        _drinkName = drinkName;
    }

    public double getPrice() {
        return _price;
    }
    public void setPrice(double price) {
        _price = price;
    }

    public double getDrinkSmall() {
        return _drinkSmall;
    }
    public void setDrinkSmall(double drinkSmall) {
        _drinkSmall = drinkSmall;
    }

    public double getPriceMed() {
        return _priceMed;
    }
    public void setPriceMed(double priceMed) {
        _priceMed = priceMed;
    }
    public double getPriceLar() {
        return _priceLar;
    }
    public void setPriceLar(double priceLar) {
        _priceLar = priceLar;
    }

    public String getImagePath() {
        return _imagePath;
    }
    public void setImagePath(String imagePath) {
        _imagePath = imagePath;
    }

    //6-args constructor
    public Drink(int drinkID, String drinkName, double drinkSmall, String imagePath, double priceMed, double priceLar){
        _drinkID = drinkID;
        _drinkName = drinkName;
        _drinkSmall = drinkSmall;
        _imagePath = imagePath;
        _priceMed = priceMed;
        _priceLar = priceLar;
        
    }
    
    public String toString() {
        return _drinkName;
    }
}