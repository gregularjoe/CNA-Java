package Java_2.Assignment2.Settings;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Settings")
public class Settings {

    private String name;
    private int height;
    private int weight;
    private String birthday;
    private double functionalThresholdPower;

    public Settings() {
        this("",0,0,"",0);
    }

    public Settings(String name, int height, int weight, String birthday, double functionalThresholdPower) {

        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.functionalThresholdPower = functionalThresholdPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getFunctionalThresholdPower() {
        return functionalThresholdPower;
    }

    public void setFunctionalThresholdPower(double functionalThresholdPower) {
        this.functionalThresholdPower = functionalThresholdPower;
    }
}
