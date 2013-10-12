package run.cross.slidetest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener ,OnGestureListener{

	//���Ƽ���
	GestureDetector mGestureDetector;  
	
	//��������
	private int verticalMinDistance = 50;
	//xλ�ƴ�С
	private int minVelocity         = 0;  
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("First");
		
		mGestureDetector = new GestureDetector(this);    
		RelativeLayout viewSnsLayout = (RelativeLayout)findViewById(R.id.page_first);    
        viewSnsLayout.setOnTouchListener(this);    
        viewSnsLayout.setLongClickable(true);    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
			  
	        // �л�Activity  
	         Intent intent = new Intent(MainActivity.this, GroupsActivity.class);  
	         startActivity(intent);  
	         //����ǳ��
	         overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	        Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();  
	    } else if (e2.getX() - e1.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {  
	  
	        // �л�Activity  
	        // Intent intent = new Intent(ViewSnsActivity.this, UpdateStatusActivity.class);  
	        // startActivity(intent);  
	        Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();  
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
	public boolean onTouch(View v, MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);  
	}
	
}
