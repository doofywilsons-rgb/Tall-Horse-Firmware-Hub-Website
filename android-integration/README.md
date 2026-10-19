# FM1 Open → Android app: integration handoff

**Status (2026-10-18):** Public catalog and website support are implemented. The existing F-1 Tall Horse Android production app is **not** contained in this repository; this Java helper has **not** been compiled into or installed as an APK. Do not mistake this file for an Android app release.

## Intended experience
When selecting the firmware with exact ID `fm1-open`, show an **FM1 Open — Setup & Tools** section within the existing Tall Horse firmware detail screen. Present three verified, user-reported statuses: successful FM1 Open boot, audio output, and preset change on 2026-10-18. Label automatic Tall Horse cross-firmware switching, full backup/restore and alternate-engine coverage **not tested**.

Show a **View setup guide** action linking to `https://github.com/doofywilsons-rgb/Tall-Horse-Firmware-Hub-Website/blob/main/workbench.html` until the website is actually hosted. Provide **Open official Workbench** using the Java helper [`android-integration/Fm1OpenWorkbench.java`](../android-integration/Fm1OpenWorkbench.java), called from the app's existing, themed detail-screen click handler; *do not* substitute an Android system file picker for its interface.

The Java helper uses Android's external browser intent and requires no USB permissions. Device-oriented Workbench functions require **desktop Chrome or Edge** and a compatible FM-1 USB-MIDI connection. On the phone, the external page may allow browsing but must not be represented as a proven mobile USB-MIDI editor.

## Data contract for the app
- `catalog_id: "fm1-open"` uniquely selects this record (never infer it from a shared product identity).
- `catalog_only: true` and `importable_package: false` mean the record has **no Tall Horse-distributed .fwsc file**.
- `companion_tools[0].url` is the actual official Workbench address.
- `hardware_validation` values represent the user's physical-device observations only.
- `package_count` remains **25** importable packages; `catalog_entry_count` is **26** visible OS entries. The official V15 recovery is separately categorized and is **not** a selectable OS.
- The catalog schema is additive; legacy firmware-import logic must **skip catalog-only records** before trying to resolve a filename/hash.

## Wiring when Android source is available
1. Copy the Java helper into the existing Android Java source package, adding that package line.
2. In the existing firmware-detail handler, check `Fm1OpenWorkbench.supports(firmware.catalogId)` and expose the Setup & Tools action for that ID only.
3. In the app's existing custom dark/Gothic UI, display a desktop Chrome/Edge notice and launch `Fm1OpenWorkbench.open(this)` on user tap; if false, use the existing app error-message component.
4. Reuse existing local setup-guide presentation or show a verified URL; do not implement an in-app WebView as a substitute for the vendor's required browser and its MIDI permissions.
5. Test on the Android app with **no FM-1 attached first**: open the detail screen, trigger the external link, return to Tall Horse, and confirm that no flash, save, restore or USB handshake was initiated. Then run regression tests for all existing firmware library flows.

## Safety and release
Keep backups, USB capability gates and flash commands under the existing app's independent safety policy. Never convert a successful FM1 Open **manual** firmware install into proof that Tall Horse can automatically switch to or restore from FM1 Open.

No user backups, SDK binaries, firmware images or secret device information belong in this public repo.
