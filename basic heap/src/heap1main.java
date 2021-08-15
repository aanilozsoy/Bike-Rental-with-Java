public class heap1main {
    public static void main(String[] args){
        heap1 heap = new heap1(8);

        heap.insert(76);
        heap.insert(3);
        heap.insert(26);
        heap.insert(11);
        heap.insert(7);
        heap.insert(89);
        heap.insert(86);
        heap.insert(55);
        System.out.println("Heap yapısının nasıl çalıştığını görmek için yapılan egzersiz");
        System.out.println();
        heap.displayheap1();

        System.out.println();
        System.out.println();

        System.out.println("İki elemanını çıkarırsam");
        System.out.println();

        heap.remove();
        heap.remove();

        heap.displayheap1();

    }
}
