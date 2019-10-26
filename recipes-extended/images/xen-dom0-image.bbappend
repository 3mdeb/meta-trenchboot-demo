IMAGE_INSTALL_append = " \
  pfsense-preinstalled \
  hvm-create \
  systemd \
  xen-xentrace \
  rc-local \
  "

ROOTFS_POSTPROCESS_COMMAND += "rootfs_install_ndvm_image; "

do_rootfs[depends] += "xen-ndvm-image:do_image_complete"

rootfs_install_ndvm_image(){
    install -d ${IMAGE_ROOTFS}/${datadir}/xen-images/
    install ${DEPLOY_DIR_IMAGE}/xen-ndvm-image-${MACHINE}.hddimg ${IMAGE_ROOTFS}/${datadir}/xen-images/xen-ndvm-image-1.hddimg
    install ${DEPLOY_DIR_IMAGE}/xen-ndvm-image-${MACHINE}.hddimg ${IMAGE_ROOTFS}/${datadir}/xen-images/xen-ndvm-image-2.hddimg
    install ${DEPLOY_DIR_IMAGE}/xen-ndvm-image-${MACHINE}.hddimg ${IMAGE_ROOTFS}/${datadir}/xen-images/xen-ndvm-image-3.hddimg
}

IMAGE_FSTYPES = "ext4 wic.gz wic.bmap"
