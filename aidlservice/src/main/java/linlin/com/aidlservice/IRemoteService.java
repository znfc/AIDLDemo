package linlin.com.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import linlin.com.service.IMyAidlInterface;

public class IRemoteService extends Service {

    private IBinder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }

        @Override
        public int multi(int a, int b) throws RemoteException {
            return 0;
        }

    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

}
