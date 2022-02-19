import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.ParseException;
import java.util.ArrayList;

public class MergeSort {
    private static boolean isInteger;
    private static boolean isString;
    private static boolean doneWithKeys = false;
    private static boolean sortAscending = true;
    private static String[] filenameArray;
    int numberOfFilesPassed = 0;
    public static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) throws ParseException {

        // Проверка на наличие ввода аргументов
        if (args.length == 0) {
            System.out.println("No arguments passed. Quittiing.");
            System.out.println("Please enter -d for sort descending. Otherwise perform ascending sort.");
            System.out.println("Please enter -i for i");

        }

        // Обработка консольного ввода
        for (String str : args) {
            while (!doneWithKeys) {
                if (str.equals("-d")) sortAscending = false;
                if (str.equals("-i")) {
                    isInteger = true;
                    isString = false;
                    doneWithKeys = true;
                }
                if (str.equals("-s")) {
                    isInteger = false;
                    isString = true;
                    doneWithKeys = true;
                }
            }
        }
        /*
        // Запись в файл
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private static long calculatePercentageMemoryUsed() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long maxMemory = heapUsage.getMax() / (1024 * 1024);
        long usedMemory = heapUsage.getUsed() / (1024 * 1024);
        long percentageUsed = (long) (100.0 * ((1.0 * usedMemory)/(1.0 * maxMemory)));
        System.out.println("Used vs. Max Memory: " + usedMemory + "M/"
                           + maxMemory + "M " + percentageUsed + "% List size: " + list.size());
        return percentageUsed;
    }
    */

    }
}
