package com.secmem.canvasdrawing;


public class PenName {
	public final static int SPEN_BRUSH_ID = 0;
	public final static int SPEN_CHINESE_BRUSH_ID = 1;
	public final static int SPEN_INK_PEN_ID = 2;
	public final static int SPEN_MAGIC_PEN_ID = 3;
	public final static int SPEN_MARKER_ID = 4;
	public final static int SPEN_PENCIL_ID = 5;
	
	public static final String	SPEN_BRUSH = new String ( "com.samsung.android.sdk.pen.pen.preload.Brush" );
	public static final String	SPEN_CHINESE_BRUSH = new String ( "com.samsung.android.sdk.pen.pen.preload.ChineseBrush" ); 
	public static final String	SPEN_INK_PEN = new String ( "com.samsung.android.sdk.pen.pen.preload.InkPen" ); 
	public static final String	SPEN_MAGIC_PEN = new String ( "com.samsung.android.sdk.pen.pen.preload.MagicPen" );
	public static final String	SPEN_MARKER = new String ( "com.samsung.android.sdk.pen.pen.preload.Marker" );
	public static final String	SPEN_PENCIL = new String ( "com.samsung.android.sdk.pen.pen.preload.Pencil" );
	
	public static int penId ( String inPEN )
	{
		if ( inPEN.equals(SPEN_BRUSH) )
		{
			return SPEN_BRUSH_ID;
		}
		else if ( inPEN.equals(SPEN_CHINESE_BRUSH) )
		{
			return SPEN_CHINESE_BRUSH_ID;
		}
		else if ( inPEN.equals(SPEN_INK_PEN)  )
		{
			return SPEN_INK_PEN_ID;
		}
		else if ( inPEN.equals(SPEN_MAGIC_PEN) )
		{
			return SPEN_MAGIC_PEN_ID;
		}
		else if ( inPEN.equals(SPEN_MARKER) )
		{
			return SPEN_MARKER_ID;
		}
		else if ( inPEN.equals(SPEN_PENCIL) )
		{
			return SPEN_PENCIL_ID;
		}
		else
		{
			return SPEN_PENCIL_ID;
		}
	}
	public static String penName ( int inID )
	{
		if ( inID == SPEN_BRUSH_ID )
		{
			return SPEN_BRUSH;
		}
		else if ( inID == SPEN_CHINESE_BRUSH_ID )
		{
			return SPEN_CHINESE_BRUSH;
		}
		else if ( inID == SPEN_INK_PEN_ID )
		{
			return SPEN_INK_PEN;
		}
		else if ( inID == SPEN_MAGIC_PEN_ID )
		{
			return SPEN_MAGIC_PEN;
		}
		else if ( inID == SPEN_MARKER_ID )
		{
			return SPEN_MARKER;
		}
		else if ( inID == SPEN_PENCIL_ID )
		{
			return SPEN_PENCIL;
		}
		else
		{
			return SPEN_PENCIL;
		}
	}
}
