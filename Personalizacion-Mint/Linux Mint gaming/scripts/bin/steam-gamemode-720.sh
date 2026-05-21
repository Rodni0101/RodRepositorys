#!/bin/bash

gamescope -w 1280 -h 720 -W 1920 -H 1080 -f -- steam -gamepadui

#Optimización para nvidia:
#gamescope -e --prefer-vk-device --disable-color-management -- steam -gamepadui

#si hay tearing o stutter
#__GL_SYNC_TO_VBLANK=1 gamescope -e -- steam -gamepadui
