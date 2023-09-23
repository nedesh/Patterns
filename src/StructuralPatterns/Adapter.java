package StructuralPatterns;
//Используя паттерн, мы можем объединить два несовместимых объекта. Конвертер между двумя несовместимыми объектами.

public class Adapter {
    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}

interface USB {

    void connectWithUsbCable();
}

class MemoryCard {

    public void insert() {
        System.out.println("Карта памяти успешно вставлена!");
    }
}

class CardReader implements USB {

    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
    }
}