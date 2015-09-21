package com.secmem.objecthandle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

import android.graphics.RectF;
import android.util.Log;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.secmem.packet.PacketData;
import com.secmem.packet.PacketType;
import com.secmem.packet.SendManager;

public class ObjectChanged {
	
	private ArrayList<SpenObjectBase> m_ObjectList = null;
	private int m_ChangedCnt = 0;
	private RectF []m_RectF = null;
	private int []m_ObjectId = null;
	private int m_RoomNum = 0;
	private boolean m_Result = false;
	
	public ObjectChanged ( ArrayList<SpenObjectBase> inObjectBaseList , int inRoom )
	{
		int tmpCnt = inObjectBaseList.size();
		m_ObjectList = inObjectBaseList;
		m_RectF = new RectF[tmpCnt];
		m_ObjectId = new int[tmpCnt];
		m_RoomNum = inRoom;
	}
	
	public int getChangedCnt ( )
	{
		return m_ChangedCnt;
	}
	
	public boolean getResult ()
	{
		return m_Result;
	}
	
	public void chnagedObject ( SpenObjectBase inObjectBase )
	{
		int tmpId = inObjectBase.getExtraDataInt("Object ID");
		
		for ( int i = 0 ; i < m_ChangedCnt ; i++ )
		{
			if ( tmpId == 0 )
			{
				if ( m_ChangedCnt != 0 )
				{
					
					return;
				}
			}
			else
			{
				if ( m_ObjectId[i] == tmpId )
				{
					Log.d("ObjectChanged" , tmpId + " , " + m_ObjectId[i] );
						return;
				}
			}
			
			
		}
		
		m_ObjectId[m_ChangedCnt] = tmpId;
		m_RectF[m_ChangedCnt] = inObjectBase.getRect();
		
		Log.d( "ObjectChanged" , "!_!:" + m_ObjectList.size() + " , " + m_ChangedCnt );
		
		if ( m_ObjectList.size() == ( m_ChangedCnt + 1 ) )
		{
			m_ChangedCnt++;
			changedPacketSend();
			
			m_Result = true;
		}
		else
		{
			
			m_ChangedCnt++;
		}
		
	}
	
	private void changedPacketSend ( )
	{
		ByteBuffer tmpByteBuffer = ByteBuffer.allocate( ( 5 * m_ChangedCnt * 4 ) + 8 );
		tmpByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		tmpByteBuffer.putInt( m_RoomNum );
		tmpByteBuffer.putInt( m_ChangedCnt );
		
		for ( int i = 0 ; i < m_ChangedCnt ; i++ )
		{
			tmpByteBuffer.putInt( m_ObjectId[i] );
			tmpByteBuffer.putFloat( m_RectF[i].top );
			tmpByteBuffer.putFloat( m_RectF[i].bottom );
			tmpByteBuffer.putFloat( m_RectF[i].left );
			tmpByteBuffer.putFloat( m_RectF[i].right );	
		}
		
		
		PacketData tmpPacketData = new PacketData( PacketType.REQ_OBJECT_CHANGE , tmpByteBuffer.array() , tmpByteBuffer.array().length );
		
		SendManager.pushQueue( tmpPacketData );
	}
	
	
	
}
