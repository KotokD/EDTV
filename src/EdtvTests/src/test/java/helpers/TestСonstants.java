package helpers;

import java.util.Random;
import java.util.UUID;

public class TestСonstants {
    public static String emailForLogin="user@ed.tv";
    public static String passwordForLogin="password";
    public static String passwordForRegistration="qwerty123()";
    public static String firstName="TestFirstName";

    public static String genarateUniqueEmail(){
        String randomString= UUID.randomUUID().toString();
        String email=randomString+"@ed.tv";
        return email;
    }
    public static String generateRandomString(int length){
        StringBuilder sb =new StringBuilder();
        Random rand=new Random();
        for(int i=0;i<length;i++){
            int index=rand.nextInt('z'-'a');
            int charIndex = 'a'+index;
            char symbol  = (char)charIndex;
            sb.append(symbol);
        }
        return sb.toString();

    }

}
