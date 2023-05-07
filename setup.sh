# Creates directory and solution files for new problem
# Usage: bash setup.sh problem_name
mkdir "$1"
cd "$1"
touch Solution.cpp
touch Solution.java
touch Solution.py
