# Copyright (c) Meta Platforms, Inc. and affiliates.
#
# This source code is licensed under the MIT license found in the
# LICENSE file in the root directory of this source tree.

cmake_minimum_required(VERSION 3.10.2)
set(CMAKE_VERBOSE_MAKEFILE on)

add_compile_options(-fexceptions -frtti -O3)

add_library(jsireact
        STATIC
        JSIExecutor.cpp
        JSINativeModules.cpp)

target_include_directories(jsireact PUBLIC .)

target_link_libraries(jsireact
        reactnative
        reactperflogger
        folly_runtime
        glog
        jsi)
