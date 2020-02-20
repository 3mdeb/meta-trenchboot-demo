require recipes-extended/images/xen-dom0-image.bb

DESCRIPTION = "APU2 virtualized router - Xen dom0 image"

IMAGE_INSTALL_append = " \
  packagegroup-core-base-utils \
  ca-certificates \
  kernel-modules \
  tpm2-tools \
  tpm2-abrmd \
  tpm2-tss \
  systemd \
  tmux \
  grub \
  lvm2 \
  xen-xentrace \
  hostapd \
  iw \
  crda \
  flashrom \
  pciutils \
  usbutils \
  linux-firmware-ath10k \
  iperf3 \
  xen-router-networkd-config \
  virtualized-router-scripts \
  packagegroup-openwrt-full \
  mountd \
  ugps \
  usbmode \
"

IMAGE_FSTYPES_append = " wic.gz wic.bmap hddimg"
