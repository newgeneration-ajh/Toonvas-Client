package com.secmem.room;

/**
 * @author sun
 *
 */
public class RoomData {

	private int mRoomNum;
	private int mPw;
	private String mRoomTitle;
	private String mMaker;
	private int mPersonCount;
	
	public RoomData( String _roomTitle, String _maker, int _pw){
		mRoomTitle = _roomTitle;
		mMaker = _maker;
		mPw = _pw;
	}
	
	public RoomData( int _roomNumber,String _roomTitle, String _maker, int _pw, int _count){
		mRoomTitle = _roomTitle;
		mMaker = _maker;
		mPw = _pw;
		mRoomNum = _roomNumber;
		mPersonCount = _count;
	}
	
	
	
	public int getmPw() {
		return mPw;
	}



	public void setmPw(int mPw) {
		this.mPw = mPw;
	}



	public int getmRoomNum() {
		return mRoomNum;
	}
	public void setmRoomNum(int mRoomNum) {
		this.mRoomNum = mRoomNum;
	}
	public String getmRoomTitle() {
		return mRoomTitle;
	}
	public void setmRoomTitle(String mRoomTitle) {
		this.mRoomTitle = mRoomTitle;
	}
	public String getmMaker() {
		return mMaker;
	}
	public void setmMaker(String mMaker) {
		this.mMaker = mMaker;
	}
	public int getmPersonCount() {
		return mPersonCount;
	}
	public void setmPersonCount(int mPersonCount) {
		this.mPersonCount = mPersonCount;
	}
	
	
}
