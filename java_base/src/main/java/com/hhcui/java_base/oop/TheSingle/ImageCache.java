package com.hhcui.java_base.oop.TheSingle;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

public class ImageCache {
    private final String TAG = this.getClass().getSimpleName();
    //图片缓存
    LruCache<String, Bitmap> mImageCache;

    public ImageCache(){
        initImageCache();
    }

    private void initImageCache() {
        //计算可用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void putBitmap(String url,Bitmap bitmap){
        Log.d(TAG, "putBitmap() called with: url = [" + url + "], bitmap = [" + bitmap + "]");
        mImageCache.put(url,bitmap);
    }

    public Bitmap getBitmap(String imageUrl){
        Log.d(TAG, "getBitmap() called with: imageUrl = [" + imageUrl + "]");
        return mImageCache.get(imageUrl);
    }
}
