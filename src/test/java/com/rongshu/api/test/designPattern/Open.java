package com.rongshu.api.test.designPattern;

public class Open implements Action {
    private final CommandAccepter editor;
    public Open(CommandAccepter editor){
        this.editor=editor;
    }
    @Override
    public void perform(){
        editor.open();
    }
}
