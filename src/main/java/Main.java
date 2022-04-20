public class Main {


    public static void main(String[] args) {

        InputOutputDao io = new InputOutput();

        BankCustomerDao dao = new BankCustomerDaoJPAImpl();

        BankCustomerController bCController = new BankCustomerController(dao, io);

        bCController.runProgram();




    }
}
