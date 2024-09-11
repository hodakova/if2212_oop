import java.util.*;

public class PenjurusanTPB {

    public static class Mahasiswa {
        private Integer NIM;
        private String Nama;
        private Double IP;
        private Double UKT;
        
        public Mahasiswa(Integer NIM, String nama, Double IP, Double UKT) { 
            // TODO!
            this.NIM = NIM;
            this.Nama = nama;
            this.IP = IP;
            this.UKT = UKT;
        }

        public Integer getNIM() { 
            // TODO!
            return NIM;
        }
        
        public String getNama() {
            // TODO!
            return Nama;
        }

        public Double getIP() {
            // TODO!
            return IP;
        }

        public Double getUKT() {
            // TODO!
            return UKT;
        }
    }

    private static class MahasiswaComparator implements Comparator<Mahasiswa> {
        /**
         * Membandingkan Mahasiswa dengan urutan sebagai berikut:
         *  1. UKT yang lebih besar akan diprioritaskan.
         *  2. IP yang lebih besar akan diprioritaskan.
         *  3. NIM yang lebih kecil akan diprioritaskan. (NIM dipastikan unik)
         */
        public int compare(Mahasiswa mahasiswa1, Mahasiswa mahasiswa2) {
            // TODO!
            if(mahasiswa2.getUKT().compareTo(mahasiswa1.getUKT()) != 0) {
                return mahasiswa2.getUKT().compareTo(mahasiswa1.getUKT());
            }
            if(mahasiswa2.getIP().compareTo(mahasiswa1.getIP()) != 0) {
                return mahasiswa2.getIP().compareTo(mahasiswa1.getIP());
            }
            return mahasiswa1.getNIM().compareTo(mahasiswa2.getNIM());
        }
    }

    /**
     * Menerima List<Mahasiswa> yang tidak terurut
     * Mengembalikan PriorityQueue<Mahasiswa> yang sudah terurut berdasarkan prioritas.
     */
    public static PriorityQueue<Mahasiswa> PembangkitanAntrianPrioritas(List<Mahasiswa> list) {
        // TODO!
        if(list.isEmpty()) {
            return new PriorityQueue<Mahasiswa>();
        }
        PriorityQueue<Mahasiswa> priorityQueue = new PriorityQueue<Mahasiswa>(list.size(), new MahasiswaComparator());
        priorityQueue.addAll(list);
        return priorityQueue;
    }
}
