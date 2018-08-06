include(ExternalProject)

# Denote the name of the folder where Darknet is to be compiled and set a
# variable named darknet.

set(DARKNET_PREFIX darknet)

# Set a variable to point to the URL of Darknet's source code. However, since it's already
# downloaded:
set(DARKNET_URL ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/darknet-nao-master.zip)

# MD5 sum of the file has been calculated, now we just set it aa a variable.
#set(DARKNET_URL_MD5 b29052cf8dfa48b771397d4bb9ddc280)

# How many CPU cores we want to use for building (for now, it's set as 2)
set(NCPU 4)

# Add instructions to build the Darknet source
ExternalProject_Add(${DARKNET_PREFIX}
  PREFIX ${DARKNET_PREFIX}
  URL ${DARKNET_URL}
  URL_MD5 ${DARKNET_URL_MD5}
  CONFIGURE_COMMAND ""
  BUILD_COMMAND make
  BUILD_IN_SOURCE 1
  INSTALL_COMMAND ""
  LOG_DOWNLOAD 1
  LOG_BUILD 1
)

ExternalProject_Get_Property(${DARKNET_PREFIX} SOURCE_DIR)
message(STATUS "Source directory of ${DARKNET_PREFIX} is ${SOURCE_DIR}")

# Set seperate directories for building in Debug or Release modes
set(DARKNET_DEBUG_DIR ${SOURCE_DIR}/build/${DARKNET_PREFIX}_debug)
set(DARKNET_RELEASE_DIR ${SOURCE_DIR}/build/${DARKNET_PREFIX}_release)

#Link the correct Darknet directory when the project is in Debug or release modes
if (CMAKE_BUILD_TYPE STREQUAL "debug")
  # in Debug mode
  link_directories(${DARKNET_DEBUG_DIR})
  set(DARKNET_LIBS darknet_debug)
  set(DARKNET_LIBRARY_DIRS ${DARKNET_DEBUG_DIR})
elseif (CMAKE_BUILD_TYPE STREQUAL "release")
  # in Release mode
  link_directories(${DARKNET_RELEASE_DIR})
  set(DARKNET_LIBS darknet)
  set(DARKNET_LIBRARY_DIRS ${DARKNET_RELEASE_DIR})
endif()

add_library(darknet_lib SHARED IMPORTED)
set_target_properties(darknet_lib PROPERTIES IMPORTED_LOCATION ~/nbites/src/man/thirdparty/darknet/darknet.so)
