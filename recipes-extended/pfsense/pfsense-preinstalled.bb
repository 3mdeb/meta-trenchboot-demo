SUMMARY = "pfsense preinstalled image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "https://cloud.3mdeb.com/index.php/s/dXNRDZwXeP5FD9s/download;downloadfilename=pfsense.img.gz"

SRC_URI[md5sum] = "eb5a167a1c6a3f287f364b7ccfa705d7"
SRC_URI[sha256sum] = "d36b27683e67e38d67af5904893635922e5a2f045ede7e5d3ea534e11b9576b1"

do_install() {
    install -d ${D}${datadir}/xen-images
    install -m 0644 ${WORKDIR}/pfsense.img ${D}${datadir}/xen-images/
}

FILES_${PN} += "${datadir}/xen-images/pfsense.img"
