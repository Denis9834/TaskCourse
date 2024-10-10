package Рекурсивное_создание_файла;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class NewFileDirectory {
    public static void main(String[] args) {

        Path directory = Path.of("C:\\Test");

        if (Files.exists(directory) && Files.isDirectory(directory)) {
            try {
                Files.walkFileTree(directory, new JokeFileVisitor());
            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        } else {
            System.out.println("Путь не существует или не является директорией");
        }
    }
}

