//        1)Запрос у пользователя ввести число
//        2)Запрос у пользователя ввести второе число
//        3)И уже на ваш выбор выполнять сложение, умножение или деление
//                1 - для суммы
//                2 - разности
//                3 - для умножения
//                4 - деления

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calcul(num1,num2,operation);
        System.out.println("Результат операции: "+result);

    }
    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию -,+,*,/:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции, попробуйте еще раз.");
            scanner.next();
            //рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static int calcul(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calcul(num1, num2, getOperation());
                //рекурсия
        }
        return result;
    }
}

