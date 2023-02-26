public class HybridSortAlgorithm implements Run{

    int[] arr;
    int size;

    public HybridSortAlgorithm(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    @Override
    public void run(int algorithmType) {
        switch(algorithmType) {
            case 1:
                System.out.println("testing tisort ... \n");
                TimSort.timSort(arr, size);
                break;
            case 2:
                System.out.println("testing introsort ... \n");
                Introsort.introSort(arr, size);
                break;
            case 3:
                System.out.println("testing Kirkpatrick-Reisch sort ... \n");
                KirkpatrickReisch.kirkpatrickReischSort(arr, size);
                break;
            default:
                break;
        }



    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
