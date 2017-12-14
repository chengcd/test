package com.ccd.test.design.state;

/**
 * Created by ccd on 2017/12/13.
 */
public class Context {
    private State state;
    public Context(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state = state;
    }

    public void method(){
        if("state1".equals(state.getValue())){
            state.method1();
        }else if("state2".equals(state.getValue())){
            state.method2();
        }
    }

}
