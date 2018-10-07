package com.mindorks.framework.mvp.data.file;

import android.content.Context;

import com.mindorks.framework.mvp.data.file.model.FileData;
import com.mindorks.framework.mvp.di.ApplicationContext;

import java.io.File;
import java.io.FileWriter;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Created by SPARK on 24/06/2018.
 */
@Singleton
public class FileManager {

    private final Context mContext;

    @Inject
    public FileManager(@ApplicationContext Context mContext) {
        this.mContext = mContext;
    }


    public Boolean append(final FileData fileData) {
        if(!fileData.getPath().exists()){
            fileData.getPath().mkdir();
        }

        try{
            File gpxfile = new File(fileData.getPath(), fileData.getFilename());
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(fileData.getData());
            writer.flush();
            writer.close();
            return true;

        }catch (Exception e){
            Timber.tag("FileHandling").d(e);
            return false;
        }
    }
}
