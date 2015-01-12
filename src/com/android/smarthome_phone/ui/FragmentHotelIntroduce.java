package com.android.smarthome_phone.ui;

import com.android.smarthome_phone.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/**
 * 酒店介绍
 * @author fengruyi
 *
 */
public class FragmentHotelIntroduce extends Fragment{
	private WebView mWebview;
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hotelintroduce_layout, null);
		mWebview = (WebView) view.findViewById(R.id.webview);
		mWebview.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
		mWebview.loadUrl("file:///android_asset/About_hotel.html");
		return view;
	}
}
