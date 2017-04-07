package linlin.com.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaopenglin on 2017/4/6.
 */

public class Student implements Parcelable{
    private String name;
    private int age;
    private long number;

    public Student() {
    }

    public Student(String name, int age, long number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Student(Parcel in) {//注意：这里的name  age  number 的
                                  // 读取顺序和下面writeToParcel()方法里面的顺序要一致，否则出错
        name = in.readString();
        age = in.readInt();
        number = in.readLong();
    }

    //记住这也是个变量，一个匿名对象
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[0];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
        age = dest.readInt();
        number = dest.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeLong(number);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }
}
