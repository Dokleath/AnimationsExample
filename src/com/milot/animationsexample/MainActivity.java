package com.milot.animationsexample;

import java.util.Random;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setContentView(R.layout.main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} 
		return super.onOptionsItemSelected(item);
	}
	
	public void startAnimation(View view) {
	    float vleraAnimacionit = 0;
	    ImageView aniView = (ImageView) findViewById(R.id.imgTitanfall);
	    switch (view.getId()) {

	    case R.id.btnRrotullo:
	      vleraAnimacionit = 360; // 360 se po dojme 360 shkalle me rrotullu
	      if (aniView.getRotation() == 360) {
	        vleraAnimacionit = 0; // e kthejme ne gjendje fillestare
	      }
	      ObjectAnimator animation1 = ObjectAnimator.ofFloat(aniView,
	          "rotation", vleraAnimacionit);
	      animation1.setDuration(2000);
	      animation1.start();

	      break;

	    case R.id.btnMshef:
	      vleraAnimacionit = 1; // alpha e ka vleren 0 per transparent 1 per normal. 0.5 gjysem transparent.
	      if (aniView.getAlpha() > 0) {
	        vleraAnimacionit = 0;
	      }
	      ObjectAnimator animation3 = ObjectAnimator.ofFloat(aniView,
	          "alpha", vleraAnimacionit);
	      animation3.setDuration(2000);
	      animation3.start();
	      break;

	    case R.id.btnGrupoAnimacionet:
	      ObjectAnimator fadeOut = ObjectAnimator.ofFloat(aniView, "alpha",
	          0f);
	      fadeOut.setDuration(2000);
	      ObjectAnimator mover = ObjectAnimator.ofFloat(aniView,
	          "translationX", -500f, 0f);
	      mover.setDuration(2000);
	      ObjectAnimator fadeIn = ObjectAnimator.ofFloat(aniView, "alpha",
	          0f, 1f);
	      fadeIn.setDuration(2000);
	      AnimatorSet animatorSet = new AnimatorSet();

	      animatorSet.play(mover).with(fadeIn).after(fadeOut);
	      animatorSet.start();
	      break;
	      
	    case R.id.btnGrupoAnimacionet2:
		      ObjectAnimator fadeOut2 = ObjectAnimator.ofFloat(aniView, "alpha",
		          0f);
		      fadeOut2.setDuration(2000);
		      ObjectAnimator mover2 = ObjectAnimator.ofFloat(aniView,
		          "translationY", 500f, 0f);
		      mover2.setDuration(2000);
		      ObjectAnimator fadeIn2 = ObjectAnimator.ofFloat(aniView, "alpha",
		          0f, 1f);
		      fadeIn2.setDuration(2000);
		      AnimatorSet animatorSet2 = new AnimatorSet();

		      animatorSet2.play(mover2).with(fadeIn2).after(fadeOut2);
		      animatorSet2.start();
		      break;

	    default:
	      break;
	    }

	  }

	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private ObjectAnimator animation1;
		private ObjectAnimator animation2;
		private View viewPerAnimim;
		private Random randon;
		private int width;
		private int height;
		private AnimatorSet set;
		View rootView;
		
		public PlaceholderFragment() {
		}

		private AnimatorSet createAnimation() {
		    int nextX = randon.nextInt(width);
		    int nextY = randon.nextInt(height);
		    viewPerAnimim = rootView.findViewById(R.id.viewPerAnimim);
		    animation1 = ObjectAnimator.ofFloat(viewPerAnimim, "x", nextX);
		    animation1.setDuration(1400);
		    animation2 = ObjectAnimator.ofFloat(viewPerAnimim, "y", nextY);
		    animation2.setDuration(1400);
		    AnimatorSet set = new AnimatorSet();
		    set.playTogether(animation1, animation2);
		    return set;
		 }
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			viewPerAnimim = rootView.findViewById(R.id.viewPerAnimim);
			
//			width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
//		    height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
//		    randon = new Random();
//
//		    set = createAnimation();
//		    set.start();
//		    set.addListener(new AnimatorListenerAdapter() {
//
//		      @Override
//		      public void onAnimationEnd(Animator animation) {
//		        int nextX = randon.nextInt(width);
//		        int nextY = randon.nextInt(height);
//		        animation1 = ObjectAnimator.ofFloat(viewPerAnimim, "x", viewPerAnimim.getX(),
//		            nextX);
//		        animation1.setDuration(1400);
//		        animation2 = ObjectAnimator.ofFloat(viewPerAnimim, "y", viewPerAnimim.getY(),
//		            nextY);
//		        animation2.setDuration(1400);
//		        set.playTogether(animation1, animation2);
//		        set.start();
//		      }
//		    });
		    
			viewPerAnimim.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {	
					int offset = 50;
					viewPerAnimim.animate().translationX(rootView.getWidth() - viewPerAnimim.getWidth() - offset).withLayer();
					
					/* 
					 * Nese dojm me animu X + Y bashk
					 * viewPerAnimim.animate().translationY(rootView.getHeight() - viewPerAnimim.getHeight() - offset).withLayer();
					 */
					
					/* 
					 * Nese dojm me lujte me transparence
					 * viewPerAnimim.animate().alpha(0.0f).withLayer(); 
					 */

					/*
					 * Nese dojm me lujte me zmadhim/zvogelim
					 * viewPerAnimim.animate().scaleX(0.0f).withLayer();
					 * viewPerAnimim.animate().scaleY(0.0f).withLayer(); 
					 */
					
					
				}
			});
			 

			return rootView;
		}
	}

}
