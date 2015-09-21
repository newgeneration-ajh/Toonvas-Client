package com.secmem.objecthandle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.secmem.network.ServerInfo;
import com.secmem.packet.PacketData;
import com.secmem.packet.PacketType;
import com.secmem.type.typeConversion;

public class ObjectConvert {
	
	public static PacketData ObjectToPakcetData ( ObjectData inData )
	{if ( inData == null)
		{
			return null;
		}
		
		PacketData outData = null;
		ByteBuffer tmpBuffer = null;
		byte[] tmpByte = new byte [ PacketType.LENTH_OBJECT ];
		tmpBuffer = ByteBuffer.allocate( PacketType.LENTH_OBJECT);
		
		tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );

		tmpBuffer.put( typeConversion.getBytes( inData.m_AxisX ) );
		tmpBuffer.put( typeConversion.getBytes( inData.m_AxisY ) );
		tmpBuffer.put( typeConversion.getBytes( inData.m_Pressure ) );
		tmpBuffer.put( typeConversion.getByte( inData.m_PointSize ) );
		tmpBuffer.put( typeConversion.getByte( inData.m_Color ) );
		tmpBuffer.put( typeConversion.getByte( inData.m_LayerNum) );
		
		tmpBuffer.flip();
		
		tmpByte = tmpBuffer.array();
		
		outData = new PacketData( PacketType.REQ_SENDOBJECT , tmpByte , ServerInfo.LENTHCODE_LENTH);
		return outData;
		
	}
	
	public static ObjectData PacketDataToObject ( PacketData inData )
	{
		if ( inData == null )
		{
			return null;
		}
		
		ObjectData tmpData = null;

		
		tmpData = new ObjectData( typeConversion.getFloat( inData.m_tmpByte , 0 ), 
										   typeConversion.getFloat( inData.m_tmpByte , 4 ), 
										   typeConversion.getFloat( inData.m_tmpByte , 8 ), 
										   typeConversion.getInt( inData.m_tmpByte , 12 ), 
										   typeConversion.getInt( inData.m_tmpByte , 16 ), 
										   typeConversion.getInt( inData.m_tmpByte , 20 ), 0);
		
		return tmpData;
	}
}
