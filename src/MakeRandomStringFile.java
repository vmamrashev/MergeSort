import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MakeRandomStringFile {
    public static void main(String[] args) throws IOException {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int stringLength;
        Random rand = new Random();
        FileWriter fw = new FileWriter("string.txt", false);

        for (int noOfStrings = 0; noOfStrings < 1000; noOfStrings++) {
            stringLength = rand.nextInt(12);
            StringBuilder buffer = new StringBuilder(stringLength);
            for (int i = 0; i < stringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (rand.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();
            fw.write( buffer.toString()+"\n");
        }
        fw.close();
    }
}
