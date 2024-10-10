package Чтение_файла;

import java.util.ArrayList;
import java.util.List;

public class NoElectricityFilter implements UserCheck {

    @Override
    public List<User> check(List<User> users) {
        List<User> noElectricityUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getElectroCountDay() + user.getElectroCountNight() == 0) {
                noElectricityUsers.add(user);
            }
        }
        return noElectricityUsers;
    }
}
