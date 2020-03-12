package cryptography;
import java.io.*;

public class Decryptor 
{
    KeyGenerator kGen;
    
    public Decryptor(String key) 
    {
        
        kGen = new KeyGenerator(key);
    }
    
    public void decrypt(String src, String trgt)throws Exception         {
         FileInputStream fin = new FileInputStream(src);
      
        FileOutputStream fout = new FileOutputStream(trgt);
              
        String nK = kGen.getNumericKey();
         
        ArmstrongManager aManager = new ArmstrongManager(nK);

        ColorManager cManager = new ColorManager(nK);
        
        //byte buffer[] = new byte[2048];
        int n, i;
        int temp;
        
        while((n = fin.read()) != -1)
        {
            //process the buffer
            //for (i =0 ; i < n; i++)
            //{
                temp = cManager.decrypt(n);
                temp = aManager.decrypt(temp);
                //buffer[i] = (byte)temp;
                fout.write(temp);
            //}
           
            //fout.write(buffer, 0, n);
        }
        
 
        fin.close();
        fout.close();
        
    }
}
