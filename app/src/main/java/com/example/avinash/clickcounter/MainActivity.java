package com.example.avinash.clickcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button press,b2;
    public TextView txt;
    public int count=0;
    public RelativeLayout mlo;
    public int test=0;
    public int color=0x0000ff;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlo=(RelativeLayout)findViewById(R.id.screen);

        b2=(Button)findViewById(R.id.button2);
        press=(Button)findViewById(R.id.button);
        txt=(TextView)findViewById(R.id.textView);
        txt.setText("" + count);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        try{
            String ct=sharedpreferences.getString("count","");
            int col=sharedpreferences.getInt("color",0);
            mlo.setBackgroundColor(col);
            color=col;
            count=Integer.parseInt(ct);
            txt.setText(ct);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "CURRENTLY NO SAVED VALUE:PLEASE PRESS BUTTON", Toast.LENGTH_SHORT).show();
        }}

    public void press(View v){

        count++;
        txt.setText("" + count);
        test=count%6;


        switch(test){
            case 1:mlo.setBackgroundColor(0xEECE3106);
                color=0xEECE3106;
                break;
            case 2:mlo.setBackgroundColor(0xeece0632);
                color=0xeece0632;
                break;
            case 3:mlo.setBackgroundColor(0xEECEB706);
                color=0xEECEB706;
                break;
            case 4:mlo.setBackgroundColor(0xEE1CB652);
                color=0xEE1CB652;
                break;
            case 5:mlo.setBackgroundColor(0xEE1B807A);
                color=0xEE1B807A;
                break;
            case 6:mlo.setBackgroundColor(0xEEA41CB6);
                color=0xEEA41CB6;
                break;
            default:mlo.setBackgroundColor(0xe60a657d);
                color=0xe60a657d;
        }

        String str=txt.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("count",str );
        editor.putInt("color",color);
        editor.apply();

    }

    @Override
    protected void onSaveInstanceState(Bundle State) {
        super.onSaveInstanceState(State);
        CharSequence userText = txt.getText();
        State.putCharSequence("savedText", userText);
        State.putInt("background", color);



    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        CharSequence userText = savedState.getCharSequence("savedText");
        color=savedState.getInt("background");
        mlo.setBackgroundColor(color);

        txt.setText(userText);
        String cnt=txt.getText().toString();
        count=Integer.parseInt(cnt);
    }

    public void reset(View vu) {
        count=0;
        txt.setText(""+count);
        mlo.setBackgroundColor(0x0000ff);
        color=0x0000ff;
        String str=txt.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("count", str);
        editor.putInt("color",color);
        editor.apply();
    }

}