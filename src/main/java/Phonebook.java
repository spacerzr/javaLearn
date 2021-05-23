import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Телефонный справочник
 */
public class Phonebook {
    private final Map<String, List<String>> map = new HashMap<>();

    /**
     * Метод добавления сотрудника в справочник. Если такой фамилии еще нет, то добавляется новый.
     * Если фамилия уже есть, то номер телефона добавляется в список номеров этой фамилии
     * @param surName фамилия
     * @param phoneNumber телефонный номер
     */
    public void add(String surName, String phoneNumber) {
        List<String> existedPhoneNumbers = map.get(surName);
        if(existedPhoneNumbers == null) {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            map.put(surName, phoneNumbers);
        } else {
            existedPhoneNumbers.add(phoneNumber);
        }
    }

    /**
     * Метод получения списка телефонных номеров по фамилии
     * @param surName фамилия
     * @return список телефонных номеров по фамилии. Null если такой фамилии в справочнике нет.
     */
    public List<String> get(String surName) {
        return map.get(surName);
    }
}
