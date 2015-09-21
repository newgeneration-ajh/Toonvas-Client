package com.secmem.packet;

public class PacketType {
	
	/*OpCode*/
	public final static int REQ_CLIENTLIST = 1;         //클라이언트 목록
	public final static int REQ_LOGIN = 2;               //로그인 요청
	public final static int REQ_CREATEROOM = 3;      //방 만들기 요청
	public final static int REQ_JOINROOM = 4;         //방 참가 요청
	public final static int REQ_ROOMLIST = 5;         //방 리스트 요청
	public final static int REQ_EXITROOM = 6;         //방 나가기 요청
	public final static int REQ_ROOMMESSAGE = 7;   //방내 회원들에게 메시지 전송 요청
	public final static int REQ_SENDMESSAGE = 8;      //전체 회원들에게 메시지 전송 요청
	public final static int REQ_LOGOUT = 9;            //로그아웃 요청
	public final static int REQ_SENDOBJECT = 10;      //방내 회원들에게 Point 전송 요청
	public final static int REQ_IMGPROCESSING = 11;   //????
	public final static int REQ_PENTYPE = 12;            //방내 회원들에게 PenType 전송 요청
	public final static int REQ_JOIN = 13;               //회원가입 요청
//	public final static int REQ_ROOMDEL = 14;         //방 삭제 요청
	public final static int REQ_ROOM_PW_STATE = 14;  //방 비번 상태 요청
	
	public final static int REQ_PEN_UP = 15;
	
	public final static int REQ_ROOMSTART = 16;
	
	public final static int REQ_BACKUP = 17;
	
	public final static int REQ_UNDO = 18;
	public final static int REQ_REDO = 19;
	
	public final static int REQ_STRAT_BITMAP = 20;
	public final static int REQ_BITMAP_DATA = 21;
	public final static int REQ_END_BITMAP = 22;
	
	public final static int REQ_OBJECT_CHANGE = 23;
	
	public final static int REQ_IS_ALIVE = 24;
	public final static int REQ_PAGE = 25; 
	public final static int REQ_IMAGE_PROCESSING = 26;
	
	public final static int REQ_DEL_IMAGE = 28;
	public final static int REQ_GROUP = 29;
	public final static int REQ_UNGROUP = 30;
	
	public final static int REQ_OBJECT_START = 31;
	public final static int REQ_OBJECT_DATA = 32;
	public final static int REQ_OBJECT_END = 33;
	
	public final static int REQ_ROOM_ID_LIST = 34;
	
	
	//결과 패킷
	public final static int RET_LOGIN = 102;               //로그인 성공
	public final static int RET_CREATEROOM = 103;         //방만들기 성공
	public final static int RET_JOINROOM = 104;            //회원가입 성공
	public final static int RET_ROOMLIST = 105;            //룸 리스트 전송 성공
	public final static int RET_EXITROOM = 106;            //방 나가기 성공
	public final static int RET_ROOMCLIENTLIST = 107;      //방내 참가자 목록 전송 성공
	public final static int RET_DESTROYROOM = 108;      //방 삭제 성공
	public final static int RET_LOGOUT = 109;            //로그아웃 성공
	public final static int RET_SENDMESSAGE = 110;      //전체 회원들에게 메시지 전송 성공
	public final static int RET_SENDOBJECT = 111;         //방내 회원들에게 오브젝트 전송 성공
	public final static int RET_IMGPROCESSING = 112;      //????
	public final static int RET_PENTYPE = 113;            //방내 회원들에게 PenType 전송 성공
	public final static int RET_JOIN = 114;                  //회원가입 성공
	public final static int RET_NOROOMLIST = 115;         //방 목록이 없다
	public final static int RET_ROOMDEL_SUCCESS = 116;   //방 삭제 성공
	public final static int RET_ROOMDEL_FAIL = 117;      //방 삭제 실패

	public final static int RET_EXIT_OK = 118;               //방 나가기 성공
	public final static int RET_EXIT_NO = 119;               //방 나가기 실패
	public final static int RET_PW_OK = 120;               //방 비번 틀림
	public final static int RET_PW_NO = 121;               //방 비번 맞음
	public final static int RET_LOG_FAIL = 123;            //로그인 실패
	public final static int RET_JOIN_FAIL = 124;            //회원 가입 실패

	public final static int RET_ROOMJOIN_FAIL = 125;      //방 참가 실패
	public final static int RET_ROOMJOIN_OK = 126;    //방 참가 성공
	public final static int RET_ROOMJOIN_FULL = 127;      //방 인원 가득 참
	public final static int RET_ROOMMSG_OK = 128;      //방내 메시지 보내기 성공
	public final static int RET_ROOMMSG_NO = 129;      //방내 메시지 보내기 실패
	public final static int RET_ROOMPW_NO_EXIST = 130;
	public final static int RET_ROOMPW_OK_EXIST = 131;
	
	public final static int RET_PEN_UP = 132;
	
	public final static int RET_ROOMSTART = 133;
	
	public final static int RET_UNDO = 134;
	public final static int RET_REDO = 135;
	
	public final static int RET_START_BITMAP = 136;
	public final static int RET_BITMAP_DATA = 137;
	public final static int RET_END_BITMAP = 138;
	
	public final static int RET_OTHER_START_BITMAP = 139;
	public final static int RET_OBJECT_CHANGE = 140;
	
	public final static int RET_IS_ALIVE = 141;
	
	public final static int RET_PAGE = 142;
	
	public final static int RET_IMAGE_PROCESSING = 143;
	
	public final static int RET_DEL_IMAGE = 147;
	public final static int RET_GROUP = 148;
	public final static int RET_UNGROUP = 149;
	
	public final static int RET_OBJECT_START = 150;
	public final static int RET_OBJECT_DATA = 151;
	public final static int RET_OBJECT_END = 152;
	public final static int RET_ROOM_ID_LIST = 153;
	
	//패킷 길이
	public static final int LENTH_LOGIN = 32;
	public static final int LENTH_OBJECT = 24;
	
	
	
}
