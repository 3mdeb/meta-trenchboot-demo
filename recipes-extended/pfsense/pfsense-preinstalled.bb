SUMMARY = "pfsense preinstalled image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "https://cloud.3mdeb.com/index.php/s/5Mjf8Rpe4Ptttt4/download;downloadfilename=pfsense.img.gz"

SRC_URI[md5sum] = "e922d972d43a5c42f1a8845c40b96142"
SRC_URI[sha256sum] = "9237708cf5fe33d77aad0ec920b084ae597b53524bf37760d05aca04c5eb8717"

do_install() {
    install -d ${D}${datadir}/xen-images
    install -m 0644 ${WORKDIR}/pfsense.img ${D}${datadir}/xen-images/
}

FILES_${PN} += "${datadir}/xen-images/pfsense.img"
