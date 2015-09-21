package com.secmem.layer;

import java.util.ArrayList;

import android.graphics.PointF;
import android.graphics.Rect;

import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectImage;

public class LayerData {
	private String name = null;
	private int m_LayerID = 0;
	private int m_Size = 0;
	
	private SpenObjectContainer m_ObjectContainer = null;
	private SpenObjectImage m_BackImage = null;
	
	private PointF m_Center = null;
	private float m_topY = 0;
	private float m_bottomY = 0;
	private float m_leftX = 0;
	private float m_rightX = 0;
	private float m_Hight = 0;
	private float m_Width = 0;

	private ArrayList<LayerData> m_ChildList = new ArrayList<LayerData>();
	private LayerData m_ParentLayer = null;

	private Rect m_Rect = null; 
	
	public LayerData ( int inId )
	{
		m_LayerID = inId;
		name = new String ("Layer" + Integer.toString(inId));
	}
	
	public LayerData ( int inId , String inName )
	{
		m_LayerID = inId;
		name = inName;
	}
	
	public void setPoint (  float inTop , float inBottom , float inLeft , float inRight )
	{
		m_topY = inTop;
		m_bottomY = inBottom;
		m_leftX = inLeft;
		m_rightX = inRight;
		m_Center = new PointF( ( m_leftX + m_rightX ) / 2  , ( m_topY + m_bottomY ) / 2 );
		setHight();
		setWidth();
	}
	
	public String getName ( )
	{
		return name;
	}
	
	public void setRect ( Rect inRect )
	{
		Rect oldRect = m_Rect;
		m_Rect = inRect;
		
		m_topY = m_topY / ( ( float ) oldRect.height()  / ( float ) inRect.height() );
		m_bottomY = m_bottomY / ( ( float ) oldRect.height()  / ( float ) inRect.height() );
		m_leftX = m_leftX / ( ( float ) oldRect.width()  / ( float ) inRect.width() );
		m_rightX = m_rightX / ( ( float ) oldRect.width()  / ( float ) inRect.width() );
		setPoint(m_topY, m_bottomY, m_leftX, m_rightX);
		setHight();
		setWidth();
	}
	
	public void setName ( String inName )
	{
		name = inName;
	}
	
	public PointF getCenter ( )
	{
		return m_Center;
	}
	
	public float getHight ()
	{
		return m_Hight;
	}
	
	public float getWidth ()
	{
		return m_Width;
	}
	
	private void setHight ( )
	{
		m_Hight = ( m_topY > m_bottomY ) ? ( m_topY - m_bottomY ) : ( m_bottomY - m_topY ); 
	}
	
	private void setWidth()
	{
		m_Width = ( m_rightX > m_leftX ) ? ( m_rightX - m_leftX ) : ( m_leftX - m_rightX );
	}

}
