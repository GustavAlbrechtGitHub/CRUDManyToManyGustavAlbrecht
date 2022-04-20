package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "Customer.FindAll", query = "SELECT c FROM Customer c"),
                @NamedQuery(name = "Customer.customerFindById", query = "SELECT c FROM Customer c WHERE c.id=:id"),
                @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName=:customerName"),
                @NamedQuery(name = "Customer.customerFindByPhoneNumber", query = "SELECT c FROM Customer c WHERE c.phoneNumber=:phoneNumber"),
                @NamedQuery(name = "Customer.updateCustomerName", query = "UPDATE Customer SET customerName=:customerName WHERE id=:id"),
                @NamedQuery(name = "Customer.updatePhoneNumber", query = "UPDATE Customer SET phoneNumber=:phoneNumber WHERE id=:id")

        }
)

    @Entity
    public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    private String phoneNumber;

    @ManyToMany (mappedBy = "customers", cascade = CascadeType.PERSIST) // Om du sparar en customer så sparas också banken
    private List<Bank> banks = new ArrayList<>();                   // cascade med remove tar också bort banken

    public void addBank(Bank bank){
        banks.add(bank);
        bank.getCustomers().add(this);

    }

    public void removeBank(Bank bank){
        banks.remove(bank);
        bank.getCustomers().remove(this);

    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public Customer(String customerName, String phoneNumber) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
