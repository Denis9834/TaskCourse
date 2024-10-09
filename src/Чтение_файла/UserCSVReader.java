package Чтение_файла;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCSVReader implements UserRead {
    private Path filePath;
    private String separator;

    public UserCSVReader(Path filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    public List<String> splitLine(String line) {
        String[] arr = line.split(separator);
        return Arrays.asList(arr);
    }

    @Override
    public List<User> readAllUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> data = splitLine(line);
                int id = Integer.parseInt(data.get(0));
                String name = data.get(1);

                int[] consumption = new int[data.size() - 2];

                for (int i = 2; i < data.size() - 2; i++) {
                    consumption[i -2] = Integer.parseInt(data.get(i));
                }
                User user = new User(
                        id, name, consumption[0], consumption[1], consumption[2], consumption[3], consumption[4]);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
