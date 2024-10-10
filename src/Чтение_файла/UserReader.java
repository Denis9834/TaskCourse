package Чтение_файла;

import java.util.List;

public interface UserReader {
    List<User> readAllUsers(UserCVSWriter writer);
}
