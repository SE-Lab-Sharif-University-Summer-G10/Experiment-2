package PaymentServices;

public class OnSiteOrderService extends OrderService {

    private static OnSiteOrderService instance = null;

    private OnSiteOrderService() {}

    /**
     * Singleton pattern for OnlineOrderService
     */
    public static OnSiteOrderService getInstance() {
        if (instance == null) {
            instance = new OnSiteOrderService();
        }
        return instance;
    }

    @Override
    public void orderRegister(String customerName) {
        System.out.println("on-site order registered for " + customerName);
    }

    @Override
    public void orderPayment(int foodPrice) {
        System.out.println("on-site payment with price : " + foodPrice + " Tomans!");
    }

}
