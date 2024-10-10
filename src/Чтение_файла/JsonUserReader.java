package Чтение_файла;

import java.util.List;

public class JsonUserReader implements UserReader {
    @Override
    public List<User> readAllUsers(UserCVSWriter writer) {
        return List.of();
    }
}
