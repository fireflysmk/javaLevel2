import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDict {

    /*
    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи.
    С помощью метода get() искать номер телефона по фамилии.
    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны.
     */

    private Map<String, String> phoneDict;

    public PhoneDict(Map<String, String> phoneDict) {
        this.phoneDict = phoneDict;
    }

    public void add(String phoneNum, String surName) {
        this.phoneDict.put(phoneNum, surName);
    }

    public List<String> get(String surName) {

        List<String> phoneList = new ArrayList<String>();

        for (Map.Entry<String, String> entry : phoneDict.entrySet()) {
            if (surName.equals(entry.getValue())) {
                phoneList.add(entry.getKey());
            }
        }

        if (phoneList.size() == 0) System.out.println("There is no " + surName  + " in phoneBook, try another");

        return phoneList;
    }


}
