package opensource.zjt.rxnews.presenter;



import java.util.List;

import opensource.zjt.rxnews.bean.ImageModel;
import opensource.zjt.rxnews.model.ImageModelInterface;
import opensource.zjt.rxnews.model.ImageModelImpl;
import opensource.zjt.rxnews.view.ImageViewInterface;

/**
 * Description :
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/22
 */
public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private ImageModelInterface mImageModelInterface;
    private ImageViewInterface mImageView;

    public ImagePresenterImpl(ImageViewInterface imageView) {
        this.mImageModelInterface = new ImageModelImpl();
        this.mImageView = imageView;
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModelInterface.loadImageList(this);
    }

    @Override
    public void onSuccess(List<ImageModel.NewsImagelistEntity> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }
    public void clear() {
    mImageList.clear();
    notifyDataSetChanged();
    }
    public void clearImageList() {
    mImageView.clearImages();
    }

}
