/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2022  huangyuhui <huanghongxun2008@126.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.jackhuang.hmcl.ui.main;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.jackhuang.hmcl.Metadata;
import org.jackhuang.hmcl.ui.FXUtils;
import org.jackhuang.hmcl.ui.construct.ComponentList;
import org.jackhuang.hmcl.ui.construct.IconedTwoLineListItem;

import static org.jackhuang.hmcl.util.i18n.I18n.i18n;

public class AboutPage extends StackPane {

    public AboutPage() {
        ComponentList about = new ComponentList();
        {
            IconedTwoLineListItem launcher = new IconedTwoLineListItem();
            //launcher.setImage(FXUtils.newBuiltinImage("/assets/img/icon.png"));
            launcher.setTitle("VTS-HMCL");
            launcher.setSubtitle("v1.0.0");
            launcher.setExternalLink("https://github.com/VisionTravelStudio");

            IconedTwoLineListItem author = new IconedTwoLineListItem();
            //author.setImage(FXUtils.newBuiltinImage("/assets/img/yellow_fish.png"));
            author.setTitle("huanghongxun");
            author.setSubtitle(i18n("about.author.statement"));
            author.setExternalLink("https://space.bilibili.com/1445341");

            IconedTwoLineListItem visiontravel = new IconedTwoLineListItem();
            //visiontravel.setImage(FXUtils.newBuiltinImage("/assets/img/visiontravel.png"));
            visiontravel.setTitle("Vision Travel Studio");
            visiontravel.setSubtitle(i18n("about.thanks_to.visiontravel.statement"));
            visiontravel.setExternalLink("https://space.bilibili.com/614688308");

            about.getContent().setAll(launcher, author, visiontravel);
        }

        ComponentList thanks = new ComponentList();
        {
            IconedTwoLineListItem vtszgy = new IconedTwoLineListItem();
            //vtszgy.setImage(FXUtils.newBuiltinImage("/assets/img/vtszgy.png"));
            vtszgy.setTitle("zgy22506");
            vtszgy.setSubtitle(i18n("about.thanks_to.vtszgy.statement"));
            vtszgy.setExternalLink("https://space.bilibili.com/1999540880");

            IconedTwoLineListItem vtsdt = new IconedTwoLineListItem();
            //vtsdt.setImage(FXUtils.newBuiltinImage("/assets/img/visiontravel.png"));
            vtsdt.setTitle("Vision Travel Studio Develop Team");
            vtsdt.setSubtitle(i18n("about.thanks_to.vtsdt.statement"));
            vtsdt.setExternalLink("https://github.com/VisionTravelStudio");

            IconedTwoLineListItem yushijinhun = new IconedTwoLineListItem();
            //yushijinhun.setImage(FXUtils.newBuiltinImage("/assets/img/yushijinhun.png"));
            yushijinhun.setTitle("yushijinhun");
            yushijinhun.setSubtitle(i18n("about.thanks_to.yushijinhun.statement"));
            yushijinhun.setExternalLink("https://yushi.moe/");

            IconedTwoLineListItem bangbang93 = new IconedTwoLineListItem();
            //bangbang93.setImage(FXUtils.newBuiltinImage("/assets/img/bangbang93.png"));
            bangbang93.setTitle("bangbang93");
            bangbang93.setSubtitle(i18n("about.thanks_to.bangbang93.statement"));
            bangbang93.setExternalLink("https://bmclapi2.bangbang93.com/");

            IconedTwoLineListItem glavo = new IconedTwoLineListItem();
            //glavo.setImage(FXUtils.newBuiltinImage("/assets/img/glavo.png"));
            glavo.setTitle("Glavo");
            glavo.setSubtitle(i18n("about.thanks_to.glavo.statement"));
            glavo.setExternalLink("https://github.com/Glavo");

            IconedTwoLineListItem zekerzhayard = new IconedTwoLineListItem();
            //zekerzhayard.setImage(FXUtils.newBuiltinImage("/assets/img/zekerzhayard.png"));
            zekerzhayard.setTitle("ZekerZhayard");
            zekerzhayard.setSubtitle(i18n("about.thanks_to.zekerzhayard.statement"));
            zekerzhayard.setExternalLink("https://github.com/ZekerZhayard");

            IconedTwoLineListItem zkitefly = new IconedTwoLineListItem();
            //zkitefly.setImage(FXUtils.newBuiltinImage("/assets/img/zkitefly.png"));
            zkitefly.setTitle("Zkitefly");
            zkitefly.setSubtitle(i18n("about.thanks_to.zkitefly.statement"));
            zkitefly.setExternalLink("https://github.com/zkitefly");

            IconedTwoLineListItem burningtnt = new IconedTwoLineListItem();
            //.setImage(FXUtils.newBuiltinImage("/assets/img/burningtnt.png"));
            burningtnt.setTitle("Burning_TNT");
            burningtnt.setSubtitle(i18n("about.thanks_to.burningtnt.statement"));
            burningtnt.setExternalLink("https://github.com/burningtnt");

            IconedTwoLineListItem shulkerSakura = new IconedTwoLineListItem();
            shulkerSakura.setTitle("ShulkerSakura");
            //shulkerSakura.setImage(FXUtils.newBuiltinImage("/assets/img/ShulkerSakura.png"));
            shulkerSakura.setSubtitle(i18n("about.thanks_to.shulkersakura.statement"));
            shulkerSakura.setExternalLink("https://github.com/ShulkerSakura");

            IconedTwoLineListItem gamerteam = new IconedTwoLineListItem();
            gamerteam.setTitle("gamerteam");
            //gamerteam.setImage(FXUtils.newBuiltinImage("/assets/img/gamerteam.png"));
            gamerteam.setSubtitle(i18n("about.thanks_to.gamerteam.statement"));
            gamerteam.setExternalLink("http://www.zhaisoul.com/");

            IconedTwoLineListItem redLnn = new IconedTwoLineListItem();
            redLnn.setTitle("Red_lnn");
            //redLnn.setImage(FXUtils.newBuiltinImage("/assets/img/red_lnn.png"));
            redLnn.setSubtitle(i18n("about.thanks_to.red_lnn.statement"));

            IconedTwoLineListItem mcmod = new IconedTwoLineListItem();
            //mcmod.setImage(FXUtils.newBuiltinImage("/assets/img/mcmod.png"));
            mcmod.setTitle(i18n("about.thanks_to.mcmod"));
            mcmod.setSubtitle(i18n("about.thanks_to.mcmod.statement"));
            mcmod.setExternalLink("https://www.mcmod.cn/");

            IconedTwoLineListItem mcbbs = new IconedTwoLineListItem();
            //mcbbs.setImage(FXUtils.newBuiltinImage("/assets/img/chest.png"));
            mcbbs.setTitle(i18n("about.thanks_to.mcbbs"));
            mcbbs.setSubtitle(i18n("about.thanks_to.mcbbs.statement"));

            IconedTwoLineListItem contributors = new IconedTwoLineListItem();
            //contributors.setImage(FXUtils.newBuiltinImage("/assets/img/github.png"));
            contributors.setTitle(i18n("about.thanks_to.contributors"));
            contributors.setSubtitle(i18n("about.thanks_to.contributors.statement"));
            contributors.setExternalLink("https://github.com/HMCL-dev/HMCL/graphs/contributors");

            IconedTwoLineListItem users = new IconedTwoLineListItem();
            //users.setImage(FXUtils.newBuiltinImage("/assets/img/icon.png"));
            users.setTitle(i18n("about.thanks_to.users"));
            users.setSubtitle(i18n("about.thanks_to.users.statement"));
            users.setExternalLink("https://docs.hmcl.net/groups.html");

            thanks.getContent().setAll(vtszgy, vtsdt , bangbang93, glavo, zekerzhayard, zkitefly, burningtnt, mcmod, mcbbs, shulkerSakura, gamerteam, redLnn, contributors, users);
        }

        ComponentList dep = new ComponentList();
        {
            IconedTwoLineListItem javafx = new IconedTwoLineListItem();
            javafx.setTitle("JavaFX");
            javafx.setSubtitle("Copyright © 2013, 2024, Oracle and/or its affiliates.\nLicensed under the GPL 2 with Classpath Exception.");
            javafx.setExternalLink("https://openjfx.io/");

            IconedTwoLineListItem jfoenix = new IconedTwoLineListItem();
            jfoenix.setTitle("JFoenix");
            jfoenix.setSubtitle("Copyright © 2016 JFoenix.\nLicensed under the MIT License.");
            jfoenix.setExternalLink("https://github.com/sshahine/JFoenix");

            IconedTwoLineListItem gson = new IconedTwoLineListItem();
            gson.setTitle("Gson");
            gson.setSubtitle("Copyright © 2008 Google Inc.\nLicensed under the Apache 2.0 License.");
            gson.setExternalLink("https://github.com/google/gson");

            IconedTwoLineListItem xz = new IconedTwoLineListItem();
            xz.setTitle("XZ for Java");
            xz.setSubtitle("Lasse Collin, Igor Pavlov, and/or Brett Okken.\nPublic Domain.");
            xz.setExternalLink("https://tukaani.org/xz/java.html");

            IconedTwoLineListItem fxgson = new IconedTwoLineListItem();
            fxgson.setTitle("fx-gson");
            fxgson.setSubtitle("Copyright © 2016 Joffrey Bion.\nLicensed under the MIT License.");
            fxgson.setExternalLink("https://github.com/joffrey-bion/fx-gson");

            IconedTwoLineListItem constantPoolScanner = new IconedTwoLineListItem();
            constantPoolScanner.setTitle("Constant Pool Scanner");
            constantPoolScanner.setSubtitle("Copyright © 1997-2010 Oracle and/or its affiliates.\nLicensed under the GPL 2 or the CDDL.");
            constantPoolScanner.setExternalLink("https://github.com/jenkinsci/constant-pool-scanner");

            IconedTwoLineListItem openNBT = new IconedTwoLineListItem();
            openNBT.setTitle("OpenNBT");
            openNBT.setSubtitle("Copyright © 2013-2021 Steveice10.\nLicensed under the MIT License.");
            openNBT.setExternalLink("https://github.com/GeyserMC/OpenNBT");

            IconedTwoLineListItem minecraftJFXSkin = new IconedTwoLineListItem();
            minecraftJFXSkin.setTitle("minecraft-jfx-skin");
            minecraftJFXSkin.setSubtitle("Copyright © 2016 InfinityStudio.\nLicensed under the GPL 3.");
            minecraftJFXSkin.setExternalLink("https://github.com/InfinityStudio/minecraft-jfx-skin");

            dep.getContent().setAll(javafx, jfoenix, gson, xz, fxgson, constantPoolScanner, openNBT, minecraftJFXSkin);
        }

        ComponentList legal = new ComponentList();
        {
            IconedTwoLineListItem copyright = new IconedTwoLineListItem();
            copyright.setTitle(i18n("about.copyright"));
            copyright.setSubtitle(i18n("about.copyright.statement"));
            copyright.setExternalLink("https://hmcl.huangyuhui.net/about/");

            IconedTwoLineListItem claim = new IconedTwoLineListItem();
            claim.setTitle(i18n("about.claim"));
            claim.setSubtitle(i18n("about.claim.statement"));
            claim.setExternalLink(Metadata.EULA_URL);

            IconedTwoLineListItem openSource = new IconedTwoLineListItem();
            openSource.setTitle(i18n("about.open_source"));
            openSource.setSubtitle(i18n("about.open_source.statement"));
            openSource.setExternalLink("https://github.com/HMCL-dev/HMCL");

            legal.getContent().setAll(copyright, claim, openSource);
        }

        VBox content = new VBox(16);
        content.setPadding(new Insets(10));
        content.getChildren().setAll(
                ComponentList.createComponentListTitle(i18n("about")),
                about,

                ComponentList.createComponentListTitle(i18n("about.thanks_to")),
                thanks,

                ComponentList.createComponentListTitle(i18n("about.dependency")),
                dep,

                ComponentList.createComponentListTitle(i18n("about.legal")),
                legal
        );


        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        FXUtils.smoothScrolling(scrollPane);
        getChildren().setAll(scrollPane);
    }
}
