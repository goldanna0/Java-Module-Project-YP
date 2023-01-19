import java.util.Scanner;

public class Calculator {
    double totalPrice;
    private StringBuilder itemList = new StringBuilder();
    private int countOfItems;
    private int peopleCount;

    public Calculator(int count) {
        peopleCount = count;
    }

    // метод  добавляет один новый товар в расчет калькулятора
    private void addNewItem() {
        Item newitem = new Item();
        newitem.inputData();
        itemList.append("\n").append(newitem.name);
        totalPrice += newitem.price;
        countOfItems++;
        System.out.println("Товар " + newitem.name + " добавлен в перечень");
        //System.out.println("В калькуляторе "+countOfItems + " товаров");

    }

    // метод определяет, нужно ли продолжать добавленее товаров в калькулятор
    private boolean needToStop() {
        System.out.println("Хотите добавить еще один товар или завершить?");
        Scanner newScanner = new Scanner(System.in);
        String answer = newScanner.next();
        // для всех ответов кроме "завершить" в любом регистре вернет false, то есть ввод товаров завершен
        return answer.equalsIgnoreCase("Завершить");

    }

    public void addAllItems() {
        System.out.println("Заполняем перечень товаров");
        while (true) {
            addNewItem();
            if (needToStop()) {
                break;
            }
        }
    }

    // этот метод выводит всю информацию, использовавшуюся для расчета, и результаты расчета калькулятора
    public void printResults() {
        double pricePerPerson;
        String strRub;
        String template = "С каждого человека: %.2f ";
        System.out.println("Общая сумма товаров в расчете:" + totalPrice);
        System.out.println("Добавленные товары:" + itemList);
        pricePerPerson = totalPrice / peopleCount;
        strRub = formatRubString((int) Math.floor(pricePerPerson));
        template += strRub;
        System.out.println(String.format(template, pricePerPerson));
    }

    // форматирование "рубль" в нужный падеж для вывода результата
    // 1 рубль 2-4 рубля, 5-20 рублей, для чисел от 20 до 100 формат повторяет правило для остатка от деления данного числа на 10
    private String formatRubString(int price) {
        String priceStr;
        if (price > 100) price %= 100;
        if (price > 20) price %= 10;
        if (price == 1) {                         // 1 рубль
            priceStr = "рубль";
        } else if ((price > 1) && (price < 5)) { // 2,3,4 рубля
            priceStr = "рубля";
        } else {                                // 5-20 рублей
            priceStr = "рублей";
        }
        return priceStr;

    }

}
