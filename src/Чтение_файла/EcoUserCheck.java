package Чтение_файла;

public class EcoUserCheck implements EcoCheck{
    @Override
    public boolean isEcoUser(User user, double maxConsumption) {
        int[] consumptions = {
                user.getWaterCountDay() + user.getWaterCountNight(),
                user.getGasCount(),
                user.getElectroCountDay() + user.getElectroCountNight()
        };
        for (int consumption : consumptions) {
            if (consumption >= maxConsumption) {
                return false;
            }
        }
        return true;
    }
}
