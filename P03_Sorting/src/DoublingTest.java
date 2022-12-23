public class DoublingTest {
    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/
    private static Double[] generate_random(int N){
        Double[] a = new Double[N];
        for(int i = 0; i<N; i++){
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    public static void main(String[] args) {
        int N = 1000;

        //first test
        Stopwatch sw = new Stopwatch();
        QuickSortMedian5.sort(generate_random(N));  // selection sort
        double TN = sw.elapsedTime();

        // second test of double
        sw = new Stopwatch();
        QuickSortMedian5.sort(generate_random(N*2));
        double TN2 = sw.elapsedTime();

        double ratio = TN2/TN;
        double b = Math.log(ratio) / Math.log(2);
        double aNum = TN2 / Math.pow(2*N, b);
        StdOut.println("b = "+b);
        StdOut.println("T(N) = " + aNum + " * N^"+ b);

    }
}
