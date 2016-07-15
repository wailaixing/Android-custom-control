package com.example.youku;

import android.os.Bundle;

import com.example.youku.util.AnimationUtils;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener{
	private RelativeLayout rl_level3;
	private RelativeLayout rl_level2;
	private RelativeLayout rl_level1;
	
	boolean isLevel1Display=true;
	boolean isLevel2Display=true;
	boolean isLevel3Display=true;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//初始化控件
		initView();
		
	
	}
	private void initView(){
		findViewById(R.id.ib_home).setOnClickListener(this);
		findViewById(R.id.ib_menu).setOnClickListener(this);
		
		rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);
		rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
		rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);
	
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_MENU){
			
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
	@Override
	public void onClick(View v) {
		if(AnimationUtils.runningAnimationCount>0){
			//当前动画正在执行，
			return;
		}
		
		switch(v.getId()){
		case R.id.ib_home:
			if(isLevel2Display){
				long delay=0;
				
				if(isLevel3Display){
					AnimationUtils.rotateOutAnim(rl_level3,0);
					isLevel3Display=false;
					delay+=200;
				}
				AnimationUtils.rotateOutAnim(rl_level2, delay);
			}else{
				//如果当前的三级菜单隐藏，就显示
				AnimationUtils.rotateInAnim(rl_level2);
			}
			isLevel2Display=!isLevel2Display;			
			break;
		case R.id.ib_menu:
			if(isLevel3Display){
				//如果当前的三级菜单已显示，就隐藏
				AnimationUtils.rotateOutAnim(rl_level3,0);
			}else{
				//如果当前的三级菜单隐藏，就显示
				AnimationUtils.rotateInAnim(rl_level3);
			}
			isLevel3Display=!isLevel3Display;
			
			break;
		default:
			break;
		
		}
	}



}
