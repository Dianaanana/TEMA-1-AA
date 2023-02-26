import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestParams {

    int size;
    String folder;
    FileWriter outWriter;
    public static int testNumber = 0;

    public TestParams(int size, String folder) {
        this.size = size;

        this.folder = folder;
        ++testNumber;

        File directory = new File(this.folder);
        if (!directory.exists()) {
            directory.mkdir();
        }

        String outPath = this.folder + "/test" + testNumber + ".in";

        try {
            File outFile = new File(outPath);
            outFile.createNewFile();
            this.outWriter = new FileWriter(outFile);
        } catch(IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}