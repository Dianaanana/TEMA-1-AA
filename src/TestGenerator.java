import java.io.IOException;
import java.util.Random;

public class TestGenerator {
    private static final Random RANDOM = new Random();

    private static void generateTest(TestParams params) throws IOException {
        // initialize array
        int[] array = new int[params.size];
        params.outWriter.write(params.size + "\n");

        for(int i = 0; i < params.size; i++) {
            array[i] = RANDOM.nextInt(1, 9999999);
            params.outWriter.write(array[i] + " ");
        }
        System.out.println(array);
        params.outWriter.write("\n");
        params.outWriter.close();
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws  IOException {
        final TestParams[] testParams = {
            new TestParams(30, "src/in"),
            new TestParams(40, "src/in"),
            new TestParams(50, "src/in"),
            new TestParams(60, "src/in"),
            new TestParams(70, "src/in"),
            new TestParams(80, "src/in"),
            new TestParams(90, "src/in"),
            new TestParams(100, "src/in"),
            new TestParams(150, "src/in"),
            new TestParams(200, "src/in"),

            new TestParams(250, "src/in"),
            new TestParams(300, "src/in"),
            new TestParams(350, "src/in"),
            new TestParams(400, "src/in"),
            new TestParams(450, "src/in"),
            new TestParams(500, "src/in"),
            new TestParams(550, "src/in"),
            new TestParams(600, "src/in"),
            new TestParams(650, "src/in"),
            new TestParams(700, "src/in"),

            new TestParams(1000, "src/in"),
            new TestParams(2000, "src/in"),
            new TestParams(3000, "src/in"),
            new TestParams(4000, "src/in"),
            new TestParams(5000, "src/in"),
            new TestParams(6000, "src/in"),
            new TestParams(7000, "src/in"),
            new TestParams(8000, "src/in"),
            new TestParams(9000, "src/in"),
            new TestParams(10000, "src/in"),

            new TestParams(11000, "src/in"),
            new TestParams(12000, "src/in"),
            new TestParams(13000, "src/in"),
            new TestParams(14000, "src/in"),
            new TestParams(15000, "src/in"),
            new TestParams(16000, "src/in"),
            new TestParams(17000, "src/in"),
            new TestParams(18000, "src/in"),
            new TestParams(19000, "src/in"),
            new TestParams(20000, "src/in"),
        };

        for(int i = 0; i < TestParams.testNumber; i++) {
            generateTest(testParams[i]);
        }
    }
}
