package PaymentServices;

public class PhoneOrderService implements OrderRegisterService, OrderPaymentService {
    @Override
    public void orderRegister(String customerName) {
        System.out.println("Phone order registered for " + customerName);
    }

    @Override
    public void orderPayment(int foodPrice) {
        System.out.println("Phone Payment with Price : " + foodPrice + " Tomans!");
    }
}
