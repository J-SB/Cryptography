package cryptography;
import java.io.*;

public class Encryptor 
{
    KeyGenerator kGen;
    
    public Encryptor(String key) 
    {
        
        kGen = new KeyGenerator(key);
    }
    
    public void encrypt(String src, String trgt)throws Exception
      {
        FileInputStream fin = new FileInputStream(src);
        
        FileOutputStream fout = new FileOutputStream(trgt);
        
        String nK = kGen.getNumericKey();
        //for level 1 of encryption
        ArmstrongManager aManager = new ArmstrongManager(nK);
        //for level 2 of encryption
        ColorManager cManager = new ColorManager(nK);
        
        byte buffer[] = new byte[2048];
        int n, i;
        int temp;
        
        while((n = fin.read()) != -1)
        {
            //process the buffer
            //for (i =0 ; i < n; i++)
            //{
                temp = aManager.encrypt(n & 0xFF);
                temp = cManager.encrypt(temp);
                //buffer[i] = (byte)temp;
                fout.write(temp);
            //}
            //write into the result
            //fout.write(buffer, 0, n);
        }
        
        
        fin.close();
        fout.close();
        
    }
}
