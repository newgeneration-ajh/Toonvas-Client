package com.secmem.packet;

import android.os.Handler;

public class RecvThread implements Runnable {

	private Thread m_RecvThread =null;
	private RecvBufferManager m_BufferManager = new RecvBufferManager();
	private static Handler m_Handler = null;

	
	public RecvThread( Handler inHandler )
	{
		m_RecvThread = new Thread ( this );
		m_Handler = inHandler;
		m_RecvThread.setPriority( 2 );
	}
	
	public static synchronized void setHandler ( Handler inHandler )
	{
		m_Handler = inHandler;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while ( true )
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ( RecvManager.isEmpty() != true )
			{
				m_BufferManager.RecvBufferData( RecvManager.popQueue() );
				m_Handler.sendMessage( m_BufferManager.getMessage( m_Handler.obtainMessage() ) );	
				
			}
		}
	}
	
	public void threadStart ( )
	{
		m_RecvThread.start();
	}
	
	public Thread.State threadState ( )
	{
		return m_RecvThread.getState();
	}
	

}
