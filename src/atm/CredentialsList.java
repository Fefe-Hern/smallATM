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
public class CredentialsList {
    private static Map<String, Credentials> idList; // = new HashMap<>(999);
    private static File atmData;
    
    public static void start() {
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
    
    public static void read(String key) {
        if(idList.containsKey(key)) {
            Credentials currentAccount = idList.get(key);
            System.out.println(currentAccount.toString());
        }
    }
    
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
    
    public static boolean createNewID(String id, String pin) {
        if(!idList.containsKey(id)) {
            idList.put(id, new Credentials(id, pin));
            return true;
        }
        return false;
    }
}
