package com.secmem.packet;

public class PacketType {
	
	/*OpCode*/
	public final static int REQ_CLIENTLIST = 1;         //Ŭ���̾�Ʈ ���
	public final static int REQ_LOGIN = 2;               //�α��� ��û
	public final static int REQ_CREATEROOM = 3;      //�� ����� ��û
	public final static int REQ_JOINROOM = 4;         //�� ���� ��û
	public final static int REQ_ROOMLIST = 5;         //�� ����Ʈ ��û
	public final static int REQ_EXITROOM = 6;         //�� ������ ��û
	public final static int REQ_ROOMMESSAGE = 7;   //�泻 ȸ���鿡�� �޽��� ���� ��û
	public final static int REQ_SENDMESSAGE = 8;      //��ü ȸ���鿡�� �޽��� ���� ��û
	public final static int REQ_LOGOUT = 9;            //�α׾ƿ� ��û
	public final static int REQ_SENDOBJECT = 10;      //�泻 ȸ���鿡�� Point ���� ��û
	public final static int REQ_IMGPROCESSING = 11;   //????
	public final static int REQ_PENTYPE = 12;            //�泻 ȸ���鿡�� PenType ���� ��û
	public final static int REQ_JOIN = 13;               //ȸ������ ��û
//	public final static int REQ_ROOMDEL = 14;         //�� ���� ��û
	public final static int REQ_ROOM_PW_STATE = 14;  //�� ��� ���� ��û
	
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
	
	
	//��� ��Ŷ
	public final static int RET_LOGIN = 102;               //�α��� ����
	public final static int RET_CREATEROOM = 103;         //�游��� ����
	public final static int RET_JOINROOM = 104;            //ȸ������ ����
	public final static int RET_ROOMLIST = 105;            //�� ����Ʈ ���� ����
	public final static int RET_EXITROOM = 106;            //�� ������ ����
	public final static int RET_ROOMCLIENTLIST = 107;      //�泻 ������ ��� ���� ����
	public final static int RET_DESTROYROOM = 108;      //�� ���� ����
	public final static int RET_LOGOUT = 109;            //�α׾ƿ� ����
	public final static int RET_SENDMESSAGE = 110;      //��ü ȸ���鿡�� �޽��� ���� ����
	public final static int RET_SENDOBJECT = 111;         //�泻 ȸ���鿡�� ������Ʈ ���� ����
	public final static int RET_IMGPROCESSING = 112;      //????
	public final static int RET_PENTYPE = 113;            //�泻 ȸ���鿡�� PenType ���� ����
	public final static int RET_JOIN = 114;                  //ȸ������ ����
	public final static int RET_NOROOMLIST = 115;         //�� ����� ����
	public final static int RET_ROOMDEL_SUCCESS = 116;   //�� ���� ����
	public final static int RET_ROOMDEL_FAIL = 117;      //�� ���� ����

	public final static int RET_EXIT_OK = 118;               //�� ������ ����
	public final static int RET_EXIT_NO = 119;               //�� ������ ����
	public final static int RET_PW_OK = 120;               //�� ��� Ʋ��
	public final static int RET_PW_NO = 121;               //�� ��� ����
	public final static int RET_LOG_FAIL = 123;            //�α��� ����
	public final static int RET_JOIN_FAIL = 124;            //ȸ�� ���� ����

	public final static int RET_ROOMJOIN_FAIL = 125;      //�� ���� ����
	public final static int RET_ROOMJOIN_OK = 126;    //�� ���� ����
	public final static int RET_ROOMJOIN_FULL = 127;      //�� �ο� ���� ��
	public final static int RET_ROOMMSG_OK = 128;      //�泻 �޽��� ������ ����
	public final static int RET_ROOMMSG_NO = 129;      //�泻 �޽��� ������ ����
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
	
	//��Ŷ ����
	public static final int LENTH_LOGIN = 32;
	public static final int LENTH_OBJECT = 24;
	
	
	
}
