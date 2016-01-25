package opensource.zjt.rxnews.model;

import java.util.List;

import opensource.zjt.rxnews.bean.ImageModel;
import opensource.zjt.rxnews.net.NewsCallback;
import opensource.zjt.rxnews.net.NewsFactory;
import opensource.zjt.rxnews.net.NewsResponse;
import opensource.zjt.rxnews.rxmethod.RxNews;
import retrofit.Call;

/**
 */
public class ImageModelImpl implements ImageModelInterface {

    /**
     * 获取图片列表
     * @param listener
     */
    @Override
    public void loadImageList(final OnLoadImageListListener listener) {

        Call<ImageModel> call = NewsFactory.getRxNewsImageApi().loadImage(RxNews.KEY,10,1);
        call.enqueue(new NewsCallback<ImageModel>() {
            @Override
            public void onCallback(NewsResponse<ImageModel> response) {
                if (response.isSuccess()){
                    listener.onSuccess(response.getmResult().getNewslist());
                }else {
                    listener.onFailure(response.getErrorMessage());
                }
            }
        });
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<ImageModel.NewsImagelistEntity> list);
        void onFailure(String msg);
    }
}
