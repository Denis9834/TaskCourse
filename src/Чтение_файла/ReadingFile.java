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
        UserCSVReader reader = new UserCSVReader(input, "\\|");
        UserCVSWriter writer = new UserCVSWriter(input);

        EcoCheck ecoFilter = new EcoUserCheck(500);
        EcoCheck electricCheck = new NoElectricityCheck();

        List<User> inputData = reader.readAllUsers(writer);
        List<User> ecoUser = ecoFilter.isEcoUser(inputData);
        List<User> noElectricity = electricCheck.isEcoUser(inputData);
        writer.writeHeader(reader.getHeader());
        writer.write(noElectricity);

        System.out.println("Фильтрация завершена");
    }
}

