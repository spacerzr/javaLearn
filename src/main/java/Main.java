import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] array = new String[]{"слово", "первое", "повтор", "второе", "Юля", "повтор", "еще повтор", "еще повтор", "четвертое", "пятое", "еще повтор", "третье", "Юля", "Юля", "Юля"};

        uniqueElements(array);
        calculateElementsCount(array);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "123123123");
        phonebook.add("Петров", "34523416462");
        phonebook.add("Сидоров", "24682452052");
        phonebook.add("Петров", "987987978987");

        String surName = "Петров";
        List<String> phoneNumbersBySurName = phonebook.get(surName);

        if(phoneNumbersBySurName != null) {
            System.out.println("По фамилии " + surName + " найдены номера: " + phoneNumbersBySurName);
        } else {
            System.out.println("По фамилии " + surName + " записей нет");
        }
    }

    /**
     * Первое задание. Ищет уникальные элементы
     * @param array массив данных
     */
    private static void uniqueElements(String[] array) {
        List<String> listFromArray = Arrays.asList(array);
        Set<String> uniqueElements = new HashSet<>(listFromArray);
        System.out.println("Уникальные элементы массива: " + uniqueElements);
    }

    /**
     * Подсчет количества повторений слов в массиве
     * @param array массив данных
     */
    private static void calculateElementsCount(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: array) {
            Integer count = map.get(word);
            if(count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }
        System.out.println("Количество повторов слов:");
        System.out.println(map);
    }
}
