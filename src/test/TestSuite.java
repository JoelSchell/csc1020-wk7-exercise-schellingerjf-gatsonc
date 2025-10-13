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

    }
}
