package test;

public class BankAccount {
    private final String owner;
    private long balanceCents; // store money in cents to avoid floating point errors

    public BankAccount(String owner, long initialCents) {
        if (owner == null || owner.isBlank()) throw new IllegalArgumentException("owner required");
        if (initialCents < 0) throw new IllegalArgumentException("initial must be >= 0");
        this.owner = owner;
        this.balanceCents = initialCents;
    }

    public String owner() { return owner; }
    public long balanceCents() { return balanceCents; }

    /**
     * Deposit must be > 0
     */
    public void deposit(long cents) {
        if (cents <= 0) throw new IllegalArgumentException("deposit must be > 0");
        balanceCents += cents;
    }

    /**
     * Withdraw must be > 0 and cannot exceed balance
     */
    public void withdraw(long cents) {
        if (cents <= 0) throw new IllegalArgumentException("withdraw must be > 0");
        if (cents > balanceCents) throw new IllegalStateException("insufficient funds");
        balanceCents -= cents;
    }

    /**
     * Transfer amount > 0, cannot exceed balance, cannot transfer to self
     */
    public void transferTo(BankAccount target, long cents) {
        if (target == null) throw new IllegalArgumentException("target required");
        if (target == this) throw new IllegalArgumentException("cannot transfer to self");
        if (cents <= 0) throw new IllegalArgumentException("transfer must be > 0");
        if (cents > balanceCents) throw new IllegalStateException("insufficient funds");
        this.balanceCents -= cents;
        target.balanceCents += cents;
    }
}
