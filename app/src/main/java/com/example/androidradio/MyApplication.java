package com.example.androidradio;

import android.content.Context;
import android.widget.Toast;

import org.acra.*;
import org.acra.annotation.*;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.data.StringFormat;

@AcraCore(buildConfigClass = BuildConfig.class)
@AcraToast(resText = R.string.acra_toast_text, length = Toast.LENGTH_LONG)
public class MyApplication extends android.app.Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        CoreConfigurationBuilder builder = new CoreConfigurationBuilder(this);
        builder.setBuildConfigClass(BuildConfig.class).setReportFormat(StringFormat.KEY_VALUE_LIST)
                .setAlsoReportToAndroidFramework(true);
        builder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class).setMailTo("kaiku.chrash@gmail.com")
                .setSubject("Kaiku Crash Report")
                .setEnabled(true);
        ACRA.init(this, builder);
    }
}
