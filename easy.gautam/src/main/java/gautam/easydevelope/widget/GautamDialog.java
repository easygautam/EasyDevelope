package gautam.easydevelope.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import gautam.easydevelope.utils.ParamUtils;

public class GautamDialog {
    private final String TAG = getClass().getSimpleName();
    private Context mContext;
    private Dialog mDialog;
    private String info;
    private View view;
    private boolean fillWidthToWindow;
    private boolean fillHeightToWindow;
    WindowManager.LayoutParams layoutParams;

    public GautamDialog(Context mContext, View view) {
        this.mContext = mContext;
        this.mDialog = new Dialog(mContext);
        this.view = view;
        initDialog(view);
    }

    public static GautamDialog with(Context gContext, View view) {
        return new GautamDialog(gContext, view);
    }

    private void initDialog(View view) {
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(view);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialog.getWindow().getAttributes());
        layoutParams.height = ParamUtils.WRAP_CONTENT;
        layoutParams.width = ParamUtils.WRAP_CONTENT;
        mDialog.getWindow().setAttributes(layoutParams);
        setGravity(Gravity.CENTER);
    }

    public void setWidth(int width) {
        layoutParams.width = width;
        mDialog.getWindow().setAttributes(layoutParams);
    }

    public Dialog getDialog(){
        return mDialog;
    }

    public void setHeight(int height) {
        layoutParams.height = height;
        mDialog.getWindow().setAttributes(layoutParams);
    }

    public void setCancelable(boolean flag) {
        mDialog.setCancelable(flag);
    }


    public void setCanceledOnTouchOutside(boolean cancel) {
        mDialog.setCanceledOnTouchOutside(cancel);
    }

    public void setGravity(int gravity) {
        mDialog.getWindow().setGravity(gravity);
    }

    public void show() {
        if (!mDialog.isShowing())
            mDialog.show();
    }

    public void dismiss() {
        if (mDialog.isShowing())
            mDialog.dismiss();
    }

}
