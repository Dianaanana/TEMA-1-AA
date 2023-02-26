import java.io.IOException;


public class Main {


    public static void main(final String[] args) throws IOException {

        for(int i = 1; i <= Constants.NR_TESTS; i++) {
            RWOp.createFiles(i);
            HybridSortAlgorithm myAlgorithm = RWOp.readInputs(Integer.parseInt(args[0]));

            long start1 = System.nanoTime();

            myAlgorithm.run(Integer.parseInt(args[0]));

            long end1 = System.nanoTime();

            System.out.println("Test " + i + " nano seconds: "+ (end1-start1));
//            System.out.println("Elapsed Time in mili seconds:" + TimeUnit.MILLISECONDS.convert((end1-start1), TimeUnit.NANOSECONDS));
//            System.out.println("Elapsed Time in micro seconds:" + TimeUnit.MICROSECONDS.convert((end1-start1), TimeUnit.NANOSECONDS));
            RWOp.writeOutputs(myAlgorithm);

        }

    }
}