package Java_2.Assignment2.Settings;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SettingsMarshal {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String menuOption = "";

        Path filePath = Paths.get("src/main/java/Assignment2/Settings/Settings.xml");


        while (!menuOption.equals("X")) {
            System.out.println("Enter A to View Settings: ");
            System.out.println("Enter B to Update Settings: ");
            System.out.println("Enter X to Quit: ");
            menuOption = scanner.nextLine().toUpperCase();

            if (menuOption.equals("A")) {
                if (Files.exists(filePath)) {
                    try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
                        Settings settings = JAXB.unmarshal(bufferedReader, Settings.class);
                        System.out.println("-----------------------------------------------");
                        System.out.printf("Name: %s\n", settings.getName());
                        System.out.printf("Height: %d\n", settings.getHeight());
                        System.out.printf("Weight: %d\n", settings.getWeight());
                        System.out.printf("Birthday: %s\n", settings.getBirthday());
                        System.out.printf("Functional Threshold Power: %.2f\n", settings.getFunctionalThresholdPower());
                        System.out.println("-----------------------------------------------");

                    } catch (Exception exception) {
                        System.err.println(exception);
                    }
                } else {

                    System.out.println("Settings file does not exist, try option B to Update settings.");
                }
            }

            else if (menuOption.equals("B")) {
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)){

                    System.out.println("Enter name: ");
                    String userName = scanner.nextLine();
                    System.out.println("Enter height in cm: ");
                    int userHeight = scanner.nextInt();
                    System.out.println("Enter weight in kg: ");
                    int userWeight = scanner.nextInt();
                    System.out.println("Enter birthday (yyyy-mm-dd)");
                    String userBirthday = scanner.next();
                    System.out.println("Enter functional threshold power: ");
                    double userFunctionalThresholdPower = scanner.nextDouble();

                    Settings settings = new Settings();
                    settings.setName(userName);
                    settings.setWeight(userWeight);
                    settings.setHeight(userHeight);
                    settings.setBirthday(userBirthday);
                    settings.setFunctionalThresholdPower(userFunctionalThresholdPower);
                    JAXB.marshal(settings, bufferedWriter);

                    System.out.println("Settings saved to Settings.xml");
                    System.out.println("------------------------------------------");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                if (!menuOption.equals("X")) {
                    System.out.println("I'm sorry that isn't a valid menu option. Try Again.");
                }
            }
        }
        scanner.close();
    }
}






