package kr.co.crescentcorp.buddytest.chat;

import android.app.Application;
import android.provider.SyncStateContract;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 * Created by GingerAebi on 2016. 5. 18..
 */
public class ChatApplication extends Application {
    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("188.166.210.190:80");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
