SUMMARY = "HVM create"
DESCRIPTION = "HVM create"
HOMEPAGE = ""
LICENSE = "CLOSED"

SRC_URI = " \
  file://opnsense.cfg \
  file://vms.sh \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = "opnsense pv hostapd"

do_install() {
    install -d ${D}${ROOT_HOME}
    install -m  0755 ${S}/vms.sh ${D}${ROOT_HOME}
    install -m  0644 ${S}/opnsense.cfg ${D}${ROOT_HOME}
}

FILES_${PN} += "${ROOT_HOME}"
