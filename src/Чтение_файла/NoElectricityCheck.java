package Чтение_файла;

import java.util.ArrayList;
import java.util.List;

public class NoElectricityCheck implements EcoCheck {

    @Override
    public List<User> isEcoUser(List<User> users) {
        List<User> noElectricityUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getElectroCountDay() + user.getElectroCountNight() == 0) {
                noElectricityUsers.add(user);
            }
        }
        return noElectricityUsers;
    }
}
