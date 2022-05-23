# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)
project(dlab-lib LANGUAGES C CXX)

#set(NAME "dlab-lib")
#set(PROJECT_NAME ${NAME})

#库目录
#set(TOP_DIR ${CMAKE_CURRENT_LIST_DIR}/../)

#开始 OpenCV
set(CMAKE_VERBOSE_MAKEFILE on)
#set(libs "${CMAKE_SOURCE_DIR}/src/main/jniLibs")
set(libs "${CMAKE_SOURCE_DIR}/jniLibs")
include_directories(${CMAKE_SOURCE_DIR}/include)

#include_directories(${CMAKE_SOURCE_DIR}/src/main/cpp/include/opencv2)

add_library(libopencv_calib3d STATIC IMPORTED )
set_target_properties(libopencv_calib3d PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_calib3d.a")

add_library(libopencv_core STATIC IMPORTED )
set_target_properties(libopencv_core PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_core.a")

add_library(libopencv_java3 SHARED IMPORTED )
set_target_properties(libopencv_java3 PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_java3.so")

add_library(libopencv_features2d STATIC IMPORTED )
set_target_properties(libopencv_features2d PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_features2d.a")

add_library(libopencv_flann STATIC IMPORTED )
set_target_properties(libopencv_flann PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_flann.a")

add_library(libopencv_highgui STATIC IMPORTED )
set_target_properties(libopencv_highgui PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_highgui.a")

add_library(libopencv_imgcodecs STATIC IMPORTED )
set_target_properties(libopencv_imgcodecs PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_imgcodecs.a")

add_library(libopencv_imgproc STATIC IMPORTED )
set_target_properties(libopencv_imgproc PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_imgproc.a")

add_library(libopencv_ml STATIC IMPORTED )
set_target_properties(libopencv_ml PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_ml.a")

add_library(libopencv_objdetect STATIC IMPORTED )
set_target_properties(libopencv_objdetect PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_objdetect.a")

add_library(libopencv_photo STATIC IMPORTED )
set_target_properties(libopencv_photo PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_photo.a")

add_library(libopencv_shape STATIC IMPORTED )
set_target_properties(libopencv_shape PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_shape.a")

add_library(libopencv_stitching STATIC IMPORTED )
set_target_properties(libopencv_stitching PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_stitching.a")

add_library(libopencv_superres STATIC IMPORTED )
set_target_properties(libopencv_superres PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_superres.a")

add_library(libopencv_video STATIC IMPORTED )
set_target_properties(libopencv_video PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_video.a")

add_library(libopencv_videoio STATIC IMPORTED )
set_target_properties(libopencv_videoio PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_videoio.a")

add_library(libopencv_videostab STATIC IMPORTED )
set_target_properties(libopencv_videostab PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_videostab.a")

add_library(libopencv_ts STATIC IMPORTED )
set_target_properties(libopencv_ts PROPERTIES
        IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libopencv_ts.a")

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fexceptions -frtti")

#include_directories(D:/Projects/Android/CLMAndroid/OpenCV-android-sdk/sdk/native/jni/include )
#set(OpenCV_DIR D:/Projects/Android/CLMAndroid/OpenCV-android-sdk/sdk/native/jni)
#find_package(OpenCV REQUIRED)
#target_link_libraries(${OpenCV_LIBS})
#-------------------------------------------------OpenCV 结束

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#add_subdirectory(${TOP_DIR}/dlib dlib_binary_dir)
#add_subdirectory(${TOP_DIR}/minilog minilog_binary_dir)
#add_subdirectory(${TOP_DIR}/common common_binary_dir)
#add_subdirectory(${TOP_DIR}/LinearMath LinearMath_binary_dir)

#add_subdirectory(dlib dlib_binary_dir)
add_subdirectory(dlib)
#add_subdirectory(minilog minilog_binary_dir)
#add_subdirectory(common common_binary_dir)
#add_subdirectory(LinearMath LinearMath_binary_dir)

#add_subdirectory(dlib)
#add_subdirectory(minilog)
#add_subdirectory(common)
#add_subdirectory(LinearMath)

add_library(
        # Sets the name of the library.
        dlab-lib
        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).

        #log
        log/logging.cc
        log/logging.h

        LinearMath/Matrix3x3.h
        LinearMath/MinMax.h
        LinearMath/QuadWord.h
        LinearMath/Quaternion.h
        LinearMath/Scalar.h
        LinearMath/Transform.h
        LinearMath/Vector3.h

        #dlib
        dlib/threads/threads_kernel_shared.cpp
        dlib/threads/threads_kernel_shared.h
        dlib/entropy_decoder/entropy_decoder_kernel_2.cpp
        dlib/entropy_decoder/entropy_decoder_kernel_2.h
        dlib/base64/base64_kernel_1.cpp
        dlib/base64/base64_kernel_1.h
        dlib/threads/threads_kernel_1.cpp
        dlib/threads/threads_kernel_1.h
        dlib/threads/threads_kernel_2.cpp
        dlib/threads/threads_kernel_2.h

        #common
        fileutils.h
        types.h
        bitmap2mat2bitmap.cpp
        bitmap2mat2bitmap.h
        rgb2yuv.cpp
        rgb2yuv.h
        yuv2rgb.cpp
        yuv2rgb.h

        #main
        imageutils_jni.cpp
        jni_head_pose_det.cpp
)


# 指定引用的外部库的搜索路径
#LINK_DIRECTORIES(${ROOT_DIR}/opencv32)
#link_directories(opencv32)


# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
#add_library(opencv_calib3d STATIC IMPORTED)



#find_package(OpenCV REQUIRED)
#include_directories(${OpenCV_INCLUDE_DIRS})


#add_library(opencv_core STATIC IMPORTED)
#include_directories(${PROJECT_SOURCE_DIR}/include
#        include/opencv2)

target_link_libraries(dlab-lib
        libopencv_java3
        libopencv_calib3d
        libopencv_core
        libopencv_features2d
        libopencv_flann
        libopencv_highgui
        libopencv_imgcodecs
        libopencv_imgproc
        libopencv_ml
        libopencv_objdetect
        libopencv_photo
        libopencv_shape
        libopencv_stitching
        libopencv_superres
        libopencv_video
        libopencv_videoio
        libopencv_videostab
        #dlib
        jnigraphics
        ${log-lib}
)