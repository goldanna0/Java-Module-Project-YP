import java.util.Scanner;

public class Item {
    String name;
    double price;

    public void inputData() { //Информацию о новом товаре вводит пользователь

        Scanner newScanner = new Scanner(System.in);
        System.out.println("Укажите название товара:");
        name = newScanner.next();

        while (true) { //повторяем, пока пользователь не введет данные в нужном формате
            System.out.println("Укажите цену товара:");
            if (newScanner.hasNextDouble()) { //проверка типа (ожидаем  double)
                price = newScanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Цена товара должна быть строго больше 0!");
                } else break;
            } else { //проверка формата введенных пользователем данных завершилась неуспешно
                System.out.println("Неверный формат ввода");
                newScanner.next();
            }
        }

    }
}
