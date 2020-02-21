LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=47819091dc3777f6899ac4e6dbff2613"

SRC_URI = "git://github.com/oblique/create_ap.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d67a5a59df3c329058507d0cb3f6382d9a2f5f9a"

RDEPENDS_${PN} = "bash"
DEPENDS = "iptables dnsmasq util-linux procps hostapd iproute2 iw"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# This is a guess; additional arguments may be required
	oe_runmake install 'DESTDIR=${D}'
}

FILES_${PN} += "\
		${prefix}/lib \
		${datadir} \
"

