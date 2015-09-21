package com.secmem.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import android.util.Log;


public class CRemote {
	private Socket m_socket = null;
	
	private BufferedOutputStream m_sbout = null;
	private BufferedInputStream m_sbin = null;

	private byte [] m_rBuf = new byte[4096];
	private ByteBuffer m_Buffer = ByteBuffer.allocateDirect(4096);
	
	private int m_RecvLen = 0;
	
	public CRemote(String IP, int port)
	{
		try {
			m_socket = new Socket(IP, port);
			
			//서버와 통신할 input, output 스트림 생성
			m_sbout = new BufferedOutputStream(m_socket.getOutputStream());
			m_sbin = new BufferedInputStream(m_socket.getInputStream());
		} catch (UnknownHostException e) {
			//e.printStackTrace();
			String msg = e.getMessage();
			Log.d("CRemote Socket err", msg);
		} catch (IOException e) {
			//e.printStackTrace();
			String msg = e.getMessage();
			Log.d("CRemote Socket err", msg);
		}
		
		m_Buffer.order(ByteOrder.LITTLE_ENDIAN);
	}
	
	public boolean SocketClose()
	{
		try {
			m_socket.close();
			Log.d("CRemote SocketClose", "소캣정상종료");
			return true;
		} catch (IOException e) {
			String msg = e.getMessage();
			Log.d("CRemote SocketClose", msg);
			return false;
		}
	}
	
	public void SendPacket ( byte sBuf[] )
	{
		Log.d("sendpacket", "call CRemote");
		try
		{
			m_sbout.write(sBuf);
			m_sbout.flush();
		}
		catch(IOException ie)
		{
			String msg = ie.getMessage();
			Log.d("에러", msg);
		}
	}
	
	public int RecvPacket() throws IOException
	{
		m_RecvLen = 0;
		m_RecvLen = m_sbin.read( m_rBuf , 0 , 4088);
		Log.d("recv_data", "read success");
		
		m_Buffer.put( m_rBuf );
			
		int tmpSize = m_Buffer.getInt(4);
		
		if ( m_RecvLen < 0 )
		{
			return m_RecvLen;
		}

		Log.d("recvPacket", "Recv......first" + Integer.toString(tmpSize) + " " + Integer.toString(m_RecvLen));
			
		while ( tmpSize > m_RecvLen ) // 데이터가 덜 도착했을 경우
		{
			
			m_RecvLen += m_sbin.read( m_rBuf , m_RecvLen , 4088 - m_RecvLen );
			Log.d("recvPacket", "Recv......" + Integer.toString(tmpSize) + " " + Integer.toString(m_RecvLen));
			if ( tmpSize > 4092 )
			{
				break;
			}
		}
		m_Buffer.clear();
			
		Log.d("recvPacket", "Recv Sucess");
		return m_RecvLen;
		
		
	}
	
	public boolean GetPacket(byte [] rBuf)
	{
		if ( m_rBuf[0] == 0 )
		{
			return false;
		}
		System.arraycopy(m_rBuf, 0, rBuf, 0, m_RecvLen);
		m_RecvLen = 0;
		Arrays.fill(m_rBuf, (byte) 0);
		return true;
	}
	
	public Socket getSocket(){return m_socket;}
	
}
