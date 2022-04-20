import entity.Bank;
import entity.Customer;

public class BankCustomerController {


    InputOutputDao io;

    BankCustomerDao dao;

    public BankCustomerController(BankCustomerDao dao, InputOutputDao io) {
        this.dao = dao;
        this.io = io;
    }

    public void addBankController(){

        Bank bank = io.readBank();

        dao.addBank(bank);

        io.printMessage("Bank has been added!");

    }

    public void addCustomerController(){

        Customer customer = io.readCustomer();

        dao.addCustomer(customer);

        io.printMessage("Customer has been added!");

    }

    public void addTwoBanksToOneCustomerController(){

        Bank bank1 = io.readBank();

        Bank bank2 = io.readBank();

        Customer customer = io.readCustomer();



        dao.addTwoBanksAndCustomer(bank1, bank2, customer);

        io.printMessage("Banks and Customer has been added!");

    }

    public void addNewBanktoNewCustomerController(){

        Bank bank = io.readBank();

        Customer customer = io.readCustomer();

        dao.addNewBanktoNewCustomer(customer, bank);

        io.printMessage("Bank and customer has been added!");
    }

    public void addNewCustomerToExistingBankController(){

        int id = io.returnBankId();

        Customer customer = io.readCustomer();

        dao.addNewCustomerToExistingBank(id, customer);

        io.printMessage("Customer has been added to the bank!");

    }

    public void addExistingCustomerToExistingBankController(){

        String bankName = io.returnBankName();

        String customerName = io.returnCustomerName();

        dao.addExistingCustomerToExistingBank(bankName, customerName);

        io.printMessage("Bank and customer has been joined!");

    }

    public void showAllBanksAndCustomersController(){

        io.printList(dao.showAllBanks());

        io.printList(dao.showAllCustomers());

    }

    public void removeBankController(){

        String bankName = io.returnBankName();

        dao.removeBankByName(bankName);

        io.printMessage("Bank has been removed!");

    }

    public void removeCustomerController(){

        String customerName = io.returnCustomerName();

        dao.removeCustomerByName(customerName);

        io.printMessage("Customer has been removed!");

    }

    public void findBankByIdController(){

        int id = io.returnBankId();

        io.printBank(dao.findBankById(id));

    }

    public void findCustomerByIdController(){

        int id = io.returnCustomerId();

        io.printCustomer(dao.findCustomerById(id));

    }

    public void updateBankNameController(){

        int id = io.returnBankId();

        String bankName = io.returnBankName();

        dao.updateBankName(bankName, id);

        io.printMessage("Bank has been updated!");

    }

    public void removeBankFromCustomerController(){

        int bID = io.returnBankId();

        int cID = io.returnCustomerId();


        dao.removeBankFromCustomer(cID, bID);

        io.printMessage("Bank have been removed from customer!");


    }

    public void updateCustomerNameController(){

        int id = io.returnCustomerId();

        String customerName = io.returnCustomerName();

        dao.updateCustomerName(customerName, id);

        io.printMessage("Customer has been updated!");

    }

    public void showAllBankCustomersController(){

        int id = io.returnBankId();

        io.printList(dao.showAllBankCustomers(id));

        io.ifCustomersAreNull(dao.showAllBankCustomers(id));

    }

    public void showAllCustomersWithoutBankController(){

        io.printList(dao.showAllCustomersWithoutBank());

    }

    public void showAllBanksWithoutCustomerController(){

        io.printList(dao.showAllBanksWithoutCustomer());
    }

    public void showAllBanksAscOrdController(){

        io.printList(dao.showAllBanksAscOrd());

    }

    public void showAllCustomersAscOrdController(){

        io.printList(dao.showAllCustomersAscOrd());

    }

    public void removeBanksFromCustomerController(){

        int id = io.returnCustomerId();

        dao.removeBanksFromCustomer(id);

        io.printMessage("Banks have been removed from customer!");

    }

    public void getCustomerAndTheirBankController(){

       int id = io.returnCustomerId();

        io.printList(dao.getCustomerAndTheirBank(id));

    }

  public void showAllBanksFromCustomerController(){

        int id = io.returnCustomerId();

      io.printList(dao.showAllBanksFromCustomer(id));

      io.ifBanksAreNull(dao.showAllBanksFromCustomer(id));



    }

    public void runProgram() {

        boolean loop = true;


        while (loop) {

            io.menu();

            String choice = io.getStringInput();


            switch (choice) {

                case "1" -> addBankController();
                case "2" -> addCustomerController();
                case "3" -> addTwoBanksToOneCustomerController();
                case "4" -> showAllBanksAndCustomersController();
                case "5" -> addNewBanktoNewCustomerController();
                case "6" -> addNewCustomerToExistingBankController();
                case "7" -> addExistingCustomerToExistingBankController();
                case "8" -> removeCustomerController();
                case "9" -> removeBankController();
                case "10" -> findCustomerByIdController();
                case "11" -> findBankByIdController();
                case "12" -> updateBankNameController();
                case "13" -> updateCustomerNameController();
                case "14"-> removeBankFromCustomerController();
                case "15" -> removeBanksFromCustomerController();
                case "16" -> getCustomerAndTheirBankController();
                case "17" -> showAllBanksFromCustomerController();
                case "18" -> showAllBankCustomersController();
                case "19" -> showAllCustomersWithoutBankController();
                case "20" -> showAllBanksWithoutCustomerController();
                case "21" -> showAllBanksAscOrdController();
                case "22" -> showAllCustomersAscOrdController();
                case "0" ->  loop = false;
                default -> System.out.println("Wrong input, please choose 1-9");
            }
        }


    }

}
