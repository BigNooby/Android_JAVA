package com.hhcui.hhcui;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: IllegalNameUtil
 * @Description:
 * @Author: hhcui
 * @CreateDate: 2020/1/10 9:12
 * @UpdateDate: 2020/1/10 9:12
 * @Version: 1.0
 */
public class IllegalNameUtil {
    private final String TAG = this.getClass().getSimpleName();
    private List<String> mIllegalNameList = new ArrayList<>();
    private volatile static IllegalNameUtil mInstance = null;

    private IllegalNameUtil(Context context) {
        initIllegalNameResource(context);

    }

    public static IllegalNameUtil getInstance (Context context){
        if (context == null) {
            throw new IllegalArgumentException("context must be not null !");
        }
        if (mInstance == null) {
                synchronized (IllegalNameUtil.class) {
                    if (mInstance == null) {
                        mInstance = new IllegalNameUtil(context);
                    }
                }
            }
        return mInstance;
    }

    private void initIllegalNameResource(Context context) {
        mIllegalNameList .addAll(Arrays.asList(context.getResources().getStringArray(R.array.illegal_name_bad_language))) ;
        mIllegalNameList .addAll(Arrays.asList(context.getResources().getStringArray(R.array.illegal_name_cmd))) ;
        mIllegalNameList .addAll(Arrays.asList(context.getResources().getStringArray(R.array.illegal_name_government))) ;
        mIllegalNameList .addAll(Arrays.asList(context.getResources().getStringArray(R.array.illegal_name_leader))) ;
    }

    public boolean isIllegalName(String name) {
        Log.d(TAG, "isIllegalName() called with: name = [" + name + "]");
        return mIllegalNameList.contains(name);
    }
}
