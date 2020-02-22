FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_apped() {
    rm ${D}${sysconfdir}/hostapd.conf
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}
}
