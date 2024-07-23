import PaymentServices.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        OrderServiceFactory orderServiceFactory = OrderServiceFactory.getInstance();
        OrderService orderService;
        String customerName;
        Order order;
        int customerAnswerForOrder = 0;
        int customerAnswerForPaymentMethod;

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
        System.out.println("Enter Your Payment Method:");
        System.out.println("For online payment enter 1.");
        System.out.println("For on-site payment enter 2.");
        System.out.println("For payment over phone enter 3.");
        customerAnswerForPaymentMethod = scanner.nextInt();
        orderService = orderServiceFactory.createOrderService(customerAnswerForPaymentMethod);
        if (orderService == null){
            System.out.println("Invalid Method");
            return;
        }
        orderService.orderRegister(customerName);

        //Step3 : pay price
        System.out.println("Pay Price:");
        orderService.orderPayment(order.getTotalPrice());

        //Finally Print Bill
        System.out.println(order);
    }



}
