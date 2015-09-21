package com.secmem.room;

import java.io.UnsupportedEncodingException;

import android.os.Bundle;

import com.secmem.type.typeConversion;

public class RoomListData {
	public String m_Name = null;
	public String m_Master = null;
	public int m_roomNum = 0;
	public int m_roomLength = 0;
	public int m_inerNum = 0;
	
	public RoomListData ( Bundle inBundle ) {
		byte[] inData = inBundle.getByteArray("msgdata");
		m_roomNum = typeConversion.getInt( inData, 0 );
		m_roomLength = typeConversion.getInt ( inData, 4 );
		try {
			m_Name = new String( inData , 8 , m_roomLength , "KSC5601" );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m_roomLength = typeConversion.getInt( inData , 8+m_roomLength );
		
	} 
}
