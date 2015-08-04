package com.example.ktsubasa.collection; /**
 * Created by k.tsubasa on 2015/07/25.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter{

    private Context mContext;   //mainActivity側に渡す?

    private ArrayList<Integer> mList;  //ページ数用リスト
    private int Width;

    public CustomPagerAdapter(Context context){     //コンストラクタ　初期化
        mContext=context;
        mList=new ArrayList<Integer>();
    }



    public void add(Integer item,int width){    //　色のデータ(int型)と画面の横幅を新しいページに記録
        mList.add(item);                    //30
        Width=width;
    }

    public void TextViewer(LinearLayout linea,String ss){               //LinearLayoutと、表示したい文字列を引数に文字列を表示
        TextView textView =new TextView(mContext);
        textView.setText(ss);
        textView.setTextSize(30);
       // textView.setTextColor(item);//色変更 メソッド化により停止　itemを引数としてとれば再稼働
        textView.setGravity(Gravity.BOTTOM);
        linea.addView(textView, createParam(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void ImageViewer(LinearLayout linea,String name,String syoukai,int page_number){        //Viewerメソッド
        ImageButton imgbutton=new ImageButton(mContext);
        String s=name;
        String ss=syoukai;
        if(page_number==0){
            imgbutton.setImageResource(R.drawable.kyoro);
        }else if(page_number==1){
            imgbutton.setImageResource(R. drawable.nenga2015);
        }else if(page_number==2){
            imgbutton.setImageResource(R.drawable.peko);
        }else {
            imgbutton.setImageResource(R.drawable.nanana);
        }


        imgbutton.setPadding(0, 0, 0, 0);//25
        imgbutton.setScaleType(ImageView.ScaleType.FIT_XY);

        //画像ボタンアクション(中身はアラートダイアログ)


        imgbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);            //アラートダイアログ
                alertDialog.setIcon(R.drawable.kyoro);
                alertDialog.setTitle(s);
                alertDialog.setMessage();
                alertDialog.setPositiveButton("閉じる", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("AlertDialog", "Poositive which:" + which);
                    }
                });
                alertDialog.show();                                                     //アラートダイアログ
            }
        });

        linea.addView(imgbutton, createParam(Width,Width));  //画面の横幅に合わせて画像表示　　　※画像によってWidth,widthを変更する必要あり


    }




   // @override
    public Object instantiateItem(ViewGroup container, int position){

        Integer item =mList.get(position);
        LinearLayout linearLayout=new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);         //アイテムを縦に表示




        TextViewer(linearLayout,"真珠博物館");       //テキスト表示

        //画像ボタン表示

        ImageButton imgbutton=new ImageButton(mContext);

        imgbutton.setImageResource(R.drawable.ookyoro);
        imgbutton.setPadding(0, 0, 0, 0);//25
        imgbutton.setScaleType(ImageView.ScaleType.FIT_XY);

        //画像ボタンアクション(中身はアラートダイアログ)

        imgbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);            //アラートダイアログ
                alertDialog.setIcon(R.drawable.kyoro);
                alertDialog.setTitle("名前");
                alertDialog.setMessage("説明");
                alertDialog.setPositiveButton("閉じる", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("AlertDialog", "Poositive which:" + which);
                    }
                });
                alertDialog.show();                                                     //アラートダイアログ
            }
        });

        linearLayout.addView(imgbutton, createParam(Width,Width));  //画面の横幅に合わせて画像表示　　　※画像によってWidth,widthを変更する必要あり
        String s=null;
        if(item==0){
            TextViewer(linearLayout, "キョロちゃん");
        }else if(item==1){
            TextViewer(linearLayout,"年賀状");
        }else if(item==2){
            TextViewer(linearLayout,"ペコちゃん");
        }else if(item==3){
            TextViewer(linearLayout,"地縛霊");
        }else{
            TextViewer(linearLayout,"FOX");
        }

        container.addView(linearLayout);

        return linearLayout;
    }



    private LinearLayout.LayoutParams createParam(int w,int h){
        return new LinearLayout.LayoutParams(w,h);
    }

    public void destroyItem(ViewGroup container,int position, Object object){
        container.removeView((View) object);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout) object;
    }
}
