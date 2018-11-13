package com.thinkman.getdeviceinfo;

import android.Manifest;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_imei)
    TextView m_tvImei = null;

    @BindView(R.id.tv_imsi)
    TextView m_tvImsi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MainActivityPermissionsDispatcher.initUIWithCheck(this);
    }

    @OnClick(R.id.btn_get)
    public void onGetClick() {
        MainActivityPermissionsDispatcher.initUIWithCheck(this);
    }

    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    public void initUI() {
        TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        m_tvImei.setText("imei: " + tm.getDeviceId());
        m_tvImsi.setText("imsi: " + tm.getSubscriberId());
    }


}
