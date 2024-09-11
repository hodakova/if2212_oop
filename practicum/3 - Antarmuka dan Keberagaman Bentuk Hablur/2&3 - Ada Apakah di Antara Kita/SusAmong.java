import java.util.Scanner;

public class SusAmong {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int nPlayers = scanner.nextInt();
        int nImpostors = scanner.nextInt();
        
        for(int i = 1; i <= nImpostors; i ++) {
            new RedAstronaut("Crewmate " + i );
        }
        for(int i = 1 + nImpostors; i <= nPlayers; i ++) {
            new BlueAstronaut("Crewmate " + i);
        }

        /*
        int impostorCount = 0, crewmateCount = 0;
        for(Player p : Player.getPlayers()) {
            if (p instanceof Impostor && !p.isFrozen()) {
                impostorCount++;
            } else if (p instanceof Crewmate && !p.isFrozen()) {
                crewmateCount++;
            }
        }
        System.out.println("Impostor: " + impostorCount);
        System.out.println("Crewmates: " + crewmateCount);
        */

        int taskCompleted = 0;
        int playersFrozen = 0;
        int emergencyMeetingCalled = 0;
        int commands;
        
        while(true) {
            commands = scanner.nextInt();
            
            if(commands == 1) {
                int idPlayer = scanner.nextInt();
                
                if(Player.getPlayers()[idPlayer] instanceof BlueAstronaut) {
                    BlueAstronaut b = (BlueAstronaut) Player.getPlayers()[idPlayer];
                    b.completeTask();
                    taskCompleted ++;
                }
            }
            else if(commands == 2) {
                int idImpostor = scanner.nextInt();
            
                if(Player.getPlayers()[idImpostor] instanceof Impostor) {
                    int idPlayer = scanner.nextInt();
                    ((RedAstronaut) Player.getPlayers()[idImpostor]).freeze(Player.getPlayers()[idPlayer]);
                    playersFrozen ++;
                }
            }
            else if(commands == 3) {
                for(Player p : Player.getPlayers()) {
                    p.emergencyMeeting();
                }
                emergencyMeetingCalled ++;
            }
            else if(commands == 4) {
                break;
            }
            if(Player.getPlayers()[0].gameOver()) {
                break;
            }
        }
        /*
        impostorCount = 0; crewmateCount = 0;
        for(Player p : Player.getPlayers()) {
            if (p instanceof Impostor && !p.isFrozen()) {
                impostorCount++;
            } else if (p instanceof Crewmate && !p.isFrozen()) {
                crewmateCount++;
            }
        }
        System.out.println("Impostor: " + impostorCount);
        System.out.println("Crewmates: " + crewmateCount);
        */

        System.out.println("Task completed: " + taskCompleted);
        System.out.println("Players frozen: " + playersFrozen);
        System.out.println("Emergency meetings called: " + emergencyMeetingCalled);
        System.out.println("Game Over. Thanks for playing!");
        
        scanner.close();
    }
}