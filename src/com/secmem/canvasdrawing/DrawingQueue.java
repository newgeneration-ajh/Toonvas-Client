package com.secmem.canvasdrawing;

import java.util.LinkedList;
import java.util.Queue;

public class DrawingQueue {
	private Queue<DrawingData> m_Queue = new LinkedList<DrawingData>();
	
	public void pushQueue ( DrawingData inData )
	{
		m_Queue.offer(inData);
	}
	
	public DrawingData popQueue ( )
	{
		return m_Queue.poll();
	}
	
	public boolean isEmpty () 
	{
		return m_Queue.isEmpty();
	}
	
	public int getEleCnt ()
	{
		return m_Queue.size();
	}
}
