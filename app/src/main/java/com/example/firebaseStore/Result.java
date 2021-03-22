package com.example.firebaseStore;

public class Result {
    int num1, num2;
    int results;

    public Result() {
    }

    public Result(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }
    public int results(int num1, int num2){
        results=num1+num2;
        return results;
    }

}
