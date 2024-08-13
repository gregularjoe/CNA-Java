package Java_2.Assignment3.Redaction;

public class Redactor {
    String sampleText;

    public Redactor(String sampleText) {
        this.sampleText = sampleText;
    }

    public String replaceWords() {
        this.sampleText = this.sampleText.replaceAll("[0-9]{2}-[0-9][2]-[0-9]{4}.?", "##-##-####");
        this.sampleText = this.sampleText.replaceAll("[0-9]{2}-[0-9]{2}-[0-9]{2}.?", "##-##-##.");
        this.sampleText = this.sampleText.replaceAll("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}.?", "####-####-####-####");
        this.sampleText = this.sampleText.replaceAll("\\$[0-9]+(.[0-9]{2})?", "\\$####.##");
        this.sampleText = this.sampleText.replaceAll("CODE[0-9]+.?", "CODE#################.");

        return this.sampleText;
    }
}
