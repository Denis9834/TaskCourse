package Рекурсивное_создание_файла;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class JokeFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc == null) {
            createFile(dir);
            return FileVisitResult.CONTINUE;
        } else {
            throw exc;
        }
    }

    private void createFile(Path directory) {
        Path jokeFile = directory.resolve("joke.java");

        if (Files.exists(jokeFile)) {
            System.out.println("Файл уже существует -> " + jokeFile.toAbsolutePath());
            return;
        }
        try {
            Files.writeString(jokeFile, getText());
            System.out.println("Файл создан: " + jokeFile.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла " + jokeFile.toAbsolutePath());
        }
    }

    private String getText() {
        return "public class newFile {\n" +
                "public static void main(String[] args) {\n" +
                "System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";
    }
}
