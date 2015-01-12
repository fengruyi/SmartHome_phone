package com.android.smarthome_phone.view;

import java.util.ArrayList;
import java.util.List;

import com.android.smarthome_phone.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;

/**
 * 自定义可以动态添加图片张数和自动滚动轮播控件，基于viewpager实现
 * @author fengruyi
 *
 */
public class HorizonRollingView extends RelativeLayout implements OnPageChangeListener{
	/**
	 * 是否需要自动轮播
	 */
	private boolean isAutoPlaying;
	/**
	 * 轮播图集
	 */
	private List<View> mImageviews;
	/**
	 * 图片地址
	 */
	//private List<String> imageUris;
	/**
	 * 本地图片id
	 */
	private int[]  imageresIds;
	/**
	 * 指示点
	 */
	private List<View> mDots;
	/**
	 * 实现轮播的组件
	 */
	private ViewPager mViewPager;
	/**
	 * 装载小圆点的layout
	 */
	private LinearLayout mDotsLayout;
	/**
	 * 当前显示图片的位置
	 */
	private int currentItem  = 0;
	/**
	 * 輪番時間六間隔為5秒
	 */
	private final int TIME_RATE = 5000;
    private MyPagerAdapter mAdapter;
	public HorizonRollingView(Context context) {
		
		super(context,null);
		// TODO Auto-generated constructor stub
	}

	public HorizonRollingView(Context context, AttributeSet attrs) {
		super(context, attrs,0);
		
		
	}
	public HorizonRollingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		
	}
	// 切换当前显示的图片

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if(!isAutoPlaying){
				return;
			}
			if (imageresIds.length > 0) {
				currentItem = (currentItem + 1) % imageresIds.length;
				mViewPager.setCurrentItem(currentItem);// 切换当前显示的图片
				mHandler.sendEmptyMessageDelayed(0, TIME_RATE);
			}
		};
	};
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		imageresIds = new int[]{};
		mImageviews = new ArrayList<View>();
		mDots = new ArrayList<View>();
		mAdapter = new MyPagerAdapter();
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mDotsLayout = (LinearLayout) findViewById(R.id.layout_dots);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		if(isAutoPlaying){
			mHandler.removeCallbacksAndMessages(null);
			mHandler.sendEmptyMessageDelayed(0, TIME_RATE);
		}
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		if(!isAutoPlaying){
			mHandler.removeCallbacksAndMessages(null);
		}
	}
	public void setData(int[] imageresIds,boolean isAutoPlaying){
		this.imageresIds = imageresIds;
		LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(8,8);
		lp.setMargins(5, 0, 0, 0);
		for(int i = 0 ,length = imageresIds.length; i<length; i++){
			
			ImageView viewDot =  new ImageView(getContext());
			if(i == 0 ){
				viewDot.setBackgroundResource(R.drawable.dot_focused);
			}else{
				viewDot.setBackgroundResource(R.drawable.dot_normal);
			}
			viewDot.setLayoutParams(lp);
			mDotsLayout.addView(viewDot,lp);
			mDots.add(viewDot);
		}

		mAdapter.notifyDataSetChanged();
		if(isAutoPlaying){
			startPlay();
		}
	}
	private void startPlay(){
		isAutoPlaying = true;
		mHandler.sendEmptyMessageDelayed(0, TIME_RATE);
	}
	private void stopPlay(){
		isAutoPlaying = false;
		mHandler.removeCallbacksAndMessages(null);
	}
	 /** 
     * 设置选中的tip的背景 
     * @param selectItems 
     */  
    private void setImageBackground(int selectItems){ 
        for(int i=0; i<mDots.size(); i++){  
            if(i == selectItems){  
            	mDots.get(i).setBackgroundResource(R.drawable.dot_focused);  
            }else{  
            	mDots.get(i).setBackgroundResource(R.drawable.dot_normal);  
            }  
        }  
    }  
	
	private class MyPagerAdapter extends PagerAdapter{
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			if(mImageviews.size()>=position){
				ImageView imageView = new ImageView(getContext());
				imageView.setScaleType(ScaleType.FIT_XY);
				//imageView.setImageUrl("");
				//imageView.setOnClickListener(l);//点击事件
				imageView.setBackgroundResource(imageresIds[position]);
				mImageviews.add(imageView);
			}
			container.addView(mImageviews.get(position));
			return mImageviews.get(position);
		}
		
		@Override
		public int getCount() {
			return imageresIds.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(arg0);
		
	};
}
