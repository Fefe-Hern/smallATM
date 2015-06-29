package atm;
public class Tester {
    public static void main(String[] args) {
        //Read a file
        CredentialsList.loadFile();
        CredentialsList.read("1121");
        Login.createLoginArea();
    }
}
