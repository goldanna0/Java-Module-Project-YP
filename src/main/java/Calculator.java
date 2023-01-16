import java.util.Scanner;

public class Calculator {
    double total_price;
    String item_list="";
    int countOfItems;
    int peopleCount;

    public Calculator(int count) {
        peopleCount = count;
    }

    // метод  добавляет один новый товар в расчет калькулятора
    public void AddNewItem () {
        Item newitem = new Item();
        newitem.InputData();
        item_list+="\n"+ newitem.name;
        total_price+=newitem.price;
        countOfItems++;
        System.out.println("Товар "+newitem.name + " добавлен в перечень");
        //System.out.println("В калькуляторе "+countOfItems + " товаров");

    }
    // метод определяет, нужно ли продолжать добавленее товаров в калькулятор
    public boolean NeedToStop () {
        //return countOfItems>=2;
        System.out.println("Хотите добавить еще один товар или завершить?");
        Scanner newScanner = new Scanner(System.in);
        String answer = newScanner.next();
        // для всех ответов кроме "завершить" в любом регистре вернет false, то есть ввод товаров завершен
        return answer.equalsIgnoreCase("Завершить");

    }
    public void AddAllItems () {
        System.out.println("Заполняем перечень товаров");
        while (true) {
            AddNewItem();
            if (NeedToStop()) {
                break;
            }
        }
    }
    // этот метод выводит всю информацию, использовавшуюся для расчета, и результаты расчета калькулятора
    public void PrintResults () {
        double pricePerPerson;
        String strRub;
        String template = "С каждого человека: %.2f ";
        System.out.println("Общая сумма товаров в расчете:" + total_price);
        System.out.println("Добавленные товары:" + item_list);
        pricePerPerson = total_price / peopleCount;
        strRub = formatRubString((int)Math.floor(pricePerPerson));
        template+=strRub;
        System.out.println(String.format(template,pricePerPerson));
    }

    // форматирование "рубль" в нужный падеж для вывода результата
    // 1 рубль 2-4 рубля, 5-20 рублей, для чисел от 20 до 100 формат повторяет правило для остатка от деления данного числа на 10
    public String formatRubString (int price) {
        String priceStr;
        if (price >100) price %= 100;
        if (price >20) price %= 10;
        if (price==1) {                         // 1 рубль
            priceStr = "рубль";
        } else if ((price >1) && (price <5)) { // 2,3,4 рубля
            priceStr = "рубля";
        } else {                                // 5-20 рублей
            priceStr = "рублей";
        }
        return priceStr;

    }

}
