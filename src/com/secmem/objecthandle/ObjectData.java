package com.secmem.objecthandle;

public class ObjectData {
	public float m_AxisX;
	public float m_AxisY;
	public float m_Pressure;
	public int m_Color;
	public int m_PointSize;
	public int m_LayerNum;
	public int m_Type;
	
	public ObjectData ( float inAxisX , float inAxixY , float inPressure , int inSize , int inColor , int inLayernum  ,int inType )  {
		m_AxisX = inAxisX;
		m_AxisY = inAxixY;
		m_Pressure = inPressure;
		m_Color = inColor;
		m_PointSize = inSize;
		m_LayerNum = inLayernum;
		m_Type = inType;
	}
}
