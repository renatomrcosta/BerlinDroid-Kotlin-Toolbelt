#!/bin/zsh

DIRS=$(ls)

UPPERCASED=$(echo "$DIRS" | awk '{print toupper($0)}')

echo "$UPPERCASED"
