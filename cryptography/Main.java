package cryptography;

public class Main 
{
   
    public static void main(String[] args) 
    {
        
        try
        {
            String src = "d:/images/kids.jpg";
            String enc = "d:/images/e_kids.jpg";
            String dec = "d:/images/d_kids.jpg";

            String key = "How old is my computer?";

            Encryptor objEnc = new Encryptor(key);
            Decryptor objDec = new Decryptor(key);

            objEnc.encrypt(src, enc);
            System.out.println("Encryption Done");
            
            objDec.decrypt(enc, dec);
            System.out.println("Decryption Done");
        

        }
        catch(Exception ex)
        {
            System.out.println("Err: " +ex.getMessage());
        }
    }
    
}
