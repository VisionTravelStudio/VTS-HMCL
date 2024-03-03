# ⛏ Hello Minecraft! Launcher 💎

[![Build Status](https://ci.huangyuhui.net/job/HMCL/badge/icon?.svg)](https://ci.huangyuhui.net/job/HMCL)
![Downloads](https://img.shields.io/github/downloads/huanghongxun/HMCL/total)
![Stars](https://img.shields.io/github/stars/huanghongxun/HMCL)
[![Discord](https://img.shields.io/discord/995291757799538688.svg?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/jVvC7HfM6U)
[![KOOK](https://img.shields.io/badge/KOOK-HMCL-brightgreen)](https://kook.top/Kx7n3t)

English | [中文](README_cn.md)

## Introduction

HMCL is a cross-platform Minecraft launcher which supports Mod Management, Game Customizing, Auto Installing (Forge, NeoForge, Fabric, Quilt, LiteLoader and OptiFine), Modpack Creating, UI Customization, and more.

HMCL has amazing cross-platform capabilities.
It can not only run on different operating systems such as Windows, Linux, and macOS,
but also supports multiple CPU architectures such as x86, arm, mips, and loongarch.
You can easily play Minecraft on different platforms through HMCL.

For systems and CPU architectures supported by HMCL, see [this table](PLATFORM.md).

## Download

Download the latest version from [the official website](https://hmcl.huangyuhui.net/download).

You can also download the latest version of HMCL in [GitHub Releases](https://github.com/HMCL-dev/HMCL/releases).

Although not necessary, it is recommended to download the ones from the official website.

## License

The software is distributed under [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html) with additional terms.

### Additional terms under GPLv3 Section 7

1. When you distribute a modified version of the software, you must change the software name or the version number in a reasonable way in order to distinguish it from the original version. (Under [GPLv3, 7(c)](https://github.com/HMCL-dev/HMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L372-L374))

   The software name and the version number can be edited [here](https://github.com/HMCL-dev/HMCL/blob/javafx/HMCL/src/main/java/org/jackhuang/hmcl/Metadata.java#L33-L35).

2. You must not remove the copyright declaration displayed in the software. (Under [GPLv3, 7(b)](https://github.com/HMCL-dev/HMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L368-L370))

## Contribution

If you want to submit a pull request, there are some requirements:

* IDE: Intellij IDEA
* Compiler: Java 1.8 or Java 11+
* Do NOT modify `gradle` files

### Compilation

Simply execute the following command in project root directory:

```bash
./gradlew clean build
```

Make sure you have Java installed with JavaFX 8 at least. Liberica Full JDK 8 or later is recommended.

## JVM Options (for debugging)

| Parameter                                    | Description                                                                                    |
|----------------------------------------------|------------------------------------------------------------------------------------------------|
| `-Dhmcl.home=<path>`                         | Override HMCL directory.                                                                       |
| `-Dhmcl.self_integrity_check.disable=true`   | Bypass the self integrity check when checking for update.                                      |
| `-Dhmcl.bmclapi.override=<url>`              | Override API Root of BMCLAPI download provider, defaults to `https://bmclapi2.bangbang93.com`. |
| `-Dhmcl.font.override=<font family>`         | Override font family.                                                                          |
| `-Dhmcl.version.override=<version>`          | Override the version number.                                                                   |
| `-Dhmcl.update_source.override=<url>`        | Override the update source for HMCL itself.                                                    |
| `-Dhmcl.authlibinjector.location=<path>`     | Use specified authlib-injector (instead of downloading one).                                   |
| `-Dhmcl.openjfx.repo=<maven repository url>` | Add custom Maven repository for download OpenJFX.                                              |
| `-Dhmcl.native.encoding=<encoding>`          | Override the native encoding.                                                                  |
| `-Dhmcl.microsoft.auth.id=<App ID>`          | Override Microsoft OAuth App ID.                                                               |
| `-Dhmcl.microsoft.auth.secret=<App Secret>`  | Override Microsoft OAuth App secret.                                                           |
