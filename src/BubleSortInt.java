import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class BubleSortInt {
    public static void main(String[] args)  throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("int.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Integer i = Integer.parseInt(line);
                list.add(i);
            }
        }


        FileWriter fw = new FileWriter("SortedInt.txt", false);
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    int tmp = list.get(i);
                    list.set( i, list.get(i - 1));
                    list.set( i - 1, tmp);
                    needIteration = true;
                }
            }
        }


        for(Integer curInt: list){
            fw.write(curInt +"\n");
        }
        fw.close();

    }
}
