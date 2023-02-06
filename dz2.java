// Пусть дан список сотрудников. Написать программу, которая найдет и выведет повторяющиеся имена 
// с количеством повторений. Отсортировать по убыванию популярности Имени.

import java.util.*;

public class dz2 {
    public static void main(String[] args) {

        // Создаем список сотрудников
        List<String> employees = new ArrayList<>();
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Мария Савина");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");

        // Список для хранения уникальных имен
        List<String> uniqueNames = new ArrayList<>();

        // Словарь для хранения пар "имя - количество повторений"
        Map<String, Integer> nameOccurrences = new HashMap<>();

        for (String employee : employees) {
            String[] names = employee.split(" ");
            String name = names[0];

            // Добавляем уникальные имена в список
            if (!uniqueNames.contains(name)) {
                uniqueNames.add(name);
            }

            // Подсчитываем количество повторений имени
            if (nameOccurrences.containsKey(name)) {
                int occurrences = nameOccurrences.get(name);
                occurrences++;
                nameOccurrences.put(name, occurrences);
            } else {
                nameOccurrences.put(name, 1);
            }
            
        }

        // Сортируем имена по убыванию популярности и выводим на экран
        Collections.sort(uniqueNames, (name1, name2) -> {
            if (nameOccurrences.get(name1) > nameOccurrences.get(name2)) {
                return -1;
            }
            return 1;
        });

        for (String name : uniqueNames) {
            System.out.println(name + ": " + nameOccurrences.get(name));
        }
    }
}