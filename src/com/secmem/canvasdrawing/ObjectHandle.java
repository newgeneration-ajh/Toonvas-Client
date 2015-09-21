package com.secmem.canvasdrawing;

import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.RectF;

import com.samsung.android.sdk.pen.document.SpenObjectBase;

public class ObjectHandle {
	private HashMap< Integer, ArrayList< SpenObjectBase > > m_ObjectHashMap = 
			new HashMap<Integer, ArrayList<SpenObjectBase>>();
	
	public ObjectHandle( int []inMaster )
	{
		for ( int i = 0 ; i < inMaster.length ; i++ )
		{
			m_ObjectHashMap.put( Integer.valueOf(inMaster[i])  , new ArrayList<SpenObjectBase>()); 
		}
	}
	
	public void inSertObject ( int masterNum , SpenObjectBase inObject )
	{
		m_ObjectHashMap.get( masterNum ).add( inObject );
	}
	
	public SpenObjectBase changeObject ( int masterNum , int objectId , RectF inRect )
	{
		SpenObjectBase tmpObject = getObject(masterNum, objectId); 
		tmpObject.setRect(inRect, true );
		
		return tmpObject;
	}
	
	public void deleteObject ( int masterNum , int objectId )
	{
		ArrayList<SpenObjectBase> tmpObjectList = m_ObjectHashMap.get( masterNum );
		
		if ( tmpObjectList == null )
		{
			return;
		}
		int tmpObjectCnt = tmpObjectList.size();
		
		for ( int i = 0 ; i < tmpObjectCnt ; i++ )
		{
			if( tmpObjectList.get(i).getExtraDataInt("Object ID") == objectId )
			{
				tmpObjectList.remove(i);
			}
		}
	}
	
	public SpenObjectBase getObject ( int masterNum , int objectId)
	{
		ArrayList<SpenObjectBase> tmpObjectList = m_ObjectHashMap.get( masterNum );
		
		if ( tmpObjectList == null )
		{
			return null;
		}
		for (SpenObjectBase spenObjectBase : tmpObjectList) 
		{
			if ( spenObjectBase.getExtraDataInt("Object ID") == objectId )
			{
				return spenObjectBase;
			}
			
		}
		return null;
	}	
}
