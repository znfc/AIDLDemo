package linlin.com.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import linlin.com.service.Student;
import linlin.com.service.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1,num2;
    private TextView result,text;
    private Button measure;
    private IMyAidlInterface iMyAidl;
    /**
     * 这个conn也是一个变量
     * 准确说是个匿名对象
     * 不是什么方法，切记这样理解
     */
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("zhao11", "ServiceConnection :onServiceConnected方法调用了");
            iMyAidl = IMyAidlInterface.Stub.asInterface(service);
            Log.i("TAG", "bind service successful");
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidl = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        measure = (Button) findViewById(R.id.measure);
        result = (TextView) findViewById(R.id.result);
        text = (TextView) findViewById(R.id.text);
        measure.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("zhao11",this.getClass().getSimpleName()+ ": onStart方法调用了");
        bindService();
    }

    @Override
    public void onClick(View v) {
        try {
            int tempNum1 = Integer.parseInt(num1.getText().toString());
            int tempNum2 = Integer.parseInt(num2.getText().toString());
            int i = iMyAidl.add(tempNum1,tempNum2);
            result.setText("" + i);
            ArrayList<Student> students = (ArrayList<Student>) iMyAidl.addStudent(new Student("张三",22,1102004));
            text.setText(students.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("linlin.com.aidlservice","linlin.com.aidlservice.IRemoteService"));
        bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
