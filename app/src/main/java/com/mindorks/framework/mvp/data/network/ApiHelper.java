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

import io.reactivex.Observable;

/**
 * Created by janisharali on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<UploadResponse> uploadQuestionApiCall(UploadQuestionRequest request);

    Observable<UpdateSyncStsResponse> updateSyncStsOfQuestion(UpdateSyncStsRequest request, int id);

    Observable<UpdateSyncStsResponse> updateSyncStsOfOption(UpdateSyncStsRequest request,int id);

    Observable<UpdateSyncStsResponse> updateSyncStsOfExamTest(UpdateSyncStsRequest request, int id);

    Observable<UpdateSyncStsResponse> updateSyncStsOfSubject(UpdateSyncStsRequest request, int id);

    Observable<LogoutResponse> doLogoutApiCall();

    Observable<BlogResponse> getBlogApiCall();

    Observable<QuestionsResponse> getQuestionApiCall();

    Observable<OptionsResponse> getOptionApiCall();

    Observable<OpenSourceResponse> getOpenSourceApiCall();

    Observable<ExamTestResponse> getExamTestApiCall();

    Observable<SubjectResponse> getSubjectApiCall();
}
