#!/bin/bash

pkill -TERM steam
sleep 1

pkill -TERM gamescope
sleep 1

pkill -KILL gamescope 2>/dev/null

exit 0
