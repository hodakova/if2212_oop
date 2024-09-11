import java.util.Scanner;
import java.lang.System;

public class GameSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = Integer.parseInt(scanner.nextLine());
        String seeker = scanner.nextLine();
        HideNSeek hidenseek = new HideNSeek(seeker, p);

        System.out.printf("Game dimulai dengan %d", hidenseek.getPlayer());
        System.out.println(" pemain, seeker adalah " + hidenseek.getSeeker());
        
        int x = 1;
        int y;
        while(x<p) {
            y = Integer.parseInt(scanner.nextLine());
            if(x == y) {
                hidenseek.foundPlayer();
                System.out.printf("%d Pemain ditemukan\n", hidenseek.getPlayerFound());
                x++;
            }
        }

        System.out.print("Semua pemain telah ditemukan, permainan selesai.\n");
        scanner.close();
    }
}
