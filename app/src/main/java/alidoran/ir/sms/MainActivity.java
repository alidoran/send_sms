package alidoran.ir.sms;

import android.Manifest;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static Context context;
    Button btnsend;
    EditText edtnumber;
    EditText edtmessage;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        context=MainActivity.this;


        ActivityCompat.requestPermissions ( MainActivity.this , new String[]{Manifest.permission.RECEIVE_SMS} , 1 );
        ActivityCompat.requestPermissions ( MainActivity.this , new String[]{Manifest.permission.SEND_SMS} , 2 );
        ActivityCompat.requestPermissions ( MainActivity.this , new String[]{Manifest.permission.READ_SMS} , 3 );

        edtmessage = findViewById ( R.id.edtmessage );
        edtnumber = findViewById ( R.id.edtnumber );
        btnsend = findViewById ( R.id.btnsend );

        btnsend.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                String number = edtnumber.getText ( ).toString ( );
                String text = edtmessage.getText ( ).toString ( );
                SmsManager manager = SmsManager.getDefault ( );
                manager.sendTextMessage ( number , null , text , null , null );

            }
        } );
    }
}
