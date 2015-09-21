package com.secmem.objecthandle;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectQueue {
	
	private final static int MAX_ELE = 10;
	
	private static Queue<ObjectData> m_Queue = new LinkedList<ObjectData>();

	
	public synchronized static void pushQueue ( ObjectData inData ) 
	{
		m_Queue.offer(inData);
	}
	
	public synchronized static ObjectData popQueue ( )
	{
		if ( m_Queue.isEmpty() != true )
		{
			return m_Queue.poll();
		}
		return null;
	}
	
	public synchronized static boolean isMaxEle ( ) {
		if ( m_Queue.size() == MAX_ELE ) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
