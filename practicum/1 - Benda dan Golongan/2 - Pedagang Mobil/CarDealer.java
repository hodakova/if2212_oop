public class CarDealer {
    private static int totalCar = 0;
    private String brand;
    private int carInDealer;
    private int carPrice;
    private int profit = 0;

    /**
     * CarDealer constructor
     * Inisiasi sekaligus menambah totalCar
     * @param brand
     * @param carInDealer
     * @param carPrice
     */
    public CarDealer(String brand, int carInDealer, int carPrice) {
        this.brand = brand;
        this.carInDealer = carInDealer;
        this.carPrice = carPrice;
        totalCar += carInDealer;
    }

    /**
     * getBrand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * getCarInDealer
     * @return carInDealer
     */
    public int getCarInDealer() {
        return carInDealer;
    }
    
    /**
     * getCarPrice
     * @return carPrice
     */
    public int getCarPrice() {
        return carPrice;
    }

    /**
     * getProfit
     * @return profit
     */
    public int getProfit() {
        return profit;
    }

    /**
     * getTotalCar
     * @return totalCar
     */
    public static int getTotalCar() {
        return totalCar;
    }

    /**
     * sellCar
     * @param amount
     * @return void
     */
    public void sellCar(int amount) {
        if(amount <= carInDealer) {
            carInDealer -= amount;
            totalCar -= amount;
            profit += amount * carPrice;
        }
    }
}