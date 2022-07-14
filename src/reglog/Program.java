package reglog;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);		
		RegisterLogin registerLogin;

		Scanner sc = new Scanner(System.in);

		Character option;
		do{
			System.out.println("Do you want to register or login? (r/l)");
			option = sc.next().toUpperCase().charAt(0);
		} while (option != 'R' && option != 'L');

		

		if (option == 'R'){			
		System.out.println("Enter your Username:");
		String name = sc.next();
		System.out.println("Enter your email:");
		String email = sc.next();
		String password;
		String confirmPassword;
		do {
		System.out.println("Enter your password:");
		password = sc.next();
		System.out.println("Confirm your password:");
		confirmPassword = sc.next();
		} while (!password.equals(confirmPassword));
		registerLogin = new RegisterLogin(name, email, password, confirmPassword);
		registerLogin.register(name, email, password, confirmPassword);
		
				
				
		} else {
			System.out.println("Enter your Username:");
			String name = sc.next();
			System.out.println("Enter your password:");
			String password = sc.next();
			registerLogin = new RegisterLogin(name, password);
			registerLogin.login(name, password);
		}

		
		


		sc.close();
	}

}
