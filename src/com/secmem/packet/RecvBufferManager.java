package com.secmem.packet;

import android.os.Bundle;
import android.os.Message;

import com.secmem.canvasdrawing.StrokeData;

public class RecvBufferManager {
	private Message m_tmpMessage = new Message();
	private StrokeData m_StrokeData = new StrokeData();
	private int m_ObjectCnt = 0;
	
	public RecvBufferManager ( )
	{
		
	}
	
	public void RecvBufferData ( PacketData inData )
	{
		synchronized ( inData ) {
			Bundle tmpBundle = new Bundle();
			m_tmpMessage.what = inData.m_opCode;
			
			if ( inData.m_opCode == PacketType.RET_PEN_UP )
			{
				m_StrokeData = new StrokeData();
				m_StrokeData.setBytes(inData.m_tmpByte);
				m_tmpMessage.obj = m_StrokeData.getStrokeObject();
			}
			
			else if ( inData.m_opCode == PacketType.RET_OBJECT_START )
			{
				m_StrokeData.setBytesInfo(inData.m_tmpByte);
			}
			
			else if ( inData.m_opCode == PacketType.RET_OBJECT_DATA )
			{
				m_StrokeData.setBytes(inData.m_tmpByte, m_ObjectCnt );
				m_ObjectCnt++;
			}
			
			else if ( inData.m_opCode == PacketType.RET_OBJECT_END )
			{
				m_StrokeData.setPoints();
				m_tmpMessage.obj = m_StrokeData.getStrokeObject();
				m_ObjectCnt = 0;
			}
			else
			{
				tmpBundle.putByteArray("msgdata", inData.m_tmpByte);
				m_tmpMessage.setData(tmpBundle);
			}
		}
		
	}
	
	public Message getMessage ( Message tmpMessage ) 
	{
		tmpMessage.what = m_tmpMessage.what;
		if( m_tmpMessage.what == PacketType.RET_OBJECT_END )
		{
			tmpMessage.obj = m_tmpMessage.obj;
		}
		
		else
		{
			tmpMessage.setData( m_tmpMessage.getData() );
		}
		return tmpMessage;
	}
	
}
