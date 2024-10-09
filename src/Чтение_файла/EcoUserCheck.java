package Чтение_файла;

import java.util.ArrayList;
import java.util.List;

public class EcoUserCheck implements EcoCheck {
    private double maxConsumption;

    public EcoUserCheck(double maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    @Override
    public List<User> isEcoUser(List<User> users) {
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
