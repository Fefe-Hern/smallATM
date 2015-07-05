package atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.HashMap;
import java.util.Map;

/*
    The ATM will start up by checking if ATMData.fer exists. If not, create directory to ATMData.fer
*/
/**
 * The main(hash) handler that saves information to a file, and attempts to retrieve it.
 * <p>
 * If a file (ATMData.fer) is not created at the source, then a new Hashmap will be made.
 * Otherwise, the program will retrieve the file and create the Hashmap from its contents.
 * Afterwards, the Hashmap can be edited, and then saved into the file.
 * 
 * @version %I%
 */
public class CredentialsFile {
    private static Map<String, Credentials> idList;
    private static File atmData;
    
    /**
     * Generate a new HashMap and file ATMData.fer, or find it if one exists.
     */
    public static void loadFile() {
        atmData = new File("ATMData.fer");
        if(atmData.exists()) {
            createHashmap();
        } else {
            try {
                atmData.createNewFile();
                System.out.println("File created at " + atmData.getPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            idList = new HashMap<>(999);
        }
    }
    
    /**
     * Called by <b>CredentialsList.start</b> if file was found.<p>Reads file into idList HashMap.
     */
    private static void createHashmap() {
        try {
            FileInputStream fis = new FileInputStream(atmData);
            ObjectInputStream ois = new ObjectInputStream(fis);
            idList = (HashMap<String, Credentials>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("HashMap not found");
            ex.printStackTrace();
        }
    }
    
    /**
     * If the key field is inside idList HashMap, it will print that field's node to console.
     */
    public static void read(String key) {
        if(idList.containsKey(key)) {
            Credentials currentAccount = idList.get(key);
            System.out.println(currentAccount.toString());
        }
    }
    
    /**
     * Saves the HashMap into file to be called in the future.
     */
    public static void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream(atmData);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(idList);
            oos.close();
            fileOut.close();
        } catch (IOException ex) {
            //Logger.getLogger(CredentialsList.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    /**
     * If the key field doesn't exist, then create the new node in the idList Hashmap.
     */
    public static boolean createNewID(String id, String pin) {
        if(!idList.containsKey(id)) {
            idList.put(id, new Credentials(id, pin));
            return true;
        }
        return false;
    }
    
    /**
     * Searches for the credentials with key field ID, then returns it. Returns null otherwise.
     */
    public static Credentials fetchID(String id) {
        if(idList.containsKey(id)) {
            return idList.get(id).deepCopy();
        }
        return null;
    }
    
    /**
     * If the HashMap contains the ID, replace the value with the specified account's value.
     */
    public static boolean updateID(Credentials account) {
        if(idList.containsKey(account.getId())) {
            idList.put(account.getId(), account);
            return true;
        }
        return false;
    }
    
    /**
     * If the Hashmap contains the ID specified, remove it.
     */
    public static boolean deleteID(Credentials account) {
        if(idList.containsKey(account.getId())) {
            idList.remove(account.getId());
            return true;
        }
        return false;
    }
}
