package com.secmem.canvasdrawing;

public class DrawingData {
	public float m_pointX = 0;
	public float m_pointY = 0;
	public float m_pressure = 0;
	
	public DrawingData( float inX , float inY , float inPressure) 
	{
		m_pointX = inX;
		m_pointY = inY;
		m_pressure = inPressure;
	} 
}
