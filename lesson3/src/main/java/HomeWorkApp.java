import java.util.*;

public class HomeWorkApp {
    public static void main(String[] args) {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.
         */

        String[] strArr = {"табуретка", "стул", "кровать", "диван", "кровать", "кровать", "стол", "собака", "кот", "кот", "крот", "крот"
                , "стена", "человек", "нос", "вещь", "вещь", "сигара"};

        //Set<String> set = Set.of(strArr);

        List<String> list = List.of(strArr);

        // печать только уникальных слов
        for (String s : list) {
            int counter = 0;
            for (String sArr : strArr) {
                if (s.equals(sArr)) counter++;
            }
            if (counter == 1) System.out.println(s);

        }
        System.out.println("\n"+ "==================================================" + "\n");

        //считаем сколько раз встречается каждое слово
        // Используем сет чтобы не было дублиактов в ответе
        Set<String> set = new HashSet<>();

        for (String s : list) {
            int counter = 0;
            for (String sArr : strArr) {
                if (s.equals(sArr)) counter++;
            }
           set.add(s  +  " встречается " + counter + " раз(а)");
        }

        for (String s : set) {
            System.out.println(s);
        }


        /*
        справочник
         */

        PhoneDict myDict = new PhoneDict(new HashMap<String, String>());

        myDict.add("12345", "Ivanov");
        myDict.add("222222", "Ivanov");
        myDict.add("4444444", "Ivanov");
        myDict.add("88888888", "Petrov");
        myDict.add("99999999", "Petrov");
        myDict.add("123123123", "Sidorov");
        myDict.add("9857373839", "Kuznetsov");


        for (String s : myDict.get("Ivanov")) {
            System.out.println(s);
        }

        for (String s : myDict.get("ываыва")) {
            System.out.println(s);
        }

    }
}
