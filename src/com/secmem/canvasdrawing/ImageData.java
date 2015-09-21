package com.secmem.canvasdrawing;

import android.graphics.Bitmap;
import android.graphics.RectF;

import com.samsung.android.sdk.pen.document.SpenObjectImage;

public class ImageData {
	Bitmap m_inBitmap;
	RectF m_Center;
	
	public ImageData ( SpenObjectImage inImage )
	{
		m_inBitmap = inImage.getImage();
		m_Center = inImage.getRect();
	}
}
