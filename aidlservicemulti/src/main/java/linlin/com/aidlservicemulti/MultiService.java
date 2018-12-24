package linlin.com.aidlservicemulti;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import linlin.com.service.IMyAidlInterface;

public class MultiService extends Service {

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return 0;
        }

        @Override
        public int multi(int a, int b) throws RemoteException {
            return a * b;
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
