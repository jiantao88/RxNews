package opensource.zjt.rxnews.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;


import butterknife.Bind;
import butterknife.ButterKnife;
import opensource.zjt.rxnews.R;
import opensource.zjt.rxnews.base.BaseActivity;
import opensource.zjt.rxnews.bean.NewsModel;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.presenter.NewsDetailPresenter;
import opensource.zjt.rxnews.presenter.NewsDetailPresenterImpl;
import opensource.zjt.rxnews.view.NewsDetailView;

public class NewsDetailActivity extends BaseActivity implements NewsDetailView {

    @Bind(R.id.ivImage)
    ImageView ivImage;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.progress)
    ProgressBar mProgressBar;
    @Bind(R.id.detail_webview)
    WebView detailWebview;
    private NewsModel.NewslistEntity mNews;
    private NewsDetailPresenter mNewsDetailPresenter;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        detailWebview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        detailWebview.getSettings().setJavaScriptEnabled(true);
        detailWebview.setBackgroundColor(0);

        mNews = (NewsModel.NewslistEntity) getIntent().getParcelableExtra(Constant.NEWSDETAIL);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mNews.getTitle());

        Glide.with(this).load(mNews.getPicUrl()).into(ivImage);

        mNewsDetailPresenter = new NewsDetailPresenterImpl(getApplication(), this);
        mNewsDetailPresenter.loadNewsDetail(mNews.getUrl());
    }

    @Override
    public void showNewsDetailContent(String detailUrl) {
        detailWebview.loadUrl(detailUrl);
        detailWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }
}
