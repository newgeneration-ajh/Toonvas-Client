package com.secmem.room;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.secmem.packet.PacketData;
import com.secmem.packet.PacketType;
import com.secmem.type.typeConversion;

public class RoomBufferManager {
	
	private PacketData m_PacketData = null;
	
	public RoomBufferManager ( RoomPacketData inData )
	{
		ByteBuffer tmpBuffer = null;
		byte[] tmpByte = null;
		
		tmpByte = new byte[ inData.m_NameLenth + inData.m_PassLenth + 8];
		
		tmpBuffer = ByteBuffer.allocate( tmpByte.length );
		
		tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		tmpBuffer.put( typeConversion.getByte( inData.m_NameLenth) );
		tmpBuffer.put( inData.m_Name);
		tmpBuffer.put( typeConversion.getByte(inData.m_PassLenth) );
		tmpBuffer.put( inData.m_Pass );
		
		tmpBuffer.flip();
		
		tmpByte = tmpBuffer.array();
		
		m_PacketData = new PacketData ( PacketType.REQ_CREATEROOM , tmpByte , tmpByte.length );
	}
	
	public PacketData getRoomBuffer ( ) {
		return m_PacketData;
	}
	
}
