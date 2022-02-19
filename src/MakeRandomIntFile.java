import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MakeRandomIntFile {
    public static void main(String[] args) throws IOException {

        Random rand = new Random();

        FileWriter fw = new FileWriter("int.txt", false);
        for(int i = 0; i< 1000 ;i++){
            fw.write(new Integer(rand.nextInt(2147483647)).toString()+"\n");
        }
        fw.close();


    }
}
