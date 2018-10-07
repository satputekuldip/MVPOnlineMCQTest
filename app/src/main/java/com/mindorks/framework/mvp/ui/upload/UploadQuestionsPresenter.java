package com.mindorks.framework.mvp.ui.upload;

import com.androidnetworking.error.ANError;
import com.mindorks.framework.mvp.BuildConfig;
import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.data.network.model.UploadQuestionRequest;
import com.mindorks.framework.mvp.data.network.model.UploadResponse;
import com.mindorks.framework.mvp.ui.base.BasePresenter;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by SPARK on 22/06/2018.
 */
public class UploadQuestionsPresenter<V extends UploadQuestionsMvpView> extends BasePresenter<V>
        implements UploadQuestionsMvpPresernter<V> {

    @Inject
    public UploadQuestionsPresenter(DataManager dataManager,
                                    SchedulerProvider schedulerProvider,
                                    CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onSetup() {
        getMvpView().updateIpAddress(BuildConfig.LOCAL_URL);
    }

    @Override
    public void submitQuestion(String testNo, String questionNo, String questionText, List<Option> optionList) {
        if (testNo == null || testNo.isEmpty()
                || questionNo == null || questionNo.isEmpty()
                || questionText == null || questionText.isEmpty()
                || optionList == null
                || optionList.get(0).getOptionText().equals("")
                || optionList.get(1).getOptionText().equals("")
                || optionList.get(2).getOptionText().equals("")
                || optionList.get(3).getOptionText().equals("")){
            getMvpView().onError("Please Check all the Fields!");
        } else {
            getMvpView().showLoading();
            getMvpView().disableAllFielsds();
            getCompositeDisposable().add(getDataManager()
                    .uploadQuestionApiCall(new UploadQuestionRequest("Submit",testNo,
                            questionNo,questionText,
                            optionList.get(0).getOptionText(),optionList.get(0).getIsCorrect(),
                            optionList.get(1).getOptionText(),optionList.get(1).getIsCorrect(),
                            optionList.get(2).getOptionText(),optionList.get(2).getIsCorrect(),
                            optionList.get(3).getOptionText(),optionList.get(3).getIsCorrect()
                            ))
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<UploadResponse>() {
                        @Override
                        public void accept(UploadResponse response) throws Exception {
                            if (response.getStatusCode().equals("Success")) {
                                getMvpView().showSuccessDialouge("Question Uploaded");
                            } else {
                                getMvpView().hideLoading();
                                getMvpView().onError("Upload Failed!\nError code:" + response.getStatusCode());
                            }

                            if (!isViewAttached()) {
                                return;
                            }

                            getMvpView().hideLoading();
                            getMvpView().resetFields();
                            getMvpView().enableAllFields();

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                            if (!isViewAttached()) {
                                return;
                            }

                            getMvpView().hideLoading();

                            // handle the login error here
                            if (throwable instanceof ANError) {
                                ANError anError = (ANError) throwable;
                                handleApiError(anError);
                            }
                        }
                    }));
        }
    }


}
