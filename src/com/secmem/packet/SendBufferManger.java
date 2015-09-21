package com.secmem.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class SendBufferManger {
	
	private final int FIXED_LENTH = 8;
	
	private byte[] m_tmpByte = null;
	
	public SendBufferManger ( PacketData inData )
	{
		m_tmpByte = new byte[ FIXED_LENTH + inData.m_lengTh ];
		
		ByteBuffer tmpByteBuffer = ByteBuffer.allocate( inData.m_lengTh );
		
		tmpByteBuffer.order( ByteOrder.LITTLE_ENDIAN );
		
		tmpByteBuffer.putInt( inData.m_opCode );
		tmpByteBuffer.putInt( inData.m_lengTh );
		if ( tmpByteBuffer != null )
		{
			if ( inData.m_tmpByte != null )
			{
				tmpByteBuffer.put( inData.m_tmpByte , 0 , inData.m_lengTh - 8 );
		
			}
		}
		
		tmpByteBuffer.flip();
		
		m_tmpByte = tmpByteBuffer.array();
		
	}
	
	public byte[] getByte ( )
	{
		return m_tmpByte;
	}
	
}
