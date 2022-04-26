#!/bin/bash


if [ ! -f golden.txt ]; then
    make docker-run > golden.txt
    echo "Created golden master, run again to compare"
    exit 0
fi

make docker-run > current.txt
diff golden.txt current.txt > /dev/null

if [ $? == 0 ]; then
    echo "SUCCESS: current is equal to golden master"
else
    echo "FAIL: current differs from golden master"
    exit 2
fi
