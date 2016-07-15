package com.example.youku.util;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtils {

	//��ת����
	public static void rotateOutAnim(RelativeLayout layout,long delay) {
		// TODO Auto-generated method stub
		RotateAnimation ra=new RotateAnimation(
				0f, -180f, //��ʼ�����ĽǶ�,��ʱ��
				Animation.RELATIVE_TO_SELF, 0.5f, //��Ե������(��ת����xֵ)
				Animation.RELATIVE_TO_SELF,1.0f); //��Ե������(��ת����yֵ)
				
		ra.setDuration(500);//ʱ��
		ra.setFillAfter(true);
		ra.setStartOffset(delay);
		
		ra.setAnimationListener(new MyAnimationListener());
		
		layout.startAnimation(ra);
		
	}

	public static void rotateInAnim(RelativeLayout layout) {
		// TODO Auto-generated method stub
		RotateAnimation ra=new RotateAnimation(
				-180f, 0f, //��ʼ�����ĽǶȣ�˳ʱ��
				Animation.RELATIVE_TO_SELF, 0.5f, //��Ե������(��ת����xֵ)
				Animation.RELATIVE_TO_SELF,1.0f); //��Ե������(��ת����yֵ)
				
		ra.setDuration(500);//ʱ��
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
