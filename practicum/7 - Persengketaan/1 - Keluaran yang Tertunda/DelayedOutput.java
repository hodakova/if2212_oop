/**
 * DelayedOutput.java 
 * [Keluaran yang Tertunda]
 * @author [18222082] [Ahmad Habibie Marjam]
 */
public class DelayedOutput {
    public static void printDelayed(int delayMillisec, String output) {
        // TODO print output setelah di delay selama delayMillisec
        // PENTING: gunakan threading agar tidak blocking
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(delayMillisec);
                    System.out.println(output);
                }
                catch(InterruptedException e) {}
            }
        });
        thread.start();
    }
}