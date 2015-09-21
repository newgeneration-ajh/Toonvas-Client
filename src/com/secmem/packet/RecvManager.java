package com.secmem.packet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Queue;

import android.util.Log;

public class RecvManager {
	private static Queue<PacketData> m_RecvQueue = new LinkedList<PacketData>();
	private static ByteBuffer m_Buffer = ByteBuffer.allocateDirect( 10000 );
	
	
	public synchronized static void pushQueue ( PacketData inRecv ) {
		
		synchronized ( m_RecvQueue ) {
			if ( inRecv != null)
			{
				m_RecvQueue.offer( inRecv );
			}
		}
		
	}
	
	public synchronized static PacketData popQueue ( ) {
		synchronized ( m_RecvQueue ) {

			return m_RecvQueue.poll();
		}
	}
	
	public static boolean isEmpty ( )
	{
		synchronized ( m_RecvQueue ) {
			return m_RecvQueue.isEmpty();
		}
	}
	
	public synchronized static void toBuffer ( byte[] inData , int length )
	{
		m_Buffer.put( inData );
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		m_Buffer.flip();
		
		int tmpOpcode = m_Buffer.getInt();
		int tmpLength = m_Buffer.getInt(4);
		if ( tmpLength > length )
		{
			return;
		}
		byte[] tmpData = new byte[tmpLength - 8];
		
		System.arraycopy(inData, 8, tmpData, 0, tmpLength - 8);
		
		RecvManager.pushQueue( new PacketData( tmpOpcode, tmpData, tmpLength ) );
		
		m_Buffer.clear();
		
		if ( tmpLength < length )
		{
			int weightCnt = tmpLength;
			int lengthCnt = length - tmpLength;
			while ( lengthCnt > 0 )
			{
				m_Buffer.put( inData , weightCnt , lengthCnt );
				m_Buffer.order( ByteOrder.LITTLE_ENDIAN );
				
				m_Buffer.flip();
				
				tmpOpcode = m_Buffer.getInt(0);
				tmpLength = m_Buffer.getInt(4);
				
				if ( tmpLength > 0 )
				{
					tmpData = new byte[ tmpLength - 8 ];
					
					
					System.arraycopy( inData , weightCnt + 8 , tmpData , 0 , tmpLength - 8);
					Log.d("length cheak" , "weghit : " + weightCnt + " length : " + lengthCnt );
					RecvManager.pushQueue( new PacketData( tmpOpcode, tmpData, tmpLength ) );
					
					m_Buffer.clear();
				}
				
				weightCnt = weightCnt + tmpLength;
				lengthCnt = lengthCnt - tmpLength;
			}
		}
		
		
	}
}
