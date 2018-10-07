package com.mindorks.framework.mvp.ui.importquestions;

import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.ui.base.BasePresenter;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by SPARK on 21/06/2018.
 */
public class ImportQuestionsPresenter<V extends ImportQuestionsMvpView> extends BasePresenter<V> implements ImportQuestionsMvpPresenter<V> {



    @Inject
    public ImportQuestionsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onQuestionsBrowseClick() {
        getMvpView().onPickDoc(1);

    }

    @Override
    public void onOptionsBrowseClick() {
        getMvpView().onPickDoc(2);

    }

    @Override
    public void onSubmitClick() throws IOException {
        getCompositeDisposable().add(getDataManager()
                .seedDatabaseQuestions(getMvpView().getQuestionsFilePath())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {
                        return getDataManager().seedDatabaseOptions(getMvpView().getOptionsFilePath());
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        decideNextActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().onError(R.string.some_error);
                        decideNextActivity();
                    }
                }));

    }

    private void decideNextActivity() {

            getMvpView().openMainActivity();

    }

    @Override
    public void onCancelClick() {
        getMvpView().finishActivity();
    }
}
