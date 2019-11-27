# WARNING

This is WIP repo and it is under development. Use it at your own risk. 
If you have use-cases for such thing to be developed, please submit
an issue or PR with description of your needs / fixes.

## meta-trenchboot-demo

Meta layer for Trenchboot related demos

## Building

Make sure to adjust `~/ssh-keys` according to your configuration:

```
SHELL=bash kas-docker --ssh-dir ~/ssh-keys build meta-trenchboot-demo/kas.yml
```

Change a directory to `build/tmp/deploy/images/pcengines-apu2`. Find the
xen-dom0-image-pcengines-apu2 files with extensions wic.gz and wic.bmap.
Copy them to the apu platform (for example through ssh or memory stick).
At the platform, check device (`/dev/<dev>` ) of the drive to be flashed:

```bash
fdisk -l
```

Then flash the drive with bmap-tools:

```bash
bmaptool copy --bmap xen-dom0-image-pcengines-apu2.wic.bmap xen-dom0-image-pcengines-apu2.wic.gz /dev/<dev>
```

Example output

```bash
# bmaptool copy --bmap xen-dom0-image-pcengines-apu2.wic.bmap xen-dom0-image-pcengines-apu2.wic.gz /dev/sda
bmaptool: info: block map format version 2.0
bmaptool: info: 3163136 blocks of size 4096 (12.1 GiB), mapped 587526 blocks (2.2 GiB or 18.6%)
bmaptool: info: copying image 'xen-dom0-image-pcengines-apu2.wic.gz' to block device '/dev/sda' using bmap file 'xen-dom0-image-pcengines-apu2.wic.bmap'
bmaptool: info: 97% copied
bmaptool: info: 100% copied
bmaptool: info: synchronizing '/dev/sda'
bmaptool: info: copying time: 5m 30.3s, copying speed 6.9 MiB/sec
```

## Technical showcase

The demo has been shown at the [ELCE2019](https://3mdeb.com/news/events/#Embedded-Linux-Conference).
