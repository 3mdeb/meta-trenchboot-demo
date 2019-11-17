require recipes-extended/images/xen-dom0-image.bb

DESCRIPTION = "APU2 virtualized router router - Xen dom0 image"

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
  flashrom \
  pciutils \
  usbutils \
"

# IMAGE_FSTYPES = "hddirect"
