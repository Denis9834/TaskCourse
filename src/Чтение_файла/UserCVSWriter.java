package Чтение_файла;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class UserCVSWriter implements UserWriter {
    private Path outputPath;

    public UserCVSWriter(Path input) {
        this.outputPath = createOutputFile(input);
    }

    public void writeHeader(String header) {
        try (BufferedWriter bufWriter = Files.newBufferedWriter(outputPath)) {
            bufWriter.write(header);
            bufWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(List<User> users) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.APPEND)) {
            for (User user : users) {
                writer.write(
                        String.format("%d|%s|%d|%d|%d|%d|%d",
                                user.getId(), user.getName(),
                                user.getWaterCountDay(), user.getWaterCountNight(),
                                user.getGasCount(),
                                user.getElectroCountDay(), user.getElectroCountNight()));
                writer.newLine();
            }
            System.out.printf("Файл %s обновлен\n", outputPath.getFileName());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static Path createOutputFile(Path input) {
        String newFile = "eco_users.csv";
        return input.getParent().resolve(newFile);
    }
}
