### free -h

内存命令

### df -h
```perforce
$ df -h
Filesystem      Size  Used Avail Use% Mounted on
/dev/sda2        20G  3.5G   16G  18% /
tmpfs           3.9G     0  3.9G   0% /dev/shm
/dev/sda1       497M   81M  416M  17% /boot
```
用于显示**文件系统**的磁盘空间使用情况。它会列出已挂载的文件系统的信息，包括文件系统的挂载点、总容量、已使用空间、可用空间等。df -h命令提供了关于文件系统使用情况的快速概览。

#### lsblk

关注的是块设备的结构信息;lsblk用于列出块设备（磁盘、分区、逻辑卷等）的信息，包括设备名称、设备类型、挂载点等。它显示的是块设备的物理结构信息，可以用来查看磁盘的分区情况以及设备之间的关系。

```perforce
$ lsblk
NAME           MAJ:MIN RM  SIZE RO TYPE MOUNTPOINT
sda             8:0    0   20G  0 disk 
├─sda1          8:1    0  500M  0 part /boot
└─sda2          8:2    0 19.5G  0 part /
└─sda3          8:3    0    75G  0 part  
  └─centos-root 253:0    0    75G  0 lvm   /data
```
一个磁盘下有多个分区，分区可以直接格式为文件系统,分区下有多个lv卷；
sda是一个磁盘设备，它包含了三个分区：sda1、sda2和sda3。sda1分区被挂载到根目录 (/)，sda2分区被挂载到 /home 目录，而sda3分区是一个逻辑卷（LVM），其中包含逻辑卷 mylv，并且它被挂载到 /data 目录。
其中centos为lvm的逻辑卷，root为卷组，被挂载到/data目录下

### pvs  lvs
pv (Physical Volume) 卷和 lv (Logical Volume) 卷是 LVM (Logical Volume Manager) 中的两个重要概念。

使用 lsblk 命令可以显示 pv 卷和 lv 卷的信息。然而，为了更详细地查看 LVM 卷的信息，可以使用 pvs 和 lvs 命令。

pvs 命令用于显示物理卷 (Physical Volume) 的信息，包括物理卷的名称、大小、分配情况等。
lvs 命令用于显示逻辑卷 (Logical Volume) 的信息，包括逻辑卷的名称、大小、所属卷组 (Volume Group) 等。
下面是展示 pv 卷和 lv 卷信息的示例：

使用 pvs 命令：
```perforce
$ pvs
PV         VG   Fmt  Attr PSize   PFree
/dev/sda2  vg1  lvm2 a--  100.00g 20.00g
```
在上述示例中，/dev/sda2 是一个物理卷，它属于卷组 vg1。物理卷的总大小为 100.00GB，可用空间为 20.00GB。

使用 lvs 命令：
```perforce
$ lvs
LV   VG   Attr       LSize   Pool Origin Data%  Meta%  Move Log Cpy%Sync Convert
lv1  vg1  -wi-a-----  50.00g                                                    
lv2  vg1  -wi-a----- 100.00g
```
在上述示例中，lv1 和 lv2 是属于卷组 vg1 的逻辑卷。逻辑卷的大小分别为 50.00GB 和 100.00GB。

通过使用 pvs 和 lvs 命令，您可以获取更详细的有关物理卷和逻辑卷的信息，包括卷的属性、大小、空闲空间等。这有助于管理和监视 LVM 的存储配置。

### 物理卷和逻辑卷的关系

物理卷（Physical Volume，PV）和逻辑卷（Logical Volume，LV）是 Linux 系统中 LVM（Logical Volume Manager，逻辑卷管理器）的两个关键概念，它们之间存在以下关系：

物理卷（Physical Volume）：物理卷是指硬盘或分区上的存储空间，可以是整个硬盘、分区或者是多个磁盘组成的 RAID 阵列。物理卷是 LVM 的基本单元，通过将物理卷划分为一个或多个物理区域（Physical Extent），LVM 可以管理和分配磁盘空间。物理卷使用物理卷标识符（Physical Volume Identifier，PVID）来唯一标识。
卷组（Volume Group）：卷组是由一个或多个物理卷组成的逻辑存储单元，可以将多个物理卷合并为一个卷组。卷组为逻辑卷提供了一个逻辑容器，将物理卷的存储空间合并在一起，形成一个较大的、可供逻辑卷使用的存储池。卷组使用卷组标识符（Volume Group Identifier，VGID）来唯一标识。
逻辑卷（Logical Volume）：逻辑卷是从卷组中分配的逻辑存储空间，它类似于传统的分区，但具有更大的灵活性。逻辑卷可以具有不同的大小、文件系统和属性，并且可以动态调整其大小。逻辑卷使用逻辑卷标识符（Logical Volume Identifier，LVID）来唯一标识。
关系示例：

多个物理卷（PV）可以组成一个卷组（VG），卷组提供了一个逻辑容器来管理和分配物理卷的存储空间。在卷组中，逻辑卷（LV）可以从卷组中分配一部分或全部的存储空间。逻辑卷的大小和数量可以根据需求进行调整，而不需要重新分区硬盘。

总结：
物理卷是基本的存储单元，卷组是由一个或多个物理卷组成的逻辑存储单元，而逻辑卷是从卷组中分配的逻辑存储空间。物理卷提供了实际的存储空间，卷组将多个物理卷合并在一起，逻辑卷则是从卷组中分配的可管理的存储空间。这种层次结构使得 LVM 可以在逻辑层面上对存储进行管理和操作。