#!/bin/sh

function errorCheck {
    ERROR_CODE="${?}"
    if [ "${ERROR_CODE}" -ne 0  ]; then
        echo "${1} : ${ERROR_CODE}"
        exit 1
    fi
}

# Start the 2.4GHz WiFi Access Point
echo "Starting 2.4GHz WiFi Access Point..."
systemctl start hostapd
errorCheck "Failed to start Access Point"
echo "Access Point started"


# Unpack the OPNsense image if required
if [ ! -f $OPNSENSE_IMG ]; then
  echo "Could not find OPNsense image..."
  echo "Trying to unpack..."

  if [ ! -f $OPNSENSE_BZ2 ]; then
    echo "Could not find OPNsense image archive"
    exit 1
  else
    echo "Unpacking OPNsense image archive..."
    pv $OPNSENSE_BZ2 | bunzip2 -dk > $OPNSENSE_IMG
    errorCheck "Failed to unpack $OPNSENSE_BZ2"
  fi
fi


# Pass 1st Ethernet as WAN for OPNsense
xl pci-assignable-add 01:00.0
errorCheck "Failed pass PCI device"

xl create opnsense.cfg
errorCheck "Failed to create OPNsense VM"
