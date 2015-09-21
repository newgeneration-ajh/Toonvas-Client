package com.secmem.room;

import java.io.UnsupportedEncodingException;

import android.os.Bundle;

public class WaitRoomListData {
	public String m_Name[] = new String[2];
	
	public WaitRoomListData ( Bundle inBundle ) {
		
		String tmpString[] = new String[2];
		
		byte[] inData = inBundle.getByteArray("msgdata");
		try {
			tmpString[0] = new String( inData , 0 , 100 , "KSC5601" );
			m_Name[0] = tmpString[0].trim();
			tmpString[1] = new String( inData , 100 , 100 , "KSC5601" );
			m_Name[1] = tmpString[1].trim();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
