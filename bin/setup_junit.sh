#!/bin/bash
# -*- coding: utf-8 -*-

# Author: YAMAMOTO Ryotaro
# Created: 2024-04-27 (Updated: 2025-01-14)

#
# Set constants.
#
junit_platform_version='1.11.3'
standalone_jar="./junit-platform-console-standalone-${junit_platform_version}.jar"

CLEAN=0
if [ $# -ge 1 ]; then
	if [ $1 == "--clean" ]; then
		CLEAN=1
	else
		echo "Unkwnon option"
		exit 1
	fi
fi

if [ $CLEAN == 1 ]; then
	if [ -f "${standalone_jar}" ]; then
		rm "${standalone_jar}"
	fi
else
	if [ ! -f "${standalone_jar}" ]; then
		curl "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${junit_platform_version}/junit-platform-console-standalone-${junit_platform_version}.jar" \
		--output "${standalone_jar}"
	fi
fi
