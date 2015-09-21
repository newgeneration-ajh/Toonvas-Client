package com.secmem.layer;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.PointF;

import com.samsung.android.sdk.pen.document.SpenObjectBase;

public class LayerManager {
	private int m_SelLayerID = 0;
	private int m_LayerCnt = 0;
	private LayerData m_SelLayer = null;
	private ArrayList<LayerData> m_LayerList = new ArrayList<LayerData>();
	
	public LayerManager ()
	{
		
	}
	
	public void createLayer (  )
	{
		
	}
	
	public void changeSize ( )
	{
		
	}
	
	
	
	private void insertObject ( SpenObjectBase inObject , int inId )
	{
		
	}
	
	private void setLayerRange ( PointF startPoint , PointF endPoint , int inId )
	{
		
		float tmpTopY = ( startPoint.y < endPoint.y ) ? startPoint.y : endPoint.y;
		float tmpBottomY = ( startPoint.y > endPoint.y ) ? startPoint.y : endPoint.y;
		float tmpLeftX = ( startPoint.x  > endPoint.x ) ? startPoint.x : endPoint.x;
		float tmpRightX = ( startPoint.x  < endPoint.x ) ? startPoint.x : endPoint.x;
		
		m_LayerList.get(inId).setPoint(tmpTopY, tmpBottomY, tmpLeftX, tmpRightX);
	}
	
	private void setLayerBackGround ( Bitmap inBitmap , int inId )
	{
	
	}
	
	
	
}
