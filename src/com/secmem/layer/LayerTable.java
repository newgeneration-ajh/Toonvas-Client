package com.secmem.layer;

import java.util.Hashtable;


public class LayerTable {
	private Hashtable<Integer, LayerData> m_LayerHash = null;
	private int m_TableCnt  = 0;
	
	public LayerTable (  ) {
		
	}
	
	public LayerTable ( LayerData inData ) {
		m_TableCnt++;
		m_LayerHash.put(  m_TableCnt  , inData );
	}
	
	public void putTable ( LayerData inData ) {
		m_TableCnt++;
		m_LayerHash.put(  m_TableCnt  , inData );
	}
	
	public LayerData getTable ( int index ) {
		LayerData tmpData = m_LayerHash.get( index );
		return tmpData;
	}
	
	public boolean isEmpty ( ) {
		return m_LayerHash.isEmpty();
	}
}
