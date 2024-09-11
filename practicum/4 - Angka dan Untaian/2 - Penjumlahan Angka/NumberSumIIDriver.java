import java.util.Scanner;

public class NumberSumIIDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n : ");
        int n = Integer.parseInt(scanner.nextLine());
        Number[] numArr = new Number[n];
        for(int i = 0; i < n; i ++) {
            System.out.printf("numArr[%d] : ", i);
            String stringArr[] = scanner.nextLine().toLowerCase().split(" ");
            if(stringArr[0].equals("byte") || stringArr[0].equals("b")) {
                numArr[i] = Byte.parseByte(stringArr[1]);
            }
            else if(stringArr[0].equals("integer") || stringArr[0].equals("int") || stringArr[0].equals("i")) {
                numArr[i] = Integer.parseInt(stringArr[1]);
            }
            else if(stringArr[0].equals("double") || stringArr[0].equals("d")) {
                numArr[i] = Double.parseDouble(stringArr[1]);
            }
            else if(stringArr[0].equals("float") || stringArr[0].equals("f")) {
                numArr[i] = Float.parseFloat(stringArr[1]);
            }
            else if(stringArr[0].equals("short") || stringArr[0].equals("S")) {
                numArr[i] = Short.parseShort(stringArr[1]);
            }
            else if(stringArr[0].equals("long") || stringArr[0].equals("l")) {
                numArr[i] = Long.parseLong(stringArr[1]);
            }
        }
        NumberSumII numberSumII = new NumberSumII();
        System.out.println("NumberSumII : " + numberSumII.sumNumberII(numArr));
        scanner.close();
    }
}
