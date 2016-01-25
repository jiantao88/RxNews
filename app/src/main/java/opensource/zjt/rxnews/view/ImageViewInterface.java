package opensource.zjt.rxnews.view;

import java.util.List;

import opensource.zjt.rxnews.bean.ImageModel;

public interface ImageViewInterface {
    void addImages(List<ImageModel.NewsImagelistEntity> list);

    void showProgress();

    void hideProgress();

    void showLoadFailMsg();
}
