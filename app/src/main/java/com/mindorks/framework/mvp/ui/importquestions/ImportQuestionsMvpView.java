package com.mindorks.framework.mvp.ui.importquestions;

import com.mindorks.framework.mvp.ui.base.MvpView;

/**
 * Created by SPARK on 21/06/2018.
 */
public interface ImportQuestionsMvpView extends MvpView {

    void onPickDoc(int requestCode);

    void updateQuestionsFilePath(String path);

    String getQuestionsFilePath();

    void updateOptionsFilePath(String path);

    String getOptionsFilePath();

    void openMainActivity();

    void finishActivity();
}
