package com.hhcui.java_base.oop.TheSingle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class ImageLoader {
    private final String TAG = this.getClass().getSimpleName();

    private ImageCache imageCache;
    //线程池，线程数量为cpu的数量
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {
        imageCache = new ImageCache();
    }


    public void displayImage(final String url, final ImageView imageView) {
        Log.d(TAG, "displayImage() called with: url = [" + url + "], imageView = [" + imageView + "]");
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (null == bitmap) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }
                imageCache.putBitmap(url, bitmap);
            }
        });
    }

    /**
     * 下载网络图片
     *
     * @param imageUrl 图片Url
     * @return 返回bitmap
     */
    public Bitmap downloadImage(String imageUrl) {
        Log.d(TAG, "downloadImage() called with: imageUrl = [" + imageUrl + "]");
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
