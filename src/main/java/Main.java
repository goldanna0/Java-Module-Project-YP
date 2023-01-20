
import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {

        int count = getPeopleCount(); //определили число гостей
        Calculator myCalc = new Calculator(count); //создали калькулятор
        myCalc.addAllItems(); //получили информацию о товарах и их ценах для расчета
        myCalc.printResults(); //вывели результаты расчета

    }

    // этот метод возвращает введенное пользователем число гостей, на которых нужно делить счет
    private static int getPeopleCount() {
        int peopleCount;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Укажите, на какое количество людей нужно будет поделить счет? (целое число>1)");
        while (true) { //повторяем, пока пользователь не введет корректное число гостей
            if (myScanner.hasNextInt()) { //проверка типа (ожидаем целое число)
                peopleCount = myScanner.nextInt();
                if (peopleCount > 1) { //если получили корректное число гостей, то пора переходить к калькулятору
                    break;
                } else if (peopleCount == 1) {
                    System.out.println("Нет смысла делить расходы на одного");
                } else if (peopleCount < 0) {
                    System.out.println("Введено отрицательное число");
                } else {
                    System.out.println("Введено некорректное число для подсчета");
                }
            } else { //проверка формата введенных пользователем данных завершилась неуспешно ( не является int)
                System.out.println("Неверный формат ввода"); // /дробное или вообще не число
                myScanner.next();
            }
            System.out.println("Укажите корректное количество гостей");
        }
        return peopleCount;
    }

}

