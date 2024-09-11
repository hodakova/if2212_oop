import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            Email email = new Email(scan.nextLine());
            scan.close();

            if(email.validateEmail()) {
                System.out.println("true");
                System.out.println("Email validated.");
            }
        } catch (InvalidEmailException e) {
            System.out.println("InvalidEmailException! " + e.getMessage());
            System.out.println("Email string error!");
        } catch (InvalidDomainException e) {
            System.out.println("InvalidDomainException! " + e.getMessage());
            System.out.println("Email string error!");
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println("Email string error!");
        } finally {
            System.out.println("Operation finished.");
        }
    }
}
