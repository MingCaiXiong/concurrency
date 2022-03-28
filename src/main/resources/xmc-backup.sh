#!/usr/bin/env bash
echo '-----------[备份脚本开始执行]-----------'
projectName='movie'
backUpFolder=/opt/backups/$projectName
echo '备份目录：'$backUpFolder

date_now=`date +%Y-%m-%d_%H-%M`
backFileName=$projectName'_'$date_now
echo '备份名称：'$backFileName

cd backUpFolder
mkdir -p $backFileName


# -d 数据库名
# -o 导出目录
#mongodump -h 127.0.0.1:19999 -d movies -u user1 -p Password -o $backUpFolder

#mysqldump -h localhost -uroot -p123.Com! --databases $DataBaseName > $BackupDir/$sqltag

echo '数据库导出：'$backUpFolder'   完成'
#进行压缩并删除原文件
#tar zcvf $backUpFolder.tar.gz $backFileName
echo '压缩导出文件：'$backUpFolder'   完成'
rm -rf $backFileName

#定时清除文件，以访长期堆积占用磁盘空间(删除5天以前带有tar.gz文件)
#find $BackupDir -mtime +5 -name '*.tar.gz' -exec rm -rf {
#   } \;

echo '-----------[备份脚本结束执行]-----------'