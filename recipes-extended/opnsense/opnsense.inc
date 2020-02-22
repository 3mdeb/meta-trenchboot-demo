SUMMARY = "OPNsense nano image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "https://mirror.dns-root.de/opnsense/releases/${PV}/OPNsense-${PV}-OpenSSL-nano-amd64.img.bz2;unpack=no"

do_install() {
    install -d ${D}${datadir}/xen-images
    install -m 0644 ${WORKDIR}/OPNsense-${PV}-OpenSSL-nano-amd64.img.bz2 ${D}${datadir}/xen-images
}

FILES_${PN} += "${datadir}/xen-images/OPNsense-${PV}-OpenSSL-nano-amd64.img.bz2"
