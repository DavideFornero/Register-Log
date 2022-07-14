package reglog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class RegisterLogin  {
    private String name;
    private String email;
    private String password;    
    private String confirmPassword;
    
    
    public RegisterLogin(String name, String password) {
        this.name = name;        
        this.password = password;
        
    }


    public RegisterLogin(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
		return confirmPassword;
	}
    
    public String getEmail() {
        return email;
    }

   

    public void register(String name, String email, String password, String confirmPassword) {       
        try (BufferedWriter reg = new BufferedWriter(new FileWriter("user.txt",true))){             
        reg.write(name + "," + email + "," + password + "," + confirmPassword + "\n");             					
        System.out.println("User registered successfully!");  
        } catch (IOException e){
        System.out.println("Error writing to file!\n" + e.getMessage());   
        }  
        
    }

    public void login(String name, String password) {
        try (BufferedReader regReader = new BufferedReader(new FileReader("user.txt"))){
        String line;
        while ((line = regReader.readLine()) != null){
        String[] user = line.split(",");
        if (name.equals(user[0]) && password.equals(user[3])){
        System.out.println("Login successful!");
        break;
        }
        }
        if (line == null){
        System.out.println("Login failed!");
        }
        }
        catch (IOException e){
            System.out.println("Error reading from file!\n" + e.getMessage());
        }
    }


	@Override
	public int hashCode() {
		return Objects.hash(confirmPassword, email, name, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterLogin other = (RegisterLogin) obj;
		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}


	

        

    

    
}




    

   
    
   
