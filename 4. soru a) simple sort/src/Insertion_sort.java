class Array{  // verileri tutmak için vi Array sınıfı tanımladım
    private final long[] arr;
    private int nItems;

    public Array(int max) {
        arr = new long[max];  //Gerekli constructor
        nItems = 0;
    }
    public void insert(long value)
    {
        arr[nItems] = value;   //değeri ekliyor
        nItems++;
    }
    public void diplay(){
        for(int i=0; i<nItems; i++)
            System.out.print(arr[i] + " "); // değerleri görüntülüyor
        System.out.println("");
    }
    public void Insertionsert(){
        int in,out;
        for(out=1; out<nItems; out++){    //ilk olarak 1. indeksteki elemanı elimize aliyoruz ve bir önceki indeks ile karşılaştırıyoruz.
            long temp = arr[out];
            in = out;
            while(in > 0 && arr[in-1] >= temp){ //eğer küçükse onu sola atıyoruz ve büyük elemanı 1. indekse atıyoruz
                arr[in] = arr[in-1];            // daha sonra bunu tekrar tekrar diğer indeklerde de yapıyoruz
                in--;
            }
            arr[in] = temp;
        }
    }
}
public class Insertion_sort {
    public static void main(String[] args){

        int max_size = 20;
        Array array = new Array(max_size);

        array.insert(12);
        array.insert(4);
        array.insert(78);
        array.insert(19);
        array.insert(18);
        array.insert(121);
        array.insert(81);

        System.out.println("Eldeki array: ");
        array.diplay();
        System.out.println();

        System.out.println("Array'in sıralanmış hali: ");


        array.Insertionsert();
        array.diplay();
    }
}

