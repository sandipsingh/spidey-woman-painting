package com.spidey.woman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.ads.Ad;
import com.google.ads.AdRequest;
import com.google.ads.InterstitialAd;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;






public class ColorActivity extends Activity implements View.OnClickListener, View.OnTouchListener,
		UberColorPickerDialog.OnColorChangedListener,com.google.ads.AdListener
{
	//latest update
	private ImageView imageView_first,imageView_sec,imageView_third,imageView_four,imageView_five,imageView_six,imageView_saven,imageView_eight;
	LinearLayout btnSave, btnShare, btnWall,btnNew;
	Button btnSave1, btnShare1, btnWall1,btnNew1;
	private RelativeLayout my_layout,hey;
	private boolean checking=true;
	private InterstitialAd interstitial;
	/** Called when the activity is first created. */
	//**********
     Matrix matrix = new Matrix();
	 Matrix savedMatrix = new Matrix();

	 File imageFile, directory;
	 String mPath;
	 
	 // We can be in one of these 3 states
	 static final int NONE = 0;
	 static final int DRAG = 1;
	 static final int ZOOM = 2;
	 int mode = NONE;
	 ImageView OffSound;
	 // Remember some things for zooming
	 PointF start = new PointF();
	 PointF mid = new PointF();
	 float oldDist = 1f;

	 int position1;
	 int[] cols={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f
		,R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l,
		R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, 
		R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x,
		R.drawable.y, R.drawable.z, R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.dd,
		R.drawable.ee, R.drawable.ff, R.drawable.gg, R.drawable.hh, R.drawable.ii, R.drawable.jj,
		R.drawable.kk, R.drawable.ll, R.drawable.mm, R.drawable.nn, R.drawable.oo, R.drawable.pp,
		R.drawable.qq, R.drawable.rr, R.drawable.ss, R.drawable.tt, R.drawable.uu, R.drawable.vv,
		R.drawable.ww, R.drawable.xx, R.drawable.yy, R.drawable.zz, R.drawable.aaa, R.drawable.bbb
		
};

	 //*********
	
		
	
	private static final int LOW_DPI_STATUS_BAR_HEIGHT = 19;

	private static final int MEDIUM_DPI_STATUS_BAR_HEIGHT = 25;

	private static final int HIGH_DPI_STATUS_BAR_HEIGHT = 38;
	Bitmap _alteredBitmap;
	private int mColor = 0xFFFF0000;                
	FileOutputStream fout;
	int count = 0, aa = 0, originalImageOffsetX = 0, originalImageOffsetY = 0,   
			color = 0;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	String dt;
	Bitmap bitmap;
	ImageView img;
	private int imageNumber = 0;
	private static final int REFRESH_SCREEN = 1;       
	public final int[][][] _rybColorCube = {
			{
					// R = 0
					{ R.color.color_white, R.color.color_blue,
							R.color.color_blue },
					{ R.color.color_yellow, R.color.color_green,
							R.color.color_bluegreen },
					{ R.color.color_yellow, R.color.color_yellowgreen,
							R.color.color_green } },
			{
					// R = 1
					{ R.color.color_red, R.color.color_violet,
							R.color.color_blueviolet },
					{ R.color.color_orange, R.color.color_grey,
							R.color.color_grey },
					{ R.color.color_yelloworange, R.color.color_grey,
							R.color.color_grey } },
			{
					// R = 2
					{ R.color.color_red, R.color.color_redviolet,
							R.color.color_violet },
					{ R.color.color_redorange, R.color.color_grey,
							R.color.color_grey },
					{ R.color.color_grey, R.color.color_grey,
							R.color.color_grey } } };
	RelativeLayout rl, rl1, rl2;
	LinearLayout layMain;
	private AdView ad;
	public final Map<Integer, RybColorSmartCode> _rybColorMap = new HashMap<Integer, RybColorSmartCode>();
	private RadioButton rb, rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;

	TransparentPanel popup;
	Button btnShow;
	int key=0;
	Point p;
	GridView gridViewColors;
	Dialog dialog;
	public final int CATEGORY_ID=0;
//	RadioButton btnColor;
	RadioButton btn_a, btn_b, btn_c, btn_d, btn_e, btn_f, btn_g, btn_h, btn_i, btn_j, btn_k, btn_l, btn_m,
	btn_n, btn_o, btn_p, btn_q, btn_r, btn_s, btn_t, btn_u, btn_v, btn_w, btn_x, btn_y, btn_z, btn_aa, btn_bb, 
	btn_cc, btn_dd, btn_ee, btn_ff, btn_gg, btn_hh, btn_ii, btn_jj, btn_kk, btn_ll, btn_mm,
	btn_nn, btn_oo, btn_pp, btn_qq, btn_rr, btn_ss, btn_tt, btn_uu, btn_vv, btn_ww, btn_xx, btn_yy, btn_zz, btn_aaa,
	btn_bbb;
	
	int c2;
	public void onBackPressed() {
		SoundManager.instance().stopBackgroundMusic();
		return;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			finish();
			SoundManager.instance().stopBackgroundMusic();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	protected void onStop() {
		

		super.onStop();
	}

	protected void onPause() {
		SoundManager.instance().stopBackgroundMusic();

		super.onPause();
	}

	protected void onDestroy() {
		finish();
		SoundManager.instance().stopBackgroundMusic();
		super.onDestroy();
	//	unbindDrawables(findViewById(R.id.RootView));
		System.gc();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	


		SoundManager.instance().load(this);

		OffSound = (ImageView) findViewById(R.id.OffSound);
		OffSound.setTag("Sound On");
		
		
		
		
		 // Create the interstitial
	    interstitial = new InterstitialAd(this, "a150250ae10b887");

	    // Create ad request
	    AdRequest adRequest = new AdRequest();

	    // Begin loading your interstitial
	    interstitial.loadAd(adRequest);

	    // Set Ad Listener to use the callbacks below
	    interstitial.setAdListener(this);
		
		OffSound.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				// SoundManager.instance().stopBackgroundMusic();
				// OffSound.setImageResource(R.drawable.mute);
				if (OffSound.getTag().equals("Sound On")) {
					OffSound.setImageResource(R.drawable.mute);
					SoundManager.instance().stopBackgroundMusic();
					OffSound.setTag("Sound Off");
					checking=false;
				} else {
					OffSound.setImageResource(R.drawable.sound);
					SoundManager.instance().startBackgroundMusic();
					OffSound.setTag("Sound On");
					checking=true;
				}
			}

		});
		
		//latest update
		
		imageView_first=(ImageView)findViewById(R.id.imageView_first);
		imageView_sec=(ImageView)findViewById(R.id.imageView_sec);
		imageView_third=(ImageView)findViewById(R.id.imageView_thi);
		imageView_four=(ImageView)findViewById(R.id.imageView_four);
		imageView_five=(ImageView)findViewById(R.id.imageView_five);
		imageView_six=(ImageView)findViewById(R.id.imageView_six);
		imageView_saven=(ImageView)findViewById(R.id.imageView_saven);
		imageView_eight=(ImageView)findViewById(R.id.imageView_eight);
		
		imageView_first.setOnClickListener(ColorActivity.this);
		imageView_sec.setOnClickListener(ColorActivity.this);
		imageView_third.setOnClickListener(ColorActivity.this);
		imageView_four.setOnClickListener(ColorActivity.this);
		imageView_five.setOnClickListener(ColorActivity.this);
		imageView_six.setOnClickListener(ColorActivity.this);
		imageView_saven.setOnClickListener(ColorActivity.this);
		imageView_eight.setOnClickListener(ColorActivity.this);
		
		my_layout=(RelativeLayout)findViewById(R.id.myLayoutRel);
		my_layout.setVisibility(View.INVISIBLE);
		
		hey=(RelativeLayout)findViewById(R.id.hey);
		
		
	//	btnColor=(RadioButton)findViewById(R.id.btnColor);
	//	btnColor.setVisibility(View.GONE);
		btn_a=(RadioButton)findViewById(R.id.btn_a);
		btn_a.setVisibility(View.GONE);
		btn_b=(RadioButton)findViewById(R.id.btn_b);
		btn_b.setVisibility(View.GONE);
		btn_c=(RadioButton)findViewById(R.id.btn_c);
		btn_c.setVisibility(View.GONE);
		btn_d=(RadioButton)findViewById(R.id.btn_d);
		btn_d.setVisibility(View.GONE);
		btn_e=(RadioButton)findViewById(R.id.btn_e);
		btn_e.setVisibility(View.GONE);
		btn_f=(RadioButton)findViewById(R.id.btn_f);
		btn_f.setVisibility(View.GONE);
		btn_g=(RadioButton)findViewById(R.id.btn_g);
		btn_g.setVisibility(View.GONE);
		btn_h=(RadioButton)findViewById(R.id.btn_h);
		btn_h.setVisibility(View.GONE);
		btn_i=(RadioButton)findViewById(R.id.btn_i);
		btn_i.setVisibility(View.GONE);
		btn_j=(RadioButton)findViewById(R.id.btn_j);
		btn_j.setVisibility(View.GONE);
		btn_k=(RadioButton)findViewById(R.id.btn_k);
		btn_k.setVisibility(View.GONE);
		btn_l=(RadioButton)findViewById(R.id.btn_l);
		btn_l.setVisibility(View.GONE);
		btn_m=(RadioButton)findViewById(R.id.btn_m);
		btn_m.setVisibility(View.GONE);
		btn_n=(RadioButton)findViewById(R.id.btn_n);
		btn_n.setVisibility(View.GONE);
		btn_o=(RadioButton)findViewById(R.id.btn_o);
		btn_o.setVisibility(View.GONE);
		btn_p=(RadioButton)findViewById(R.id.btn_p);
		btn_p.setVisibility(View.GONE);
		btn_q=(RadioButton)findViewById(R.id.btn_q);
		btn_q.setVisibility(View.GONE);
		btn_r=(RadioButton)findViewById(R.id.btn_r);
		btn_r.setVisibility(View.GONE);
		btn_s=(RadioButton)findViewById(R.id.btn_s);
		btn_s.setVisibility(View.GONE);
		btn_t=(RadioButton)findViewById(R.id.btn_t);
		btn_t.setVisibility(View.GONE);
		btn_u=(RadioButton)findViewById(R.id.btn_u);
		btn_u.setVisibility(View.GONE);
		btn_v=(RadioButton)findViewById(R.id.btn_v);
		btn_v.setVisibility(View.GONE);
		btn_w=(RadioButton)findViewById(R.id.btn_w);
		btn_w.setVisibility(View.GONE);
		btn_x=(RadioButton)findViewById(R.id.btn_x);
		btn_x.setVisibility(View.GONE);
		btn_y=(RadioButton)findViewById(R.id.btn_y);
		btn_y.setVisibility(View.GONE);
		btn_z=(RadioButton)findViewById(R.id.btn_z);
		btn_z.setVisibility(View.GONE);
	
		btn_aa=(RadioButton)findViewById(R.id.btn_aa);
		btn_aa.setVisibility(View.GONE);
		btn_bb=(RadioButton)findViewById(R.id.btn_bb);
		btn_bb.setVisibility(View.GONE);
		btn_cc=(RadioButton)findViewById(R.id.btn_cc);
		btn_cc.setVisibility(View.GONE);
		btn_dd=(RadioButton)findViewById(R.id.btn_dd);
		btn_dd.setVisibility(View.GONE);
		btn_ee=(RadioButton)findViewById(R.id.btn_ee);
		btn_ee.setVisibility(View.GONE);
		btn_ff=(RadioButton)findViewById(R.id.btn_ff);
		btn_ff.setVisibility(View.GONE);
		btn_gg=(RadioButton)findViewById(R.id.btn_gg);
		btn_gg.setVisibility(View.GONE);
		btn_hh=(RadioButton)findViewById(R.id.btn_hh);
		btn_hh.setVisibility(View.GONE);
		btn_ii=(RadioButton)findViewById(R.id.btn_ii);
		btn_ii.setVisibility(View.GONE);
		btn_jj=(RadioButton)findViewById(R.id.btn_jj);
		btn_jj.setVisibility(View.GONE);
		btn_kk=(RadioButton)findViewById(R.id.btn_kk);
		btn_kk.setVisibility(View.GONE);
		btn_ll=(RadioButton)findViewById(R.id.btn_ll);
		btn_ll.setVisibility(View.GONE);
		btn_mm=(RadioButton)findViewById(R.id.btn_mm);
		btn_mm.setVisibility(View.GONE);
		btn_nn=(RadioButton)findViewById(R.id.btn_nn);
		btn_nn.setVisibility(View.GONE);
		btn_oo=(RadioButton)findViewById(R.id.btn_oo);
		btn_oo.setVisibility(View.GONE);
		btn_pp=(RadioButton)findViewById(R.id.btn_pp);
		btn_pp.setVisibility(View.GONE);
		btn_qq=(RadioButton)findViewById(R.id.btn_qq);
		btn_qq.setVisibility(View.GONE);
		btn_rr=(RadioButton)findViewById(R.id.btn_rr);
		btn_rr.setVisibility(View.GONE);
		btn_ss=(RadioButton)findViewById(R.id.btn_ss);
		btn_ss.setVisibility(View.GONE);
		btn_tt=(RadioButton)findViewById(R.id.btn_tt);
		btn_tt.setVisibility(View.GONE);
		btn_uu=(RadioButton)findViewById(R.id.btn_uu);
		btn_uu.setVisibility(View.GONE);
		btn_vv=(RadioButton)findViewById(R.id.btn_vv);
		btn_vv.setVisibility(View.GONE);
		btn_ww=(RadioButton)findViewById(R.id.btn_ww);
		btn_ww.setVisibility(View.GONE);
		btn_xx=(RadioButton)findViewById(R.id.btn_xx);
		btn_xx.setVisibility(View.GONE);
		btn_yy=(RadioButton)findViewById(R.id.btn_yy);
		btn_yy.setVisibility(View.GONE);
		btn_zz=(RadioButton)findViewById(R.id.btn_zz);
		btn_zz.setVisibility(View.GONE);
	
		btn_aaa=(RadioButton)findViewById(R.id.btn_aaa);
		btn_aaa.setVisibility(View.GONE);
		btn_bbb=(RadioButton)findViewById(R.id.btn_bbb);
		btn_bbb.setVisibility(View.GONE);
		
		rb7=(RadioButton) findViewById(R.id.btn_black);
		rb7.setVisibility(View.VISIBLE);
	//	Intent i=getIntent();
	//	String col1=i.getStringExtra("val");
	//	Toast.makeText(getApplicationContext(), "se" +col1, Toast.LENGTH_LONG).show();
		
//		String hash="#";
//		String col2=hash+col1;
//		System.out.println("color is" +col2);
		//
		// Ad View
		//
		rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
		String id = "a150250ae10b887";
		ad = new AdView(this, AdSize.BANNER, id);
		rl2.addView(ad);
		ad.loadAd(new AdRequest());

		rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
		layMain=(LinearLayout) findViewById(R.id.layMain);
		
		img = (ImageView) findViewById(R.id.imageView1);
		
		btnSave=(LinearLayout) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(this);
		btnShare=(LinearLayout) findViewById(R.id.btnShare);
		btnShare.setOnClickListener(this);
		btnWall=(LinearLayout) findViewById(R.id.btnWall);
		btnWall.setOnClickListener(this);
		btnNew=(LinearLayout)findViewById(R.id.btnNew);
		btnNew.setOnClickListener(this);
		
		
		btnSave1=(Button) findViewById(R.id.btnSave1);
		btnSave1.setOnClickListener(this);
		btnShare1=(Button) findViewById(R.id.btnShare1);
		btnShare1.setOnClickListener(this);
		btnWall1=(Button) findViewById(R.id.btnWall1);
		btnWall1.setOnClickListener(this);
		btnNew1=(Button)findViewById(R.id.btnNew1);
		btnNew1.setOnClickListener(this);
		
		popup=(TransparentPanel) findViewById(R.id.popup_window);
		popup.setVisibility(View.GONE);
		
		btnShow=(Button) findViewById(R.id.btnshow);
		btnShow.setOnClickListener(this);
	
		rb = (RadioButton) findViewById(R.id.btn_red);
		rb.setOnClickListener(this);
		rb1 = (RadioButton) findViewById(R.id.btn_orange);
		rb1.setOnClickListener(this);
		rb2 = (RadioButton) findViewById(R.id.btn_yellow);
		rb2.setOnClickListener(this);
		rb3 = (RadioButton) findViewById(R.id.btn_pink);
		rb3.setOnClickListener(this);
		rb4 = (RadioButton) findViewById(R.id.btn_purple);
		rb4.setOnClickListener(this);
		rb5 = (RadioButton) findViewById(R.id.btn_green);
		rb5.setOnClickListener(this);
		rb7 = (RadioButton) findViewById(R.id.btn_black);
		rb7.setOnClickListener(this);

		btn_a.setOnClickListener(this);
		btn_b.setOnClickListener(this);
		btn_c.setOnClickListener(this);
		btn_d.setOnClickListener(this);
		btn_e.setOnClickListener(this);
		btn_f.setOnClickListener(this);
		btn_g.setOnClickListener(this);
		btn_h.setOnClickListener(this);
		btn_i.setOnClickListener(this);
		btn_j.setOnClickListener(this);
		btn_k.setOnClickListener(this);
		btn_l.setOnClickListener(this);
		btn_m.setOnClickListener(this);
		btn_n.setOnClickListener(this);
		btn_o.setOnClickListener(this);
		btn_p.setOnClickListener(this);
		btn_q.setOnClickListener(this);
		btn_r.setOnClickListener(this);
		btn_s.setOnClickListener(this);
		btn_t.setOnClickListener(this);
		btn_u.setOnClickListener(this);
		btn_v.setOnClickListener(this);
		btn_w.setOnClickListener(this);
		btn_x.setOnClickListener(this);
		btn_y.setOnClickListener(this);
		btn_z.setOnClickListener(this);

		btn_aa.setOnClickListener(this);
		btn_bb.setOnClickListener(this);
		btn_cc.setOnClickListener(this);
		btn_dd.setOnClickListener(this);
		btn_ee.setOnClickListener(this);
		btn_ff.setOnClickListener(this);
		btn_gg.setOnClickListener(this);
		btn_hh.setOnClickListener(this);
		btn_ii.setOnClickListener(this);
		btn_jj.setOnClickListener(this);
		btn_kk.setOnClickListener(this);
		btn_ll.setOnClickListener(this);
		btn_mm.setOnClickListener(this);
		btn_nn.setOnClickListener(this);
		btn_oo.setOnClickListener(this);
		btn_pp.setOnClickListener(this);
		btn_qq.setOnClickListener(this);
		btn_rr.setOnClickListener(this);
		btn_ss.setOnClickListener(this);
		btn_tt.setOnClickListener(this);
		btn_uu.setOnClickListener(this);
		btn_vv.setOnClickListener(this);
		btn_ww.setOnClickListener(this);
		btn_xx.setOnClickListener(this);
		btn_yy.setOnClickListener(this);
		btn_zz.setOnClickListener(this);

		btn_aaa.setOnClickListener(this);
		btn_bbb.setOnClickListener(this);
		
		_rybColorMap.put(Color.TRANSPARENT, new RybColorSmartCode(0, 0, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_blue),
				new RybColorSmartCode(0, 0, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_bluegreen),
				new RybColorSmartCode(0, 1, 2));
		_rybColorMap.put(getResources().getColor(R.color.color_blueviolet),
				new RybColorSmartCode(1, 0, 2));
		_rybColorMap.put(getResources().getColor(R.color.color_green),
				new RybColorSmartCode(0, 1, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_grey),
				new RybColorSmartCode(1, 1, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_orange),
				new RybColorSmartCode(1, 1, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_red),
				new RybColorSmartCode(1, 0, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_redorange),
				new RybColorSmartCode(2, 1, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_redviolet),
				new RybColorSmartCode(2, 0, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_violet),
				new RybColorSmartCode(1, 0, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_white),
				new RybColorSmartCode(0, 0, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_yellow),
				new RybColorSmartCode(0, 1, 0));
		_rybColorMap.put(getResources().getColor(R.color.color_yellowgreen),
				new RybColorSmartCode(0, 2, 1));
		_rybColorMap.put(getResources().getColor(R.color.color_yelloworange),
				new RybColorSmartCode(1, 2, 0));
		initializeCanvas();          

	}                      

	private void initializeCanvas()
	{
		// TODO Auto-generated method stub

		BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
		Bitmap bmp = drawable.getBitmap();
		try 
		{
			_alteredBitmap = Bitmap.createBitmap(bmp.getWidth(),
					bmp.getHeight(), Bitmap.Config.ARGB_8888);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		Canvas canvas = new Canvas(_alteredBitmap);
		Paint paint = new Paint();
		Matrix matrix = new Matrix();
		canvas.drawBitmap(bmp, matrix, paint);

		img.setImageBitmap(_alteredBitmap);
		img.setOnTouchListener(this);
	}

	Handler hRefresh = new Handler() 
	{
		public void handleMessage(Message msg) 
		{
			switch (msg.what) 
			{
			case REFRESH_SCREEN:
				save();
				wall();
				// To go back to the first view, use switcher.showPrevious()
				break;
			case 2:
				save();
				break;
			case 3:
				if (count == 1) 
				{
					if (color != mColor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,mColor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}
				}

				if (aa == 1) 
				{
					int newcolor = 0xffff0000;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}
				} 
				else if (aa == 2) 
				{
					int newcolor = 0xffC30BEA;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}

				} 
				else if (aa == 3)
				{
					int newcolor = 0xffffff00;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}

				} 
				else if (aa == 4) 
				{
					int newcolor = 0xFFFF1493;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}

				} else if (aa == 5) 
				{
					int newcolor = 0xff5CB3FF;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}

				} 
				else if (aa == 6) 
				{
					int newcolor = 0xFFEA0BC2;
					if (color != newcolor) 
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}
				} 
				else if (aa == 7)
				{
					int newcolor = 0xFF8B4513;
					if (color != newcolor)
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}
				} 
				
				else if(aa==9)
				{
					if(color!= c2)
					{
						FloodFill floodfill=new FloodFill(bitmap, color, c2);
						floodfill.fill(originalImageOffsetX, originalImageOffsetY);
						img.invalidate();
					}
				}
				
				else if (aa == 8) 
				{
					int newcolor = 0xffffffff;
					if (color != newcolor)
					{
						FloodFill floodfill = new FloodFill(bitmap, color,newcolor);
						floodfill.fill(originalImageOffsetX,originalImageOffsetY);
						img.invalidate();
					}

				}
				break;
			default:
				break;
			}
		}
	};

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		ImageView view = (ImageView) img;
		dumpEvent(event);
		int action = event.getAction() & MotionEvent.ACTION_MASK;

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			img = (ImageView) findViewById(R.id.imageView1);
			BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
			bitmap = drawable.getBitmap();
			Rect imageBounds = new Rect();
			img.getDrawingRect(imageBounds);

			// original height and width of the bitmap
			int intrinsicHeight = drawable.getIntrinsicHeight();
			int intrinsicWidth = drawable.getIntrinsicWidth();

			// height and width of the visible (scaled) image
			int scaledHeight = imageBounds.height();
			int scaledWidth = imageBounds.width();

			// Find the ratio of the original image to the scaled image
			// Should normally be equal unless a disproportionate scaling
			// (e.g. fitXY) is used.
			float heightRatio = (float) intrinsicHeight / scaledHeight;
			float widthRatio = (float) intrinsicWidth / scaledWidth;

			// do whatever magic to get your touch point
			// MotionEvent event;

			// get the distance from the left and top of the image bounds
			float scaledImageOffsetX = event.getX() - imageBounds.left;
			float scaledImageOffsetY = event.getY() - imageBounds.top;

			// scale these distances according to the ratio of your scaling
			// For example, if the original image is 1.5x the size of the scaled
			// image, and your offset is (10, 20), your original image offset
			// values should be (15, 30).
			originalImageOffsetX = Math.round(scaledImageOffsetX * widthRatio);
			originalImageOffsetY = Math.round(scaledImageOffsetY * heightRatio);

			try {
				color = bitmap.getPixel(originalImageOffsetX,
						originalImageOffsetY);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 savedMatrix.set(matrix);
			   start.set(event.getX(), event.getY());
			   mode = DRAG;
			hRefresh.sendEmptyMessage(3);

		
			break;
		 case MotionEvent.ACTION_POINTER_DOWN:
			   oldDist = spacing(event);
			   if (oldDist > 10f) {
			    savedMatrix.set(matrix);
			    midPoint(mid, event);
			    mode = ZOOM;
			   }
			   break;
			  case MotionEvent.ACTION_UP:
			  case MotionEvent.ACTION_POINTER_UP:
			   mode = NONE;
			   break;
			  case MotionEvent.ACTION_MOVE:
			   if (mode == DRAG) {
			    // ...    
			    matrix.set(savedMatrix);
			    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);    
			   } else if (mode == ZOOM) {
			    float newDist = spacing(event);
			    if (newDist > 10f) {
			     matrix.set(savedMatrix);
			     float scale = newDist / oldDist;
			     matrix.postScale(scale, scale, mid.x, mid.y);
			    }
			   }
			   break;
		default:
			break;
		}
		view.setImageMatrix(matrix);
		return true;
	}

	
	 private void dumpEvent(MotionEvent event) {
		  String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE",
		    "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
		  StringBuilder sb = new StringBuilder();
		  int action = event.getAction();
		  int actionCode = action & MotionEvent.ACTION_MASK;
		  sb.append("event ACTION_").append(names[actionCode]);
		  if (actionCode == MotionEvent.ACTION_POINTER_DOWN
		    || actionCode == MotionEvent.ACTION_POINTER_UP) {
		   sb.append("(pid ").append(
		     action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
		   sb.append(")");
		  }
		  sb.append("[");
		  for (int i = 0; i < event.getPointerCount(); i++) {
		   sb.append("#").append(i);
		   sb.append("(pid ").append(event.getPointerId(i));
		   sb.append(")=").append((int) event.getX(i));
		   sb.append(",").append((int) event.getY(i));
		   if (i + 1 < event.getPointerCount())
		    sb.append(";");
		  }
		  sb.append("]");
		 }

		 /** Determine the space between the first two fingers */
		 private float spacing(MotionEvent event) {
		  float x = event.getX(0) - event.getX(1);
		  float y = event.getY(0) - event.getY(1);
		  return FloatMath.sqrt(x * x + y * y);
		 }

		 /** Calculate the mid point of the first two fingers */
		 private void midPoint(PointF point, MotionEvent event) {
		  float x = event.getX(0) + event.getX(1);
		  float y = event.getY(0) + event.getY(1);
		  point.set(x / 2, y / 2);
		 }
	
	
	protected final void mixColors(final RybColorSmartCode currentColorRybCode) {
		RadioGroup rg = (RadioGroup) findViewById(R.id.rg_colors);
		int checkedButtonId = rg.getCheckedRadioButtonId();

		switch (checkedButtonId) {
		case R.id.btn_red:
			currentColorRybCode.reset();
			currentColorRybCode.setR(currentColorRybCode.getR() + 1);

			break;
		case R.id.btn_yellow:
			currentColorRybCode.reset();
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			break;
		// case R.id.btn_blue:
		// currentColorRybCode.setB(currentColorRybCode.getB() + 1);
		// break;
		case R.id.btn_green:
			currentColorRybCode.reset();
			currentColorRybCode.setB(currentColorRybCode.getB() + 1);
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			break;
		case R.id.btn_orange:
			currentColorRybCode.reset();
			currentColorRybCode.setR(currentColorRybCode.getR() + 1);
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			break;
		/*
		 * case R.id.btn_pink: currentColorRybCode.reset();
		 * currentColorRybCode.setR(currentColorRybCode.getR() + 1);
		 * currentColorRybCode.setB(currentColorRybCode.getB() + 1); break;
		 */
		case R.id.btn_purple:
			currentColorRybCode.reset();
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			currentColorRybCode.setB(currentColorRybCode.getB() + 1);
			currentColorRybCode.setB(currentColorRybCode.getB() + 1);
			break;
	/*	case R.id.btn_brown:
			currentColorRybCode.reset();
			currentColorRybCode.setR(currentColorRybCode.getR() + 1);
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			currentColorRybCode.setY(currentColorRybCode.getY() + 1);
			break;     */
		case R.id.btn_black:
			currentColorRybCode.reset();
			break;
		case R.id.btn_white:
			currentColorRybCode.reset();

			break;
	
		default:
			break;
		}
	}

	protected final int rybToArgb(final RybColorSmartCode rybCode) {
		int resid = _rybColorCube[rybCode.getR()][rybCode.getY()][rybCode
				.getB()];
		int argb = getResources().getColor(resid);
		return argb;
	}

	private void unbindDrawables(View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawables(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if(checking)
		{
			SoundManager.instance().startBackgroundMusic();	
		}

		super.onResume();    
      		

	}


	public void save() {
		Bitmap bitmap;
		ImageView i = (ImageView) findViewById(R.id.imageView1);
		i.setScaleType(ScaleType.FIT_XY);
		layMain.setVisibility(View.INVISIBLE);
			OffSound.setVisibility(View.INVISIBLE);
			hey.setVisibility(View.INVISIBLE);
		mPath = Environment.getExternalStorageDirectory().toString();
		
		View v1 = i.getRootView();
		v1.setDrawingCacheEnabled(true);
		bitmap = Bitmap.createBitmap(v1.getDrawingCache());
		v1.setDrawingCacheEnabled(false);

		OutputStream fout = null;
		directory = new File(mPath, "spideywoman");
		Log.d("path", mPath);
		Log.d("dir", directory.toString());
		
		directory.mkdirs();
		Calendar c = Calendar.getInstance();                            

		try {

			imageFile = new File(directory, "spideywoman" + "_" + getDate()
					+ ".jpg");
			Log.d("nee", imageFile.toString());
			fout = new FileOutputStream(imageFile);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
		rl.setVisibility(View.VISIBLE);   
		layMain=(LinearLayout) findViewById(R.id.layMain);
		layMain.setVisibility(View.VISIBLE);
		rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
		rl2.setVisibility(View.VISIBLE);
		hey.setVisibility(View.VISIBLE);
		OffSound.setVisibility(View.VISIBLE);
		Toast.makeText(getApplicationContext(), "'Image saved to Gallery'",
				Toast.LENGTH_SHORT).show();
		sendBroadcast(new Intent(
				Intent.ACTION_MEDIA_MOUNTED,
				Uri.parse("file://" + Environment.getExternalStorageDirectory())));      
	}

	private String getDate() {
		// TODO Auto-generated method stub  
		dt = dateFormat.format(new Date());
		return dt;
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// return super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.m, menu);
		return true;
	}
*/
/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{      
		// TODO Auto-generated method stub
		switch (item.getItemId()) 
		{
		case R.id.save:
			rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);
			
			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try {
						// This is just a tmp sleep so that we can emulate
						// something loading
						Thread.sleep(1000);
						// Use this handler so than you can update the UI from a
						// thread
						hRefresh.sendEmptyMessage(2);
					} catch (Exception e) {
					}
				}
			}.start();
			return true;

		//	Intent save=new Intent();
		//	save.setClass(getApplicationContext(), Save.class);
		//	startActivity(save);
		case R.id.share:

			rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);

			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try {
						// This is just a tmp sleep so that we can emulate
						// something loading
						Thread.sleep(1000);
						// Use this handler so than you can update the UI from a
						// thread
						hRefresh.sendEmptyMessage(2);
						Intent shareCaptionIntent = new Intent(
								Intent.ACTION_SEND);
						shareCaptionIntent.setType("image/*");

						// set photo  
						// shareCaptionIntent.setData(Uri.parse("file://"
						// + directoryEntriesPath.get(position)));
						shareCaptionIntent.putExtra(
								Intent.EXTRA_STREAM,
								Uri.parse("file://" + "/mnt/sdcard/princess/"
										+ "princess" + "_" + getDate() + ".jpg"));

						// set caption
						shareCaptionIntent.putExtra(Intent.EXTRA_TEXT,
								"Hope you like it");
						shareCaptionIntent.putExtra(Intent.EXTRA_SUBJECT,
								"princess Pic");

						startActivity(Intent.createChooser(shareCaptionIntent,
								"see my pic"));
					
						} catch (Exception e) {
								}
				}
			}.start();

			return true;

		case R.id.wall:
			rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);

			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try
					{
						// This is just a tmp sleep so that we can emulate
					
						Thread.sleep(1000);
						// Use this handler so than you can update the UI from a
						// thread
						hRefresh.sendEmptyMessage(REFRESH_SCREEN);
					} catch (Exception e) 
					{
					}
				}
			}.start();

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
*/
	public void wall() {

		Toast.makeText(getApplicationContext(), "'Wallpaper has been Set'",
				Toast.LENGTH_SHORT).show();
		try {
			getApplicationContext().setWallpaper(putOverlay());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public Bitmap putOverlay()
     {
	
   WindowManager wm = (WindowManager) getApplicationContext()
			.getSystemService(Context.WINDOW_SERVICE);
	Display display = wm.getDefaultDisplay();
	// Point size = new Point();
	// display.getSize(size);
	int width = display.getWidth();
	int height = display.getHeight();
	
	DisplayMetrics displayMetrics = new DisplayMetrics();
	((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);               

	int statusBarHeight;

	switch (displayMetrics.densityDpi) {
	    case DisplayMetrics.DENSITY_HIGH:
	        statusBarHeight = HIGH_DPI_STATUS_BAR_HEIGHT;
	        break;
	    case DisplayMetrics.DENSITY_MEDIUM:
	        statusBarHeight = MEDIUM_DPI_STATUS_BAR_HEIGHT;
	        break;
	    case DisplayMetrics.DENSITY_LOW:
	        statusBarHeight = LOW_DPI_STATUS_BAR_HEIGHT;
	        break;
	    default:
	        statusBarHeight = MEDIUM_DPI_STATUS_BAR_HEIGHT;    
	}
	Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(     
			getResources(), R.drawable.img_1), 2*width, height, true);
	
	height = height - statusBarHeight;
	
	Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeFile("/mnt/sdcard/spideywoman/"+ "spideywoman" + "_" + dt + ".jpg"), width, height, false);

  Canvas canvas = new Canvas(bmp);
 canvas.drawColor(Color.RED); 
  canvas.drawBitmap(bitmap, 0, statusBarHeight, new Paint(Color.WHITE));  
  canvas.drawBitmap(bitmap, width, statusBarHeight, new Paint(Color.WHITE)); 
  return bmp;    
} 
	


	    protected Dialog onCreateDialog(int id) 
	    {
	        // TODO Auto-generated method stub
	        //step 1:Load custom dialog layout
	        LayoutInflater myInflater = LayoutInflater.from(getBaseContext());
	        View myView = myInflater.inflate(R.layout.color_picker, null);
	      
	      
	        GridView gridViewColors = (GridView) myView.findViewById(R.id.gridViewColors);
	        //step 2: Set self-defined ImageAdaper to our gridview
	        gridViewColors.setAdapter(new ColorPickerAdapter(getApplicationContext()));
	       
	        //step 3: Set up the behavior when user touches an item in the grid
	        gridViewColors.setOnItemClickListener(new GridView.OnItemClickListener(){

	            public void onItemClick(AdapterView<?> parent, View v,int position, long id)
	            {
	              
	            	rb.setSelected(false);
	            	rb1.setSelected(false);
	            	rb2.setSelected(false);
	            	rb3.setSelected(false);
	            	rb4.setSelected(false);
	            	rb5.setSelected(false);
	            	
	            	String color=((ColorPickerAdapter) parent.getAdapter()).getItem(position);
	            /*	int col1=Color.parseColor(color);
					String c=color.toString();
					Integer c1=Integer.valueOf(c);
					int c2=Integer.parseInt(c);
					
					int col=Integer.parseInt(color,16);
					Toast.makeText(getBaseContext(), "You selected" +color ,Toast.LENGTH_LONG).show();
					
					Intent i=new Intent(getApplicationContext(),ColorCindrellaActivity.class);
					i.putExtra("val", color);
					startActivity(i);
					
	            	
	            	int col1=Color.parseColor(color);*/
					String hash="#";
					String col=hash+color;
					
					//int cc=Integer.parseInt( (color,16)+0xff000000);
				/*	int col1=Integer.parseInt(col.replaceFirst("#", ""), 16);
					int color1 = Integer.parseInt(col.replaceFirst("^#",""), 16);
					*/
//sdasaf
					 c2=Color.parseColor(col);
				//	Toast.makeText(getApplicationContext(), "You selected" +col+c2, Toast.LENGTH_LONG).show();
						
					rb7=(RadioButton) findViewById(R.id.btn_black);
					rb7.setVisibility(View.GONE);
					
					
				
					count = 0;      
					aa = 9;
				//	btnColor.setVisibility(View.VISIBLE);
					
				System.out.println("POS: "+position);
				switch(position)
				{
				case 0:
				{	btn_a.setVisibility(View.VISIBLE);
					btn_a.setSelected(true);
					btn_b.setVisibility(View.GONE);
					btn_c.setVisibility(View.GONE);
					btn_d.setVisibility(View.GONE);
					btn_e.setVisibility(View.GONE);
					btn_f.setVisibility(View.GONE);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
					
				}
					break;
				case 1:
				{	btn_a.setVisibility(View.GONE);
					btn_b.setVisibility(View.VISIBLE);
					btn_b.setSelected(true);
					btn_c.setVisibility(View.GONE);
					btn_d.setVisibility(View.GONE);
					btn_e.setVisibility(View.GONE);
					btn_f.setVisibility(View.GONE);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
				
				}	
					break;
				case 2:
				{	btn_a.setVisibility(View.GONE);
					btn_b.setVisibility(View.GONE);
					btn_c.setVisibility(View.VISIBLE);
					btn_c.setSelected(true);
					btn_d.setVisibility(View.GONE);
					btn_e.setVisibility(View.GONE);
					btn_f.setVisibility(View.GONE);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
				
				}	break;
				case 3:
				{	btn_a.setVisibility(View.GONE);
					btn_b.setVisibility(View.GONE);
					btn_c.setVisibility(View.GONE);
					btn_d.setVisibility(View.VISIBLE);
					btn_d.setSelected(true);
					btn_e.setVisibility(View.GONE);
					btn_f.setVisibility(View.GONE);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
				
				}	break;
				case 4:
				{	btn_a.setVisibility(View.GONE);
					btn_b.setVisibility(View.GONE);
					btn_c.setVisibility(View.GONE);
					btn_d.setVisibility(View.GONE);
					btn_e.setVisibility(View.VISIBLE);
					btn_e.setSelected(true);
					btn_f.setVisibility(View.GONE);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
				
				}	break;
				case 5:
				{	
					btn_a.setVisibility(View.GONE);
					btn_b.setVisibility(View.GONE);
					btn_c.setVisibility(View.GONE);
					btn_d.setVisibility(View.GONE);
					btn_e.setVisibility(View.GONE);
					btn_f.setVisibility(View.VISIBLE);
					btn_f.setSelected(true);
					btn_g.setVisibility(View.GONE);
					btn_h.setVisibility(View.GONE);
					btn_i.setVisibility(View.GONE);
					btn_j.setVisibility(View.GONE);
					btn_k.setVisibility(View.GONE);
					btn_l.setVisibility(View.GONE);
					btn_m.setVisibility(View.GONE);
					btn_n.setVisibility(View.GONE);
					btn_o.setVisibility(View.GONE);
					btn_p.setVisibility(View.GONE);
					btn_q.setVisibility(View.GONE);
					btn_r.setVisibility(View.GONE);
					btn_s.setVisibility(View.GONE);
					btn_t.setVisibility(View.GONE);
					btn_u.setVisibility(View.GONE);
					btn_v.setVisibility(View.GONE);
					btn_w.setVisibility(View.GONE);
					btn_x.setVisibility(View.GONE);
					btn_y.setVisibility(View.GONE);
					btn_z.setVisibility(View.GONE);
					btn_aa.setVisibility(View.GONE);
					btn_bb.setVisibility(View.GONE);
					btn_cc.setVisibility(View.GONE);
					btn_dd.setVisibility(View.GONE);
					btn_ee.setVisibility(View.GONE);
					btn_ff.setVisibility(View.GONE);
					btn_gg.setVisibility(View.GONE);
					btn_hh.setVisibility(View.GONE);
					btn_ii.setVisibility(View.GONE);
					btn_jj.setVisibility(View.GONE);
					btn_kk.setVisibility(View.GONE);
					btn_ll.setVisibility(View.GONE);
					btn_mm.setVisibility(View.GONE);
					btn_nn.setVisibility(View.GONE);
					btn_oo.setVisibility(View.GONE);
					btn_pp.setVisibility(View.GONE);
					btn_qq.setVisibility(View.GONE);
					btn_rr.setVisibility(View.GONE);
					btn_ss.setVisibility(View.GONE);
					btn_tt.setVisibility(View.GONE);
					btn_uu.setVisibility(View.GONE);
					btn_vv.setVisibility(View.GONE);
					btn_ww.setVisibility(View.GONE);
					btn_xx.setVisibility(View.GONE);
					btn_yy.setVisibility(View.GONE);
					btn_zz.setVisibility(View.GONE);
					btn_aaa.setVisibility(View.GONE);
					btn_bbb.setVisibility(View.GONE);
				
				}	break;
				case 6:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.VISIBLE);
				btn_g.setSelected(true);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;

				case 7:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.VISIBLE);
				btn_h.setSelected(true);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;

				case 8:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.VISIBLE);
				btn_i.setSelected(true);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;

				case 9:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.VISIBLE);
				btn_j.setSelected(true);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 10:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.VISIBLE);
				btn_k.setSelected(true);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 11:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.VISIBLE);
				btn_l.setSelected(true);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 12:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.VISIBLE);
				btn_m.setSelected(true);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 13:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.VISIBLE);
				btn_n.setSelected(true);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 14:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.VISIBLE);
				btn_o.setSelected(true);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 15:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.VISIBLE);
				btn_p.setSelected(true);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 16:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.VISIBLE);
				btn_q.setSelected(true);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 17:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.VISIBLE);
				btn_r.setSelected(true);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 18:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.VISIBLE);
				btn_s.setSelected(true);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 19:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.VISIBLE);
				btn_t.setSelected(true);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 20:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.VISIBLE);
				btn_u.setSelected(true);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 21:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.VISIBLE);
				btn_v.setSelected(true);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 22:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.VISIBLE);
				btn_w.setSelected(true);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 23:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.VISIBLE);
				btn_x.setSelected(true);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;


				case 24:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.VISIBLE);
				btn_y.setSelected(true);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;

				case 25:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.VISIBLE);
				btn_z.setSelected(true);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			
			}break;
			
				case 26:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);

				btn_aa.setSelected(true);
				btn_aa.setVisibility(View.VISIBLE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 27:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.VISIBLE);
				btn_bb.setSelected(true);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 28:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.VISIBLE);
				btn_cc.setSelected(true);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 29:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.VISIBLE);
				btn_dd.setSelected(true);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 30:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.VISIBLE);
				btn_ee.setSelected(true);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 31:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.VISIBLE);
				btn_ff.setSelected(true);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 32:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.VISIBLE);
				btn_gg.setSelected(true);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 33:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.VISIBLE);
				btn_hh.setSelected(true);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 34:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.VISIBLE);
				btn_ii.setSelected(true);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 35:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.VISIBLE);
				btn_jj.setSelected(true);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 36:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.VISIBLE);
				btn_kk.setSelected(true);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 37:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.VISIBLE);
				btn_ll.setSelected(true);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 38:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.VISIBLE);
				btn_mm.setSelected(true);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 39:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.VISIBLE);
				btn_nn.setSelected(true);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 40:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.VISIBLE);
				btn_oo.setSelected(true);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 41:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.VISIBLE);
				btn_pp.setSelected(true);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 42:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.VISIBLE);
				btn_qq.setSelected(true);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 43:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.VISIBLE);
				btn_rr.setSelected(true);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;

				case 44:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setSelected(true);
				btn_ss.setVisibility(View.VISIBLE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 45:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setSelected(true);
				btn_tt.setVisibility(View.VISIBLE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 46:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.VISIBLE);
				btn_uu.setSelected(true);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 47:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.VISIBLE);
				btn_vv.setSelected(true);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 48:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.VISIBLE);
				btn_ww.setSelected(true);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 49:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.VISIBLE);
				btn_xx.setSelected(true);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 50:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.VISIBLE);
				btn_yy.setSelected(true);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 51:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.VISIBLE);
				btn_zz.setSelected(true);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 52:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.VISIBLE);
				btn_aaa.setSelected(true);
				btn_bbb.setVisibility(View.GONE);
			} break;
				case 53:
				{btn_a.setVisibility(View.GONE);
				btn_b.setVisibility(View.GONE);
				btn_c.setVisibility(View.GONE);
				btn_d.setVisibility(View.GONE);
				btn_e.setVisibility(View.GONE);
				btn_f.setVisibility(View.GONE);
				btn_g.setVisibility(View.GONE);
				btn_h.setVisibility(View.GONE);
				btn_i.setVisibility(View.GONE);
				btn_j.setVisibility(View.GONE);
				btn_k.setVisibility(View.GONE);
				btn_l.setVisibility(View.GONE);
				btn_m.setVisibility(View.GONE);
				btn_n.setVisibility(View.GONE);
				btn_o.setVisibility(View.GONE);
				btn_p.setVisibility(View.GONE);
				btn_q.setVisibility(View.GONE);
				btn_r.setVisibility(View.GONE);
				btn_s.setVisibility(View.GONE);
				btn_t.setVisibility(View.GONE);
				btn_u.setVisibility(View.GONE);
				btn_v.setVisibility(View.GONE);
				btn_w.setVisibility(View.GONE);
				btn_x.setVisibility(View.GONE);
				btn_y.setVisibility(View.GONE);
				btn_z.setVisibility(View.GONE);
				btn_aa.setVisibility(View.GONE);
				btn_bb.setVisibility(View.GONE);
				btn_cc.setVisibility(View.GONE);
				btn_dd.setVisibility(View.GONE);
				btn_ee.setVisibility(View.GONE);
				btn_ff.setVisibility(View.GONE);
				btn_gg.setVisibility(View.GONE);
				btn_hh.setVisibility(View.GONE);
				btn_ii.setVisibility(View.GONE);
				btn_jj.setVisibility(View.GONE);
				btn_kk.setVisibility(View.GONE);
				btn_ll.setVisibility(View.GONE);
				btn_mm.setVisibility(View.GONE);
				btn_nn.setVisibility(View.GONE);
				btn_oo.setVisibility(View.GONE);
				btn_pp.setVisibility(View.GONE);
				btn_qq.setVisibility(View.GONE);
				btn_rr.setVisibility(View.GONE);
				btn_ss.setVisibility(View.GONE);
				btn_tt.setVisibility(View.GONE);
				btn_uu.setVisibility(View.GONE);
				btn_vv.setVisibility(View.GONE);
				btn_ww.setVisibility(View.GONE);
				btn_xx.setVisibility(View.GONE);
				btn_yy.setVisibility(View.GONE);
				btn_zz.setVisibility(View.GONE);
				btn_aaa.setVisibility(View.GONE);
				btn_bbb.setVisibility(View.VISIBLE);
				btn_bbb.setSelected(true);
			} break;

				}

//btnColor.setButtonDrawable(cols[position]);
//**btnColor.setBackgroundResource(cols[position]);
				//	btnColor.setBackgroundColor(Color.parseColor(col));
				//	btnColor.setButtonDrawable(R.drawable.cir1);
					dialog.dismiss();
	            }
	          
	        });
	      
	        //step 4: Set the custom view to the AlertDialog      
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setTitle("choose a color");
	        builder.setView(myView);
	      
	        dialog = builder.create();
	      
	        return dialog;
	    }
	  
	  
	@SuppressWarnings("deprecation")
	public void onClick(View v) 
	{
		
		if(v.getId()==R.id.btnNew||v.getId()==R.id.btnNew1)
		{
			if(my_layout.getVisibility()==View.INVISIBLE){
				my_layout.setVisibility(View.VISIBLE);
			}
			else
			{
				my_layout.setVisibility(View.INVISIBLE);
			}
		}
		
		
		if(v.getId()==R.id.imageView_first)
		{
			img.setImageResource(R.drawable.logo4);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		if(v.getId()==R.id.imageView_sec)
		{
			img.setImageResource(R.drawable.spideywoman);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}if(v.getId()==R.id.imageView_thi)
		{
			img.setImageResource(R.drawable.spidy);   
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		if(v.getId()==R.id.imageView_four)
		{
			img.setImageResource(R.drawable.spidygirl);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		if(v.getId()==R.id.imageView_five)
		{
			img.setImageResource(R.drawable.spidygirl1);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		if(v.getId()==R.id.imageView_six)
		{
			img.setImageResource(R.drawable.spidygirl2);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		
		if(v.getId()==R.id.imageView_saven)
		{
			img.setImageResource(R.drawable.spidygirl3);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		if(v.getId()==R.id.imageView_eight)
		{
			img.setImageResource(R.drawable.spidygirl4);
			my_layout.setVisibility(View.INVISIBLE);
			initializeCanvas();
		}
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btn_pink)
		{
			
			showDialog(CATEGORY_ID);
	//	new UberColorPickerDialog(this, this, mColor, false).show();
	//	count = 1;
	//	aa = 0;
			//Dialog dialog;
		//	dialog = new ColorPickerDialog(ColorCindrellaActivity.this);
		//	dialog.show();
			
		//	Intent i=new Intent(getApplicationContext(),ColorPickerDialog.class);
		//	startActivity(i);
			/*if(p!=null)
			{
				showPopup(ColorCindrellaActivity.this,p);
			}*/
	}
		
		if(v.getId()==R.id.btnshow)
		{
			if(key==0)
			{
				key=1;
				popup.setVisibility(View.VISIBLE);
				btnShow.setBackgroundResource(R.drawable.arrow_close);
			}
			else if(key==1)
			{
				key=0;
				popup.setVisibility(View.GONE);
				btnShow.setBackgroundResource(R.drawable.arrow_open);
				my_layout.setVisibility(View.INVISIBLE);
			}
		}
		
		
		if(v.getId()==R.id.btn_a)
		{
			btn_a.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}
		if(v.getId()==R.id.btn_b)
		{
			btn_b.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_c)
		{
			btn_c.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_d)
		{
			btn_d.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_e)
		{
			btn_e.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_f)
		{
			btn_f.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_g)
		{
			btn_g.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_h)
		{
			btn_h.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_i)
		{
			btn_i.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_j)
		{
			btn_j.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_k)
		{
			btn_k.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_l)
		{
			btn_l.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_m)
		{
			btn_m.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_n)
		{
			btn_n.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_o)
		{
			btn_o.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_p)
		{
			btn_p.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_q)
		{
			btn_q.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_r)
		{
			btn_r.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_s)
		{
			btn_s.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_t)
		{
			btn_t.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_u)
		{
			btn_u.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_v)
		{
			btn_v.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_w)
		{
			btn_w.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_x)
		{
			btn_x.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_y)
		{
			btn_y.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_z)
		{
			btn_z.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_aa)
		{
			btn_aa.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_bb)
		{
			btn_bb.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_cc)
		{
			btn_cc.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_dd)
		{
			btn_dd.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ee)
		{
			btn_ee.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ff)
		{
			btn_ff.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_gg)
		{
			btn_gg.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_hh)
		{
			btn_hh.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ii)
		{
			btn_ii.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_jj)
		{
			btn_jj.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_kk)
		{
			btn_kk.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ll)
		{
			btn_ll.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_mm)
		{
			btn_mm.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_nn)
		{
			btn_nn.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_oo)
		{
			btn_oo.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_pp)
		{
			btn_pp.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_qq)
		{
			btn_qq.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_rr)
		{
			btn_rr.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ss)
		{
			btn_ss.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_tt)
		{
			btn_tt.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_uu)
		{
			btn_uu.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_vv)
		{
			btn_vv.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_ww)
		{
			btn_ww.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_xx)
		{
			btn_xx.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_yy)
		{
			btn_yy.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_zz)
		{
			btn_zz.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_aaa)
		{
			btn_aaa.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}	if(v.getId()==R.id.btn_bbb)
		{
			btn_bbb.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
		//btnColor.setSelected(true);
			count=0;
			aa=9;
		}
		
		if(v.getId()==R.id.btn_black)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb7.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);      
			//rb6.setSelected(false);
			count = 0;      
			aa = 8;
		}
		
		if(v.getId()==R.id.btn_green)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb5.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			//rb6.setSelected(false);
			rb7.setSelected(false);
			count = 0;
			aa = 6;
		}
		
		if(v.getId()==R.id.btn_orange)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb1.setSelected(true);
			rb.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);
			//rb6.setSelected(false);
			rb7.setSelected(false);
			count = 0;
			aa = 2;
		}
		
		if(v.getId()==R.id.btn_purple)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb4.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb5.setSelected(false);
			//rb6.setSelected(false);
			rb7.setSelected(false);
			count = 0;
			aa = 5;
		}
		
		if(v.getId()==R.id.btn_red)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb.setSelected(true);
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);
		//	rb6.setSelected(false);
			rb7.setSelected(false);
			count = 0;
			aa = 1;
		}
		
		
		if(v.getId()==R.id.btn_yellow)
		{
			btn_a.setSelected(false);btn_b.setSelected(false);	btn_c.setSelected(false);btn_d.setSelected(false);btn_e.setSelected(false);btn_f.setSelected(false);btn_g.setSelected(false);btn_h.setSelected(false);	btn_i.setSelected(false);
			btn_j.setSelected(false);btn_k.setSelected(false);btn_l.setSelected(false);	btn_m.setSelected(false);btn_n.setSelected(false);
			btn_o.setSelected(false);btn_p.setSelected(false);btn_q.setSelected(false);btn_r.setSelected(false);btn_s.setSelected(false);
			btn_t.setSelected(false);btn_u.setSelected(false);btn_v.setSelected(false);btn_w.setSelected(false);btn_x.setSelected(false);
			btn_y.setSelected(false);btn_z.setSelected(false);btn_aa.setSelected(false);btn_bb.setSelected(false);btn_cc.setSelected(false);
			btn_dd.setSelected(false);btn_ee.setSelected(false);btn_ff.setSelected(false);btn_gg.setSelected(false);btn_hh.setSelected(false);
			btn_ii.setSelected(false);btn_jj.setSelected(false);btn_kk.setSelected(false);btn_ll.setSelected(false);btn_mm.setSelected(false);
			btn_nn.setSelected(false);btn_oo.setSelected(false);btn_pp.setSelected(false);btn_qq.setSelected(false);btn_rr.setSelected(false);
			btn_ss.setSelected(false);btn_tt.setSelected(false);btn_uu.setSelected(false);btn_vv.setSelected(false);btn_ww.setSelected(false);
			btn_xx.setSelected(false);btn_yy.setSelected(false);btn_zz.setSelected(false);btn_aaa.setSelected(false);btn_bbb.setSelected(false);

			rb2.setSelected(true);
			rb.setSelected(false);
			rb1.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);
			//rb6.setSelected(false);
			rb7.setSelected(false);
			count = 0;
			aa = 3;
		}
		
		if(v.getId()==R.id.btnSave||v.getId()==R.id.btnSave1)
		{
			
			
		          
		                        // TODO Auto-generated method stub
		                        final ProgressDialog myPd_ring=ProgressDialog.show(ColorActivity.this, "", "Loading please wait..", true);
		                        myPd_ring.setCancelable(true);
		                        new Thread(new Runnable() {  
		                              public void run() {
		                                    // TODO Auto-generated method stub
		                                    try
		                                    {
		                                          Thread.sleep(5000);
		                                    }catch(Exception e){}
		                                    myPd_ring.dismiss();
		                              }
		                        }).start();                                          
		                  
		            
		        
			rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);

			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			
			OffSound=(ImageView) findViewById(R.id.OffSound);
			OffSound.setVisibility(View.GONE);
			
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try 
					{
					// This is just a tmp sleep so that we can emulate
					// something loading
					Thread.sleep(1000);
					// Use this handler so than you can update the UI from a
					// thread
					hRefresh.sendEmptyMessage(2);
					} catch (Exception e) {
										}
				}
			}.start();
			//	return true;
		}
		
		if(v.getId()==R.id.btnShare||v.getId()==R.id.btnShare1)
		{
			 // TODO Auto-generated method stub
            final ProgressDialog myPd_ring=ProgressDialog.show(ColorActivity.this, "", "Loading please wait..", true);
            myPd_ring.setCancelable(true);
            new Thread(new Runnable() {  
                  public void run() {
                        // TODO Auto-generated method stub
                        try
                        {
                              Thread.sleep(3000);
                        }catch(Exception e){}
                        myPd_ring.dismiss();
                  }
            }).start();  
			
            rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);

			
			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			OffSound = (ImageView) findViewById(R.id.OffSound);
			OffSound.setVisibility(View.GONE);
			
		/*	mPath = Environment.getExternalStorageDirectory().toString();
			directory = new File(mPath, "princess");
			Log.d("path", mPath);
			Log.d("dir", directory.toString());
			
			directory.mkdirs();

			imageFile = new File(directory, "princess" + "_" + getDate()+ ".jpg");*/
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try {
						// This is just a tmp sleep so that we can emulate
						// something loading
						Thread.sleep(1000);
						// Use this handler so than you can update the UI from a
						// thread
						hRefresh.sendEmptyMessage(2);
						Intent shareCaptionIntent = new Intent(Intent.ACTION_SEND);
						shareCaptionIntent.setType("image/*");

					//	File directory = new File(mPath, "princess");
					//	Log.d("path", mPath);
					//	Log.d("dir", directory.toString());
						
					//	String imageFile1=imageFile.toString();
						// set photo  
						// shareCaptionIntent.setData(Uri.parse("file://"
						// + directoryEntriesPath.get(position)));
						
						shareCaptionIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://" + "/mnt/sdcard/spideywoman/"+ "spideywoman" + "_" + getDate() + ".jpg"));

					//	shareCaptionIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://" + "/mnt/sdcard/princess/"+ imageFile));
						
					//	File pngFile=new File(directory,imageFile1);
					//	Uri pngUri=Uri.fromFile(pngFile);
					//	shareCaptionIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" +imageFile));
						
						// set caption
						shareCaptionIntent.putExtra(Intent.EXTRA_TEXT,"Hope you like it");
						shareCaptionIntent.putExtra(Intent.EXTRA_SUBJECT,"SpiderWoman Pic");

						startActivity(Intent.createChooser(shareCaptionIntent,"see my pic"));
					
						} catch (Exception e) {
								}
				}
			}.start();
		}
		
		if(v.getId()==R.id.btnWall||v.getId()==R.id.btnWall1)
		{		

            // TODO Auto-generated method stub
            final ProgressDialog myPd_ring=ProgressDialog.show(ColorActivity.this, "", "Loading please wait..", true);
            myPd_ring.setCancelable(true);
            new Thread(new Runnable() {  
                  public void run() {
                        // TODO Auto-generated method stub
                        try
                        {
                              Thread.sleep(5000);
                        }catch(Exception e){}
                        myPd_ring.dismiss();
                  }
            }).start();                     
            
            
			rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
			rl.setVisibility(View.GONE);

			layMain=(LinearLayout) findViewById(R.id.layMain);
			layMain.setVisibility(View.GONE);
			
			OffSound = (ImageView) findViewById(R.id.OffSound);
			OffSound.setVisibility(View.GONE);
			
			rl2 = (RelativeLayout) findViewById(R.id.relativeLayout4);
			rl2.setVisibility(View.GONE);
			new Thread() 
			{
				public void run() 
				{
					try
					{
					// This is just a tmp sleep so that we can emulate
				
					Thread.sleep(1000);
					// Use this handler so than you can update the UI from a
					// thread
					hRefresh.sendEmptyMessage(REFRESH_SCREEN);
					} catch (Exception e) 
					{
					}
			}
			}.start();
		}
		
		
		
		
		
	}

	
	public void colorChanged(int color) {      
		// TODO Auto-generated method stub
		mColor = color;
	}

	@Override
	public void onDismissScreen(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPresentScreen(Ad arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReceiveAd(Ad ad) {
		// TODO Auto-generated method stub
		 if (ad == interstitial) {
		      interstitial.show();
		      
		    }
	}
}