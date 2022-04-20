import entity.Bank;
import entity.Customer;

import java.util.InputMismatchException;
import java.util.List;

public interface InputOutputDao {

   public void menu();

    public int getIntInput();


    public double getDoubleInput();

    public String getStringInput();

    public void printList(List list);

    public void ifBanksAreNull(List list);

    public void ifCustomersAreNull(List list);


    public Bank readBank();


    public Customer readCustomer();

    public void printMessage(String message);

    public void printBank(Bank bank);

    public void printCustomer(Customer customer);



    public String returnBankName();

    public String returnCustomerName();

    public int returnCustomerId();

    public int returnBankId();


    public void ifClientsAreNull(List list);

}
