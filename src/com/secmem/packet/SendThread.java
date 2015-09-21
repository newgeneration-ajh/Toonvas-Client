package com.secmem.packet;

import com.secmem.network.MobileClient;

public class SendThread implements Runnable{
	
	private Thread m_SendThread = null;
	private SendBufferManger  m_SendBufferManger = null;
	
	public SendThread (  )
	{
		m_SendThread = new Thread( this );  
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
			if ( SendManager.isEmpty() != true )
			{
				m_SendBufferManger = new SendBufferManger( SendManager.popQueue() );
				
				byte tmpByte[] = m_SendBufferManger.getByte();
				
				MobileClient.SendData( tmpByte );
				
			}
		}
	}
	
	public void threadStart ( ) {
		m_SendThread.start();
	}
	
	public Thread.State threadState ( )
	{
		return m_SendThread.getState();
	}

}
