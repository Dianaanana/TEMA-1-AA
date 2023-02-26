import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RWOp {
    private static File inFile;
    private static File outFile;
    private static Scanner scanner;
    private static FileWriter outWriter;

    private RWOp() { }

    public static void createFiles(int testNumber) throws IOException {
        String inName = new String("in/test" + testNumber + ".in");
        inFile = new File(inName);
        scanner = new Scanner(inFile);

        File directory = new File("out");
        if (!directory.exists()) {
            directory.mkdir();
        }

        String outName = new String("out/test" + testNumber + ".out");
        outFile = new File(outName);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);

        File directoryTime = new File("out_time");
        if (!directoryTime.exists()) {
            directoryTime.mkdir();
        }

        String outNameTime = new String("out_time/test" + testNumber + ".out");
        outFile = new File(outNameTime);
        outFile.createNewFile();
        outWriter = new FileWriter(outFile);
    }

    public static HybridSortAlgorithm readInputs(int algorithmType) {
        int size = scanner.nextInt();
        int[] array = new int[size];
//        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++) {
            int tmp = scanner.nextInt();
            array[i] = tmp;
//            array[i] = scanner.nextInt();
        }
        switch (algorithmType) {
            case 1 : {
                return new TimSort(array, size);
            }
            case 2 : {
                return new Introsort(array, size);
            }
            case 3 : {
                return new KirkpatrickReischSort(array, size);
            }
            default : {
                System.out.println("Invalid algorithm");
                System.exit(-1);
                return null;
            }
        }
    }

    public static void writeOutputs(HybridSortAlgorithm hybridSortAlgorithm) throws IOException {

        int size = hybridSortAlgorithm.size;
        int[] array = hybridSortAlgorithm.arr;

        StringBuilder line = new StringBuilder();

        for (int i = 0; i < size; i++) {
            line.append(array[i] + " ");
        }
        line.append("\n");
        outWriter.write(line.toString());

        outWriter.close();
    }


}
