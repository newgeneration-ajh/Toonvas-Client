package com.secmem.network;

import java.io.IOException;

import android.content.Context;
import android.util.Log;

import com.secmem.packet.RecvManager;

public class MobileClient {
	
	private static final MobileClient instance = new MobileClient();
	
	private Thread m_threadList = null;
	

	public static boolean initFlag = false; 
	
	private MobileClient() {}
	
	public void initialize(Context context) {
		Log.i("yys", "run_first");
	}
	
	public void ConnectRemote(String ip, int port) {
		if ( m_RemoteSocket == null )
		{
			m_RemoteSocket = new CRemote(ip, port);
		}
	}
	
	public static MobileClient getInstance() {
		Log.i("yys", "Instance Create");
		return instance;
	}
	
	
	private static CRemote m_RemoteSocket = null;
	
	public void invoker ( ) {
	
		m_threadList = new Thread(new Runnable() {
				
				@Override
				public void run() {
					/*recv �� �����ϴ� ������*/
					while ( true ) {
						/*������ ������ recvQueue�� ���*//*
						try {
							Thread.sleep(150);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						
						
						int iRecvLen = 0;
						byte[] rBuf = null;
						try {
							Log.e("ServicesTEST", "RECEIVE START");
							iRecvLen = m_RemoteSocket.RecvPacket();
							if ( iRecvLen < 0 )
							{
								
								return;
							}
							rBuf = new byte[iRecvLen]; // iRecvLen �� ���̸� �׽�Ʈ �غ��� �����Ҵ��� �ٽ� �õ� �Ѵ�.
							Log.e("ServicesTEST", "RECEIVE FINISH");
				
						} catch (IOException e) {
							// TODO Auto-generated catch block
							Log.d("recv_data" , e.getMessage() );
							e.printStackTrace();
						}
						//iRecvLen �� 0���� ������ �������� ������ ����� ��, ������ Ż��
						if (iRecvLen <= 0) {
							if (m_RemoteSocket.SocketClose())
							{
								
							}
							else
							{
								
							}
								
							return;
						}
						
						
						while ( m_RemoteSocket.GetPacket( rBuf ) ) {
								RecvManager.toBuffer(rBuf , iRecvLen);
						}
						
					
					
					}
				}
			});//.start();
			
		m_threadList.start();
		
		initFlag = true;
		
		
		
	}


	public void StartClient() {
		
		//MobileClient.getInstance().start();
	}
	
	public boolean stateSocket () {
		return m_RemoteSocket.getSocket().isConnected();
	}
	
	public void CloseClient(){
		m_RemoteSocket.SocketClose();
	}

	public static void SendData( byte[] sBuf) {
		m_RemoteSocket.SendPacket(sBuf);
		Log.d("MobileClient", "Send ����");
	}
	
}
