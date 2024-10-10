package Чтение_файла;

import java.util.ArrayList;
import java.util.List;

public class EcoUserFilter implements UserCheck {
    private double maxConsumption;

    public EcoUserFilter(double maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    @Override
    public List<User> check(List<User> users) {
        List<User> ecoUser = new ArrayList<>();
        for (User user : users) {
            int[] consumptions = {
                    user.getWaterCountDay() + user.getWaterCountNight(),
                    user.getGasCount(),
                    user.getElectroCountDay() + user.getElectroCountNight()
            };
            boolean isEco = true;
            for (int consumption : consumptions) {
                if (consumption >= maxConsumption) {
                    isEco = false;
                    break;
                }
            }
            if (isEco) {
                ecoUser.add(user);
            }
        }
        return ecoUser;
    }
}
