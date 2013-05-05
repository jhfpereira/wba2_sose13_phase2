#!/bin/bash


#path to schema file
schemafile="$1"

#relative path to the xml instances
folderpath="$2"

if [ -z $schemafile ]; then
    schemafile="colourconnection.xsd"
fi

if [ -z $folderpath ]; then
    folderpath="./xml_test_instances/"
    
    if [ ! -d $folderpath ]; then
        echo "Folder \"$folderpath\" does not exist!"
        exit
    fi
fi


if [ ! -e $schemafile ]; then
    echo "Schema \"$schemafile\" does not exist!"
    exit
fi


non_valid_cnt=0

file_cnt=`ls $folderpath*.xml -1 | wc -w`

files_not_validated=""

for filename in $folderpath*.xml
do

    xmllint --schema $schemafile --noout $filename > /dev/null 2>&1

    if [ $? -ne 0 ]; then
        non_valid_cnt=`expr $non_valid_cnt + 1`
        files_not_validated=$files_not_validated$filename" "
    fi

done


if [ $non_valid_cnt -eq 0 ]; then
    echo ""
    echo "All files were validated successfully!"
    echo "-----------------"
    echo ""
else
    echo ""
    echo "$non_valid_cnt of $file_cnt files failed validation!"
  
    echo "-----------------"
    for file in $files_not_validated
    do
        echo $file
    done
    echo ""
fi
