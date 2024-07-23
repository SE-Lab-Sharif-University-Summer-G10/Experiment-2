package PaymentServices;

public class PhoneOrderService extends OrderService {

    private static PhoneOrderService instance = null;

    private PhoneOrderService() {}

    /**
     * Singleton pattern for PhoneOrderService
     */
    public static PhoneOrderService getInstance() {
        if (instance == null) {
            instance = new PhoneOrderService();
        }
        return instance;
    }

    @Override
    public void orderRegister(String customerName) {
        System.out.println("Phone order registered for " + customerName);
    }

    @Override
    public void orderPayment(int foodPrice) {
        System.out.println("Phone Payment with Price : " + foodPrice + " Tomans!");
    }
}
