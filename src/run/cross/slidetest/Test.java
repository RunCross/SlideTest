package run.cross.slidetest;

import run.cross.slidetest.MainActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Test extends Activity implements OnTouchListener ,OnGestureListener{

	//手势监听
		GestureDetector mGestureDetector;  
		
		private int verticalMinDistance = 50;  
		private int minVelocity         = 0;  
		
		@SuppressWarnings("deprecation")
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.page_second);
			setTitle("Second");
			mGestureDetector = new GestureDetector(this);    
			LinearLayout viewSnsLayout = (LinearLayout)findViewById(R.id.page_second);    
	        viewSnsLayout.setOnTouchListener(this);    
	        viewSnsLayout.setLongClickable(true);    
		}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e1.getX() - e2.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {  
			  
	        // 切换Activity  
//	         Intent intent = new Intent(GroupsActivity.this, MainActivity.class);  
//	         startActivity(intent);  
//			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	        Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();  
	    } else if (e2.getX() - e1.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {  
	  
	        // 切换Activity  
	    	Intent intent = new Intent(Test.this, MainActivity.class);  
	         startActivity(intent);  
			overridePendingTransition(R.anim.right_in, R.anim.right_out);  
	        Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();  
	    }  
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);  
	}

}
