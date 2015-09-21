package com.secmem.canvasdrawing;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;

import com.samsung.android.sdk.pen.document.SpenObjectStroke;

public class StrokeData implements Serializable {
	
	private int m_ArraySize;
	
	private float[] m_PointX;
	private float[] m_PointY;
	private float[] m_Pressurese; 
	private int[] m_Timestamps;
	
	private int m_PageNum = 0;
	private int m_MasterNum = 0;
	private int m_penName = 0;
	private int m_ToolType = 0;
	private int m_Color = 0;
	private int m_ObjectId = 0;
	private float m_Size = 0;
	private byte[] StrokeArray = null;
	private byte[] ObjectInfoArray = null;
	private ByteBuffer m_Buffer;
	
	public StrokeData ( )
	{
		m_MasterNum = 0;
		m_penName = 0;
		m_ToolType = 0;
		m_Color = 0;
		m_Size = 0;
		m_ArraySize = 0; 
		
		//m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
	}
	
	public StrokeData ( SpenObjectStroke inStroke )
	{
		m_penName = PenName.penId( inStroke.getPenName() );
		m_Size = inStroke.getPenSize();
		m_ToolType = inStroke.getToolType();
		m_Color = inStroke.getColor();
		m_PageNum = inStroke.getExtraDataInt("Page");
		m_ObjectId = inStroke.getExtraDataInt("Object ID");
		
		if ( inStroke.getPoints() == null )
		{
			return;
		}
		
		int strokeLength = inStroke.getPoints().length;
		m_ArraySize = strokeLength;
		
		m_PointX = new float[m_ArraySize];
		m_PointY = new float[m_ArraySize];
		m_Pressurese = new float[m_ArraySize];
		m_Timestamps = new int[m_ArraySize];
		
		int[] tmpTimestaps = inStroke.getTimeStamps();
		
		float[] tmpPressurese = inStroke.getPressures();
		
		PointF[] tmpPointFs = inStroke.getPoints();
		
		int bufferSize = m_ArraySize * 16;
		
		m_Buffer = ByteBuffer.allocate(bufferSize);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		for ( int i = 0 ; i < strokeLength ; i = i + 1 )
		{
			m_PointX[i] = tmpPointFs[i].x;
			
			m_PointY[i] = tmpPointFs[i].y;
			
			m_Pressurese[i] = tmpPressurese[i];
			
			m_Timestamps[i] = tmpTimestaps[i];
			
		}
		
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_PointX[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_PointY[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_Pressurese[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putInt(m_Timestamps[i]);
		}
		
		int tmpPosition = m_Buffer.position();
		
		StrokeArray = new byte[tmpPosition];
		
		m_Buffer.flip();
		
		m_Buffer.get(StrokeArray, 0, tmpPosition);
		
		m_MasterNum = 0;
		
		m_Buffer.clear(); 
		
		m_Buffer = ByteBuffer.allocate(32);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		m_Buffer.putInt(m_PageNum);
		m_Buffer.putInt(m_MasterNum);
		m_Buffer.putInt(m_ToolType);
		m_Buffer.putInt(m_penName);
		m_Buffer.putInt(m_Color);
		m_Buffer.putFloat(m_Size);
		m_Buffer.putInt(m_ObjectId);
		m_Buffer.putInt(m_ArraySize);
		
		tmpPosition = m_Buffer.position();
		
		ObjectInfoArray = new byte[tmpPosition];
		
		m_Buffer.flip();
		
		m_Buffer.get(ObjectInfoArray);
		
		m_Buffer.clear();
		
		
	}
	
	public StrokeData ( SpenObjectStroke inStroke , int inTool )
	{
		m_penName = PenName.penId( "com.samsung.android.sdk.pen.pen.preload.InkPen" );
		m_Size = inStroke.getPenSize();
		m_ToolType = inTool;
		m_Color = Color.WHITE;
		m_PageNum = inStroke.getExtraDataInt("Page");
		m_ObjectId = inStroke.getExtraDataInt("Object ID");
		
		if ( inStroke.getPoints() == null )
		{
			return;
		}
		
		int strokeLength = inStroke.getPoints().length;
		m_ArraySize = strokeLength;
		
		m_PointX = new float[m_ArraySize];
		m_PointY = new float[m_ArraySize];
		m_Pressurese = new float[m_ArraySize];
		m_Timestamps = new int[m_ArraySize];
		
		int[] tmpTimestaps = inStroke.getTimeStamps();
		
		float[] tmpPressurese = inStroke.getPressures();
		
		PointF[] tmpPointFs = inStroke.getPoints();
		
		int bufferSize = m_ArraySize * 16;
		
		m_Buffer = ByteBuffer.allocate(bufferSize);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		for ( int i = 0 ; i < strokeLength ; i = i + 1 )
		{
			m_PointX[i] = tmpPointFs[i].x;
			
			m_PointY[i] = tmpPointFs[i].y;
			
			m_Pressurese[i] = tmpPressurese[i];
			
			m_Timestamps[i] = tmpTimestaps[i];
			
		}
		
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_PointX[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_PointY[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putFloat(m_Pressurese[i]);
		}
		
		for ( int i = 0 ; i < strokeLength ; i++ )
		{
			m_Buffer.putInt(m_Timestamps[i]);
		}
		
		int tmpPosition = m_Buffer.position();
		
		StrokeArray = new byte[tmpPosition];
		
		m_Buffer.flip();
		
		m_Buffer.get(StrokeArray, 0, tmpPosition);
		
		m_MasterNum = 0;
		
		m_Buffer.clear(); 
		
		m_Buffer = ByteBuffer.allocate(32);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		m_Buffer.putInt(m_PageNum);
		m_Buffer.putInt(m_MasterNum);
		m_Buffer.putInt(m_ToolType);
		m_Buffer.putInt(m_penName);
		m_Buffer.putInt(m_Color);
		m_Buffer.putFloat(m_Size);
		m_Buffer.putInt(m_ObjectId);
		m_Buffer.putInt(m_ArraySize);
		
		tmpPosition = m_Buffer.position();
		
		ObjectInfoArray = new byte[tmpPosition];
		
		m_Buffer.flip();
		
		m_Buffer.get(ObjectInfoArray);
		
		m_Buffer.clear();
		
		
	}
	
	public StrokeData ( byte[] inBytes )
	{
		StrokeArray = inBytes;
		
		m_Buffer.clear();
		
		m_Buffer.put( inBytes );
		
		m_MasterNum = m_Buffer.getInt();
		m_ArraySize = m_Buffer.getInt(4);
		
		for ( int i = 0 ; i < m_ArraySize ; i++ )
		{
			m_PointX[i] = m_Buffer.getFloat( ( ( i + 1 ) * 4 ) + 4 ); 
			m_PointY[i] = m_Buffer.getFloat( ( ( i + 1 + m_ArraySize ) * 4 ) + 4 );
			m_Pressurese[i] = m_Buffer.getFloat( ( ( i + 1 + ( m_ArraySize * 2 ) ) * 4 ) + 4 ); 
			m_Timestamps[i] = m_Buffer.getInt( ( ( i + 1 + ( m_ArraySize * 3 ) ) * 4 ) + 4 );
		}
		
		
		m_penName = m_Buffer.getInt( ( m_ArraySize * 16 ) + 4 + 4 );
		m_ToolType = m_Buffer.getInt( m_ArraySize * 16 + 4 + 4 + 4 );
		m_Color = m_Buffer.getInt( m_ArraySize * 16 + 4 + 4 + 4 + 4 );
		m_Size =  m_Buffer.getFloat( ( m_ArraySize * 16 ) + 4 + 4 + 4 + 4 + 4 );
		
		m_Buffer.clear();
		
		StrokeArray = null;
		
	}
	
	public void setBytesInfo ( byte[] inBytes )
	{
		ObjectInfoArray = inBytes;
		
		m_Buffer = ByteBuffer.allocate(32);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		m_Buffer.clear();
		
		m_Buffer.put( inBytes );
		
		m_Buffer.flip();
		
		m_PageNum = m_Buffer.getInt ( 0 );
		m_MasterNum = m_Buffer.getInt( 4 );
		m_ToolType = m_Buffer.getInt( 8 );
		m_penName = m_Buffer.getInt( 12 );
		m_Color = m_Buffer.getInt(16);
		m_Size = m_Buffer.getFloat(20);
		m_ObjectId = m_Buffer.getInt(24);
		m_ArraySize = m_Buffer.getInt(28);
		
		m_Buffer.clear();
		
		m_Buffer = ByteBuffer.allocate(m_ArraySize*16);
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
		
		m_PointX = new float[m_ArraySize];
		m_PointY = new float[m_ArraySize];
		m_Pressurese = new float[m_ArraySize];
		m_Timestamps = new int[m_ArraySize];
	}
	
	public void setBytes ( byte[] inByte , int offset )
	{
		m_Buffer.put(inByte);
		
		return;
	}
	
	public void setPoints ( )
	{
		m_Buffer.flip();
		
		
		for ( int i = 0 ; i < m_ArraySize ; i++ )
		{
			m_PointX[i] = m_Buffer.getFloat( ( i  * 4 ) ); 
			m_PointY[i] = m_Buffer.getFloat( ( ( i + m_ArraySize ) * 4 ) );
			m_Pressurese[i] = m_Buffer.getFloat( ( ( i + ( m_ArraySize * 2 ) ) * 4 ) ); 
			m_Timestamps[i] = m_Buffer.getInt( ( ( i + ( m_ArraySize * 3 ) ) * 4 ) );
		}
		
		return;
		
	}
	
	public void setBytes ( byte[] inBytes )
	{
		StrokeArray = inBytes;
		
		m_Buffer.clear();
		
		m_Buffer.put( inBytes );
		
		m_Buffer.flip();
		
		m_MasterNum = m_Buffer.getInt(0);
		
		m_ArraySize = m_Buffer.getInt(4);
		
		for ( int i = 0 ; i < m_ArraySize ; i++ )
		{
			m_PointX[i] = m_Buffer.getFloat( ( ( i + 1 ) * 4 ) + 4 ); 
			m_PointY[i] = m_Buffer.getFloat( ( ( i + 1 + m_ArraySize ) * 4 ) + 4 );
			m_Pressurese[i] = m_Buffer.getFloat( ( ( i + 1 + ( m_ArraySize * 2 ) ) * 4 ) + 4 ); 
			m_Timestamps[i] = m_Buffer.getInt( ( ( i + 1 + ( m_ArraySize * 3 ) ) * 4 ) + 4 );
		}
		
		m_PageNum = m_Buffer.getInt( ( m_ArraySize * 16 ) + 4 + 4 );
		m_penName = m_Buffer.getInt( ( m_ArraySize * 16 ) + 4 + 4 + 4 );
		m_ToolType = m_Buffer.getInt( m_ArraySize * 16 + 4 + 4 + 4 + 4);
		m_Color = m_Buffer.getInt( m_ArraySize * 16 + 4 + 4 + 4 + 4 + 4);
		m_Size =  m_Buffer.getFloat( ( m_ArraySize * 16 ) + 4 + 4 + 4 + 4 + 4 + 4);
		m_ObjectId = m_Buffer.getInt ( ( m_ArraySize * 16 ) + 4 + 4 + 4 + 4 + 4 + 4 + 4);
		
		m_Buffer.clear();
		StrokeArray = null;
	}
	
	public SpenObjectStroke getStrokeObject ( )
	{
		PointF tmpPointfF[] = new PointF[m_ArraySize]; 
		float tmpPressurese[] = new float[m_ArraySize];
		int tmpTime[] = new int[m_ArraySize];
		int pointLenth = m_ArraySize;
		
		for ( int i = 0 ; i < pointLenth ; i++ )
		{
			PointF tmpPF = new PointF( m_PointX[i], m_PointY[i]);
			tmpPressurese[i] = m_Pressurese[i];
			tmpTime[i] = m_Timestamps[i];
			tmpPointfF[i] = tmpPF;
		}

		SpenObjectStroke tmpObjectStroke = new SpenObjectStroke( new String ( PenName.penName(m_penName) ) , tmpPointfF, tmpPressurese, tmpTime, true);
		
		tmpObjectStroke.setToolType(m_ToolType);
		tmpObjectStroke.setColor(m_Color);
		tmpObjectStroke.setPenSize(m_Size);
		tmpObjectStroke.setExtraDataInt( "otherData" , m_MasterNum );
		tmpObjectStroke.setExtraDataInt ( "Object ID", m_ObjectId );
		tmpObjectStroke.setExtraDataInt("Page", m_PageNum);
		
		tmpObjectStroke.setSelectable(false);
		
		Log.d("PenName" , Integer.toString(m_ToolType));
		
		return tmpObjectStroke;
	}
	
	public int getObjectId ( )
	{
		return m_ObjectId;
	}
	
	public byte[] getStrokeArray ()
	{
		return StrokeArray;
	}
	
	public byte[] getObjetInfo ()
	{
		return ObjectInfoArray;
	}
	
	public int getMasterNum ( )
	{
		return m_MasterNum;
	}
	
	
	
	private static final long serialVersionUID = 1L;
	
} 	 
