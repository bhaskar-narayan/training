/**
 * As described task is:
 * 
 * You have to create a program for ATM Which would have certain defined
 * denominations of notes : 100 ,200, 500, and 2000 INR.
 * 
 * Now you have to design your ATM in such a way that at any time ATM can be
 * top-up with any required domination like I can add 41000 as (2000 x 20) +
 * (500 x 2) notes
 * 
 * Your ATM should have a function to withdraw cash , input can be any amount:
 * 
 * Use cases for withdraw as below:
 * 
 * 1: if amount is not present show error insufficient balance
 * 
 * 2: if amount is not in the factor of available denominations show error to
 * ask for multiple of available denomination
 * 
 * 3: first largest denomination should be used than smaller : like if I opt for
 * 2300 rs, amount dispatched should be (2000 x 1 ) + (200 x 1) + (100 x 1)
 * 
 * 3.b: if any denomination is not there like suppose you don’t have 2000 notes
 * left in ATM , then, amount dispatched should be (500 x 4) + (200 x 1) + (100
 * x 1)
 * 
 * Next step: it can be done by Modi Ji, that older denomination is not valid in
 * case of demonetization, like 2000 Notes are banned and new 5000 notes are
 * legal , so you code should be like you don’t need to change much of it,
 * 
 * Try to achieve OOPS , and SOLID principles as much as you can,
 * 
 * Also, we will add new use cases to see whether your system can adapt to those
 * changes. If Not, then your design is bad. (SOLID,TRY,YAGNI,KISS)
 */

interface BankWithdrawl {
    void debit(int amount);
}
interface BankDeposit {
    void credit(int amount);
}
interface TwoThousand {
    void addTwoThousand(int numberOfNote);
}
interface FiveHundred {
    void addFiveHundred(int numberOfNote);
}
interface TwoHundred {
    void addTwoHundred(int numberOfNote);
}
interface OneHundred {
    void addOneHundred(int numberOfNote);
}



interface AlterTwoThousand {
    void changeTwoThousand(int newValue);
}
interface AlterFiveHundred {
    void changeFiveHundred(int newValue);
}
interface AlterTwoHundred {
    void changeTwoHundred(int newValue);
}
interface AlterOneHundred {
    void changeOneHundred(int newValue);
}


 class NoteValueAndCount {
    static int oneHundred = 100;
    static int twoHundred = 200;
    static int fiveHundred = 500;
    static int twoThousand = 2000;

    static int oneHundredCount;
    static int twoHundredCount;
    static int fiveHundredCount;
    static int twoThousandCount;

    static String oneHundredName = "100";
    static String twoHundredName = "200";
    static String fiveHundredName = "500";
    static String twoThousandName = "2000";
}

class WithdrawATM {
    int amount;
    int numberOfTwoThousand = 0, numberOfFiveHundred = 0, numberOfTwoHundred = 0, numberOfOneHundred = 0;
    int availableCash = NoteValueAndCount.oneHundred * NoteValueAndCount.oneHundredCount +
            NoteValueAndCount.twoHundred * NoteValueAndCount.twoHundredCount +
            NoteValueAndCount.fiveHundred * NoteValueAndCount.fiveHundredCount +
            NoteValueAndCount.twoThousand * NoteValueAndCount.twoThousandCount;
    void withdraw(int amount) {
        this.amount = amount;
        if (amount > availableCash) {
            System.out.println("Insufficient balance at ATM");
            return;
        }
        numberOfTwoThousand = amount / NoteValueAndCount.twoThousand;
        if (amount / NoteValueAndCount.twoThousand != 0 && NoteValueAndCount.twoThousandCount >= numberOfTwoThousand) {
            amount = amount % NoteValueAndCount.twoThousand;
        }
        numberOfFiveHundred = amount / NoteValueAndCount.fiveHundred;
        if (amount / NoteValueAndCount.fiveHundred != 0 && NoteValueAndCount.fiveHundredCount >= numberOfFiveHundred) {
            amount = amount % NoteValueAndCount.fiveHundred;
        }
        numberOfTwoHundred = amount / NoteValueAndCount.twoHundred;
        if (amount / NoteValueAndCount.twoHundred != 0 && NoteValueAndCount.twoHundredCount >= numberOfTwoHundred) {
            amount = amount % NoteValueAndCount.twoHundred;
        }
        numberOfOneHundred = amount / NoteValueAndCount.oneHundred;
        if (amount / NoteValueAndCount.oneHundred != 0 && NoteValueAndCount.oneHundredCount >= numberOfOneHundred) {
            amount = amount % NoteValueAndCount.oneHundred;
        }
        if (amount != 0) {
            System.out.println("Enter amount which is multiple of 2000, 500, 200, 100");
            return;
        }
        if (numberOfTwoThousand != 0) 
            System.out.println(NoteValueAndCount.twoThousandName + "/-: " + numberOfTwoThousand);
        if (numberOfFiveHundred != 0) 
            System.out.println(NoteValueAndCount.fiveHundredName + "/-: " + numberOfFiveHundred);
        if (numberOfTwoHundred != 0) 
            System.out.println(NoteValueAndCount.twoHundredName + "/-: " + numberOfTwoHundred);
        if (numberOfOneHundred != 0) 
            System.out.println(NoteValueAndCount.oneHundredName + "/-: " + numberOfOneHundred);
    }
}


class Bank implements BankWithdrawl, BankDeposit{
    String bankName = "SBI", bankIFSC = "SBIN00000567";
    int accountNumber, balance;
    Bank(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    void setAmount(int balance) {
        this.balance = balance;
    }
    @Override
    public void debit(int amount) {
        this.balance -= amount;
    }
    @Override
    public void credit(int amount) {
        this.balance += amount;
    }
}

class BalanceCheck {
    private Bank user;
    private int amount;
    BalanceCheck(Bank user, int amount) {
        this.amount = amount;
        this.user = user;
    }
    void verify() {
        if (user.balance < amount) {
            System.out.println("Insufficiant balance on your bank account");
            return;
        }
        WithdrawATM withdrawATM = new WithdrawATM();
        user.balance -= amount;
        withdrawATM.withdraw(amount);
    }
}

class ATM {
    private Bank user;
    private int amount;

    void punchCard(int amount, Bank user) {
        this.user = user;
        this.amount = amount;
    }
    void withdrawCash() {
        BalanceCheck balanceCheck = new BalanceCheck(user, amount);
        balanceCheck.verify();
    }
}

class DepositATM implements TwoThousand, FiveHundred, TwoHundred, OneHundred {

    @Override
    public void addTwoThousand(int numberOfNote) {
        NoteValueAndCount.twoThousandCount += numberOfNote;
    }

    @Override
    public void addFiveHundred(int numberOfNote) {
        NoteValueAndCount.fiveHundredCount += numberOfNote;
    }

    @Override
    public void addTwoHundred(int numberOfNote) {
        NoteValueAndCount.twoHundredCount += numberOfNote;
    }

    @Override
    public void addOneHundred(int numberOfNote) {
        NoteValueAndCount.oneHundredCount += numberOfNote;
    }
}

class ModiJi implements AlterTwoThousand, AlterFiveHundred, AlterTwoHundred, AlterOneHundred{

    @Override
    public void changeOneHundred(int newValue) {
        NoteValueAndCount.oneHundred = newValue;  
    }

    @Override
    public void changeTwoHundred(int newValue) {
        NoteValueAndCount.twoHundred = newValue;
    }

    @Override
    public void changeFiveHundred(int newValue) {
        NoteValueAndCount.fiveHundred = newValue;
    }

    @Override
    public void changeTwoThousand(int newValue) {
        NoteValueAndCount.twoThousand = newValue;
    }

}

public class Main2 {
    public static void main(String[] args) {
        Bank user = new Bank(123458);
        user.setAmount(6000);

        DepositATM depositATM = new DepositATM(); 
        depositATM.addTwoThousand(2);
        depositATM.addFiveHundred(3);
        depositATM.addTwoHundred(5);
        depositATM.addOneHundred(1);

        ATM atm = new ATM();
        atm.punchCard(5000, user);
        atm.withdrawCash();

        System.out.println("\n\nAvailable Balance: " + user.balance);
    }
}
