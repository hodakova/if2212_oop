import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = scanner.nextLine().split(" ");
        for(int i = 0; i < n; i ++) {
            strings[i] = charSort(strings[i]);
        }
        Arrays.sort(strings);
        int ctr = 0;
        String kata = "";
        for(int i = 0; i < n; i ++) {
            if(!strings[i].equals(kata)) {
                ctr ++;
                kata = strings[i];
            }
        }
        System.out.println(ctr);
        scanner.close();
    }
    public static String charSort(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}