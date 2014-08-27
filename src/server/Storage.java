package server;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by as2 on 28.08.2014.
 */
public class Storage {
    //сначала идет стандартная реализация паттерна singleton (одиночка)

    private static Storage instance = new Storage();

    private Storage(){      //приватный конструктор нужен для того чтобы нельзя было создать объект
    }

    public static Storage getInstance(){
        fillUserInfo(); //заполняем массив

        return instance;
    }

    public static ConcurrentHashMap<User, UserConnect> userAndCon = new ConcurrentHashMap<User, UserConnect>();
    // Concurrent - безопасный для использования нескольких потоков

    private static void fillUserInfo(){
        //по идее тут должно быть считывание с файла, но пока путь будет так
        userAndCon.put(new User("IlyaOzy"),null); //у неподключенных пользователей второе значение будет null
        userAndCon.put(new User("BartZlo"),null); //у неподключенных пользователей второе значение будет null
        userAndCon.put(new User("Evgenia"),null); //у неподключенных пользователей второе значение будет null
        userAndCon.put(new User("Admin"),null); //у неподключенных пользователей второе значение будет null

        //у неавторизованных пользователей имя будет "Гость345"  - я так предлагаю. Без имени использовать HashMap не выйдет
    }
}
