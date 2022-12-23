public class EdgeCases {
    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/


    public static Double[] orderA(int N){ // already ordered
        Double[] a = new Double[N];
        for (int i=0; i<N; i++){
            double mydub = i;
            a[i]= mydub;
        }
        return a;
    }

    public static Double[] orderB(int N){ // backwards but in order
        Double[] a = new Double[N];
        for (int i=0; i<N; i++){
            double mydub = i;
            a[i]= N-mydub; // is this correct?
        }
        return a;
    }

    public static Double[] orderC(int N){ // same num
        Double[] a = new Double[N];
        double rand = StdRandom.uniform(0, N); // something here, not sure how to get one random number
        for (int i = 0; i<N; i++){
            a[i] = rand;
        }
        return a;
    }

    public static Double[] orderD(int N){ // random num for each spot
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++){
            double ourNum = StdRandom.uniform(0, N); // something here, not sure how to get one random number;
            a[i] = ourNum;
        }
        return a;
    }

    public static Double[] orderE(int N){ // only one item
        Double[] a = new Double[1];
        a[0] = 4.0;
        return a;
    }

    public static Double[] orderF(int N){ // no items in list
        Double[] a = {};
        return a;
    }

    public static void main(String[] args) {
        int i = 100;
        Double[] a = orderA(i); // completely ordered
        Double[] b = orderB(i); // ordered but in reverse
        Double[] c = orderC(i); // same number
        Double[] d = orderD(i); // random number in each spot
        Double[] e = orderE(i); // only 1 item in list
        Double[] f = orderF(i); // no items in list

        Double[] chosenType = a;
        Bubble.sort(chosenType);     // bubble sort
        Selection.sort(chosenType);  // selection sort
        Insertion.sort(chosenType);  // insertion sort
        Shell.sort(chosenType);      // Shellsort
        Quick.sort(chosenType);      // quicksort
    }
}
