SUMMARY = "Add rc.local"
DESCRIPTION = "Add rc.local"
HOMEPAGE = ""
LICENSE = "CLOSED"

SRC_URI = " \
    file://rc.local \
    file://ndvm-save.sh \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${ROOT_HOME}
    install -d ${D}${sysconfdir}
    install -m  0755 ${S}/rc.local ${D}${sysconfdir}/
    install -m  0755 ${S}/ndvm-save.sh ${D}${ROOT_HOME}/
}

FILES_${PN} += "${sysconfdir} ${ROOT_HOME}/ndvm-save.sh"

RDEPENDS_${PN} += "bash"