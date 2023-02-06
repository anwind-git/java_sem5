// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
// что 1 человек может иметь несколько телефонов.

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class dz1
{
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
            while (true)
            {
                System.out.printf("Добавить контакт(1), Поиск контакта(2), Выйти(3): ");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1)
                {
                    System.out.printf("Введите фамилию: ");
                    String name = sc.nextLine();
                    System.out.printf("Введите контактный номер: ");
                    String number = sc.nextLine();
                    if (phoneBook.get(name) == null)
                    {
                        ArrayList<String> numbers = new ArrayList<>();
                        numbers.add(number);
                        phoneBook.put(name, numbers);
                    }
                    else
                    {
                        ArrayList<String> numbers = phoneBook.get(name);
                        numbers.add(number);
                        phoneBook.put(name, numbers);
                    }
                }
                else if (choice == 2)
                {
                    System.out.printf("Введите фамилию: ");
                    String name = sc.nextLine();
                    if (phoneBook.get(name) == null)
                    {
                        System.out.println("Нет контактов с такой фамилией");
                    }
                    else
                    {
                        System.out.println("Контактный(е) номер(а) телефона:");
                        ArrayList<String> numbers = phoneBook.get(name);
                        for (String number : numbers)
                        {
                            System.out.println(number);
                        }
                    }
                }
                else if (choice == 3)
                {
                    return;
                }
            }
        }
    }
}