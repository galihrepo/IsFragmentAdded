package com.example.najwa.isfragmentadded.fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.najwa.isfragmentadded.R;
import com.example.najwa.isfragmentadded.custom.widget.CustomToast;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by najwa on 5/30/2015.
 */
public class FragmentOne extends Fragment {

    private final String IMAGE_URL = "http://www.nttdata.com/jp/ja/shared/img/share_01.png";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity()).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        imageLoader.loadImage(IMAGE_URL, new SimpleImageLoadingListener(){
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                CustomToast.makeText(getActivity(), failReason.getCause().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setImageBitmap(loadedImage);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        if (this.isAdded())
            CustomToast.makeText(getActivity(), "fragment added", Toast.LENGTH_SHORT).show();
        else if (this.isHidden())
            CustomToast.makeText(getActivity(), "fragment hidden", Toast.LENGTH_SHORT).show();
        else
            CustomToast.makeText(getActivity(), "fragment status unknown", Toast.LENGTH_SHORT).show();
        return view;
    }
}
