package com.mouse.cookie.zxingtest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.covics.zxingscanner.OnDecodeCompletionListener;
import com.covics.zxingscanner.ScannerView;

public class MainActivity extends AppCompatActivity implements OnDecodeCompletionListener{

    private ScannerView mScannerView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScannerView = (ScannerView)findViewById(R.id.sv_mainactivity);
        mTextView = (TextView)findViewById(R.id.tv_mainactivity);

        mScannerView.setOnDecodeListener(this);
    }

    @Override
    public void onDecodeCompletion(String s, String s1, Bitmap bitmap) {
        mTextView.setText(s1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //打开相机和闪光
        mScannerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.onPause();
    }
}
