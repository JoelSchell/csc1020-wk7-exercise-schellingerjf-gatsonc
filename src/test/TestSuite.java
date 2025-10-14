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
    public void boundaryCase1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(0));
    }

    @Test
    @Order(5)
    public void boundaryCase2() {

    }

    @Test
    @Order(9)
    public void invalidCase1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BankAccount("", 5000));
    }

    @Test
    @Order(10)
    public void invalidCase2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BankAccount("Bob", -1000));
    }

    @Test
    @Order(11)
    public void invalidCase3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.transferTo(bankAccount1, -1000));
    }

    @Test
    @Order(12)
    public void invalidCase4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.transferTo(null, 100));
    }

    @Test
    @Order(13)
    public void invalidCase5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100));
    }

    @Test
    @Order(14)
    public void invalidCase6() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-100));
    }

    @Test
    @Order(15)
    public void invalidCase7() {
        Assertions.assertThrows(IllegalStateException.class, () -> bankAccount.transferTo(bankAccount1, 10000));
    }
}
