package opensource.zjt.rxnews.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import opensource.zjt.rxnews.R;
import opensource.zjt.rxnews.base.AppService;
import opensource.zjt.rxnews.base.RxBus;
import opensource.zjt.rxnews.event.NewsEvent;
import opensource.zjt.rxnews.bean.NewsModel;
import opensource.zjt.rxnews.net.Constant;
import opensource.zjt.rxnews.presenter.NewsPresenter;
import opensource.zjt.rxnews.presenter.NewsPresenterImpl;
import opensource.zjt.rxnews.rxmethod.RxNews;
import opensource.zjt.rxnews.ui.activity.NewsDetailActivity;
import opensource.zjt.rxnews.view.NewsView;
import rx.functions.Action1;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsView {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String TAG = NewsListFragment.class.getName();
    @Bind(R.id.recyclerView_list)
    RecyclerView recyclerView;
    @Bind(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshWidget;
    private int mColumnCount = 1;
    private LinearLayoutManager mLayoutManager;
    private int pageIndex = 1;
    private List<NewsModel.NewslistEntity> mData;
    private NewsPresenter mNewsPresenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewsListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NewsListFragment newInstance(int columnCount) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        AppService.getInstance().initNews(getActivity().getTaskId(), getID(mColumnCount));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, view);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.colorAccent,
                R.color.colorAccent, R.color.colorPrimaryDark,
                R.color.colorAccent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyItemRecyclerViewAdapter(getContext().getApplicationContext());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnScrollListener(mOnScrollListener);
        mNewsPresenter = new NewsPresenterImpl(this);
        onRefresh();
        return view;
    }

    private MyItemRecyclerViewAdapter mAdapter;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount()
                    && mAdapter.isShowFooter()) {
                //加载更多
                KLog.d(TAG, "loading more data");
                mNewsPresenter.loadNews(mColumnCount, pageIndex++);
            }
        }
    };
    private MyItemRecyclerViewAdapter.OnItemClickListener mOnItemClickListener = new MyItemRecyclerViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            NewsModel.NewslistEntity news = mAdapter.getItem(position);
            Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
            intent.putExtra(Constant.NEWSDETAIL, news);
            View transitionView = view.findViewById(R.id.ivNews);
            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                            transitionView, getString(R.string.transition_news_img));

            ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
        }
    };


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);

    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        if (mData != null) {
            mData.clear();
        }
        mNewsPresenter.loadNews(mColumnCount, pageIndex);
    }

    @Override
    public void addNew(List<NewsModel.NewslistEntity> list) {
        mAdapter.isShowFooter(true);
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(list);
        if (pageIndex == 1) {
            mAdapter.setmDate(mData);
        } else {
            if (list == null || list.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
        pageIndex += Constant.PAZE_SIZE;
    }

    @Override
    public void showProgress() {
        if (mSwipeRefreshWidget != null)
            mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        if (mSwipeRefreshWidget != null)
            mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFail() {
        if (pageIndex == 1) {
            mAdapter.isShowFooter(false);
            mAdapter.notifyDataSetChanged();
        }
        View view = getActivity() == null ? recyclerView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
        Snackbar.make(view, getString(R.string.load_fail), Snackbar.LENGTH_SHORT).show();
    }

    private String getID(int type) {
        String id;
        switch (type) {
            case 0:
                id = Constant.NEWSTYPE_KEJI;
                break;
            case 1:
                id = Constant.NEWSTYPE_GUOJI;
                break;
            case 2:
                id = Constant.NEWSTYPE_SHEHUI;
                break;
            case 3:
                id = Constant.NEWSTYPE_TIYU;
                break;
            default:
                id = Constant.NEWSTYPE_KEJI;
                break;
        }
        return id;
    }
}
