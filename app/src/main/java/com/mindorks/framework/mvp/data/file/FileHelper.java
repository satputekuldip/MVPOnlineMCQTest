package com.mindorks.framework.mvp.data.file;

import com.mindorks.framework.mvp.data.file.model.FileData;

import io.reactivex.Observable;

/**
 * Created by SPARK on 24/06/2018.
 */
public interface FileHelper {

    Observable<Boolean> saveDataToFile(FileData fileData);
}
