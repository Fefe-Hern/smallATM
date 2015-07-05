package atm;
public class Tester {
    public static void main(String[] args) {
        //Read a file
        CredentialsFile.loadFile();
        CredentialsFile.read("1121");
        Login.createLoginArea();
    }
}
