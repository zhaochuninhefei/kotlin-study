#!/bin/bash

echo "Check remote:"
git remote -v

echo "Push Start..."
git push origin --all
echo "Push Over."