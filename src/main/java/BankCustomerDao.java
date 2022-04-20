import entity.Bank;
import entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public interface BankCustomerDao {

    public void addBank(Bank bank);

    public void addCustomer(Customer customer);

    public void addTwoBanksAndCustomer(Bank bank1, Bank bank2, Customer customer);

    public List showAllBanks();

    public List showAllCustomers();

    public void addNewBanktoNewCustomer(Customer customer, Bank bank);

    public void addNewCustomerToExistingBank(int id, Customer customer);

    public void addExistingCustomerToExistingBank(String bankName, String customerName);

    public void removeBankByName(String bankName);

    public void removeCustomerByName(String customerName);

    public Bank findBankById(int id);

    public Customer findCustomerById(int id);

    public void updateBankName(String bankName, int id);

    public void updateCustomerName(String customerName, int id);

    public List showAllBanksFromCustomer(int id);

    public List showAllBankCustomers(int id);

    public List showAllCustomersWithoutBank();

    public List getCustomerAndTheirBank(int id);

    public void removeBankFromCustomer(int cID, int bID);

    public List removeBanksFromCustomer(int id);

    public List showAllBanksWithoutCustomer();

    public List showAllBanksAscOrd();

    public List showAllCustomersAscOrd();

}
