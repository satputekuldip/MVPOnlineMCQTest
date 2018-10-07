package com.mindorks.framework.mvp.data.file;

import com.mindorks.framework.mvp.data.file.model.FileData;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by SPARK on 24/06/2018.
 */
@Singleton
public class AppFileHelper implements FileHelper {


    private FileManager fileManager;

    @Inject
    AppFileHelper(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public Observable<Boolean> saveDataToFile(final FileData fileData) {
        return Observable.fromCallable(new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                return fileManager.append(fileData);
            }
        });
    }
}
