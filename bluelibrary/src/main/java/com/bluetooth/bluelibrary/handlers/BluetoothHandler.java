package com.bluetooth.bluelibrary.handlers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

import com.bluetooth.bluelibrary.utils.SimpleBluetoothListener;

/**
 * Created by Amar
 * A handler for receiving messages from the bluetooth device.
 */
public class BluetoothHandler extends Handler {
    public static final int MESSAGE_READ = 121;
    public static final int MESSAGE_WAIT_FOR_CONNECTION = 143;
    public static final int MESSAGE_CONNECTION_MADE = 155;
    public static final int MESSAGE_A2DP_PROXY_RECEIVED = 157;
    public SimpleBluetoothListener mListener;
    public Activity mActivity;
    public ProgressDialog dialog;
    public boolean shouldShowSnackbars;

    /**
     * Bluetooth Handler class for handling messages from the bluetooth device.
     * @param listener listener for simple bluetooth.
     * @param context reference context.
     */
    public BluetoothHandler(SimpleBluetoothListener listener, Context context) {
        this.mListener = listener;
        if(context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        dialog = new ProgressDialog(context);
    }

    public void setShowSnackbars(boolean show) {
        this.shouldShowSnackbars = show;
    }
}
