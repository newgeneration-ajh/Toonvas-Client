package com.secmem.canvasdrawing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import android.os.Bundle;

import com.secmem.packet.PacketData;
import com.secmem.packet.PacketType;

public class DranwingManager {
	public static PacketData getPacket ( DrawingData inData , String inRoomNum )
	{
		ByteBuffer tmpBuffer = ByteBuffer.allocate(16);
		byte[] tmpByte = null;
		PacketData tmpData = null;
		
		tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
		tmpBuffer.putInt(Integer.parseInt(inRoomNum));
		tmpBuffer.putFloat(inData.m_pointX);
		tmpBuffer.putFloat(inData.m_pointY);
		tmpBuffer.putFloat(inData.m_pressure);
		
		tmpBuffer.flip();
		
		tmpByte = tmpBuffer.array();
		
		tmpData = new  PacketData(PacketType.REQ_SENDOBJECT, tmpByte, 16);
		
		return tmpData;
	}
	
	public static byte[] setBundle ( Bundle inData )
	{
		return inData.getByteArray("msgdata");
	}
}
