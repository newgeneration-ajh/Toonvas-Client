package com.secmem.packet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class BitmapRecvThread {
	private byte[] m_inFileByte = null;
	private HashMap<String, FileOutputStream> m_StreamHash = new HashMap<String, FileOutputStream>();
	private String m_CahcePath = new String ("/sdcard/Toonvascache/inFile");
	
	public BitmapRecvThread ( int otherSocket , int otherObjectId )
	{
		try {
			FileOutputStream tmpFileOutputStream = new FileOutputStream( m_CahcePath + Integer.toString(otherSocket) + 
					Integer.toString(otherObjectId) + ".bmp" );
			m_StreamHash.put(Integer.toString(otherSocket)+Integer.toString(otherObjectId), tmpFileOutputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public  void setFileBytes ( byte[] in , int otherSocket , int otherObjectId )
	{
		m_inFileByte = in;
		try {
			m_StreamHash.get(Integer.toString(otherSocket)+Integer.toString(otherObjectId)).write(m_inFileByte);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setFilePath ( int otherSocket , int otherObjectId )
	{
		try {
			FileOutputStream tmpFileOutputStream = new FileOutputStream( m_CahcePath + Integer.toString(otherSocket) + 
					Integer.toString(otherObjectId) + ".bmp" );
			m_StreamHash.put(Integer.toString(otherSocket)+Integer.toString(otherObjectId), tmpFileOutputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void closeFile ( int otherSocket , int otherObjectId )
	{
		try {
			m_StreamHash.get(Integer.toString(otherSocket)+Integer.toString(otherObjectId)).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
