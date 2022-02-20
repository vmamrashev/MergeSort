import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main (String[] args)  throws IOException {
        boolean neadSorting = true;
        List<Integer> sordedList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader("in1.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("in2.txt"));
             BufferedReader br3 = new BufferedReader(new FileReader("in3.txt"))) {
            //Вычитываем куски файлов, заполняя списки 1,2,3 пока не будет занята 1/2 кучи
            while (neadSorting) {
                //пока куча не заполнилась на 10% читаем из первого файла
                while (heapUsed() < 10.0) {
                    String line1 = br1.readLine();
                    while (line1 != null) {
                        list1.add(Integer.parseInt(line1));
                    }
                }

                //пока куча не заполнилась на 20% читаем из второго файла
                String line2 = br2.readLine();
                while (heapUsed() < 20.0) {
                    while (line2 != null) {
                        list2.add(Integer.parseInt(line2));
                    }
                }

                //пока куча не заполнилась на 30% читаем из третьего файла
                String line3 = br3.readLine();
                while (heapUsed() < 30.0) {
                    while (line3 != null) {
                        list3.add(Integer.parseInt(line3));
                    }
                }
            }
        }

        // Сортировка вычитанных фрагментов, запись в sordedList
        int list1MinIndex = 0;
        int list2MinIndex = 0;
        int list3MinIndex = 0;
        int sortedListMinIndex = 0;

        while (list1MinIndex < list1.size() && list2MinIndex < list2.size() && list3MinIndex < list3.size()){
            if (list1.get(list1MinIndex)<= list2.get(list2MinIndex) && list1.get(list1MinIndex)<= list3.get(list3MinIndex)) {
                sordedList.set(sortedListMinIndex, list1.get(list1MinIndex));
                list1MinIndex++;
            }
            else {
                if (list2.get(list2MinIndex)<= list3.get(list3MinIndex)) {
                    sortedList.set(sortedListMinIndex, list2.get(list2MinIndex));
                    list2MinIndex++;
                }
                else {
                    sortedList.set(sortedListMinIndex, list3.get(list3MinIndex));
                    list3MinIndex++;
                }
                sortedListMinIndex++;
            }
            while (list1MinIndex < list1.size()){
                sortedList.set

            }
        }

        //Запись в файл из sordedList
        FileWriter fw = new FileWriter("MergedInt.txt", true);
        for (Integer curInt : sortedList) {
            fw.write(curInt + "\n");
        }
        fw.close();
    }

    //Проверка доли заполненной памяти
    private static long heapUsed() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long maxMemory = heapUsage.getMax() / (1048576);
        long usedMemory = heapUsage.getUsed() / (1048576);
        long percentageUsed = (long) (100.0 * ((1.0 * usedMemory)/(1.0 * maxMemory)));
        return percentageUsed;
    }
}
