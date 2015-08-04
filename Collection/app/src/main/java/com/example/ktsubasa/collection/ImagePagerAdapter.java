package com.example.ktsubasa.collection;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by k.tsubasa on 2015/07/25.
 */
public class ImagePagerAdapter extends PagerAdapter {

    private Context mContext;

    private ContentResolver mResolver;

    private ArrayList<Long> mList;

    public ImagePagerAdapter(Context context){
        mContext=context;
        mResolver=mContext.getContentResolver();
        mList=new ArrayList<Long>();
    }

    public void add(Long id){
        mList.add(id);
    }

    //@override
    public Object instantiateItem(ViewGroup container,int position){

        Long id=mList.get(position);
        Uri uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toString());
        Bitmap bitmap=null;
        try{
            bitmap=getBitmap(uri);
        }catch(IOException e){
            e.printStackTrace();
        }

        ImageView imageView=new ImageView(mContext);
        imageView .setImageBitmap(bitmap);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View)object);
    }

    public int getCount(){
        return mList.size();
    }



    public boolean isViewFromObject(View view,Object object){
        return view.equals(object);
    }

    public Bitmap getBitmap(Uri imageUri) throws IOException{
        BitmapFactory.Options mOptions=new BitmapFactory.Options();
        mOptions.inSampleSize=10;
        Bitmap resizeBitmap=null;

        InputStream is=mResolver.openInputStream(imageUri);
        resizeBitmap= BitmapFactory.decodeStream(is, null, mOptions);
        is.close();
        return resizeBitmap;
    }
}
