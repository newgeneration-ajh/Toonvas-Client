package com.secmem.packet;

import com.secmem.network.ServerInfo;

public class PacketData {
	
	public int m_opCode;
	public byte[] m_tmpByte;
	public int m_lengTh;
	
	public PacketData ( int opCode , byte[] inData , int lengTh ) {
		m_opCode = opCode;
		m_lengTh = lengTh + ServerInfo.OPCODE_LENTH + ServerInfo.LENTHCODE_LENTH;		
		m_tmpByte = inData;
	}

}
