package PaymentServices;

public class OrderServiceFactory {

    private static OrderServiceFactory instance = null;

    private OrderServiceFactory() {}

    /**
     * Singleton pattern for OrderServiceFactory
     */
    public static OrderServiceFactory getInstance() {
        if (instance == null) {
            instance = new OrderServiceFactory();
        }
        return instance;
    }

    public OrderService createOrderService(int orderType) {
        return switch (orderType) {
            case 1 -> OnSiteOrderService.getInstance();
            case 2 -> OnlineOrderService.getInstance();
            default -> null;
        };
    }
}
