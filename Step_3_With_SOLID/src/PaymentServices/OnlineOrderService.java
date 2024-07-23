package PaymentServices;

public class OnlineOrderService implements OrderRegisterService, OrderPaymentService {
    @Override
    public void orderRegister(String customerName) {
        System.out.println("online order registered for " + customerName);
    }

    @Override
    public void orderPayment(int foodPrice) {
        System.out.println("online Payment with Price : " + foodPrice + " Tomans!");
    }
}
