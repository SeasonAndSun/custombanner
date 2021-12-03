package com.liecen.custombanner.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.liecen.custombanner.R;
import com.liecen.custombanner.TransformerBackgroundView;
import com.liecen.custombanner.banner.Banner;
import com.liecen.custombanner.banner.adapter.BannerImageTitleItemAdapter;
import com.liecen.custombanner.banner.listener.OnPageChangeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private TransformerBackgroundView transformerBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = findViewById(R.id.banner);
        transformerBg = findViewById(R.id.transformer_bg);

        initBanner();
        initTransformerBg();
    }

    private void initBanner() {

        ArrayList<String> mDatas = new ArrayList<>();
        mDatas.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019b0e59dd0177a80121ae0c32dc43.jpg%402o.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641025369&t=587b057265fdaf539f86feb0e3f350bb");
        mDatas.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01502759dd015ea801204463b01bed.jpg%401280w_1l_2o_100sh.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641025391&t=8bcf58dbc71a99969d1a5aa719a68b6b");
        mDatas.add("https://img2.baidu.com/it/u=1417941609,2817717192&fm=15&fmt=auto");
        mDatas.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F6920d2c44e8feac9e785d5ef321027c00fa60ca6397cb-ZpNIjZ_fw658&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641025428&t=50914f0ad8e28f784b5d6101f93d55f0");
        mDatas.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01308e5919b9baa801216a3e0fa17f.jpg%402o.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641025464&t=b8077554c72b46f243c0348b5030521d");

        banner.setBannerGalleryEffect(10, 10,0.6f);
        banner.setAdapter(new BannerImageTitleItemAdapter(mDatas));

    }

    private void initTransformerBg() {

        ArrayList<String> colors = new ArrayList<>();
        colors.add("#104C2F");
        colors.add("#FBB720");
        colors.add("#4F0F53");
        colors.add("#396CC8");
        colors.add("#CC1F32");
        transformerBg.setTransformerColors(colors);
        transformerBg.setupWithViewPager(banner);
    }



}