package Чтение_файла;

public class UserCSVReader implements UserRead{
    private String separator;

    public UserCSVReader(String separator) {
        this.separator = separator;
    }

    @Override
    public User readNewUser(String line) {
        String[] arr = line.split(separator);
        int id = Integer.parseInt(arr[0]);
        String name = arr[1];
        int waterCountDay = Integer.parseInt(arr[2]);
        int waterCountNight = Integer.parseInt(arr[3]);
        int gazCount = Integer.parseInt(arr[4]);
        int electroCountDay = Integer.parseInt(arr[5]);
        int electroCountNight = Integer.parseInt(arr[6]);

        return new User(id, name, waterCountDay, waterCountNight, gazCount, electroCountDay, electroCountNight);
    }
}
