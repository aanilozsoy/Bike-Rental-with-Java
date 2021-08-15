import java.util.ArrayList;

class node {  //Node sınıfı
    private Durak_heap iData;

    public node(Durak_heap iData) {
        this.iData = iData;
    }

    public Durak_heap getKey() {
        return iData;
    }

    public void setKey(Durak_heap iData) {
        this.iData = iData;
    }
}
class Heap // heap sınıfı ve gerekli değişkenler
{
    private node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) //Constructor
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new node[maxSize];
    }

    public boolean isEmpty()
    { return currentSize==0; }

    public boolean insert(Durak_heap key)  //Heapın maksimum kapasiteye ulaşıp oluşmadığını kontrol ediyor ulaştıysa false döndürüp insert yapmıyor
    {
        if(currentSize==maxSize)
            return false;
        node new_Node = new node(key);
        heapArray[currentSize] = new_Node;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index)  // Parent node ve elimizdeki nodun değerleri kıyaslanır büyük olana öncelik vererek atamalar tekrarlanır.
    {
        int parent = (index-1) / 2;
        node bottom = heapArray[index];

        while( index > 0 &&
                heapArray[parent].getKey().getNormalBisiklet() < bottom.getKey().getNormalBisiklet() )
        {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1) / 2;
        }
        heapArray[index] = bottom;
    }

    public node remove()
    {
        node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index)   // top = elimizdeki node
    {                                    // elimizdeki nodun key değeri en büyük oluncaya kadar recursive ile devam eder bu method
        int largerChild;
        node top = heapArray[index];
        while(index < currentSize/2)
        {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            if(rightChild < currentSize &&
                    heapArray[leftChild].getKey().getNormalBisiklet() <
                            heapArray[rightChild].getKey().getNormalBisiklet())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if( top.getKey().getNormalBisiklet() >= heapArray[largerChild].getKey().getNormalBisiklet())
                break;

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue)  //Verilen indexe değeri atama yapan method.
    {
        if(index<0 || index>=currentSize)
            return false;
        int oldValue = heapArray[index].getKey().getNormalBisiklet(); //istenen indeksteki varolan değeri aldık
        heapArray[index].getKey().setNormalBisiklet(newValue); //istenen indexe yeni değeri atadık.
        if(oldValue < newValue)
            trickleUp(index);  // eğer istenen değer büyükse trickleUp ı çağırdık
        else
            trickleDown(index); // küçükse de trickleDown i çağırdık
        return true;
    }

    public void displayHeap()  //Yazdırmak için Heaparrayi dolaşıp teker teker yazdırıyor
    {
        System.out.println("heapArray'in içindekiler: ");
        System.out.println();
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.println(heapArray[m].getKey() + " ");
            else
                System.out.print( "Null");
        System.out.println();

    }

    public void max_3_Normal_Node(){   //Heap yapısı zaten öncelikli olduğu için ilk 3 elemanı bize istenen değeri verecek
        System.out.println("En fazla normal bisiklete sahip 3 durağın bilgileri");
        System.out.println();
        for(int i = 0 ; i < 3 ; i++){
            System.out.println(heapArray[i].getKey());
        }

    }

}
class Heap_uygulama {
    public static void main(String[] args) {
        String[] duraklar4 = {"Inciraltı, 28, 2, 10", "Sahilevleri, 8, 1, 11", "Doğal Yaşam Parkı, 17, 1, 6", "Bostanlı İskele, 7, 0, 5", "Uçkuyular, 8, 1, 8", "Güzelyalı, 15, 0, 4", "Karantina, 21, 3, 6", "Cesme, 13, 5, 2", "Liman, 24, 2, 6"};
        ArrayList<Durak_heap> duraklarList_heap = new ArrayList<>();

        for (String value : duraklar4) {

            String[] s = value.split(", ");
            String temp_durak_Adi = s[0];
            int temp_bos_park_sayisi = Integer.parseInt(s[1]);
            int temp_tandem_bisiklet = Integer.parseInt(s[2]);
            int temp_normal_bisiklet = Integer.parseInt(s[3]);
            Durak_heap durak = new Durak_heap(temp_durak_Adi, temp_bos_park_sayisi, temp_tandem_bisiklet, temp_normal_bisiklet);
            duraklarList_heap.add(durak);

        }
        Heap heap = new Heap(duraklarList_heap.size());

        for (Durak_heap durak2 : duraklarList_heap) {
            heap.insert(durak2);
        }
        heap.displayHeap();
        System.out.println("--------------------");
        heap.max_3_Normal_Node();


    }
}

