/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.data.network;

import com.mindorks.framework.mvp.data.network.model.BlogResponse;
import com.mindorks.framework.mvp.data.network.model.ExamTestResponse;
import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.data.network.model.LogoutResponse;
import com.mindorks.framework.mvp.data.network.model.OpenSourceResponse;
import com.mindorks.framework.mvp.data.network.model.OptionRequest;
import com.mindorks.framework.mvp.data.network.model.OptionsResponse;
import com.mindorks.framework.mvp.data.network.model.QuestionRequest;
import com.mindorks.framework.mvp.data.network.model.QuestionsResponse;
import com.mindorks.framework.mvp.data.network.model.SubjectResponse;
import com.mindorks.framework.mvp.data.network.model.UpdateSyncStsRequest;
import com.mindorks.framework.mvp.data.network.model.UpdateSyncStsResponse;
import com.mindorks.framework.mvp.data.network.model.UploadQuestionRequest;
import com.mindorks.framework.mvp.data.network.model.UploadResponse;
import com.mindorks.framework.mvp.ui.upload.UploadQuestionsActivity;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                                  request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                    request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                                  request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<UploadResponse> uploadQuestionApiCall(UploadQuestionRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_UPLOAD_QUESTION)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(UploadResponse.class);
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(LogoutResponse.class);
    }

    @Override
    public Observable<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(BlogResponse.class);
    }

    @Override
    public Observable<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(OpenSourceResponse.class);
    }

    @Override
    public Observable<QuestionsResponse> getQuestionApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_QUESTION)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(QuestionsResponse.class);
    }

    @Override
    public Observable<OptionsResponse> getOptionApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPTION)
//                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(OptionsResponse.class);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfQuestion(UpdateSyncStsRequest request, int id) {
        return Rx2AndroidNetworking.patch(ApiEndPoint.ENDPOINT_QUETION_UPDATE + id)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(UpdateSyncStsResponse.class);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfOption(UpdateSyncStsRequest request,int id) {
        return Rx2AndroidNetworking.patch(ApiEndPoint.ENDPOINT_OPTION_UPDATE + id)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(UpdateSyncStsResponse.class);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfExamTest(UpdateSyncStsRequest request, int id) {
        return Rx2AndroidNetworking.patch(ApiEndPoint.ENDPOINT_EXAM_TEST_UPDATE + id)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(UpdateSyncStsResponse.class);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfSubject(UpdateSyncStsRequest request, int id) {
        return Rx2AndroidNetworking.patch(ApiEndPoint.ENDPOINT_SUBJECT_UPDATE + id)
                .addBodyParameter(request)
                .build()
                .getObjectObservable(UpdateSyncStsResponse.class);
    }

    @Override
    public Observable<ExamTestResponse> getExamTestApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_EXAM_TEST)
                .build()
                .getObjectObservable(ExamTestResponse.class);
    }

    @Override
    public Observable<SubjectResponse> getSubjectApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SUBJECT)
                .build()
                .getObjectObservable(SubjectResponse.class);
    }
}

