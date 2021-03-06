/*
 *  KUVEYT TÜRK PARTICIPATION BANK INC.
 *
 *   Developed under MIT License
 *   Copyright (c) 2018
 *
 *   Author : Fikri Aydemir
 *   Last Modified at : 17.04.2018 17:10
 *
 *
 */

package tr.com.kuveytturk.android.sdk.receivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import tr.com.kuveytturk.android.sdk.api.ResponseHandlingFacade;
import tr.com.kuveytturk.android.sdk.util.Constants;

public class PostResponseBroadcastReceiver<T extends Activity & ResponseHandlingFacade> extends BroadcastReceiver {
    private T mResponseAcceptorActivity;

    public PostResponseBroadcastReceiver(T responseAcceptorActivity){
        mResponseAcceptorActivity = responseAcceptorActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String responseBody = intent.getStringExtra(Constants.KT_POST_SERVICE_PAYLOAD);
        mResponseAcceptorActivity.onPostResponseReceivedFromKTAPI(responseBody);
    }
}
