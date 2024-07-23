package PaymentServices;

public class OnlineOrderService extends OrderService {

    private static OnlineOrderService instance = null;

    private OnlineOrderService() {}

    /**
     * Singleton pattern for OnlineOrderService
     */
    public static OnlineOrderService getInstance() {
        if (instance == null) {
            instance = new OnlineOrderService();
        }
        return instance;
    }

    @Override
    public void orderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
    }

    @Override
    public void orderPayment(int foodPrice) {
        System.out.println("online payment with price : " + foodPrice + " Tomans!");
    }
}
