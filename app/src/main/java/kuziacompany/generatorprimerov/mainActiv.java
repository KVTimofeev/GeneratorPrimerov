package kuziacompany.generatorprimerov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import junit.framework.Test;

import java.util.SimpleTimeZone;

public class mainActiv extends AppCompatActivity implements View.OnClickListener{
    Button toTrain, toTest;
    TextView Menu, Size;
    SimpleTimeZone timeZone;
    ImageView imgFon;



    protected void onCreate(Bundle savedInstanceState){
        StackTraceElement[] tr=  Thread.currentThread().getStackTrace();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_main);
        toTrain = (Button)findViewById(R.id.Trening);
        toTest = (Button)findViewById(R.id.testing);
        toTest.setOnClickListener(this);

        toTrain.setOnClickListener(this);

        imgFon = (ImageView)findViewById(R.id.imagFon);
        imgFon.setImageResource(R.drawable.fon);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case(R.id.Trening):
                Intent intentStretch = new Intent(this, Stretch.class);
            startActivity(intentStretch);
            break;
            case(R.id.testing):
                Intent intentTest = new Intent(this, test.class);
                startActivity(intentTest);
                break;


        }
    }


}
