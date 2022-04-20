package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NamedQueries(
        {
                @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
                @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id=:id"),
                @NamedQuery(name = "Bank.findByBankName", query = "SELECT b FROM Bank b WHERE b.bankName=:bankName"),
                @NamedQuery(name = "Bank.updateName", query = "UPDATE Bank SET bankName=:bankName WHERE id=:id"),

        }
)

@Entity
    public class Bank {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String bankName;

        @ManyToMany(cascade = CascadeType.PERSIST)
        List<Customer> customers = new ArrayList<>();

        public void addCustomer(Customer customer){
            customers.add(customer);

            customer.getBanks().add(this);
        }

        public void removeCustomer(Customer customer){
            customers.remove(customer);

            customer.getBanks().remove(this);

        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return getId() == bank.getId() && Objects.equals(getBankName(), bank.getBankName()) && Objects.equals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBankName(), customers);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public Bank(String bankName) {
            this.bankName = bankName;
        }

        public Bank() {
        }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}

