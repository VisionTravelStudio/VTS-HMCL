/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2021  huangyuhui <huanghongxun2008@126.com> and contributors
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

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.image.ImageView;
import org.jackhuang.hmcl.event.EventBus;
import org.jackhuang.hmcl.event.RefreshedVersionsEvent;
import org.jackhuang.hmcl.game.HMCLGameRepository;
import org.jackhuang.hmcl.game.ModpackHelper;
import org.jackhuang.hmcl.game.Version;
import org.jackhuang.hmcl.setting.Accounts;
import org.jackhuang.hmcl.setting.Profile;
import org.jackhuang.hmcl.setting.Profiles;
import org.jackhuang.hmcl.task.Schedulers;
import org.jackhuang.hmcl.task.Task;
import org.jackhuang.hmcl.ui.Controllers;
import org.jackhuang.hmcl.ui.FXUtils;
import org.jackhuang.hmcl.ui.SVG;
import org.jackhuang.hmcl.ui.account.AccountAdvancedListItem;
import org.jackhuang.hmcl.ui.construct.AdvancedListBox;
import org.jackhuang.hmcl.ui.construct.AdvancedListItem;
import org.jackhuang.hmcl.ui.construct.MessageDialogPane;
import org.jackhuang.hmcl.ui.decorator.DecoratorAnimatedPage;
import org.jackhuang.hmcl.ui.decorator.DecoratorPage;
import org.jackhuang.hmcl.ui.download.ModpackInstallWizardProvider;
import org.jackhuang.hmcl.ui.nbt.NBTEditorPage;
import org.jackhuang.hmcl.ui.nbt.NBTHelper;
import org.jackhuang.hmcl.ui.versions.GameAdvancedListItem;
import org.jackhuang.hmcl.ui.versions.Versions;
import org.jackhuang.hmcl.upgrade.UpdateChecker;
import org.jackhuang.hmcl.util.Lang;
import org.jackhuang.hmcl.util.StringUtils;
import org.jackhuang.hmcl.util.TaskCancellationAction;
import org.jackhuang.hmcl.util.io.CompressingUtils;
import org.jackhuang.hmcl.util.versioning.VersionNumber;

import java.io.File;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.jackhuang.hmcl.ui.FXUtils.runInFX;
import static org.jackhuang.hmcl.ui.construct.AdvancedListItem.createImageView;
import static org.jackhuang.hmcl.ui.versions.VersionPage.wrap;
import static org.jackhuang.hmcl.util.logging.Logger.LOG;
import static org.jackhuang.hmcl.util.i18n.I18n.i18n;

//test


public class RootPage extends DecoratorAnimatedPage implements DecoratorPage {
    private MainPage mainPage = null;

    public RootPage() {
        EventBus.EVENT_BUS.channel(RefreshedVersionsEvent.class)
                .register(event -> onRefreshedVersions((HMCLGameRepository) event.getSource()));

        Profile profile = Profiles.getSelectedProfile();
        if (profile != null && profile.getRepository().isLoaded())
            onRefreshedVersions(Profiles.selectedProfileProperty().get().getRepository());

        getStyleClass().remove("gray-background");
        getLeft().getStyleClass().add("black-background");
    }

    @Override
    public ReadOnlyObjectProperty<State> stateProperty() {
        return getMainPage().stateProperty();
    }

    @Override
    protected Skin createDefaultSkin() {
        return new Skin(this);
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            MainPage mainPage = new MainPage();
            FXUtils.applyDragListener(mainPage,
                    file -> ModpackHelper.isFileModpackByExtension(file) || NBTHelper.isNBTFileByExtension(file),
                    modpacks -> {
                        File file = modpacks.get(0);
                        if (ModpackHelper.isFileModpackByExtension(file)) {
                            Controllers.getDecorator().startWizard(
                                    new ModpackInstallWizardProvider(Profiles.getSelectedProfile(), file),
                                    i18n("install.modpack"));
                        } else if (NBTHelper.isNBTFileByExtension(file)) {
                            try {
                                Controllers.navigate(new NBTEditorPage(file));
                            } catch (Throwable e) {
                                LOG.warning("Fail to open nbt file", e);
                                Controllers.dialog(i18n("nbt.open.failed") + "\n\n" + StringUtils.getStackTrace(e),
                                        i18n("message.error"), MessageDialogPane.MessageType.ERROR);
                            }
                        }
                    });

            FXUtils.onChangeAndOperate(Profiles.selectedVersionProperty(), mainPage::setCurrentGame);
            mainPage.showUpdateProperty().bind(UpdateChecker.outdatedProperty());
            mainPage.latestVersionProperty().bind(UpdateChecker.latestVersionProperty());

            Profiles.registerVersionsListener(profile -> {
                HMCLGameRepository repository = profile.getRepository();
                List<Version> children = repository.getVersions().parallelStream()
                        .filter(version -> !version.isHidden())
                        .sorted(Comparator
                                .comparing((Version version) -> Lang.requireNonNullElse(version.getReleaseTime(), Instant.EPOCH))
                                .thenComparing(version -> VersionNumber.asVersion(repository.getGameVersion(version).orElse(version.getId()))))
                        .collect(Collectors.toList());
                runInFX(() -> {
                    if (profile == Profiles.getSelectedProfile())
                        mainPage.initVersions(profile, children);
                });
            });
            this.mainPage = mainPage;
        }
        return mainPage;
    }

    private static class Skin extends DecoratorAnimatedPageSkin<RootPage> {

        protected Skin(RootPage control) {
            super(control);
            ImageView titleIcon = new ImageView(FXUtils.newBuiltinImage("/assets/img/VTSSL-logo.png"));

            AdvancedListItem Lsidebar_1 = new AdvancedListItem();

            Lsidebar_1.createImageView(FXUtils.newBuiltinImage("/assets/img/VTSSL-logo.png"));


            AdvancedListItem Lsidebar_2 = new AdvancedListItem();
            AdvancedListItem Lsidebar_3 = new AdvancedListItem();
            AdvancedListItem Lsidebar_4 = new AdvancedListItem();
            AdvancedListItem Lsidebar_5 = new AdvancedListItem();
            AdvancedListItem Lsidebar_6 = new AdvancedListItem();
            AdvancedListItem Lsidebar_7 = new AdvancedListItem();
            AdvancedListItem Lsidebar_8 = new AdvancedListItem();
            AdvancedListItem Lsidebar_9 = new AdvancedListItem();
            AdvancedListItem Lsidebar_10 = new AdvancedListItem();
            AdvancedListItem Lsidebar_11 = new AdvancedListItem();
            AdvancedListItem Lsidebar_12 = new AdvancedListItem();
            AdvancedListItem Lsidebar_13 = new AdvancedListItem();


            // first item in left sidebar
            AccountAdvancedListItem accountListItem = new AccountAdvancedListItem();
            accountListItem.setOnAction(e -> Controllers.navigate(Controllers.getAccountListPage()));
            accountListItem.accountProperty().bind(Accounts.selectedAccountProperty());

            // second item in left sidebar
            GameAdvancedListItem gameListItem = new GameAdvancedListItem();
            gameListItem.setOnAction(e -> {
                Profile profile = Profiles.getSelectedProfile();
                String version = Profiles.getSelectedVersion();
                if (version == null) {
                    Controllers.navigate(Controllers.getGameListPage());
                } else {
                    Versions.modifyGameSettings(profile, version);
                }
            });

            // third item in left sidebar
            AdvancedListItem gameItem = new AdvancedListItem();
            gameItem.setLeftGraphic(wrap(SVG.VIEW_LIST));
            gameItem.setActionButtonVisible(false);
            gameItem.setTitle(i18n("version.manage"));
            gameItem.setOnAction(e -> Controllers.navigate(Controllers.getGameListPage()));

            // forth item in left sidebar
            AdvancedListItem downloadItem = new AdvancedListItem();
            downloadItem.setLeftGraphic(wrap(SVG.DOWNLOAD_OUTLINE));
            downloadItem.setActionButtonVisible(false);
            downloadItem.setTitle(i18n("download"));
            downloadItem.setOnAction(e -> Controllers.navigate(Controllers.getDownloadPage()));
            runInFX(() -> FXUtils.installFastTooltip(downloadItem, i18n("download.hint")));

            // fifth item in left sidebar
            AdvancedListItem launcherSettingsItem = new AdvancedListItem();
            launcherSettingsItem.setLeftGraphic(wrap(SVG.GEAR_OUTLINE));
            launcherSettingsItem.setActionButtonVisible(false);
            launcherSettingsItem.setTitle(i18n("settings"));
            launcherSettingsItem.setOnAction(e -> Controllers.navigate(Controllers.getSettingsPage()));

            // sixth item in left sidebar
            AdvancedListItem chatItem = new AdvancedListItem();
            chatItem.setLeftGraphic(wrap(SVG.CHAT));
            chatItem.setActionButtonVisible(false);
            chatItem.setTitle(i18n("chat"));
            chatItem.setOnAction(e -> FXUtils.openLink("https://qm.qq.com/q/uZUVlOvqyk"));

            //seventh item in left sidebar
            AdvancedListItem chatItemDC = new AdvancedListItem();
            chatItemDC.setLeftGraphic(wrap(SVG.CHAT));
            chatItemDC.setActionButtonVisible(false);
            chatItemDC.setTitle(i18n("chat.discord"));
            chatItemDC.setOnAction(e -> FXUtils.openLink("https://discord.gg/RDJhXb7CT3"));

            // the left sidebar
            AdvancedListBox sideBar = new AdvancedListBox()
                    //.startCategory(i18n("").toUpperCase(Locale.ROOT)) //account
                    .add(Lsidebar_1)
                    .add(Lsidebar_2)
                    .add(Lsidebar_3)
                    .add(Lsidebar_4)
                    .add(Lsidebar_5)
                    .add(Lsidebar_6)
                    .add(Lsidebar_7)
                    .add(Lsidebar_8)
                    .add(Lsidebar_9)
                    .add(Lsidebar_10)
                    .add(Lsidebar_11)
                    //.add(Lsidebar_12)
                    //.add(Lsidebar_13)
                    .add(accountListItem)
                    //.startCategory(i18n(" ").toUpperCase(Locale.ROOT)) //version

                    //.add(gameItem)
                    //.add(downloadItem)
                    .startCategory("") //i18n(" ").toUpperCase(Locale.ROOT)    settings.launcher.general
                    .add(gameListItem)
                    //.add(launcherSettingsItem)
                    //.add(chatItem)
                    //.add(chatItemDC)
                    ;

            // the root page, with the sidebar in left, navigator in center.
            setLeft(sideBar);
            setCenter(getSkinnable().getMainPage());
        }

    }

    private boolean checkedModpack = false;

    private void onRefreshedVersions(HMCLGameRepository repository) {
        runInFX(() -> {
            if (!checkedModpack) {
                checkedModpack = true;

                if (repository.getVersionCount() == 0) {
                    File modpackFile = new File("modpack.zip").getAbsoluteFile();
                    if (modpackFile.exists()) {
                        Task.supplyAsync(() -> CompressingUtils.findSuitableEncoding(modpackFile.toPath()))
                                .thenApplyAsync(
                                        encoding -> ModpackHelper.readModpackManifest(modpackFile.toPath(), encoding))
                                .thenApplyAsync(modpack -> ModpackHelper
                                        .getInstallTask(repository.getProfile(), modpackFile, modpack.getName(),
                                                modpack)
                                        .executor())
                                .thenAcceptAsync(Schedulers.javafx(), executor -> {
                                    Controllers.taskDialog(executor, i18n("modpack.installing"), TaskCancellationAction.NO_CANCEL);
                                    executor.start();
                                }).start();
                    }
                }
            }
        });
    }
}
