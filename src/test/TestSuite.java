package test;
import org.junit.jupiter.api.*;


public class TestSuite {
    private BankAccount bankAccount;
    private BankAccount bankAccount1;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount("Bob", 5000);
        bankAccount1 = new BankAccount("Billy", 2000);
    }

    @Test
    @Order(1)
    public void happyCase1() {
        bankAccount.deposit(5000);
        Assertions.assertEquals(bankAccount.balanceCents(), 10000);
    }

    @Test
    @Order(2)
    public void happyCase2() {
        bankAccount.withdraw(1000);
        Assertions.assertEquals(bankAccount.balanceCents(), 4000);
    }

    @Test
    @Order(3)
    public void happyCase3() {
        bankAccount.transferTo(bankAccount1, 1000);
        Assertions.assertEquals(bankAccount.balanceCents(), 4000);
        Assertions.assertEquals(bankAccount1.balanceCents(), 3000);
    }

    @Test
    @Order(4)
    public void boundaryCase1(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(0));


    }
}
