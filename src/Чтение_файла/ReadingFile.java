package Чтение_файла;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Написать программу которая на вход принимает путь до файлика формата data.csv и число максимального потребления
 * Программа должна в новый файлик рядом с входным вывести информацию о всех экологичных пользователях
 * Экологичным считается тот кто каждый природный ресурс потребляет меньше изначально заданного числа
 */
public class ReadingFile {
    public static void main(String[] args) {
        Path input = Paths.get("C:\\Users\\Admin\\Desktop\\data.csv");
        filterEcoUsers(input, 500);
    }

    private static void writerFile(BufferedWriter bufWr, String data) throws IOException {
        bufWr.write(data);
        bufWr.newLine();
    }

    private static Path createOutputFile(Path input) {
        String newFile = "eco_users.csv";
        return input.getParent().resolve(newFile);
    }

    private static void filterEcoUsers(Path input, double maxСonsumption) {
        Path output = createOutputFile(input);
        EcoUserCheck check = new EcoUserCheck();
        try (BufferedReader bufReader = Files.newBufferedReader(input);
             BufferedWriter bufWriter = Files.newBufferedWriter(output)) {

            String header = bufReader.readLine();
            if (header != null) {
                writerFile(bufWriter, header); //оставляем заголовок
            }
            String line;
            UserCSVReader userCSVReader = new UserCSVReader("|");
            while ((line = bufReader.readLine()) != null) {
//                String[] arr = line.split("\\|");
                User user = userCSVReader.readNewUser(line);

                if (check.isEcoUser(user, maxСonsumption)) {
                    writerFile(bufWriter, line);
                }
//                int[] consumption = new int[arr.length - 1];
//                consumption[0] = Integer.parseInt(arr[2]);
//                consumption[1] = Integer.parseInt(arr[3]);
//                consumption[2] = Integer.parseInt(arr[4]);
//                consumption[3] = Integer.parseInt(arr[5]);
//                consumption[4] = Integer.parseInt(arr[6]);
//
//                for (int i = 2; i < arr.length - 2; i++) {
//                    consumption[i - 2] = Integer.parseInt(arr[i]);
//                }
//
//                boolean isEcoUser = true;
//                for (int array : consumption) {
//                    if (array >= maxСonsumption) {
//                        isEcoUser = false;
//                        break;
//                    }
//                }
//                if (isEcoUser) {
//                    writerFile(bufWriter, line);
//                }
            }
            System.out.printf("Фильтрация завершена. Файл %s обновлен.", output.getFileName());
        } catch (IOException e) {
            System.out.println("Ошибка фильтрации " + e);
        }
    }
}
