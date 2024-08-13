package Java_2.Assignment3.Redaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FunWithRedactor {
    public static void main(String[] args) {
        String filePath = "sampleInfo.txt.txt";

        try {
            String sampleText = new String(Files.readAllBytes(Paths.get(filePath)));
            Redactor redactor = new Redactor(sampleText);
            String modifiedContent = redactor.replaceWords();

            Files.write(Paths.get(filePath), modifiedContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
