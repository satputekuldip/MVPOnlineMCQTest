package com.mindorks.framework.mvp.ui.importquestions;

import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

import java.io.IOException;

/**
 * Created by SPARK on 21/06/2018.
 */
@PerActivity
public interface ImportQuestionsMvpPresenter<V extends ImportQuestionsMvpView & MvpView>
        extends MvpPresenter<V> {

    void onQuestionsBrowseClick();

    void onOptionsBrowseClick();

    void onSubmitClick() throws IOException;

    void onCancelClick();
}
