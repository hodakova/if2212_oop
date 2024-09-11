import java.util.*;

class MyQueue {
    // Definisi variabel penggunaan stack
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    // Konstruktor
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    // Menambah elemen x ke belakang Queue
    public void push(int x) {
        s1.push(x);
    }

    // Menghapus elemen dari depan Queue dan mengembalikan elemen tersebut
    public int pop() {
        /* 1 2 3 4 5, -
         * -, 5 4 3 2
         * 2 3 4 5
         */
        int x = 0;
        while(!s1.isEmpty()) {
            x = s1.pop();
            if(!s1.isEmpty()) {
                s2.push(x);
            }
        }
        int y;
        while(!s2.isEmpty()) {
            y = s2.pop();
            s1.push(y);
        }
        return x;
    }

    // Mengembalikan elemen depan Queue
    public int peek() {
        int x = 0;
        while(!s1.isEmpty()) {
            x = s1.pop();
            s2.push(x);
        }
        int y;
        while(!s2.isEmpty()) {
            y = s2.pop();
            s1.push(y);
        }
        return x;
    }

    // Mengembalikan apakah Queue kosong (true) atau tidak (false)
    public boolean empty() {
        return s1.isEmpty();
    }
}
