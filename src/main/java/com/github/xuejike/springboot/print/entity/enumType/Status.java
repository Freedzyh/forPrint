package com.github.xuejike.springboot.print.entity.enumType;

/**
 * Created by xuemingyu 2018/3/23
 */
public enum Status {
    /**
     * 启用
     */
    use,
    /**
     * 禁用
     */
    disable;

    public String cn() {
        switch (this) {
            case use:
                return "启用";
            case disable:
                return "禁用";
            default:
                return "未知状态";
        }
    }
}
