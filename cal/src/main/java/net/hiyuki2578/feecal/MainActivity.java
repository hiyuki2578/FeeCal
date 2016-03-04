package net.hiyuki2578.feecal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hiyuki on 2016/03/03.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    double fee,cash;
    private ArrayList<String> ret;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fee = 0.0;
        cash = 0.0;
        i = 0;
        Button wayadult = (Button)findViewById(R.id.wayadult);
        wayadult.setOnClickListener(this);
        Button waystu = (Button)findViewById(R.id.waystu);
        waystu.setOnClickListener(this);
        Button wayage = (Button)findViewById(R.id.wayage);
        wayage.setOnClickListener(this);
        Button dayadult = (Button)findViewById(R.id.dayadult);
        dayadult.setOnClickListener(this);
        Button daystu = (Button)findViewById(R.id.daystu);
        daystu.setOnClickListener(this);
        Button dayage = (Button)findViewById(R.id.dayage);
        dayage.setOnClickListener(this);
        Button weekadult = (Button)findViewById(R.id.weekadult);
        weekadult.setOnClickListener(this);
        Button weekstu = (Button)findViewById(R.id.weekstu);
        weekstu.setOnClickListener(this);
        Button weekage = (Button)findViewById(R.id.weekage);
        weekage.setOnClickListener(this);
        Button mon2 = (Button)findViewById(R.id.mon2);
        mon2.setOnClickListener(this);
        Button mon5 = (Button)findViewById(R.id.mon5);
        mon5.setOnClickListener(this);
        Button mon10 = (Button)findViewById(R.id.mon10);
        mon10.setOnClickListener(this);
        Button clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear:
                clear();
                break;
            case R.id.wayadult:
                if(i != 1){
                    clear();
                }
                i = 1;
                add(2.20);
                break;
            case R.id.waystu:
                if(i != 2){
                    clear();
                }
                i = 2;
                add(1.40);
                break;
            case R.id.wayage:
                if(i != 3){
                    clear();
                }
                i = 3;
                add(1.40);
                break;
            case R.id.dayadult:
                if(i != 4){
                    clear();
                }
                i = 4;
                add(6.60);
                break;
            case R.id.daystu:
                if(i != 5){
                    clear();
                }
                i = 5;
                add(5.20);
                break;
            case R.id.dayage:
                if(i != 6){
                    clear();
                }
                i = 6;
                add(5.20);
                break;
            case R.id.weekadult:
                if(i != 7){
                    clear();
                }
                i = 7;
                add(33.00);
                break;
            case R.id.weekstu:
                if(i != 8){
                    clear();
                }
                i = 8;
                add(26.00);
                break;
            case R.id.weekage:
                if(i != 9){
                    clear();
                }
                i = 9;
                add(26.00);
                break;
            case R.id.mon2:
                cashadd(2.00);
                break;
            case R.id.mon5:
                cashadd(5.00);
                break;
            case R.id.mon10:
                cashadd(10.00);
                break;
        }
    }
    public void cashadd(double num){
        TextView text = (TextView)findViewById(R.id.change);
        cash = cash + num;
        text.setText(getString(R.string.Fee) + ": " + fee + "\n" + getString(R.string.Cash) + ": " + cash + "\n" + getString(R.string.Change) + "\n" + change());
    }
    public void add(double num){
        TextView text = (TextView)findViewById(R.id.change);
        fee = fee + num;
        text.setText(getString(R.string.Fee) + ": " + fee + "\n" + getString(R.string.Cash) + ": " + cash + "\n" + getString(R.string.Change) + "\n" + change());
    }
    public String change(){
        String change;
        double temp;
        int num;
        ret = new ArrayList<String>();
        temp = cash - fee;
        ret.add("2.0 : " + (int)(temp / 2));
        num = (int)(temp / 2);
        temp = temp - (2 * num);
        ret.add("\n1.0 : " + (int)(temp / 1));
        if(temp >= 1.0){
            temp = temp - 1;
        }
        ret.add("\n0.5 : " + (int)(temp / 0.5));
        num = (int)(temp / 0.5);
        temp = temp - (0.5 * num);
        ret.add("\n0.2 : " + (int)(temp / 0.2));
        num = (int)(temp / 0.2);
        temp = temp - (0.2 * num);
        if(temp >= 0.01) {
            ret.add("\n0.1 : 1");
        }else{
            ret.add("\n0.1 : 0");
        }
        ret.add("\n0.1 : " + temp * 10);
        change = ret.get(0) + ret.get(1) + ret.get(2) + ret.get(3) + ret.get(4);
        return change;
    }
    public void clear(){
        TextView text = (TextView)findViewById(R.id.change);
        fee = 0.0;
        cash = 0.0;
        text.setText("");
    }
}
