import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class SimpleMerge {

    public static void main (String[] args) throws IOException{
        boolean neadMore1 = true;
        boolean neadMore2 = true;
        boolean neadMore3 = true;
        int min1 = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        int min3 = Integer.MIN_VALUE;
        ArrayList<Integer> SortedList = new ArrayList<Integer>;
        try (BufferedReader br1 = new BufferedReader(new FileReader("in1.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("in2.txt"));
             BufferedReader br3 = new BufferedReader(new FileReader("in3.txt"))) {

            for (int i = 0; i < 3; i++) {
                if (neadMore1) {min1 = Integer.parseInt(br1.readLine()); neadMore1 = false;}
                if (neadMore2) {min2 = Integer.parseInt(br2.readLine()); neadMore2 = false;}
                if (neadMore3) {min3 = Integer.parseInt(br3.readLine()); neadMore3 = false;}

                if (min1 <= min2){
                    SortedList.add(min1);
                    neadMore1 = true;
                }
                else {
                    if (min2 <= min3){
                        SortedList.add(min2);
                        neadMore2 = true;
                    }
                    else {
                        SortedList.add(min3);
                        neadMore3 = true;
                    }
                }
            }
        }

    }
}
