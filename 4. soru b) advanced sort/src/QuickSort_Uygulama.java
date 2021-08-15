class ArrayIns {
    private final long[] quick_Array; // long tipinde elemanları tutan bir Array tanımladık
    private int nItems; // eleman sayısı

    public ArrayIns(int max) {
        quick_Array = new long[max]; // constructor
        nItems = 0;
    }

    public void insert(long value) {
        quick_Array[nItems] = value; // direkt atama yapar
        nItems++;
    }
    public void display() {  // yazdırma
        System.out.print("Array: ");
        for (int j = 0; j < nItems; j++)
            System.out.print(quick_Array[j] + " ");
        System.out.println("");
    }

    public void quickSort() {    //recursive ile sortu çağırırız
        recQuickSort(0, nItems - 1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0)          // Liste boyutu <=  ise sıralama gereksizdir
            return;
        {
            long pivot = quick_Array[right];

            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);  //solu sıralam
            recQuickSort(partition + 1, right);  // sağı sırala
        }
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (quick_Array[++leftPtr] < pivot)
                ;  // büyük olanı bulur

            while (rightPtr > 0 && quick_Array[--rightPtr] > pivot)
                ; // küçük olanı bulur
            if (leftPtr >= rightPtr)
                break;  // sol daha büyükse breakliyor ama
            else
                swap(leftPtr, rightPtr); // sağ daha büyükse swapliyor
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) { //yukarıdaki methodlarda yeri değiştirilmesi gereken elemanların
        long temp = quick_Array[dex1];    // yerini değiştirir
        quick_Array[dex1] = quick_Array[dex2];
        quick_Array[dex2] = temp;
    }

}
class QuickSort_Uygulama {
    public static void main(String[] args) {

        int maxSize = 10;
        ArrayIns arr = new ArrayIns(maxSize);

        arr.insert(1);
        arr.insert(23);
        arr.insert(6);
        arr.insert(57);
        arr.insert(14);
        arr.insert(45);
        arr.insert(87);
        arr.insert(90);
        arr.insert(5);

        arr.display();
        arr.quickSort();
        arr.display();
    }
}
