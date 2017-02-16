package gautam.easydevelope.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by gautam on 2/16/2017.
 */

public class WindowUtils {
    private Context mContext;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;

    private int windowWidth;
    private int windowHeight;


    public WindowUtils(Context mContext) {
        this.mContext = mContext;
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    public static WindowUtils with(Context context){
        return  new WindowUtils(context);
    }

    public int getWindowWidth() {
        windowWidth = displayMetrics.widthPixels;
        return windowWidth;
    }

    public int getWindowHeight() {
        windowHeight = displayMetrics.heightPixels;
        return windowHeight;
    }

}
