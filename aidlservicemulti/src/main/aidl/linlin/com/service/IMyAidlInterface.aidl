// IMyAidlInterface.aidl
package linlin.com.service;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add( int num1 , int num2);
    int multi( int a , int b);
}