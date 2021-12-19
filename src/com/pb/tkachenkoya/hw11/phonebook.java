package com.pb.tkachenkoya.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


/*Создать в пакете hw11 консольное приложение "Телефонная книга". с применением лямбда функции и Stream API.
        Каждый элемент должен иметь:
        ФИО
        дата рождения
        телефоны (количество не ограничено)
        адрес
        дата и время редактирования

        Обеспечить следующий функционал:
        добавление элемента
        удаление элемента
        поиск элементов
        вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
        редактирование элемента
        запись в файл всех данных
        загрузка из файла всех данных*/

public class phonebook {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean finished = false;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Телефонный справочник");
            System.out.println("1 - Добавить запись   2 - Удалить   3 - Поиск ");
            System.out.println("4 - Вывод всех записей с сортировкой по ФИО");
            System.out.println("5 - Вывод всех записей с сортировкой по дате рождения");
            System.out.println("6 - Редактирование записи");
            System.out.println("0 - Выход");

            String choice = in.nextLine();

            switch (choice) {
                case "1":
                    Phonebooks.add();
                    break;
                case "2":
                    Phonebooks.del();
                    break;
                case "3":
                    Phonebooks.find();
                    break;
                case "4":
                    Phonebooks.printPhonSur();
                    break;
                case "5":
                    Phonebooks.printPhonNum();
                    break;
                case "6":
                    Phonebooks.change();
                    break;
                case "0":
                    System.out.println("Пока!");
                    finished = true;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
            if (finished) break;
        }


    }


    public static class Phonebooks {


        public static void add() throws IOException {
                       Scanner in = new Scanner(System.in);
            System.out.println("Введите фамилию");
            String tsurname = in.nextLine();
            System.out.println("Введите имя");
            String tname = in.nextLine();
            System.out.println("Введите отчество");
            String tpatronymic = in.nextLine();
            System.out.println("Введите дату рождения");
            String tbirthDate = in.nextLine();
            System.out.println("Введите номера телефонов, после окончания введите end");
            List tNumbers = new ArrayList<>();
            while (true) {
                String number = in.nextLine();
                if (number.equals("конец"))
                    break;
                else tNumbers.add(number);
            }
            System.out.println("Введите адрес");
            String taddress = in.next();
            LocalDate teditDate = LocalDate.now();
            Person person = new Person(tsurname, tname, tpatronymic, tbirthDate, tNumbers, taddress, teditDate);
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
             SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer() );
            mapper.registerModule(module);
            HashMap hm = new HashMap();
            hm.put(tsurname, person);

            ObjectInputStream din = new ObjectInputStream(new FileInputStream("phonebook.json"));
            boolean flag = true;
            while (flag) {
                try {
                    Person allPerson = (Person) din.readObject();
                    hm.put(allPerson.getSurname(), allPerson);
din.close();
                    Iterator iter = hm.entrySet().iterator();
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.json"));
                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        Person value = (Person) entry.getValue();

                        out.writeObject(value);
                    }
                    out.close();
                    System.out.println("Запись создана");

                } catch (Exception e) {
                    flag = false;
                }
                din.close();
            }
        }

        public static void del() throws IOException, ClassNotFoundException {
            HashMap hm = new HashMap();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.json"));
            ObjectInputStream din = new ObjectInputStream(new FileInputStream("phonebook.json"));
            Person allPerson = (Person) din.readObject();
            hm.put(allPerson.getSurname(), allPerson);
            System.out.println("Введите фамилию для удаления записи");
            Scanner in = new Scanner(System.in);
            String result = in.nextLine();
            if (hm.containsKey(result)) {
                System.out.println(hm.get(result).toString());
                System.out.println("Вы уверены, что хотите удалить: 1 (да), 0 (нет)?");
                int flag = in.nextInt();
                if (flag == 1) {
                    hm.remove(result);

                    Iterator iter = hm.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        Person value = (Person) entry.getValue();
                        out.writeObject(value);
                    }
                    out.close();
                    System.out.println("Запись удалена");
                } else {
                    System.out.println("Восстановить");
                }
            } else {
                System.out.println("Такая запись не существует");
            }

        }

        public static void change() throws IOException, ClassNotFoundException {
            HashMap hm = new HashMap();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.json"));
            ObjectInputStream din = new ObjectInputStream(new FileInputStream("phonebook.json"));
            Person allPerson = (Person) din.readObject();
            hm.put(allPerson.getSurname(), allPerson);
            Scanner in = new Scanner(System.in);
            System.out.println("Введите фамилию для изменения:");
            String surname = in.nextLine();
            if (hm.containsKey(surname)) {
                System.out.println(hm.get(surname).toString());
                hm.remove(surname);
                System.out.println("Введите данные заново");
                add();

            } else {
                System.out.println("Такая запись не существует");
            }
        }

        public static void printPhonSur() throws IOException, ClassNotFoundException {
            HashMap hm = new HashMap();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.json"));
            ObjectInputStream din = new ObjectInputStream(new FileInputStream("phonebook.json"));
            Person allPerson = (Person) din.readObject();
            hm.put(allPerson.getSurname(), allPerson);
            System.out.println("Телефонный справочник: ");
            List<String> sortEntry = new ArrayList<>(hm.keySet());
            Collections.sort(sortEntry);
            System.out.println("Сортировка по фамилии: " + sortEntry);
        }

        public static void printPhonNum() throws IOException, ClassNotFoundException {
            HashMap hm = new HashMap();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.json"));
            ObjectInputStream din = new ObjectInputStream(new FileInputStream("phonebook.json"));
            Person allPerson = (Person) din.readObject();
            hm.put(allPerson.getSurname(), allPerson);
            System.out.println("Телефонный справочник: ");
            List<String> list = new ArrayList<String>(hm.values());

            Collections.addAll(list);
            list.stream()
                    .sorted()
                    .forEach(s -> System.out.println(s));

        }

        public static void find() throws IOException, ClassNotFoundException {
            HashMap hm = new HashMap();
            File file = Paths.get("phonebook.json").toFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Person allPerson = (Person) ois.readObject();
            hm.put(allPerson.getSurname(), allPerson);
            System.out.println("Введите искомую фамилию");
            Scanner in = new Scanner(System.in);
            String result = in.nextLine();
            if (hm.containsKey(result)) {
                System.out.println(hm.get(result).toString());
            } else {
                System.out.println("Такая запись не существует");
            }

        }
    }
}



