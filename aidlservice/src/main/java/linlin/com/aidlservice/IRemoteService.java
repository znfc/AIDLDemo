package linlin.com.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import linlin.com.service.IMyAidlInterface;
import linlin.com.service.Student;

public class IRemoteService extends Service {

    /**
     * 这个mBinder只是个变量，是一个初始化好的变量
     * 准确说是个匿名对象
     * 不是什么方法，切记这样理解
     */
    private IBinder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }

        @Override
        public List<Student> addStudent(Student student) throws RemoteException {
            students.add(student);
            return students;
        }
    };
    private ArrayList<Student> students;
    @Override
    public IBinder onBind(Intent intent) {
        students = new ArrayList<>();
        Log.i("zhao11","service onBind 方法调用了");
        return mBinder;
    }

}
