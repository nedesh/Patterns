package CreationalPatterns;
//Позволяет выбрать конкретную реализацию фабрики из семейства возможных фабрик. Создает семейство связанных объектов. Легко расширять.

public class AbstractFactory {
    public static void main(String[] args) {
        String LoanType = "Credit";
        AbsFactory ifactory = null;
        if (LoanType.equals("Credit")) {
            ifactory = new CreditPercentAbsFactory();
        } else if (LoanType.equals("Mortgage")) {
            ifactory = new MortgagePercentAbsFactory();
        }

        AlphaBank lada = ifactory.getAlphaBank();
        System.out.println(lada.getAlphaBankPercent());
    }
}

interface AlphaBank {
    long getAlphaBankPercent();
}

interface SberBank {
    long getSberBankPercent();
}

interface TinkoffBank {
    long getTinkoffBankPercent();
}

interface AbsFactory {
    AlphaBank getAlphaBank();

    SberBank getSberBank();

    TinkoffBank getTinkoffBank();
}

class CreditAlphaBankImpl implements AlphaBank {

    @Override
    public long getAlphaBankPercent() {
        return 15;
    }
}

class CreditSberBankImpl implements SberBank {

    @Override
    public long getSberBankPercent() {
        return 13;
    }
}

class CreditTinkoffBankImpl implements TinkoffBank {

    @Override
    public long getTinkoffBankPercent() {
        return 10;
    }
}

class MortgageAlphaBankImpl implements AlphaBank {

    @Override
    public long getAlphaBankPercent() {
        return 8;
    }
}

class MortgageSberBankImpl implements SberBank {

    @Override
    public long getSberBankPercent() {
        return 9;
    }
}

class MortgageTinkoffBankImpl implements TinkoffBank {

    @Override
    public long getTinkoffBankPercent() {
        return 7;
    }
}

class CreditPercentAbsFactory implements AbsFactory {

    @Override
    public AlphaBank getAlphaBank() {
        return new CreditAlphaBankImpl();
    }

    @Override
    public SberBank getSberBank() {
        return new CreditSberBankImpl();
    }

    @Override
    public TinkoffBank getTinkoffBank() {
        return new CreditTinkoffBankImpl();
    }
}

class MortgagePercentAbsFactory implements AbsFactory {

    @Override
    public AlphaBank getAlphaBank() {
        return new MortgageAlphaBankImpl();
    }

    @Override
    public SberBank getSberBank() {
        return new MortgageSberBankImpl();
    }

    @Override
    public TinkoffBank getTinkoffBank() {
        return new MortgageTinkoffBankImpl();
    }
}

