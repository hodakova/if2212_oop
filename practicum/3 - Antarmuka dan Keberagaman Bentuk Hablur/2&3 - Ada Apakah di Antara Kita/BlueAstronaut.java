import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Atribut jumlah task yang harus diselesaikan (integer)
    // YOUR CODE HERE
    private int numTasks;

    // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
    // YOUR CODE HERE
    private int taskSpeed;

    // Atribut untuk mengecek apakah task sudah selesai pertama kali
    // YOUR CODE HERE
    private boolean hasCompletedTasks = false;

    // Atribut DEFAULT_NUM_TASKS bertipe data int dengan nilai 6
    // YOUR CODE HERE
    private static final int DEFAULT_NUM_TASKS = 6;
    
    // Atribut DEFAULT_TASK_SPEED bertipe data int dengan nilai 10
    // YOUR CODE HERE
    private static final int DEFAULT_TASK_SPEED = 10;

    public BlueAstronaut(String name) {
        // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, dan DEFAULT_TASK_SPEED
        // YOUR CODE HERE
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        // Panggil constructor dari superclass dengan parameter name dan susLevel
        // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
        // YOUR CODE HERE
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    /*

    */
    public void emergencyMeeting() {
        // YOUR CODE HERE 
        if(!isFrozen()) {
            boolean kick = false;
            int susLevel = 0;
            int idPlayer = 0;
            for(int i = 0; i < getPlayers().length; i ++) {
                if(!(getPlayers()[i].isFrozen())) {
                    if(getPlayers()[i].getSusLevel() > susLevel) {
                        kick = true;
                        susLevel = getPlayers()[i].getSusLevel();
                        idPlayer = i;
                    }
                    else if(getPlayers()[i].getSusLevel() == susLevel) {
                        kick = false;
                    }
                }
            }
            if(kick) {
                getPlayers()[idPlayer].setFrozen(true);
            }
            gameOver();
        }
    }

    /*
        * BlueAstronaut yang frozen tidak dapat menyelesaikan tugas.
        * Jika taskSpeed lebih besar dari 20, kurangi numTasks sebanyak 2. Jika tidak, kurangi 1 dari numTasks.
            * Jika numTasks turun di bawah 0, tetapkan menjadi 0
        * Setelah BlueAstronaut selesai dengan tugas mereka, yang berarti numTasks sama dengan 0 (hanya untuk pertama kali),
            * Cetak `"I have completed all my tasks"`
            * Kemudian kurangi susLevel BlueAstronaut sebesar 50% (dibulatkan ke bawah)
        * Tidak mengembalikan apapun.
    */
    public void completeTask() {
        // YOUR CODE HERE
        if(!isFrozen()) {
            if(taskSpeed > 20) {
                numTasks -= 2;
            }
            else {
                numTasks -= 1;
            }
            if(numTasks < 0) {
                numTasks = 0;
            }
            if(numTasks == 0 && !hasCompletedTasks) {
                hasCompletedTasks = true;
                System.out.println("I have completed all my tasks");
                setSusLevel((int) (getSusLevel() * .5));
            }
        }
    }

    /*
        * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen, susLevel, numTasks, dan taskSpeed
        * Mengembalikan sebuah boolean.
    */
    public boolean equals(Object o) {
        // YOUR CODE HERE
        if(o instanceof BlueAstronaut) {
            BlueAstronaut b = (BlueAstronaut) o;
            return super.equals(o) && numTasks == b.numTasks && taskSpeed == b.taskSpeed;
        }
        return false;
    }

    /*
        Mengembalikan String yang menggambarkan BlueAstronaut sebagai berikut:
        * `"My name is [name], and I have a `susLevel` of [susLevel]. I am currently (frozen / not frozen). I have [numTasks] left over."`
            * Jika susLevel lebih besar dari 15, kembalikan keluaran dalam huruf kapital semua. (Hint: toUppercase)
            * (Note: gantikan nilai dalam tanda kurung [] dengan nilai sebenarnya)
        * Anda harus menggunakan metode toString() dari kelas Player.
    */
    public String toString() {
        // YOUR CODE HERE
        String out = super.toString() + " I have " + numTasks + " left over.";
        if(getSusLevel() <= 15) {
            return out;
        }
        else {
            return out.toUpperCase();
        }
    }
}
