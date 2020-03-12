package cryptography;

/*
Uses the permutation and combination of armsrtong 
numbers to generate a numeric key from string input.
*/

class KeyGenerator 
{
     
    private static int armstrongNumbers[]= {153, 370, 371, 407};
    private static int baseTable[]= {1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431, 3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321};
    
    
    private String key, numericKey;
    
    KeyGenerator(String k) 
    {
        this.key = k;
        this.numericKey = "";
    }
    
    String getNumericKey()
    {
        if(numericKey.equals(""))
            generateNumericKey();
        
        return numericKey;
    }
    
    private void generateNumericKey()
    {        
        int tot = 0;
        int l, i;
        l = key.length();
        for(i =0; i < l; i++)
        {            
            tot += key.charAt(i);
            
        }
               
        int permutation = baseTable[tot % baseTable.length];
        
        
        String temp= "";
         
         while(permutation > 0)
        {
            temp =  armstrongNumbers[permutation % 10 -1] + temp;
            permutation /= 10; 
        }
        //numericKey = partA+partB
        numericKey = temp + tot;
    }
    
    void display()
    {
        System.out.println("key " + key);
        System.out.println("numeric key " + numericKey);
    }
}
