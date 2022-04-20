import entity.Bank;
import entity.Customer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class InputOutput implements InputOutputDao{

    static Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("""
                _______________________________________________
                              Employee Management
                _______________________________________________
                1. Add Bank
                2. Add Customer
                3. Add Two Banks To One Customer
                4. Show All Banks And Customers
                5. Add New Customer To New Bank
                6. Add New Customer To Existing Bank
                7. Add Existing Customer To Existing Bank
                8. Delete Customer
                9. Delete Bank
                10. Find Customer By Id
                11. Find Bank By Id
                12. Update Bank Name
                13. Update Customer Name
                14. Remove Bank from Customer
                15. Remove Banks from Customer
                16. Get Customer and their Bank
                17. Show All Banks From Customer
                18. Show All Bank Customers
                19. Show All Customers Without Bank
                20. Show all banks without customer
                21. Show All Banks in Ascending Order
                22. Show All Customers in Ascending Order
                0. Exit

                Please choose: """);


    }

    public int getIntInput() {

        int input = 0;

        while (true) {
            try {
                input = sc.nextInt();
                return input;

            } catch (InputMismatchException e) {

                System.out.println("Endast numeriska värden tack");
            } finally {
                sc.nextLine();

            }

        }
    }



    public double getDoubleInput() {

        double input = 0;

        while (true) {
            try {
                input = sc.nextDouble();
                return input;

            } catch (InputMismatchException e) {
                System.out.print("Wrong input, please insert number : ");
            } finally {
                sc.nextLine();
            }
        }
    }

    public String getStringInput() {

        String input = sc.nextLine();

        return input;
    }

    public void printList(List list) {
        list.forEach(System.out::println);

    }

    public void ifBanksAreNull(List list) {

        if (list.size() == 0) {

            System.out.println("No Banks to this customer");
        }
    }
        public void ifCustomersAreNull(List list) {

            if (list.size() == 0) {

                System.out.println("No customers to this bank");
            }
        }

        public Bank readBank() {

        Bank bank = new Bank();

        System.out.println("Please enter name of bank: ");

        bank.setBankName(getStringInput());

        return bank;

    }


    public Customer readCustomer() {

        Customer customer = new Customer();

        System.out.println("Please enter customer name: ");

        customer.setCustomerName(getStringInput());

        System.out.println("Please enter customer phoneNumber: ");

        customer.setPhoneNumber(getStringInput());

        return customer;


    }

    public void printMessage(String message) {
        System.out.println(message);

    }

    public void printBank(Bank bank){

        System.out.println(bank);
    }

    public void printCustomer(Customer customer){

        System.out.println(customer);
    }



    public String returnBankName() {

        System.out.println("Please enter name of bank: ");

        String bankName = getStringInput();

        return bankName;

    }

    public String returnCustomerName() {

        System.out.println("Please enter name of customer: ");

        String customerName = getStringInput();

        return customerName;
    }

    public int returnCustomerId() {

        System.out.println("Please enter customer id:");

        int id = getIntInput();

        return id;
    }

    public int returnBankId() {

        System.out.println("Please enter bank id:");

        int id = getIntInput();

        return id;
    }


    public void ifClientsAreNull(List list) {

        if (list.size() == 0) {

            System.out.println("No clients to this bank");
        }

    }

}
