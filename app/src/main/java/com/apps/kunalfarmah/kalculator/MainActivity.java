package com.apps.kunalfarmah.kalculator;

import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {



    Scientific scientific = new Scientific();

    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;
    TextView angle;
    TextView operator2;

    FrameLayout fl;
    FrameLayout frag;



    AboutFragment about = new AboutFragment();
    UsageFragment usage = new UsageFragment();


    boolean sci_used = false;
    boolean n1isfilled = false;
    boolean n2isfilled = false;
    boolean equalispressed = false;
    boolean sci_ops = false;
    int f = 0;

    int eq = 0;
    String oldops;

    public Double temp = 0d;



    Double ans_d = 0d;
    Double NaNi =NaN;

    Double ans = 0d;
    Integer ans_i = 0;




    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button close;

    Button pi;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button perc;
    Button sq;
    Button sqrt;
    Button pow;
    Button rem;
    Button C;
    Button ln;
    Button log;
    ImageButton back;
    Button dot;
    Button equals;
    Button extra;
    Button e;
    Button pow10;

    LinearLayout calc;


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString("n1",  n1.getText().toString());
        outState.putString("n2",  n2.getText().toString());
        outState.putString("ops",  ops.getText().toString());
        outState.putString("operator2",   operator2.getText().toString());
        boolean operator2_shown = operator2.isShown();
        outState.putBoolean("operator2_shown",operator2_shown);
        outState.putString("res",  res.getText().toString());
        outState.putString("oldops",  oldops);
        outState.putString("angle", angle.getText().toString());


        outState.putDouble("ans",  ans);
        outState.putDouble("temp",  temp);
        outState.putDouble("ans_d",  ans_d);


        outState.putInt("f",f);
        outState.putInt("eq",eq);


        outState.putBoolean("n1isfilled",n1isfilled);
        outState.putBoolean("n2isfilled",n2isfilled);
        outState.putBoolean("sci_used",sci_used);
        outState.putBoolean("sci_ops",sci_ops);
        outState.putBoolean("equalispressed",equalispressed);
        outState.putBoolean("sci.trigo",scientific.trigo);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        //To Retrieve data from "saved_state"

        n1.setText(savedInstanceState.getString("n1"));
        n2.setText(savedInstanceState.getString("n2"));
        ops.setText(savedInstanceState.getString("ops"));

        if(savedInstanceState.getBoolean("operator2_shown"))
            operator2.setVisibility(View.VISIBLE);

        operator2.setText(savedInstanceState.getString("operator2"));

        res.setText(savedInstanceState.getString("res"));
        angle.setText(savedInstanceState.getString("angle"));


        ans = savedInstanceState.getDouble("ans");
        ans_d = savedInstanceState.getDouble("ans_d");
        temp = savedInstanceState.getDouble("temp");

        f=  savedInstanceState.getInt("f");
        eq=savedInstanceState.getInt("eq");

        oldops = savedInstanceState.getString("oldops");

        sci_ops= savedInstanceState.getBoolean("sci_ops");
        sci_used = savedInstanceState.getBoolean("sci_used");
        n1isfilled = savedInstanceState.getBoolean("n1isfilled");
        n2isfilled = savedInstanceState.getBoolean("n2isfilled");
        equalispressed = savedInstanceState.getBoolean("equalispressed");
        scientific.trigo = savedInstanceState.getBoolean("sci.trigo");

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getting// width of the screen
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int scr_width = display.widthPixels;



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setTitle(R.string.app_name);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.kalc);



        int orientation = this.getResources().getConfiguration().orientation;





        calc = (LinearLayout) findViewById(R.id.display);

        fl = findViewById(R.id.scibuttons);
        frag = findViewById(R.id.frag);


        res = (TextView) findViewById(R.id.result);

        n1 = (TextView) findViewById(R.id.n1);
        ops = (TextView) findViewById(R.id.operator);
        operator2 = (TextView) findViewById(R.id.operator2);
        n2 = (TextView) findViewById(R.id.n2);
        angle = (TextView) findViewById(R.id.angle);


        b1 = findViewById(R.id.num1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.num2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.num3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.num4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.num5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.num6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.num7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.num8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.num9);
        b9.setOnClickListener(this);
        b0 = findViewById(R.id.num0);
        b0.setOnClickListener(this);
        extra = findViewById(R.id.sci1);
        extra.setOnClickListener(this);


        pi = findViewById(R.id.pi);
        pi.setOnClickListener(this);
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);
        mul = findViewById(R.id.mul);
        mul.setOnClickListener(this);
        div = findViewById(R.id.div);
        div.setOnClickListener(this);
        perc = findViewById(R.id.perc);
        perc.setOnClickListener(this);
        rem = findViewById(R.id.rem);
        rem.setOnClickListener(this);
        sqrt = findViewById(R.id.sqrt);
        sqrt.setOnClickListener(this);
        ln = findViewById(R.id.ln);
        ln.setOnClickListener(this);
        log = findViewById(R.id.log);
        log.setOnClickListener(this);
        back = findViewById(R.id.backsp);
        back.setOnClickListener(this);
        C = findViewById(R.id.c);
        C.setOnClickListener(this);
        pow = findViewById(R.id.pow);
        pow.setOnClickListener(this);
        dot = findViewById(R.id.numdot);
        dot.setOnClickListener(this);
        equals = findViewById(R.id.equals);
        equals.setOnClickListener(this);
        e = findViewById(R.id.e);
        e.setOnClickListener(this);
        pow10 = findViewById(R.id.pow10);
        pow10.setOnClickListener(this);

        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            extra.setVisibility(View.GONE);


        getSupportFragmentManager().beginTransaction().add(R.id.scibuttons, scientific).commit();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // View view = menu.findItem(R.id.tool).getActionView();



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.howtouse) {
            getSupportFragmentManager().popBackStack();
            frag.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.frag, usage).addToBackStack("usage").commit();
            return true;
        }

        if (id == R.id.about) {
            getSupportFragmentManager().popBackStack();
            frag.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.frag, about).addToBackStack("about").commit();
            return true;
        }

        return true;
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.sci1:

                fl.setVisibility(View.VISIBLE);



                break;

            case R.id.num0:

                visual();

                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("0");
                        res.setText("0");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("0");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("0");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");

                        if (!operator2.isShown()) {

                            if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                            else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                            if(ans.toString().contains("E"))
                                res.setText(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                                res.setText(ans.toString());

                            }
                        }

                        else if (operator2.isShown()) {
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());

                            if(ans.toString().contains("E"))
                                res.setText(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                                res.setText(ans.toString());

                            }
                        }

                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("0");
                        res.setText("0");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("0");

                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("0");
                        n2isfilled = true;
                        if(ops.getText().toString().equals("/")) {
                            res.setText("NaNi");
                            break;
                        }

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }

                }

                break;

            case R.id.pi:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("\u03C0");
                        n1isfilled = true;

                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("\u03C0");
                        n2isfilled = true;


                    }


                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("\u03C0");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("\u03C0");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("\u03C0");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");

                    }


                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));

                        else
                            res.setText(ans.toString());;
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }
                break;


            case R.id.e:

                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("e");
                        n1isfilled = true;

                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        ops.setText("e");

                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("e");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !(ops.getText().toString().equals("e")))) {
                        n2.append("e");
                    }
                    if (!operator2.isShown()) {



                        if (n2.length() >= 3) {
                            ans= result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                            if(ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }
                            res.setText(ans.toString());
                        }
                        else if (scientific.trigo) {

                            ans =scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());

                            if(ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }

                            res.setText(ans.toString());
                        }
                        else {
                            ans= result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                            if(ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }
                            res.setText(ans.toString());
                        }
                    }
                    else if (operator2.isShown() && (n2.length()>=3 || scientific.trigo )) {

                        ans =scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());


                        if(ans.toString().contains("E"))
                            ans = Double.parseDouble(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        }
                        if (n2.length() >= 3)
                            res.setText(ans.toString());
                        else if (scientific.trigo)
                            res.setText(ans.toString());

                        else {
                            res.setText(ans.toString());

                        }
                    }


                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("e");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        ops.setText("e");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("e");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !(ops.getText().toString().equals("e")))) {
                        n2.append("e");

                    }

                    if (!operator2.isShown()) {


                        if (n2.length() >= 3) {
                            ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                            if (ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }
                            res.setText(ans.toString());
                        } else if (scientific.trigo) {

                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());

                            if (ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }

                            res.setText(ans.toString());
                        } else  {
                            ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                            if (ans.toString().contains("E"))
                                ans = Double.parseDouble(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            }
                            res.setText(ans.toString());
                        }
                    } else if (operator2.isShown() && (n2.length() >= 3 || scientific.trigo)) {

                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());


                        if (ans.toString().contains("E"))
                            ans = Double.parseDouble(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        }
                        if (n2.length() >= 3)
                            res.setText(ans.toString());
                        else if (scientific.trigo)
                            res.setText(ans.toString());

                        else {
                            res.setText(ans.toString());

                        }
                    }
                }

                break;


            case R.id.num1:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("1");
                        res.setText("1");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("1");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("1");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("1");
                        res.setText("1");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("1");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("1");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");

                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }
                break;

            case R.id.num2:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("2");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("2");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("2");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("2");
                        f = 1;
                        n1isfilled = true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("2");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("2");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;

            case R.id.num3:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("3");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("3");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("3");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("3");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("3");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("3");
                        n1isfilled = true;
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("3");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("3");
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;

            case R.id.num4:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("4");

                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("4");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("4");
                        n2isfilled = true;


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");

                    }

                    if (!operator2.isShown()) {

                        if(!sci_used)  ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("4");
                        f = 1;
                        n1isfilled = true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("4");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("4");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }
                f = 0;
                break;


            case R.id.num5:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("5");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("5");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("5");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));

                        else
                            res.setText(ans.toString());;
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("5");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("5");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("5");
                        n2isfilled = true;


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;


            case R.id.num6:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("6");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("6");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("6");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("6");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("6");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("6");
                        n2isfilled = true;


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");

                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;

            case R.id.num7:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("7");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("7");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("7");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                    }


                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("7");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("7");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("7");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;


            case R.id.num8:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("8");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("8");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("8");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("8");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("8");
                        n1isfilled = true;

                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("8");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                }

                break;

            case R.id.num9:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("9");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("9");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("9");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");

                    }
                    if (!operator2.isShown() ) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());

                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (!operator2.getText().toString().equals("") ) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }
                } else if (equalispressed) {


                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("9");
                        f = 1;

                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("9");

                    } else if (!n2isfilled && !(ops.getText().toString().equals(".")) && f == 1) {
                        n2.setText("9");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");



                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        if(ans.toString().contains("E"))
                            res.setText(ans_setting(ans));


                        else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());

                        }
                    }

                }


                break;

            case R.id.numdot:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("0");
                        n1.append(".");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append(".");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("0");
                        n2.append(".");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");
                    }

                    if (!operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '.')
                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        else {
                        }
                    } else if (operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '.')
                            res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                        else {
                        }
                    }
                }

                else if (equalispressed) {


                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("0");
                        n1.append(".");
                        f = 1;

                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append(".");

                    } else if (!n2isfilled && !(ops.getText().toString().equals(".")) && f == 1) {
                        n2.setText("0");
                        n2.append(".");

                        n2isfilled = true;


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");

                    }

                    if (!operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '.')
                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        else {//carry on}
                        }
                    } else if (operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '.')
                            res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                        else {//carry on}
                        }

                    }
                }

                break;


            case R.id.add:
                visual();


                oldops = ops.getText().toString();
                ops.setText("+");

                if (!n1isfilled && !sci_ops) {
                    n1.setText("0");
                    n1isfilled=true;
                }

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    if(res.getText().toString().contains("E")){
                        n1.setText(ans_small(Double.parseDouble(res.getText().toString())));
                    }
                    else {
                        Double n = Math.round((Double.parseDouble(res.getText().toString())) * 100.0) / 100.0;
                        n1.setText(n.toString());
                    }

                    ops.setText("+");
                    n2.setText("0");
                    n2isfilled = false;
                    sci_used=false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {

                    if(operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                        sci_used=false;
                        operator2.setVisibility(View.GONE);
                        operator2.setText("");
                    }

                    else if(!operator2.isShown()) {
                        if (!scientific.trigo) {
                            ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                            sci_used=false;

                        } else {
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                            sci_used=false;
                        }
                    }
                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    n1isfilled = true;
                    ops.setText("+");



                    n2.setText("0");

                    n2isfilled = false;
                }

                // for case sin(x)+n

                else if (sci_ops ) {


                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    n1isfilled = true;
                    ops.setText("+");
                    sci_used=false;
                    n2.setText("0");
                    n2isfilled = false;


                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                }


                break;

            case R.id.sub:

                visual();


                oldops = ops.getText().toString();


                if (!n1isfilled && scientific.invpressed % 2 == 0) {
                    ops.setText("-");
                    n1.setText("0");
                    n1isfilled=true;

                } else if (n1isfilled && ops.getText().toString().equals(".") && !sci_used) {
                    ops.setText("-");
                    n2.setText("0");
                    break;
                }

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    if(res.getText().toString().contains("E")){
                        n1.setText(ans_small(Double.parseDouble(res.getText().toString())));
                    }
                    else {
                        Double n = Math.round((Double.parseDouble(res.getText().toString())) * 100.0) / 100.0;
                        n1.setText(n.toString());
                    }
                    ops.setText("-");
                    n2.setText("0");
                    n2isfilled = false;
                    sci_used=false;
                    f = 1;
                } else if ((!n1.getText().toString().equals("0") && (n2.getText().toString().equals("0") || n2.getText().toString().equals("")) && ((!ops.getText().toString().equals(".") && !sci_ops) || ((!operator2.getText().equals("")) && sci_ops)) || scientific.invpressed % 2 != 0)) {

                    n2.setText("-");
                    n2isfilled = true;
                    break;
                } else if (n1.getText().toString().equals("") && n2.getText().toString().equals("0") && scientific.trigo) {
                    n2.setText("-");
                    n2isfilled = true;
                    scientific.trigo = false;
                    break;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {

                    if(operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                        ops.setText("-");
                        sci_used=false;
                        operator2.setVisibility(View.GONE);
                        operator2.setText("");
                    }

                    else if(!operator2.isShown()) {
                        if (!scientific.trigo) {
                            ops.setText("-");
                            ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                            sci_used=false;

                        } else {
                            ops.setText("-");
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                            sci_used=false;
                        }
                    }
                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    n1isfilled = true;
                    ops.setText("-");
                    n2.setText("0");

                    n2isfilled = false;
                }



                else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    n1isfilled = true;
                    ops.setText("-");
                    sci_used=false;
                    n2.setText("0");
                    n2isfilled = false;

                    eq = 1;

                    sci_ops = false;
                }


                break;

            case R.id.mul:
                visual();
                oldops = ops.getText().toString();


                if (!n1isfilled) {
                    break;
                }

                ops.setText("X");

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    if(res.getText().toString().contains("E")){
                        n1.setText(ans_small(Double.parseDouble(res.getText().toString())));
                    }
                    else {
                        Double n = Math.round((Double.parseDouble(res.getText().toString())) * 100.0) / 100.0;
                        n1.setText(n.toString());
                    }
                    ops.setText("X");
                    n2.setText("0");
                    sci_used=false;
                    n2isfilled = false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {

                    if(operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                        sci_used=false;
                        operator2.setVisibility(View.GONE);
                        operator2.setText("");
                    }

                    else if(!operator2.isShown()) {
                        if (!scientific.trigo) {
                            ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                            sci_used=false;

                        } else {
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                            sci_used=false;
                        }
                    }
                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    ops.setText("X");
                    n2.setText("");
                    n2isfilled = false;
                } else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    n1isfilled = true;
                    ops.setText("X");
                    sci_used=false;
                    n2.setText("0");
                    n2isfilled = false;
                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                    scientific.trigo = false;
                }

                break;

            case R.id.div:
                visual();

                oldops = ops.getText().toString();

                if (!n1isfilled) {
                    break;

                }

                ops.setText("/");

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    if(res.getText().toString().contains("E")){
                        n1.setText(ans_small(Double.parseDouble(res.getText().toString())));
                    }
                    else {
                        Double n = Math.round((Double.parseDouble(res.getText().toString())) * 100.0) / 100.0;
                        n1.setText(n.toString());
                    }
                    ops.setText("/");
                    n2.setText("0");
                    n2isfilled = false;
                    sci_used=false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {

                    if(operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                        sci_used=false;
                        operator2.setVisibility(View.GONE);
                        operator2.setText("");
                    }

                    else if(!operator2.isShown()) {
                        if (!scientific.trigo) {
                            ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                            sci_used=false;

                        } else {
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
                            sci_used=false;
                        }
                    }
                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                        n1.setText(ans.toString());

                    }
                    ops.setText("/");
                    n2.setText("");
                    n2isfilled = false;
                } else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());

                    if(ans.toString().contains("E"))
                        n1.setText(ans_small(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 1000) / 1000.0;
                        n1.setText(ans.toString());

                    }
                    ops.setText("/");
                    n2.setText("0");
                    sci_used=false;
                    n2isfilled = false;
                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                }

                break;

            case R.id.perc:
                if (!n1isfilled) {
                    res.setText("Syntax Error");
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    ops.setText("%");
                    if (!operator2.isShown())
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown())
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());


                } else if (n1isfilled && n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.append("%");
                    if (!operator2.isShown())
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown())
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                }

                break;

            case R.id.sqrt:

                scientific.trigo=true;


                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;

                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("sqrt");
                    sci_ops = true;

                }

                else if((n1isfilled && n2isfilled && !ops.getText().toString().equals("."))) {

                    scientific.trigo=true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("sqrt");

                    if (!equalispressed) {

                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;
                    }

                    else if(equalispressed){
                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;

                        f=1;

                    }
                }

                else if(!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot")&& !ops.getText().toString().equals("sec")&& !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos")&& !ops.getText().toString().equals("(arc)tan"))&& !ops.getText().toString().equals("log")&& !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt")){


                    sci_used = true;
                    operator2.setText("sqrt");
                    operator2.setVisibility(View.VISIBLE);

                }


                break;

            case R.id.rem:
                visual();
                //  ops.setText("REM");

                if (n1.getText().toString().equals("0")) {
//                    n1.setText("");
//                    n1isfilled = true;
                    res.setText("Syntax Error");
                }

                else if(!n1.getText().toString().equals("0") && !n2isfilled && ops.getText().toString().equals(".")){
                    ops.setText("REM");
                }

                else if(n1isfilled && n2isfilled){
                    res.setText("Syntx Error");
                }


                break;

            case R.id.pow:
                visual();

                if(!n1isfilled){
                    res.setText("Syntax Error");
                }

                else  if (ops.getText().toString().equals(".")) {
                    ops.setText("^");
                    n2.setText("");
                }

                else if (n1isfilled && n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.append("^");

                    if (!operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '^')
                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        else {//carry on}
                        }
                    } else if (operator2.isShown()) {
                        String num = n2.getText().toString();
                        int len = num.length();

                        // preventing the case of error like 6. is not a number

                        if (num.charAt(len - 1) != '^')
                            res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                        else {//carry on}
                        }

                    }
                }

                break;

            case R.id.pow10:

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("10^");

                }else if((n1isfilled && n2isfilled && !ops.getText().toString().equals(".")) || equalispressed && !calc.isShown()){
                    if(operator2.isShown()){
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }


                    n1.setText("");
                    n1isfilled=true;


                    ops.setText("10^");

                    n2.setText("0");
                    n2isfilled=false;

                }
                else if(!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot")&& !ops.getText().toString().equals("sec")&& !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos")&& !ops.getText().toString().equals("(arc)tan"))&& !ops.getText().toString().equals("log")&& !ops.getText().toString().equals("ln")&& !ops.getText().toString().equals("sqrt")&& !ops.getText().toString().equals("10^")){


                    sci_used = true;
                    operator2.setText("10^");
                    operator2.setVisibility(View.VISIBLE);

                }
                break;


            case R.id.log:

                scientific.trigo=true;

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("log");
                    sci_ops = true;

                }

                else if((n1isfilled && n2isfilled && !ops.getText().toString().equals("."))) {

                    scientific.trigo=true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("log");

                    if (!equalispressed) {

                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;
                    }

                    else if(equalispressed){
                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;

                        f=1;

                    }
                }
                else if(!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot")&& !ops.getText().toString().equals("sec")&& !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos")&& !ops.getText().toString().equals("(arc)tan"))&& !ops.getText().toString().equals("log")&& !ops.getText().toString().equals("ln")&& !ops.getText().toString().equals("sqrt")&& !ops.getText().toString().equals("10^")){


                    sci_used = true;
                    operator2.setText("log");
                    operator2.setVisibility(View.VISIBLE);

                }
                break;


            case R.id.ln:

                scientific.trigo=true;

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("ln");
                    sci_ops = true;

                }

                else if((n1isfilled && n2isfilled && !ops.getText().toString().equals("."))) {

                    scientific.trigo=true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("ln");

                    if (!equalispressed) {

                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;
                    }

                    else if(equalispressed){
                        n1.setText("");
                        n1isfilled = true;

                        n2.setText("0");
                        n2isfilled = false;

                        f=1;

                    }
                }

                else if(!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot")&& !ops.getText().toString().equals("sec")&& !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos")&& !ops.getText().toString().equals("(arc)tan"))&& !ops.getText().toString().equals("log")&& !ops.getText().toString().equals("ln")&& !ops.getText().toString().equals("sqrt")&& !ops.getText().toString().equals("10^")){


                    sci_used = true;
                    operator2.setText("ln");
                    operator2.setVisibility(View.VISIBLE);

                }

                break;

            case R.id.backsp:
                visual();

                if (n2isfilled) {

                    String str = n2.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);      //deleting 1 element with every touch
                        n2.setText(str);
                    } else if (str.length() <= 1) {
                        n2.setText("0");
                        n2isfilled = false;
                    }


                } else if (!n2isfilled && !operator2.getText().toString().equals("")) {
                    operator2.setText("");
                    operator2.setVisibility(View.GONE);
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    ops.setText(".");

                } else if (!n2isfilled && ops.getText().toString().equals(".") && n1isfilled) {
                    String str = n1.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);
                        n1.setText(str);
                    } else if (str.length() <= 1) {
                        n1.setText("0");
                        n1isfilled = false;
                    }
                } else if (!n1isfilled && !n2isfilled) {
                    n1.setText("0");
                    n2.setText("0");
                }


                if (!operator2.isShown()) {
                    if(n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        n2isfilled = false;
                    }
                    if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                    else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    if(ans.toString().contains("E"))
                        res.setText(ans_setting(ans));

                    else
                        res.setText(ans.toString());;
                } else if (operator2.isShown()) {
                    if(n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        n2isfilled = false;
                    }
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    if(ans.toString().contains("E"))
                        res.setText(ans_setting(ans));

                    else
                        res.setText(ans.toString());
                }




                break;


            case R.id.equals:

                if(!calc.isShown())
                    break;


                calc.setVisibility(View.GONE);
                angle.setVisibility(View.GONE);


                // if we r using scientific calculator or have 2 operators nested, use the fragment's result method
                if ((sci_used || operator2.isShown()) && eq != 1) {
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    if(ans.equals(NaN)){
                        res.setText("NaNi");
                        equalispressed = true;
                        f = 0;
                        sci_used = false;
                        sci_ops = false;
                        eq = 0;
                        break;
                    }

                    if(ans.toString().contains("E"))
                        res.setText(ans_setting(ans));


                    else {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());

                    }


                } else {

                    if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if (!ans.equals( NaN)) {
                            if(ans.toString().contains("E"))
                                res.setText(ans_setting(ans));


                            else {
                                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                                res.setText(ans.toString());

                            }

                        } else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText("NaNi");
                            equalispressed = true;
                            f = 0;
                            sci_used = false;
                            sci_ops = false;
                            eq = 0;
                            break;
                        }
                    } else if (!n2isfilled) {
                        res.setText(n1.getText().toString());

                    } else if (!n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        res.setText(n2.getText().toString());
                    }


                }

                equalispressed = true;
                f = 0;
                sci_used = false;
                sci_ops = false;
                eq = 0;

                operator2.setText("");
                operator2.setVisibility(View.GONE);


                break;


            case R.id.c:
                resetall();
                equalispressed = false;
                break;
        }


        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resetall();
                equalispressed = false;
                return true;
            }
        });
    }


    Double result(String n1, String n2, String ops) {

        if (n1.equals("\u03C0")) {
            Double PI = Math.PI;
            PI=Math.round(PI*1000000.0)/1000000.0;
            n1 = PI.toString();
        }

        if (n1.equals("e")) {
            Double E = Math.E;
            E=Math.round(E*1000000.0)/1000000.0;
            n1 = E.toString();
        }

        if (n2.equals("\u03C0")) {
            Double PI = Math.PI;
            PI=Math.round(PI*1000000.0)/1000000.0;
            n2 = PI.toString();
        }

        if (n2.equals("e")) {
            Double E = Math.E;
            E=Math.round(E*1000000.0)/1000000.0;
            n2 = E.toString();
        }


        if (n2.contains("%")) {

            int len = n2.length();

            if (n2.charAt(len - 1) == '%') {
                String val = n2.substring(0, len - 1);

                temp = (Double.parseDouble(val) / 100d) * Double.parseDouble(n1);

                n2 = temp.toString();

            } else if (n2.charAt(len - 1) != '%') {

                int index = n2.indexOf("%");

                String perc = n2.substring(0, (index));  // getting percentage
                String num = n2.substring(index + 1, len);  // getting number to process

                temp = Double.parseDouble(perc) / 100d * Double.parseDouble(num);

                n2 = temp.toString();

            }
        }

        if(n2.contains("e")){


            if(n2.charAt(0) == 'e'){
                res.setText("Syntax Error");
                return Double.parseDouble(n1);
            }

            int len = n2.length();

            int index = n2.indexOf("e");

            String num = n2.substring(0, (index));  // getting percentage
            String pow = n2.substring(index + 1, len);  // getting number to process

            if(!pow.equals(""))
                temp = Double.parseDouble(num) * Math.pow(10d,Double.parseDouble(pow));

            else
                temp = Double.parseDouble(num)*Math.E;

            n2 = temp.toString();

        }

        if(n2.contains("\u03C0")){


            if(n2.charAt(0) == '\u03C0'){
                res.setText("Syntax Error");
                return Double.parseDouble(n1);
            }

            int len = n2.length();

            int index = n2.indexOf("\u03C0");

            String num = n2.substring(0, (index));  // getting percentage
            //String pow = n2.substring(index + 1, len);  // getting number to process


            temp = Double.parseDouble(num)*Math.round(Math.PI*1000000.0)/1000000.0;

            n2 = temp.toString();

        }

        if(n2.contains("^")){

            int len = n2.length();

            int index = n2.indexOf("^");

            String num = n2.substring(0, (index));  // getting percentage
            String pow = n2.substring(index + 1, len);  // getting number to process

            if(!pow.equals(""))

                temp = Math.pow(Double.parseDouble(num),Double.parseDouble(pow));

            else
                temp = Double.parseDouble(num);

            n2 = temp.toString();

        }

        switch (ops) {

            case "+":

                ans_d = Double.parseDouble(n1) + Double.parseDouble(n2);

                break;
            case "-":

                ans_d = Double.parseDouble(n1) - Double.parseDouble(n2);

                break;
            case "X":

                ans_d = Double.parseDouble(n1) * Double.parseDouble(n2);

                break;

            case "/":
                if (!n2.equals("0")) {

                    ans_d = Double.parseDouble(n1) / Double.parseDouble(n2);
                } else ans_d = -99999d;
                break;


            case "REM":
                ans_d = Double.parseDouble(n1) % Double.parseDouble(n2);

                break;

            case "sqrt":

                if(Double.parseDouble(n2)<0){
                    res.setText("NaNi");
                    return NaN;
                }


                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.sqrt(Double.parseDouble(n2)))
                        : java.lang.Math.sqrt(Double.parseDouble(n2));

//                if(ans_d.equals(NaNi)) {
//                    res.setText("Nani");
//                    //return -99999d;
//                }
//
//                else{
//                    ans_d = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
//                    res.setText(ans_d.toString());
//                }
                break;

            case "log":

                if(Double.parseDouble(n2)<=0){
                    res.setText("NaNi");
                    return NaN;
                }

                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log10(Double.parseDouble(n2)))
                        : java.lang.Math.log10(Double.parseDouble(n2));
                break;

            case "ln":

                if(Double.parseDouble(n2)<=0){
                    res.setText("NaNi");
                    return NaN;
                }

                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log(Double.parseDouble(n2)))
                        : java.lang.Math.log(Double.parseDouble(n2));
                break;

            case "^":


                ans_d = java.lang.Math.pow(Double.parseDouble(n1), Double.parseDouble(n2));
                break;

            case "e":

                ans_d = Double.parseDouble(n1) * java.lang.Math.pow(10d, Double.parseDouble(n2));
                break;

            case "10^":

                ans_d = java.lang.Math.pow(10d, Double.parseDouble(n2));
                break;

            case "%":
                if (!n2isfilled) {
                    ans_d = Double.parseDouble(n1) / 100d;
                } else if (n2isfilled && !n2.contains("%")) {
                    ans_d = (Double.parseDouble(n1) / 100d) * Double.parseDouble(n2);
                }

                break;

            case "." : ans_d=0d;


        }

        return ans_d;

    }


    void reset() {

        ops.setText(".");
        n2.setText("0");
        n2isfilled = false;
        res.setText("");

        if(operator2.isShown()){
            operator2.setText("");
            operator2.setVisibility(View.GONE);
        }
    }

    void resetall() {


        n1.setText("0");
        n1isfilled = false;

        n2.setText("0");
        n2isfilled = false;



        ops.setText(".");

        res.setText("0");

        if (operator2.getVisibility() == View.VISIBLE) {
            operator2.setText("");
            operator2.setVisibility(View.GONE);
        }

        sci_used = false;
        sci_ops = false;


    }



    void visual() {


        calc.setVisibility(View.VISIBLE);
        angle.setVisibility(View.VISIBLE);

    }

    String ans_setting(Double ans){

        String temp = ans.toString();

        int index = temp.indexOf("E");

        String num = temp.substring(0,index);
        String e_pow = temp.substring(index,temp.length());

        // taking 8 digits upto E
        Double num1 = Double.parseDouble(num);
        num1 = Math.round(num1.doubleValue() * 100000000.0) / 100000000.0;

        String final_num = num1.toString()+e_pow;

        return final_num;

    }

    String ans_small(Double ans){
        String temp = ans.toString();

        int index = temp.indexOf("E");

        String num = temp.substring(0,index);
        String e_pow = temp.substring(index,temp.length());

        // taking 4 digits upto E
        Double num1 = Double.parseDouble(num);
        num1 = Math.round(num1.doubleValue() * 100.0) / 100.0;

        String final_num = num1.toString()+e_pow;

        return final_num;



    }


}