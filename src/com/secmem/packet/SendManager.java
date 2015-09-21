package com.secmem.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Queue;

import android.os.storage.StorageManager;
import android.util.Log;

import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.secmem.canvasdrawing.StrokeData;

public class SendManager {
	private static Queue<PacketData> m_SendQueue = new LinkedList<PacketData>();
	private static ByteBuffer m_Buffer = ByteBuffer.allocateDirect(9000);
	private static byte[] m_roomBytes;
	
	
	public synchronized static void pushQueue ( PacketData inSend ) {
		synchronized (m_SendQueue) {
			m_SendQueue.offer( inSend );
		}
		
	}
	
	public synchronized static void pushQueue ( SpenObjectStroke inStroke , int inRoom )
	{
		PacketData startData = new PacketData ( PacketType.REQ_OBJECT_START , null , 0 );
		PacketData endData = new PacketData ( PacketType.REQ_OBJECT_END , null , 0 );
		StrokeData tmpStrokeData = new StrokeData ( inStroke );
		int dividePacket = 0;
		
		byte tmpBytes[] = tmpStrokeData.getObjetInfo();
		
		if ( tmpBytes == null )
			return;
		
		ByteBuffer tmpBuffer = ByteBuffer.allocate( tmpBytes.length + 4);
		tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
		
		tmpBuffer.putInt( inRoom );
		tmpBuffer.put( tmpBytes );
		
		tmpBuffer.flip();
		
		startData.m_tmpByte = tmpBuffer.array();
		startData.m_lengTh = startData.m_tmpByte.length + 8;
		
		int ArraySize = tmpStrokeData.getStrokeArray().length;
		
		dividePacket = ArraySize / 4000 + 1;
		
		ByteBuffer tmpStrokeArrayBuffer = ByteBuffer.allocate(ArraySize);
		
		PacketData strokeData[] = new PacketData[dividePacket];
		
		tmpStrokeArrayBuffer.put( tmpStrokeData.getStrokeArray() );
		
		byte tmpStrokeArray[];
		
		for ( int i = 0 ; i < dividePacket ; i++ )
		{
			tmpStrokeArray = null;
			
			strokeData[i] = new PacketData ( PacketType.REQ_OBJECT_DATA , null , 0 );
			if ( dividePacket - 1 == i )
			{
				int dataSize =  ArraySize % 4000;
				
				strokeData[i].m_tmpByte = new byte[dataSize + 4];
				
				tmpBuffer = ByteBuffer.allocate( dataSize + 4 );
				
				tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
				
				tmpBuffer.putInt( inRoom );
				
				tmpStrokeArray = new byte[dataSize];
				
				tmpStrokeArrayBuffer.position(i*4000);
				
				tmpStrokeArrayBuffer.get(tmpStrokeArray, 0 , dataSize );
				
				tmpBuffer.put( tmpStrokeArray );
				
				tmpBuffer.flip();
				
				tmpBuffer.get( strokeData[i].m_tmpByte );
				
				tmpBuffer.clear();
				
				strokeData[i].m_lengTh = strokeData[i].m_tmpByte.length + 8;
			}
			else
			{
				strokeData[i].m_tmpByte = new byte[4004];
				
				tmpBuffer = ByteBuffer.allocate(4004);
				
				tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
				
				tmpBuffer.putInt( inRoom );
				
				tmpStrokeArray = new byte[4000];
				
				tmpStrokeArrayBuffer.position(i*4000);
				
				tmpStrokeArrayBuffer.get(tmpStrokeArray, 0 , 4000 );
				
				tmpBuffer.put( tmpStrokeArray );
				
				tmpBuffer.flip();
				
				tmpBuffer.get( strokeData[i].m_tmpByte );
				
				tmpBuffer.clear();
				
				strokeData[i].m_lengTh = strokeData[i].m_tmpByte.length + 8;
				
			}
		}
		
		synchronized (m_SendQueue) {
			m_SendQueue.offer( startData );
			for ( int i = 0 ; i < dividePacket ; i ++ )
			{
				m_SendQueue.offer(strokeData[i]);
			}
			m_SendQueue.offer( endData );
		}
		
	}
	
	public synchronized static void pushQueue ( SpenObjectStroke inStroke , int inRoom , int inTool )
	{
		PacketData startData = new PacketData ( PacketType.REQ_OBJECT_START , null , 0 );
		PacketData endData = new PacketData ( PacketType.REQ_OBJECT_END , null , 0 );
		StrokeData tmpStrokeData = new StrokeData ( inStroke , inTool );
		
		int dividePacket = 0;
		byte tmpBytes[] = tmpStrokeData.getObjetInfo();
		
		if ( tmpBytes == null )
			return;
		
		ByteBuffer tmpBuffer = ByteBuffer.allocate( tmpBytes.length + 4);
		tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
		
		tmpBuffer.putInt( inRoom );
		tmpBuffer.put( tmpBytes );
		
		tmpBuffer.flip();
		
		startData.m_tmpByte = tmpBuffer.array();
		startData.m_lengTh = startData.m_tmpByte.length + 8;
		
		int ArraySize = tmpStrokeData.getStrokeArray().length;
		
		dividePacket = ArraySize / 4000 + 1;
		Log.d("Eraser" , "Pakcet Creating...2");
		ByteBuffer tmpStrokeArrayBuffer = ByteBuffer.allocate(ArraySize);
		
		PacketData strokeData[] = new PacketData[dividePacket];
		
		tmpStrokeArrayBuffer.put( tmpStrokeData.getStrokeArray() );
		
		byte tmpStrokeArray[];
		
		
		for ( int i = 0 ; i < dividePacket ; i++ )
		{
			tmpStrokeArray = null;
			
			strokeData[i] = new PacketData ( PacketType.REQ_OBJECT_DATA , null , 0 );
			if ( dividePacket - 1 == i )
			{
				int dataSize =  ArraySize % 4000;
				
				strokeData[i].m_tmpByte = new byte[dataSize + 4];
				
				tmpBuffer = ByteBuffer.allocate( dataSize + 4 );
				
				tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
				
				tmpBuffer.putInt( inRoom );
				
				tmpStrokeArray = new byte[dataSize];
				
				tmpStrokeArrayBuffer.position(i*4000);
				
				tmpStrokeArrayBuffer.get(tmpStrokeArray, 0 , dataSize );
				
				tmpBuffer.put( tmpStrokeArray );
				
				tmpBuffer.flip();
				
				tmpBuffer.get( strokeData[i].m_tmpByte );
				
				tmpBuffer.clear();
				
				strokeData[i].m_lengTh = strokeData[i].m_tmpByte.length + 8;
			}
			else
			{
				strokeData[i].m_tmpByte = new byte[4004];
				
				tmpBuffer = ByteBuffer.allocate(4004);
				
				tmpBuffer.order( ByteOrder.LITTLE_ENDIAN );
				
				tmpBuffer.putInt( inRoom );
				
				tmpStrokeArray = new byte[4000];
				
				tmpStrokeArrayBuffer.position(i*4000);
				
				tmpStrokeArrayBuffer.get(tmpStrokeArray, 0 , 4000 );
				
				tmpBuffer.put( tmpStrokeArray );
				
				tmpBuffer.flip();
				
				tmpBuffer.get( strokeData[i].m_tmpByte );
				
				tmpBuffer.clear();
				
				strokeData[i].m_lengTh = strokeData[i].m_tmpByte.length + 8;
				
			}
		}
		
		synchronized (m_SendQueue) {
			m_SendQueue.offer( startData );
			for ( int i = 0 ; i < dividePacket ; i ++ )
			{
				m_SendQueue.offer(strokeData[i]);
			}
			m_SendQueue.offer( endData );
		}
	}
	
	public synchronized static void pushQueue ( int inType , byte[] inRoom )
	{
		PacketData tmpData = new PacketData( inType , inRoom , 4 );
		
		m_roomBytes = inRoom;
		
		synchronized (m_SendQueue) {
			m_SendQueue.offer( tmpData );
		}
	}
	
	public synchronized static void pushQueue ( int inType , byte[] inRoom , int inObjectId )
	{
		ByteBuffer tmpBuffer = ByteBuffer.allocate(8);
		
		tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		tmpBuffer.put( inRoom );
		tmpBuffer.putInt( inObjectId );
		
		tmpBuffer.flip();
		
		byte[] tmpByte = tmpBuffer.array();
		
		PacketData tmpData = new PacketData( inType , tmpByte , 8 );
		
		m_roomBytes = inRoom;
		
		synchronized (m_SendQueue) {
			m_SendQueue.offer( tmpData );
		}
	}
	
	public synchronized static void pushQueue ( int inType , int ObjectId )
	{
		PacketData tmpData = new PacketData( inType , m_roomBytes , 4);
		
		synchronized (m_SendQueue) {
			m_SendQueue.offer( tmpData );
		}
	}
	
	public synchronized static void pushQueue ( byte[] inBytes , int inRoom , int inCount , int size , int ObjectId )
	{
		PacketData tmpData = new PacketData ( PacketType.REQ_BITMAP_DATA , null , 0 );
		
		ByteBuffer tmpBuffer = ByteBuffer.allocate(4096);
		
		tmpBuffer.clear();
		tmpBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		tmpBuffer.putInt( inRoom );
		tmpBuffer.putInt(ObjectId);
		tmpBuffer.putInt( inCount );
		tmpBuffer.put(inBytes , 0 , size );
		
		tmpBuffer.flip();
		tmpData.m_tmpByte = tmpBuffer.array();
		tmpData.m_lengTh = size + 8  + 8;
		
		
		synchronized (m_SendQueue) {
			Log.d("numbering cheak", Integer.toString(inCount));
			Log.d("numbering cheak", tmpData.m_tmpByte + "" );
			m_SendQueue.offer( tmpData );
		}
	}
	
	public synchronized static PacketData popQueue ( ) {
		synchronized (m_SendQueue) {
			return m_SendQueue.poll();
		}
		
	}
	
	public synchronized static boolean isEmpty () 
	{
		synchronized ( m_SendQueue ) {
			return m_SendQueue.isEmpty();
		}
		
	}
}
