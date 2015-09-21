package com.secmem.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class typeConversion {
	public static float getFloat ( byte[] arr, int start  ) {
		int i = 0;
		int len = 4;
		int cnt = 0;
		byte[] tmp = new byte[len];
		
		for ( i = start ; i < ( start + len ) ; i++ )
		{
			tmp[cnt] = arr[i];
			cnt++;
		}
		
		int accum = 0;
		i = 0;
		
		for ( int shiftByte = 0 ; shiftByte < 32 ; shiftByte += 8 ){
			accum |= ( ( long ) ( tmp[i] & 0xff ) ) << shiftByte;
			i++;
		}
		return Float.intBitsToFloat(accum);
	}
	
	public static int getInt ( byte[] src , int start ) {
		
		int s1 = src[0+start] & 0xFF;
		int s2 = src[1+start] & 0xFF;
		int s3 = src[2+start] & 0xFF;
		int s4 = src[3+start] & 0xFF;
	    
	 return ((s4 << 24) + (s3 << 16) + (s2 << 8) + (s1 << 0));
	
	}
	
	public static byte[] getBytes(float value) {
	       
        byte[] array = new byte[4];
       
        int intBits=Float.floatToIntBits(value);
       
        array[0]=(byte)((intBits&0x000000ff)>>0);
        array[1]=(byte)((intBits&0x0000ff00)>>8);
        array[2]=(byte)((intBits&0x00ff0000)>>16);
        array[3]=(byte)((intBits&0xff000000)>>24);
       
        return array;
	}
	
	public static byte[] getByte ( int nVal ) {
		byte[] numberVal = new byte[4];
		
		numberVal[0] = (byte)((nVal)&0xff);
		numberVal[1] = (byte)((nVal>>8)&0xff);
		numberVal[2] = (byte)((nVal>>16)&0xff);
		numberVal[3] = (byte)((nVal>>24)&0xff);
		
		return numberVal;
	}
	
	public static byte[] getByte ( Object inObj ) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(bos);
			try {
				out.writeObject(inObj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		byte[] tmpBytes = bos.toByteArray(); 
		
		return tmpBytes;
	}
	
}
