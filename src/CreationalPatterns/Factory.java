package CreationalPatterns;
//Используется, когда у нас есть суперкласс с несколькими подклассами и на основе ввода, нам нужно вернуть один из подкласса.
//Класс не знает какого типа объект он должен создать. Объекты создаются в зависимости от входящих данных.

public class Factory {
    public static void main(String[] args) {
        String alpha = "alpha";
        String sber = "sber";

        CreditFactory factory = new CreditFactory();

        Credit credit = factory.getCurrentCredit(alpha);
        credit.getCredit();
        System.out.println(credit.getCreditPercent());

        Credit credit1 = factory.getCurrentCredit(sber);
        credit1.getCredit();
        System.out.println(credit1.getCreditPercent());
    }
}

class CreditFactory {
    public Credit getCurrentCredit(String input) {
        Credit credit = null;
        if (input.equals("alpha")) {
            credit = new Alpha();
        } else if (input.equals("sber")) {
            credit = new Sber();
        } else if (input.equals("tinkoff")) {
            credit = new Tinkoff();
        }
        return credit;
    }
}

interface Credit {
    void getCredit();

    int getCreditPercent();
}

class Alpha implements Credit {

    @Override
    public void getCredit() {
        System.out.println("кредит в альфе");
    }

    @Override
    public int getCreditPercent() {
        return 22;
    }
}

class Sber implements Credit {

    @Override
    public void getCredit() {
        System.out.println("кредит в сбере");
    }

    @Override
    public int getCreditPercent() {
        return 55;
    }
}

class Tinkoff implements Credit {

    @Override
    public void getCredit() {
        System.out.println("кредит в тиньке");
    }

    @Override
    public int getCreditPercent() {
        return 33;
    }
}