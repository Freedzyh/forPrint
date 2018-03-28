package com.github.xuejike.springboot.print.entity.enumType;

public enum SysType {

    //0-产品，1-部件
    product,parts;



    public String cn() {
        switch (this){
            case product:
                return "产品";
            case parts:
                return "部件";
                default:
                    return "";
        }
    }
}
