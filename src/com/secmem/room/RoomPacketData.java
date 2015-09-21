package com.secmem.room;

import java.io.UnsupportedEncodingException;


public class RoomPacketData {
	public int m_NameLenth;
	public byte[] m_Name;
	public int m_PassLenth;
	public byte[] m_Pass;
	
	public RoomPacketData ( String inName , String inPass ) 
	{
		
		try {
			m_Name = inName.getBytes("KSC5601");
			m_Pass = inPass.getBytes("KSC5601");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		m_NameLenth = m_Name.length;
		m_PassLenth = m_Pass.length;
	}
}
