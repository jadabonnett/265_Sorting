/**
 * The following code is *mostly* a copy of Quick class (quick sort) from algs4.jar
 */
import java.util.Arrays;
public class QuickSortMedian5 extends QuickSortMedian {

    public static class MedianOf5 extends MedianOfN {
        public MedianOf5() {
            // tell QuickSortMedian.MedianOfN we will find the median of 5 items
            super(5);
        }

        /***********************************************************
         * Determines which index in parameter indices points to
         * the median value in parameter a
         * @param a the array containing values
         * @param indices the array containing indices into a
         * @return the index of median value
         ***********************************************************/
        public int median(Comparable[] a, int[] indices) {
            // get values at specified indices
            int i0 = indices[0];
            int i1 = indices[1];
            int i2 = indices[2];
            int i3 = indices[3];
            int i4 = indices[4];
            Comparable a0 = a[i0];
            Comparable a1 = a[i1];
            Comparable a2 = a[i2];
            Comparable a3 = a[i3];
            Comparable a4 = a[i4];
            Comparable[] sortingList = new Comparable[5];
            sortingList[0] = a0;
            sortingList[1] = a1;
            sortingList[2] = a2;
            sortingList[3] = a3;
            sortingList[4] = a4;

            StdOut.printf("%s %s %s %s %s \n",sortingList[0], sortingList[1], sortingList[2],sortingList[3],sortingList[4]);
            Insertion.sort(sortingList); // this is incorrect
            Comparable median = sortingList[2];
            StdOut.printf("%s %s %s %s %s \n",sortingList[0], sortingList[1], sortingList[2],sortingList[3],sortingList[4]);
            if (median.compareTo(a0) == 0){
                StdOut.print(a0);
                return i0;
            }else if(median.compareTo(a1) == 0){
                StdOut.print(a1);
                return i1;
            }else if(median.compareTo(a2) == 0){
                StdOut.print(a2);
                return i2;
            }else if(median.compareTo(a3) == 0){
                StdOut.print(a3);
                return i3;
            }else{StdOut.print(a4); return i4;}
        }
    }

    /***********************************************************************
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     ***********************************************************************/
    public static void sort(Comparable[] a) {
        MedianOf5 median = new MedianOf5();
        QuickSortMedian.sort(a, median);
    }


    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = {0.0, 0.6, 0.1, 0.9, 8.4, 5.3, 200.9, 75.6};
        QuickSortMedian5.sort(a);
    }
}
