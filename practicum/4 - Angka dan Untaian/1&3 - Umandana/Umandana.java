public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
    public static String toUmandana(String words) {
        String umandana = "";
        int i = 0;
        while(i < words.length()) {
            if(!Character.isLetter(words.charAt(i))) {
                umandana += words.charAt(i);
            }
            else if(words.charAt(i) == 'a') {
                umandana += "aiden";
            }
            else if(words.charAt(i) == 'i') {
                umandana += "ipri";
            }
            else if(words.charAt(i) == 'u') {
                umandana += "upru";
            }
            else if(words.charAt(i) == 'e') {
                umandana += "epre";
            }
            else if(words.charAt(i) == 'o') {
                umandana += "opro";
            }
            else if(words.charAt(i) == 'n') {
                if(i + 1 < words.length()) {
                    if(words.charAt(i + 1) == 'g') {
                        if(i + 2 < words.length()) {
                            if(isVowel(words.charAt(i + 2))) {
                                umandana += "ng";
                            }
                            else {
                                umandana += "strengen";
                            }
                        }
                        else {
                            umandana += "strengen";
                        }
                        i ++;
                    }
                    else if(words.charAt(i + 1) == 'y') {
                        umandana += "ny";
                        i ++;
                    }
                    else if(isVowel(words.charAt(i + 1))) {
                        umandana += "n";
                    }
                    else {
                        umandana += "nes";
                    }
                }
                else {
                    umandana += "nes";
                }
            }
            else {
                if(i + 1 < words.length()) {
                    if(isVowel(words.charAt(i + 1))) {
                        umandana += words.charAt(i);
                    }
                    else {
                        umandana += words.charAt(i) + "es";
                    }
                }
                else {
                    umandana += words.charAt(i) + "es";
                }
            }
            i ++;
        }
        return umandana;
    }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        String normal = new String(words);
        normal = normal.replaceAll("aiden", "a");
        normal = normal.replaceAll("ipri", "i");
        normal = normal.replaceAll("upru", "u");
        normal = normal.replaceAll("epre", "e");
        normal = normal.replaceAll("opro", "o");
        normal = normal.replaceAll("strengen", "ng");
        normal = normal.replaceAll("([^aiueo])es", "$1");
        return normal;
    }

    public static boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'i':
            case 'u':
            case 'e':
            case 'o':
                return true;
            default:
                return false;
        }
    }

}