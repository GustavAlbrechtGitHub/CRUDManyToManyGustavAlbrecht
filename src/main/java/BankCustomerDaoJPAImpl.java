import entity.Bank;
import entity.Customer;

import javax.persistence.*;
import java.util.List;



public class BankCustomerDaoJPAImpl implements BankCustomerDao{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public void addBank(Bank bank){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(bank);
        em.getTransaction().commit();
        em.close();


    }

    public void addCustomer(Customer customer){
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(customer);


        em.getTransaction().commit();
        em.close();


    }

    public void addTwoBanksAndCustomer(Bank bank1, Bank bank2, Customer customer){
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(customer);

        customer.addBank(bank1);

        customer.addBank(bank2);

        em.getTransaction().commit();
        em.close();


    }

    public List showAllBanks(){

        EntityManager em = emf.createEntityManager();


        List<Bank> bankList = em.createNamedQuery("Bank.findAll", Bank.class).getResultList();


        em.close();

        return bankList;

    }

    public List showAllCustomers(){

        EntityManager em = emf.createEntityManager();

        List<Customer> customerList = em.createNamedQuery("Customer.FindAll", Customer.class).getResultList();

        em.close();

        return customerList;


    }


    public void addNewBanktoNewCustomer(Customer customer, Bank bank){

        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(customer);

        customer.addBank(bank);

        em.getTransaction().commit();

        em.close();


    }

    public void addNewCustomerToExistingBank(int id, Customer customer){

        EntityManager em = emf.createEntityManager();


       /* Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName).getSingleResult();*/

        Bank bank = em.find(Bank.class, id);

        bank.addCustomer(customer);


        em.getTransaction().begin();

        em.persist(bank);

        em.getTransaction().commit();

        em.close();

    }

    public void addExistingCustomerToExistingBank(String bankName, String customerName){

        //show all banks and customers

        EntityManager em = emf.createEntityManager();

        Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName).getSingleResult();

        Customer customer = em.createNamedQuery("Customer.findByCustomerName", Customer.class)
                .setParameter("customerName", customerName).getSingleResult();


        em.getTransaction().begin();

        bank.addCustomer(customer);

        em.getTransaction().commit();

        em.close();

    }

    public void removeBankByName(String bankName){

        EntityManager em = emf.createEntityManager();

        Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName)
                .getSingleResult();


        em.getTransaction().begin();


        em.remove(bank);

        em.getTransaction().commit();

        em.close();




    }

    public void removeCustomerByName(String customerName){

        EntityManager em = emf.createEntityManager();

        Customer customer = em.createNamedQuery("Customer.findByCustomerName", Customer.class)
                .setParameter("customerName", customerName)
                .getSingleResult();

        em.getTransaction().begin();


        em.remove(customer);

        em.getTransaction().commit();

        em.close();


    }

    public Bank findBankById(int id){
        EntityManager em = emf.createEntityManager();


      /*  List<Bank> bankList = em.createNamedQuery("Bank.findById", Bank.class)
                .setParameter("id", id)
                .getResultList();*/

       Bank bank = em.find(Bank.class, id);


        em.close();

        return bank;


    }



    public Customer findCustomerById(int id){
        EntityManager em = emf.createEntityManager();


       /* List<Customer> customerList = em.createNamedQuery("Customer.customerFindById", Customer.class)
                .setParameter("id", id)
                .getResultList();*/

        Customer customer = em.find(Customer.class, id);

        em.close();

        return customer;

    }

    public void updateBankName(String bankName, int id){
        EntityManager em = emf.createEntityManager();


        Bank bank = em.find(Bank.class, id);

        em.getTransaction().begin();

        bank.setBankName(bankName);

        em.getTransaction().commit();
        em.close();

    }

    public void updateCustomerName(String customerName, int id){
        EntityManager em = emf.createEntityManager();


        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();

        customer.setCustomerName(customerName);

        em.getTransaction().commit();
        em.close();

    }

    public List showAllBanksFromCustomer(int id){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, id);

        em.getTransaction().commit();

        em.close();

        return customer.getBanks();

    }

    public List showAllBankCustomers(int id){

        EntityManager em = emf.createEntityManager();

       /* List list = em.createQuery("SELECT c FROM Customer c WHERE c.bank.bankName=:bankName", Customer.class)
                .setParameter("bankName", bankName)
                .getResultList();*/

        em.getTransaction().begin();

        Bank bank = em.find(Bank.class, id);


        em.getTransaction().commit();

        em.close();

        return bank.getCustomers();

    }

    public List showAllCustomersWithoutBank(){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List list = em.createQuery("SELECT c FROM Customer c WHERE c.banks is empty", Customer.class)
                .getResultList();

        em.getTransaction().commit();

        em.close();

        return list;

    }

    public List getCustomerAndTheirBank(int id){

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, id);

        List<Bank> bankList = customer.getBanks();

        em.close();

        return bankList;


    }

    public void removeBankFromCustomer(int cID, int bID){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, cID);

        Bank bank = em.find(Bank.class, bID);

        customer.removeBank(bank);

        em.getTransaction().commit();

        em.close();

    }

    public List removeBanksFromCustomer(int id){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, id);

        for (Bank b : customer.getBanks()){

            b.getCustomers().remove(customer);
        }

        customer.getBanks().clear();

        em.getTransaction().commit();

        em.close();

        return customer.getBanks();

    }

    public List showAllBanksWithoutCustomer(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        List list = em.createQuery("SELECT b FROM Bank b WHERE b.customers is empty", Bank.class)
                .getResultList();

        em.getTransaction().commit();

        em.close();

        return list;

    }

    public List showAllBanksAscOrd(){
        EntityManager em = emf.createEntityManager();

        List<Bank> bankList = em.createQuery("SELECT b FROM Bank b ORDER BY b.bankName ASC", Bank.class)
                .getResultList();


        return bankList;

    }

    public List showAllCustomersAscOrd(){

        EntityManager em = emf.createEntityManager();

        List<Customer> customerList = em.createQuery("SELECT c FROM Customer c ORDER BY c.customerName ASC", Customer.class)
                .getResultList();


        return customerList;

    }

}
