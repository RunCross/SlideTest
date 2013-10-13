package run.cross.slidetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ViewF extends Activity implements OnGestureListener{

	private GestureDetector gestureDetector = null;  
    private ViewFlipper viewFlipper = null;  
  
    private Activity mActivity = null;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewflipper);
		
		viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);  
        gestureDetector = new GestureDetector(this);    // 声明检测手势事件  
  
        for (int i = 0; i < 4; i++) {          // 添加图片源  
           TextView tv = new TextView(this);
           tv.setText(" "+i);
            viewFlipper.addView(tv, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));  
        }  
          
        viewFlipper.setAutoStart(true);         // 设置自动播放功能（点击事件，前自动播放）  
        viewFlipper.setFlipInterval(3000);  
        if(viewFlipper.isAutoStart() && !viewFlipper.isFlipping()){  
            viewFlipper.startFlipping();  
        }  
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {  
        if (e2.getX() - e1.getX() > 120) {            // 从左向右滑动（左进右出）  
            Animation rInAnim = AnimationUtils.loadAnimation(mActivity, R.anim.push_right_in);  // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）  
            Animation rOutAnim = AnimationUtils.loadAnimation(mActivity, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）  
  
            viewFlipper.setInAnimation(rInAnim);  
            viewFlipper.setOutAnimation(rOutAnim);  
            viewFlipper.showPrevious();  
            return true;  
        } else if (e2.getX() - e1.getX() < -120) {        // 从右向左滑动（右进左出）  
            Animation lInAnim = AnimationUtils.loadAnimation(mActivity, R.anim.push_left_in);       // 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）  
            Animation lOutAnim = AnimationUtils.loadAnimation(mActivity, R.anim.push_left_out);     // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）  
  
            viewFlipper.setInAnimation(lInAnim);  
            viewFlipper.setOutAnimation(lOutAnim);  
            viewFlipper.showNext();  
            return true;  
        }  
        return true;  
    }  

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
