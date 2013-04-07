package com.aimartt.calculator;

import com.aimartt.calculator.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CaculatorActivity extends Activity {
	
	/** 计算器结果控件的值 */
	private static String RESULT_TEXT = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caculator);
        Button clearButton = (Button) findViewById(id.clear);
        //注册清除键长按事件
        clearButton.setOnLongClickListener(new OnLongClickListener() {	
			public boolean onLongClick(View v) {
				clearResultText();		//清空计算器结果	
				return false;
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.caculator, menu);
    	return true;
    }
    
    /**
     * 点击数字键（0）事件。
     * @author tt
     * @param view
     */
    public void clickZeroButton(View view) {
    	Button zeroButton = (Button) findViewById(id.zero);
    	String zero = zeroButton.getText().toString();
    	appendValueByButton(zero);
	}
    
    /**
     * 点击数字键（1）事件。
     * @author tt
     * @param view
     */
    public void clickOneButton(View view) {
    	Button oneButton = (Button) findViewById(id.one);
    	String one = oneButton.getText().toString();
    	appendValueByButton(one);
    }
    
    /**
     * 点击数字键（2）事件。
     * @author tt
     * @param view
     */
    public void clickTwoButton(View view) {
    	Button twoButton = (Button) findViewById(id.two);
    	String two = twoButton.getText().toString();
    	appendValueByButton(two);
    }
    
    /**
     * 点击数字键（3）事件。
     * @author tt
     * @param view
     */
    public void clickThreeButton(View view) {
    	Button threeButton = (Button) findViewById(id.three);
    	String three = threeButton.getText().toString();
    	appendValueByButton(three);
    }
    
    /**
     * 点击数字键（4）事件。
     * @author tt
     * @param view
     */
    public void clickFourButton(View view) {
    	Button fourButton = (Button) findViewById(id.four);
    	String four = fourButton.getText().toString();
    	appendValueByButton(four);
    }
    
    /**
     * 点击数字键（5）事件。
     * @author tt
     * @param view
     */
    public void clickFiveButton(View view) {
    	Button fiveButton = (Button) findViewById(id.five);
    	String five = fiveButton.getText().toString();
    	appendValueByButton(five);
    }
    
    /**
     * 点击数字键（6）事件。
     * @author tt
     * @param view
     */
    public void clickSixButton(View view) {
    	Button sixButton = (Button) findViewById(id.six);
    	String six = sixButton.getText().toString();
    	appendValueByButton(six);
    }
    
    /**
     * 点击数字键（7）事件。
     * @author tt
     * @param view
     */
    public void clickSevenButton(View view) {
    	Button sevenButton = (Button) findViewById(id.seven);
    	String seven = sevenButton.getText().toString();
    	appendValueByButton(seven);
    }
    
    /**
     * 点击数字键（8）事件。
     * @author tt
     * @param view
     */
    public void clickEightButton(View view) {
    	Button eightButton = (Button) findViewById(id.eight);
    	String eight = eightButton.getText().toString();
    	appendValueByButton(eight);
    }
    
    /**
     * 点击数字键（9）事件。
     * @author tt
     * @param view
     */
    public void clickNineButton(View view) {
    	Button nineButton = (Button) findViewById(id.nine);
    	String nine = nineButton.getText().toString();
    	appendValueByButton(nine);
    }
    
    /**
     * 点击冒号键（:）事件。
     * @author tt
     * @param view
     */
    public void clickColonButton(View view) {
    	Button colonButton = (Button) findViewById(id.colon);
    	String colon = colonButton.getText().toString();
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = resultText.getText().toString();
    	//判断是否可以添加冒号
    	if (RESULT_TEXT.matches("\\d+(:?\\d*\\+\\d+)?")) {
    		resultText.setText(RESULT_TEXT + colon);	
    	}
    }
    
    /**
     * 点击加号键（+）事件。
     * @param view
     */
    public void clickAddButton(View view) {
    	Button addButton = (Button) findViewById(id.add);
    	String add = addButton.getText().toString();
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = resultText.getText().toString();
    	if (RESULT_TEXT.matches("\\d+(:\\d+)?")) {
    		resultText.setText(RESULT_TEXT + add);
    	}
    }
    
    /**
     * 点击等号键（=）事件。
     * @author tt
     * @param view
     */
    public void clickCalculateButton(View view) {
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = resultText.getText().toString();
    	if (RESULT_TEXT.indexOf("+") < 0 || RESULT_TEXT.endsWith("+") || RESULT_TEXT.endsWith(":")) {
			return;		//未输入加号、以加号或冒号结尾时，不做任何操作
		}
    	String[] times = RESULT_TEXT.split("\\+");		//以加号切割字符串
    	if (times.length != 2) {
			return;		//当结果不能分割为两段时间时，不做任何操作
		}
    	int hourOfFirst;
    	int minuteOfFirst;
    	int hourOfSecond;
    	int minuteOfSecond;
    	hourOfFirst = minuteOfFirst = hourOfSecond = minuteOfSecond = 0;
    	//处理第一段字符串
    	String[] hourAndMinute;
    	if (times[0].indexOf(":") < 0) {
    		hourOfFirst = Integer.valueOf(times[0]);
    		minuteOfFirst = 0;
    	} else {
    		hourAndMinute = times[0].split(":", 2);
    		hourOfFirst = Integer.valueOf(hourAndMinute[0]);
    		minuteOfFirst = Integer.valueOf(hourAndMinute[1]);
    	}
		//处理第二段字符串
    	if (times[1].indexOf(":") < 0) {
    		hourOfSecond = Integer.valueOf(times[1]);
    		minuteOfSecond = 0;
    	} else {
    		hourAndMinute = times[1].split(":", 2);
    		hourOfSecond = Integer.valueOf(hourAndMinute[0]);
    		minuteOfSecond = Integer.valueOf(hourAndMinute[1]);
    	}
    	//计算小时和分钟的和
    	int hourOfResult = hourOfFirst + hourOfSecond;
    	int minuteOfResult = minuteOfFirst + minuteOfSecond;
		//处理相加后的结果
		if (minuteOfResult >= 60) {
			int hour = minuteOfResult / 60;
			int minute = minuteOfResult % 60;
			hourOfResult += hour;
			minuteOfResult = minute;
		}
		//处理分钟，保证分钟均为两位
		String minuteResultString;
		if (minuteOfResult == 0) {
			minuteResultString = "00";
		} else if (minuteOfResult < 10) {
			minuteResultString = "0" + minuteOfResult;
		} else {
			minuteResultString = String.valueOf(minuteOfResult);
		}
		RESULT_TEXT = hourOfResult + ":" + minuteResultString;
		resultText.setText(RESULT_TEXT);
    }
    
    /**
     * 点击清除键（C）事件。
     * @param view
     */
    public void clickClearButton(View view) {
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = resultText.getText().toString();
    	int length = RESULT_TEXT.length();
    	if (length == 0) {
    		return;
		}
    	//当计算器结果控件中的值不为空时，截掉最后一位
    	RESULT_TEXT = RESULT_TEXT.substring(0, length - 1);
    	resultText.setText(RESULT_TEXT);
    }
    
    /**
     * 将 <tt>text</tt> 添加到 {@link #RESULT_TEXT} 的尾部。
     * @author tt
     * @param text 要添加的字符串
     * @see #RESULT_TEXT
     */
    private void appendValueByButton(String text) {
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = resultText.getText().toString();
    	resultText.setText(RESULT_TEXT + text);
    }
    
    /**
     * 清空 {@link #RESULT_TEXT}。
     * @author tt
     * @see #RESULT_TEXT
     */
    private void clearResultText() {
    	EditText resultText = (EditText) findViewById(id.result);
    	RESULT_TEXT = "";
    	resultText.setText(RESULT_TEXT);
    }
    
}