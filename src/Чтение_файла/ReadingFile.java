package Чтение_файла;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Написать программу которая на вход принимает путь до файлика формата data.csv и число максимального потребления
 * Программа должна в новый файлик рядом с входным вывести информацию о всех экологичных пользователях
 * Экологичным считается тот кто каждый природный ресурс потребляет меньше изначально заданного числа
 */
public class ReadingFile {
    public static void main(String[] args) {
        Path input = Paths.get("C:\\Users\\Admin\\Desktop\\data.csv");
        UserRead read = new UserCSVReader(input, "|");
        EcoCheck ecoFilter = new EcoUserCheck(500);
        EcoCheck electricCheck = new NoElectricityCheck();
        UserWriter writer = new UserCVSWriter(input);

        List<User> inputData = read.readAllUsers();
        List<User> ecoUser = ecoFilter.isEcoUser(inputData);
        List<User> noElectricity = electricCheck.isEcoUser(inputData);
        writer.write(ecoUser);

        System.out.println("Фильтрация завершена");
    }
}

