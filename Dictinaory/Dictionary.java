import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;


public class Dictionary {
    private static boolean modified = false;
    private static String dictionaryFile = System.getProperty("user.dir")+"/doctionary.ser";
    public static boolean isModified(){
        return modified;
    }
    private static String message = "";
    public static String getMessage(){
        return message;
    }
    public static void setMessage(String message){
        message = message;
    }
    public static TreeMap<String,String> words = new TreeMap();
    public static TreeMap<String ,String> getWords(){
        return words;
    }
    public static void setWords(TreeMap<String,String> words){
        words = words;
        modified = true;
    }
    public static String searchWord(String word){
        return (String)words.get(word);
    }
    public static void addWord(String word,String meaning){
        words.put(word, meaning);
        modified = true;
    }
    public static boolean deleteWord(String word){
        Object done = words.remove(word);
        if(done == null){
            return  false;
        }
        modified = true;
        return true;
    }
    public static boolean saveToDisk(){
        try{
            System.out.println(dictionaryFile);
            FileOutputStream fs = new FileOutputStream(dictionaryFile);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(words);
            os.close();
            fs.close();
            modified = false;
            return true;
        }
        catch(Exception ex){
            message = ex.getMessage();
        }
        return false;
    }
    public static boolean loadFromDisk(){
        try{
            FileInputStream fs = new FileInputStream(dictionaryFile);
            ObjectInputStream is = new ObjectInputStream(fs);
            words = (TreeMap)is.readObject();
            is.close();
            fs.close();
            modified = false;
            return true;
        }
        catch(Exception ex){
            message = ex.getMessage();
        }
        return false;
    }
}
