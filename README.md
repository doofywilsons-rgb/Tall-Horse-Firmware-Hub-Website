# Tall Horse Firmware Hub — Public Website

The public website and research catalog for MVAVE FM-1 firmware.

This repository contains documentation and catalog metadata only. It does not distribute firmware binaries, experimental images, backups, credentials, or recovery files.

Firmware entries and research builds are not guarantees of safe flashing, backup, or restoration on physical hardware. Original developers retain their rights; follow each project's license and redistribution permissions.

Private research and firmware development are maintained separately.

## Developer attribution

The [Developer Credits](DEVELOPERS.md) document lists linked GitHub repositories, the commit contributors GitHub reported at audit time, upstream fork parents and evidence notes. The website also has a searchable per-OS credit directory. This is not a complete authorship claim; please submit documented corrections.

## FM1 Open (#26) companion tools

FM1 Open has an [official Workbench setup and backup guide](workbench.html) and direct link to [M-VAVE's Workbench](https://open.m-vave.com/fm1-workbench). The public catalog now has **26 firmware choices**, but only **25 importable firmware packages**; FM1 Open is a **catalog-only** entry and no new firmware binary is distributed here. V15 recovery remains a separate record. The boot, sound and preset-change checks were reported from the user's FM-1 on 2026-10-18; automatic flashing, universal backup and restore are not verified.

[Android Java integration handoff](android-integration/README.md) and [Java Workbench launcher](android-integration/Fm1OpenWorkbench.java) are available as developer materials, **not** a built Android app. Desktop Chrome or Edge is recommended by M-VAVE for hardware-facing Workbench operations.

The static catalog and safety metadata can be checked with `node tools/validate-catalog.mjs` (also configured for GitHub Actions).
