public class Ucrypt {

    /**
     * Mengembalikan string yang telah dihash
     * 
     * Hash dilakukan dengan cara:
     * 1. Mengubah kata menjadi bahasa Umandana
     * 2. Menggeser karakter sebanyak huruf vokal pada kata awal
     * 3. Apabila karakter merupakan digit angka maka:
     * 3.1 Digit diubah menjadi huruf kecil sesuai urutan alfabet (a urutan ke-0)
     * 3.2 Karakter kemudian digeser sebanyak huruf vokal pada kata awal
     * Contoh: hash(tes123) = tepreses123 -> ufqsftftcde
     * 
     * @param word kata yang akan dihash
     * @return kata yang telah dihash
     */
    public static StringBuilder hash(String word) {
        int vowelCtr = word.replaceAll("[^aiueoAIUEO]", "").length();
        String umandana = Umandana.toUmandana(word);
        StringBuilder numbCypher = new StringBuilder();
        for (int i = 0; i < umandana.length(); i ++) {
            if (Character.isDigit(umandana.charAt(i))) {
                numbCypher.append((char) (Character.getNumericValue(umandana.charAt(i)) + 'a'));
            }
            else {
                numbCypher.append(umandana.charAt(i));
            }
        }
        StringBuilder cypher = new StringBuilder();
        for (int i = 0; i < numbCypher.length(); i ++) {
            cypher.append((char) ((numbCypher.charAt(i) + vowelCtr - 'a') % 26 + 'a'));
        }
        return cypher;
    }

    /**
     * Mengecek apakah parameter hashed merupakan parameter plain yang telah dihash
     * 
     * @param plain  kata sebelum dihash
     * @param hashed kata setelah dihash
     * @return true apabila hashed merupakan plain yang telah dihash
     */
    public static boolean compare(String plain, String hashed) {
        return hash(plain).toString().equals(hashed);
    }
}
