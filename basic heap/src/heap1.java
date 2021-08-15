class Node1  // Heap yapının node sınıfı
{
    private int iData;

    public Node1(int key){
        { iData = key; }
    }

    public int getKey(){
        { return iData; }
    }
    public void setKey(int id){
        { iData = id; }

    }
}

class heap1   // heap sınıfı ve gerekli değişkenler
{
    private final Node1[] heapArray1;
    private final int maxSize;
    private int currentSize;

    public heap1(int a)  //Constructor
    {
        maxSize = a;
        currentSize = 0;
        heapArray1 = new Node1[maxSize];
    }

    public boolean isEmpty()
    { return currentSize==0; }

    public boolean insert(int key)
    {
        if(currentSize==maxSize) //Heapın maksimum kapasiteye ulaşıp oluşmadığını kontrol ediyor ulaştıysa false döndürüp insert yapmıyor
            return false;
        Node1 new_Node = new Node1(key);
        heapArray1[currentSize] = new_Node;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index)  // Parent node ve elimizdeki nodun değerleri kıyaslanır büyük olana öncelik vererek atamalar tekrarlanır.
    {
        int parent = (index-1) / 2;
        Node1 bottom = heapArray1[index];

        while( index > 0 &&
                heapArray1[parent].getKey() < bottom.getKey() )
        {
            heapArray1[index] = heapArray1[parent];
            index = parent;
            parent = (parent-1) / 2;
        }
        heapArray1[index] = bottom;
    }

    public Node1 remove()
    {
        Node1 root = heapArray1[0];
        heapArray1[0] = heapArray1[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) // top = elimizdeki node
    {                                  // elimizdeki nodun key değeri en büyük oluncaya kadar recursive ile devam eder bu method
        int largerChild;
        Node1 top = heapArray1[index];
        while(index < currentSize/2)
        {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            if(rightChild < currentSize &&
                    heapArray1[leftChild].getKey() <
                            heapArray1[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if( top.getKey() >= heapArray1[largerChild].getKey() )
                break;

            heapArray1[index] = heapArray1[largerChild];
            index = largerChild;
        }
        heapArray1[index] = top;
    }

    public boolean change(int index, int newValue)     //Verilen indexe değeri atama yapan method.
    {
        if(index<0 || index>=currentSize)
            return false;
        int oldValue = heapArray1[index].getKey(); //istenen indeksteki varolan değeri aldık
        heapArray1[index].setKey(newValue);  //istenen indexe yeni değeri atadık.
        if(oldValue < newValue)
            trickleUp(index); // eğer istenen değer büyükse trickleUp ı çağırdık
        else
            trickleDown(index); // küçükse de trickleDown i çağırdık
        return true;
    }

    public void displayheap1()  // Heap içini dolaşarak verileri yazdırır
    {
        System.out.println("heap arrayin içindekiler");
        for(int m=0; m<currentSize; m++){

            if(heapArray1[m] != null) {
                System.out.print(heapArray1[m].getKey() + " ");
            }else {
                System.out.print("Null");
                System.out.println();
            }
        }
    }

}
