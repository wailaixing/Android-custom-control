package com.example.youku.util;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtils {

	//旋转动画
	public static void rotateOutAnim(RelativeLayout layout,long delay) {
		// TODO Auto-generated method stub
		RotateAnimation ra=new RotateAnimation(
				0f, -180f, //开始结束的角度,逆时针
				Animation.RELATIVE_TO_SELF, 0.5f, //相对的坐标点(旋转中心x值)
				Animation.RELATIVE_TO_SELF,1.0f); //相对的坐标点(旋转中心y值)
				
		ra.setDuration(500);//时长
		ra.setFillAfter(true);
		ra.setStartOffset(delay);
		
		ra.setAnimationListener(new MyAnimationListener());
		
		layout.startAnimation(ra);
		
	}

	public static void rotateInAnim(RelativeLayout layout) {
		// TODO Auto-generated method stub
		RotateAnimation ra=new RotateAnimation(
				-180f, 0f, //开始结束的角度，顺时针
				Animation.RELATIVE_TO_SELF, 0.5f, //相对的坐标点(旋转中心x值)
				Animation.RELATIVE_TO_SELF,1.0f); //相对的坐标点(旋转中心y值)
				
		ra.setDuration(500);//时长
		ra.setFillAfter(true);
		ra.setAnimationListener(new MyAnimationListener());

		layout.startAnimation(ra);
	}
	
	public static int runningAnimationCount=0;
	
	static class MyAnimationListener implements AnimationListener{

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			runningAnimationCount++;
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			runningAnimationCount--;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
		}
		
		
		
	}

}
