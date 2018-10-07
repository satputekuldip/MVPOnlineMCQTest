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

package com.mindorks.framework.mvp.data;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.mindorks.framework.mvp.data.db.DbHelper;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.data.db.model.User;
import com.mindorks.framework.mvp.data.file.FileHelper;
import com.mindorks.framework.mvp.data.file.model.FileData;
import com.mindorks.framework.mvp.data.network.ApiHeader;
import com.mindorks.framework.mvp.data.network.ApiHelper;
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
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.di.ApplicationContext;
import com.mindorks.framework.mvp.utils.CommonUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by janisharali on 27/01/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private final FileHelper mFileHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper, FileHelper fileHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mFileHelper = fileHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                                  request) {
        return mApiHelper.doGoogleLoginApiCall(request);
    }

    @Override
    public Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                    request) {
        return mApiHelper.doFacebookLoginApiCall(request);
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                                  request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Observable<UploadResponse> uploadQuestionApiCall(UploadQuestionRequest request) {
        return mApiHelper.uploadQuestionApiCall(request);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfQuestion(UpdateSyncStsRequest request, int id) {
        return mApiHelper.updateSyncStsOfQuestion(request,id);
    }

    @Override
    public Observable<UpdateSyncStsResponse> updateSyncStsOfOption(UpdateSyncStsRequest request, int id) {
        return mApiHelper.updateSyncStsOfOption(request,id);
    }

    @Override
    public Observable<ExamTestResponse> updateSyncStsOfExamTest(UpdateSyncStsRequest request, int id) {
        return mApiHelper.updateSyncStsOfExamTest(request, id);
    }

    @Override
    public Observable<SubjectResponse> updateSyncStsOfSubject(UpdateSyncStsRequest request, int id) {
        return mApiHelper.updateSyncStsOfSubject(request, id);
    }

    @Override
    public Observable<ExamTestResponse> getExamTestApiCall() {
        return mApiHelper.getExamTestApiCall();
    }

    @Override
    public Observable<SubjectResponse> getSubjectApiCall() {
        return mApiHelper.getSubjectApiCall();
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return mApiHelper.doLogoutApiCall();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath) {

        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return mDbHelper.isQuestionEmpty();
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return mDbHelper.isOptionEmpty();
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return mDbHelper.saveQuestion(question);
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return mDbHelper.saveOption(option);
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
        return mDbHelper.saveQuestionList(questionList);
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> optionList) {
        return mDbHelper.saveOptionList(optionList);
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mDbHelper.getAllQuestions();
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions(final String questionsFilePath) throws IOException {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        Type type = $Gson$Types
                .newParameterizedTypeWithOwner(null, List.class,
                        Question.class);
        List<Question> questionList = gson.fromJson(CommonUtils.loadJSONFromSDcard(mContext, questionsFilePath),
                type);

        return saveQuestionList(questionList);
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions(final String optionsFilePath) throws IOException {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        Type type = new TypeToken<List<Option>>() {
        }
                .getType();
        List<Option> optionList = gson.fromJson(
                CommonUtils.loadJSONFromSDcard(mContext, optionsFilePath),
                type);

        return saveOptionList(optionList);
    }

    @Override
    public Observable<Boolean> seedDatabaseOptionsFromServer(final String jsonArray) throws IOException {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        Type type = new TypeToken<List<Option>>() {}.getType();
        List<Option> optionList = gson.fromJson(
                CommonUtils.loadJSONFromJSONArray(mContext, jsonArray), type);
        return saveOptionList(optionList);
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestionsFromServer(final String jsonArray) throws IOException {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        Type type = $Gson$Types.newParameterizedTypeWithOwner(null, List.class, Question.class);
        List<Question> questionList = gson.fromJson
                (CommonUtils.loadJSONFromJSONArray(mContext, jsonArray), type);

        return saveQuestionList(questionList);
    }

    @Override
    public Observable<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }

    @Override
    public Observable<QuestionsResponse> getQuestionApiCall() {
        return mApiHelper.getQuestionApiCall();
    }

    @Override
    public Observable<OptionsResponse> getOptionApiCall() {
        return mApiHelper.getOptionApiCall();
    }

    @Override
    public Observable<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiHelper.getOpenSourceApiCall();
    }

    @Override
    public Observable<Boolean> saveDataToFile(FileData fileData) {
        return mFileHelper.saveDataToFile(fileData);
    }
}
