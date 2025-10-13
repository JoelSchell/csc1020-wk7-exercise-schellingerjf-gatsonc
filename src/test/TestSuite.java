package test;
import org.junit.jupiter.api.*;


public class TestSuite {
    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount("Bob", 5000);
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
}
