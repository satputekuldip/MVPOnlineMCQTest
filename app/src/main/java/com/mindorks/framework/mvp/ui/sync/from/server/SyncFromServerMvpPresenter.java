package com.mindorks.framework.mvp.ui.sync.from.server;


import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.base.MvpPresenter;
import com.mindorks.framework.mvp.ui.base.MvpView;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by SPARK on 21/06/2018.
 */
@PerActivity
public interface SyncFromServerMvpPresenter<V extends SyncFromServerMvpView>
        extends MvpPresenter<V> {

    void onFabButtonClicked();

//    void getQuestionsJSON(String questionsLink);

//    void getOptionsJSON(String optionsLink);

//    void storeQuestions(String json) throws IOException;

//    void storeOptions(String json) throws IOException;

    void onSetup();

//    void saveToFile(String data,String filename);



}
