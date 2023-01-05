import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        int peopleCount = getPeopleCount();
        System.out.println("Делим счет на "+ peopleCount + " гостей");
    }
    // эта функция возвращает введенное пользователем число гостей, на которых нужно делить счет
    public static int getPeopleCount() {
        int myCount;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Укажите, на какое количество людей нужно будет поделить счет? (>1)");
        while (true) { //повторяем, пока пользователь не введет корректное число гостей
            myCount = myScanner.nextInt();
            if (myCount >1) { //если получили корректное число гостей, то пора переходить к калькулятору
                break;
            }
            else if (myCount==1) {
                System.out.println("Нет смысла делить расходы на одного");
            } else {
                System.out.println("Введено некорректное число для подсчета");
            }
            System.out.println("Укажите корректное количество гостей");
        }
        return myCount;
    }
}
