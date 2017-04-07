// IMyAidlInterface.aidl
package linlin.com.service;

//导入所需要使用的非默认支持数据类型的包,记住要导入一下。刚刚学不知道怎么自动导入所以手动导入了
import linlin.com.service.Student;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add( int num1 , int num2);
    List<Student> addStudent(in Student student);//这里的in 一定需要的  或者out
}
