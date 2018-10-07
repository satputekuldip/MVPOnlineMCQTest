package com.mindorks.framework.mvp.ui.sync.from.server;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.data.network.model.OptionsResponse;
import com.mindorks.framework.mvp.data.network.model.QuestionsResponse;
import com.mindorks.framework.mvp.data.network.model.UpdateSyncStsRequest;
import com.mindorks.framework.mvp.data.network.model.UpdateSyncStsResponse;
import com.mindorks.framework.mvp.ui.base.BasePresenter;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by SPARK on 21/06/2018.
 */
public class SyncFromServerPresenter<V extends SyncFromServerMvpView> extends BasePresenter<V>
        implements SyncFromServerMvpPresenter<V> {

    @Inject
    public SyncFromServerPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onFabButtonClicked() {
        getQuestionsFromServer();
        getOptionsFromServer();
    }

    @Override
    public void onSetup() {


    }

    private void getQuestionsFromServer() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getQuestionApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<QuestionsResponse>() {
                    @Override
                    public void accept(@NonNull QuestionsResponse questionsResponse)
                            throws Exception {
                        if (questionsResponse != null && questionsResponse.getData() != null) {

                            for (QuestionsResponse.QuestionsRepo responseData : questionsResponse.getData()) {
                                Log.d("TEST", responseData.toString());
                                storeQuestion(responseData);
                            }

                        } else {
                            getMvpView().onError("Nothing to Sync");
                        }
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }

    private void getOptionsFromServer() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getOptionApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<OptionsResponse>() {
                    @Override
                    public void accept(@NonNull OptionsResponse optionsResponse)
                            throws Exception {
                        if (optionsResponse != null && optionsResponse.getData() != null) {

                            for (OptionsResponse.OptionsRepo responseData : optionsResponse.getData()) {
                                Log.d("TEST", responseData.toString());
                                storeOptions(responseData);
                            }

                        } /*else {
                            getMvpView().onError("Nothing to Sync");
                        }*/
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                            getMvpView().onError("Error Could not getting Options From Server!");
                        }
                    }
                }));
    }

    private void storeQuestion(final QuestionsResponse.QuestionsRepo responseData) {
        getCompositeDisposable().add(getDataManager()
                .saveQuestion(
                        new Question(
                                responseData.getId(),
                                responseData.getTestNo(),
                                responseData.getQuestionNumber(),
                                responseData.getQuestionText(),
                                responseData.getImgUrl(),
                                responseData.getCreatedAt(),
                                responseData.getUpdatedAt()
                        )
                )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        updateSyncStsQuestion(responseData);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().showErrorDialouge(R.string.some_error);
                    }
                }));
    }

    private void storeOptions(final OptionsResponse.OptionsRepo responseData) {
        getCompositeDisposable().add(getDataManager()
                .saveOption(
                        new Option(
                                responseData.getId(),
                                responseData.getQuestionId(),
                                responseData.getOptionNo(),
                                responseData.getOptionText(),
                                responseData.isCorrect(),
                                responseData.getCreatedAt(),
                                responseData.getUpdatedAt()
                        )
                )
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        updateSyncStsOption(responseData);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().onError("Error: Could not Insert Option");
                    }
                }));
    }

    private void updateSyncStsOption(OptionsResponse.OptionsRepo responseData) {
        getCompositeDisposable().add(getDataManager()
                .updateSyncStsOfOption(new UpdateSyncStsRequest("1")
                        , Integer.parseInt(responseData.getId().toString()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        new Consumer<UpdateSyncStsResponse>() {
                            @Override
                            public void accept(UpdateSyncStsResponse updateSyncStsResponse) throws Exception {
                                if (!isViewAttached()) {
                                    return;
                                }
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                getMvpView().onError("Error: Could not update Sync Status!");
                            }
                        }
                )
        );
    }

    private void updateSyncStsQuestion(final QuestionsResponse.QuestionsRepo responseData) {
        getCompositeDisposable().add(getDataManager()
                .updateSyncStsOfQuestion(new UpdateSyncStsRequest("1")
                        , Integer.parseInt(responseData.getId().toString()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        new Consumer<UpdateSyncStsResponse>() {
                            @Override
                            public void accept(UpdateSyncStsResponse updateSyncStsResponse) throws Exception {
                                if (!isViewAttached()) {
                                    return;
                                }
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                getMvpView().onError("Error: Could not update Sync Status Of Question no !" + responseData.getQuestionNumber());
                            }
                        }
                )
        );
    }
}
