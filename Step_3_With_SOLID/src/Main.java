import PaymentServices.OnSiteOrderRegisterService;
import PaymentServices.OnlineOrderRegisterService;
import PaymentServices.OrderPaymentService;
import PaymentServices.OrderRegisterService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        OrderRegisterService orderRegisterService = null;
        OrderPaymentService orderPaymentService = null;
        String customerName;
        Order order;
        int customerAnswerForOrder=0;
        int customerAnswerForPaymentMethod=0;

        System.out.println("Enter Customer Name : ");
        customerName = scanner.nextLine();
        order = new Order(customerName);

        //Step 1 : Select Order Items
        while (customerAnswerForOrder!=3){
            System.out.println("For Ordering Sandwich enter 1.");
            System.out.println("For Ordering Pizza enter 2.");
            System.out.println("For submit your order enter 3");
            customerAnswerForOrder = scanner.nextInt();

            if(customerAnswerForOrder==1){
                order.addItem(new Food("sandwich",1000));
            } else if(customerAnswerForOrder==2){
                order.addItem(new Food("pizza",2000));
            }


        }

        //Step2 : Select Payment Method
        System.out.println("Enter Your Payment Method (1 for online and 2 for on-site):");
        customerAnswerForPaymentMethod = scanner.nextInt();
        if(customerAnswerForPaymentMethod==1){
            orderRegisterService = new OnlineOrderRegisterService();
            orderPaymentService = new OnlineOrderRegisterService();
        } else if(customerAnswerForPaymentMethod==2){
            orderRegisterService = new OnSiteOrderRegisterService();
            orderPaymentService = new OnSiteOrderRegisterService();
        } else {
            System.out.println("Invalid Method");
            return;
        }
        orderRegisterService.orderRegister(customerName);

        //Step3 : pay price
        System.out.println("Pay Price:");
        orderPaymentService.orderPayment(order.getTotalPrice());

        //Finally Print Bill
        System.out.println(order);
    }



}
