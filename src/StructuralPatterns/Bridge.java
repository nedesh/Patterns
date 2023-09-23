package StructuralPatterns;
//Разделяет реализацию и абстракцию, дает возможность изменять их свободно друг от друга. Делает конкретные классы независимыми от классов реализации интерфейса.

public class Bridge {
    public static void main(String[] args) {
        Bank vtb = new VTB(new MortgageLoan());
        vtb.setLoan();
        System.out.println();
        Bank sber = new SBER(new CreditLoan());
        sber.setLoan();
    }
}

interface Loan {
    void setLoan();
}

abstract class Bank {
    protected Loan loan;

    public Bank(Loan loan) {
        this.loan = loan;
    }

    abstract public void setLoan();
}

class VTB extends Bank {
    public VTB(Loan loan) {
        super(loan);
    }

    public void setLoan() {
        System.out.print("VTB loan: ");
        loan.setLoan();
    }
}

class SBER extends Bank {
    public SBER(Loan loan) {
        super(loan);
    }

    public void setLoan() {
        System.out.print("SBER loan: ");
        loan.setLoan();
    }
}

class CreditLoan implements Loan {
    public void setLoan() {
        System.out.println("Credit");
    }
}

class MortgageLoan implements Loan {
    public void setLoan() {
        System.out.println("Mortgage");
    }
}
