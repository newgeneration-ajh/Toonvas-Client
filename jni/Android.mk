LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

OPENCV_LIB_TYPE:=STATIC
OPENCV_INSTALL_MODULES:=on

include D:\OpenCV-2.4.7-android-sdk\OpenCV-2.4.7-android-sdk\sdk\native\jni\OpenCV.mk

LOCAL_DEFAULT_CPP_EXTENSION := cpp
LOCAL_MODULE    := SSMProject
LOCAL_SRC_FILES := SSMProject.cpp
LOCAL_LDLIBS +=  -llog -ldl

include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := opencv_java
LOCAL_SRC_FILES := libopencv_java.so
include $(PREBUILT_SHARED_LIBRARY)