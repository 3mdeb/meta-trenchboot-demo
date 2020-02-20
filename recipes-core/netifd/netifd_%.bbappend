do_install_append(){
    # Copy the libs to proper directory
    cp -r ${D}/lib/* ${D}${base_libdir}
    rm -rf ${D}/lib
}

