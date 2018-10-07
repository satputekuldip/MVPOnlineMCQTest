package com.mindorks.framework.mvp.ui.upload;

import com.mindorks.framework.mvp.ui.base.MvpView;

/**
 * Created by SPARK on 22/06/2018.
 */
public interface UploadQuestionsMvpView extends MvpView {

    void updateIpAddress(String ipAddres);

    String getIpAddress();

    void resetFields();

    void disableAllFielsds();

    void enableAllFields();
}
