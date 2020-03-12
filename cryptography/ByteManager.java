package cryptography;

//Convenience class to:
//* break a byte into nibbles
//* merge the nibbles to reform the byte

class ByteManager 
{
    
    static int[] byteToNibble(int x)
    {   int arr[] = new int[2];
        arr[0] = (x & 255) >> 4;//higher nibble
        arr[1] = x & 15;//lower nibble
        return arr;
    }
    
    static int nibblesToByte(int nibbles[])
    {        return ((nibbles[0]&15)<<4)| (nibbles[1]&15);
    }
}
