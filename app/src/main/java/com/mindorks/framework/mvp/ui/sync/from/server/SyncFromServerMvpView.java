package com.mindorks.framework.mvp.ui.sync.from.server;

import com.mindorks.framework.mvp.ui.base.MvpView;

/**
 * Created by SPARK on 21/06/2018.
 */
public interface SyncFromServerMvpView extends MvpView {

    void startFABAnimation();
    void finishFABAnimation();

    void saveJsonFile(String json, String filename);
}
