echo
echo "[ COMPILE ] Compiling 'lucernas_assignment_8.s' and 'LucernasAssignment8.java'..."

make

echo
echo "[ RUN ] Running 'lucernas_assignment_8'..."

./lucernas_assignment_8

echo
echo "[ RUN ] Running 'LucernasAssginment8.class'..."

java LucernasAssignment8

echo
echo
echo
echo "[ CLEAN ] Cleaning up..."

make clean

echo
echo "Done"
echo
