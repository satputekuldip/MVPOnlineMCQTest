package com.mindorks.framework.mvp.ui.upload;

import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by SPARK on 22/06/2018.
 */
@PerActivity
public interface UploadQuestionsMvpPresernter<V extends UploadQuestionsMvpView> extends MvpPresenter<V> {

    void onSetup();

    void submitQuestion(String testNo, String questionNo, String questionText, List<Option> optionList);


}
