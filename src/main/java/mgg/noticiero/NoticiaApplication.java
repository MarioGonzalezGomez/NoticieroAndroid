package mgg.noticiero;

import android.app.Application;

public class NoticiaApplication extends Application {
    public static Preferences pref;

    @Override
    public void onCreate() {
        super.onCreate();
        pref = new Preferences(getBaseContext());
    }
}
