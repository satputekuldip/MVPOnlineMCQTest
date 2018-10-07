package com.mindorks.framework.mvp.data.network;

import com.mindorks.framework.mvp.BuildConfig;


public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "/588d15f5100000a8072d2945";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL
            + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";

    public static final String ENDPOINT_QUESTION = BuildConfig.BASE_URL
            + "/api/questions/getUnSyncedItems";


    public static final String ENDPOINT_QUETION_UPDATE = BuildConfig.BASE_URL
            + "/api/questions/updateSyncStatus/";

    public static final String ENDPOINT_OPTION = BuildConfig.BASE_URL
            + "/api/options/getUnSyncedItems";

    public static final String ENDPOINT_OPTION_UPDATE = BuildConfig.BASE_URL
            + "/api/options/updateSyncStatus/";

    public static final String ENDPOINT_EXAM_TEST_UPDATE = BuildConfig.BASE_URL
            + "/api/examTests/updateSyncStatus/";

    public static final String ENDPOINT_EXAM_TEST = BuildConfig.BASE_URL
            + "/api/examTests/getUnSyncedItems";

    public static final String ENDPOINT_SUBJECT = BuildConfig.BASE_URL
            + "/api/examTests/getUnSyncedItems";

    public static final String ENDPOINT_SUBJECT_UPDATE = BuildConfig.BASE_URL
            + "/api/subjects/updateSyncStatus/";

    public static final String ENDPOINT_UPLOAD_QUESTION = BuildConfig.BASE_URL
            + "/post_question.php";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
