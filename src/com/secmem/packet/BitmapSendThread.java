package com.secmem.packet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import android.util.Log;

public class BitmapSendThread implements Runnable {
	
	private Thread m_Thread = new Thread ( this );
	private String m_FilePath = null;
	private FileInputStream m_FileInputStream = null;
	private int m_roomNum = 0;
	private Queue<FileInputStream> m_StreamQueue = new LinkedList<FileInputStream>();
	private Queue<Integer> m_ObjectIdQueue = new LinkedList<Integer>();
	
	public BitmapSendThread ( String inPath , int inObjectId , int m_roomNum )
	{
		Integer objectId = new Integer(inObjectId);
		m_FilePath = inPath;
		try {
			FileInputStream tmpFileInputStream = new FileInputStream( m_FilePath );
			m_StreamQueue.offer(tmpFileInputStream);
			m_ObjectIdQueue.offer(objectId);
			m_Thread.start();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void setBitmapPath ( String inPath , int inObjectId )
	{
		m_FilePath = inPath;
		Integer objectId = new Integer(inObjectId);
		try {
			FileInputStream tmpFileInputStream = new FileInputStream( inPath );
			synchronized (m_StreamQueue) {
				m_StreamQueue.offer(tmpFileInputStream);
			}
			synchronized (m_ObjectIdQueue) {
				m_ObjectIdQueue.offer(objectId);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run () 
	{
		while ( true )
		{
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while ( m_StreamQueue.isEmpty() != true )
			{
				FileInputStream tmpStream = m_StreamQueue.poll();
				Integer tmpId = m_ObjectIdQueue.poll();
				try {
					int i = 0;
					int cnt = 0;
					byte[] tmpByte = new byte[4076];
					while ( ( i = tmpStream.read(tmpByte, 0, 4076) ) != -1 )
					{
						SendManager.pushQueue(tmpByte, m_roomNum, cnt, i , tmpId  );
						
						Log.d("send bitmap", "cnt : " + Integer.toString(cnt));
						cnt++;
					}
					SendManager.pushQueue( PacketType.REQ_END_BITMAP , m_roomNum);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*try {
					m_FileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	}
	public void startThread ( )
	{
		m_Thread.start();
	}
	
}
