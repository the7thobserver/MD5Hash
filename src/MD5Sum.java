import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Sum {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        Path fileLocation = Paths.get("<file_path>");
        byte[] data = Files.readAllBytes(fileLocation.toAbsolutePath());

        byte[] digest = md.digest(data);

        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }

        System.out.println(hashtext.toUpperCase());
    }
}
