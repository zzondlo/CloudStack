#!/bin/sh

export CATALINA_HOME=/usr/share/tomcat

ant clean-all

ant automated-test-run

exit $?