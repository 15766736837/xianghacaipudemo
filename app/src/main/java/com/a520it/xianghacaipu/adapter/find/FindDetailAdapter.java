package com.a520it.xianghacaipu.adapter.find;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.bean.disbean.DetailBean;
import com.a520it.xianghacaipu.bean.disbean.MultiItem;
import com.a520it.xianghacaipu.utils.LoadImageUtil;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by simon on 2017/7/17.
 */

public class FindDetailAdapter extends BaseMultiItemQuickAdapter<MultiItem, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FindDetailAdapter(List<MultiItem> data) {

        super(data);
        addItemType(MultiItem.CONTENT, R.layout.find_detail_content_layout);
        addItemType(MultiItem.COMMENT, R.layout.find_detail_comment_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItem item) {
        DetailBean.DataBean.FloorBean floorBean = item.getFloorBean();
        switch (helper.getItemViewType()) {
            case MultiItem.CONTENT:
                //设置头像
                LoadImageUtil.getInstance().display(floorBean.getCustomer().getImgShow(), (CircleImageView) helper.getView(R.id.find_detail_content_head_icon));
                //设置昵称,发布时间
                helper.setText(R.id.find_detail_content_name, floorBean.getCustomer().getNickName()).setText(R.id.find_detail_content_content, floorBean.getTimeShow());

                //设置正文
                LinearLayout linearLayout = helper.getView(R.id.find_detail_content_show_pic);
                for (int i = 0; i < floorBean.getContent().size(); i++) {
                    DetailBean.DataBean.FloorBean.ContentBean contentBean = floorBean.getContent().get(i);
                    //设置文本
                    TextView textView = getTextView();
                    if ("".equals(contentBean.getText().get(0))) {
                        textView.setVisibility(View.GONE);
                    }
                    textView.setText(contentBean.getText().get(0));
                    //设置图片
                    ImageView imageView = getImageView();
                    LoadImageUtil.getInstance().display(contentBean.getImg(), imageView);
                    linearLayout.addView(textView);
                    linearLayout.addView(imageView);
                }
                //设置点赞
                LinearLayout likeLinearLayout = helper.getView(R.id.find_detail_content_like);
                helper.setText(R.id.find_detail_content_like_count,String.valueOf(floorBean.getLikeNum()));
                List<DetailBean.DataBean.FloorBean.LikeListBean> likeList = floorBean.getLikeList();
                int count = likeList.size() > 8 ? 8 : likeList.size();
                for (int i = 0; i < count; i++) {
                    CircleImageView likePic = getLikePic(likeLinearLayout);
                    LoadImageUtil.getInstance().display(likeList.get(i).getImgShow(), likePic);
                    likeLinearLayout.addView(likePic);
                }
                break;
            case MultiItem.COMMENT:
                DetailBean.DataBean.FloorBean.CustomerBean customer = floorBean.getCustomer();
                LoadImageUtil.getInstance().display(customer.getImgShow(), (CircleImageView) helper.getView(R.id.find_detail_content_head_icon));
                helper.setText(R.id.find_detail_content_content, item.getFloorBean().getContent().get(0).getText().get(0)).setText(R.id.find_detail_content_name, customer.getNickName()).setText(R.id.find_detail_content_time, floorBean.getTimeShow());
                break;
        }
    }

    private CircleImageView getLikePic(LinearLayout likeLinearLayout) {

        CircleImageView circleImageView = new CircleImageView(mContext);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(80, 80);
        circleImageView.setPadding(8, 8, 8, 8);
        textParams.setMargins(0, 8, 0, 0);
        circleImageView.setLayoutParams(textParams);
        return circleImageView;
    }



    private TextView getTextView() {
        TextView textView = new TextView(mContext);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.setMargins(0, 8, 0, 0);
        textView.setLayoutParams(textParams);
        textView.setLineSpacing(0, 1f);
        textView.setTextColor(mContext.getResources().getColor(R.color.text_color_696969));
        textView.setTextSize(16);
        return textView;
    }

    private ImageView getImageView() {
        ImageView imageView = new ImageView(mContext);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageParams.setMargins(0, 16, 0, 8);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(imageParams);
        return imageView;
    }
}
