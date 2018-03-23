package com.github.xuejike.springboot.print.controller;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.controller.BaseController;
import com.bidanet.bdcms.core.exception.BaseException;
import com.github.xuejike.springboot.print.exception.NoLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuejike on 2017/3/23.
 */
public class BaseAdminController extends BaseController {

    @ExceptionHandler(NoLoginException.class)
    @ResponseBody
    public AjaxCallBack noLogin(){
        AjaxCallBack ajaxCallBack = new AjaxCallBack(AjaxCallBack.STATUS_TIMEOUT, "未登录");
        return ajaxCallBack;

    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public AjaxCallBack errorMsg(BaseException e) {
        AjaxCallBack ajaxCallBack = new AjaxCallBack(AjaxCallBack.STATUS_ERROR, e.getMessage());
        ajaxCallBack.setCloseCurrent(false);
        return ajaxCallBack;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxCallBack exception(Exception e){
        e.printStackTrace();
        AjaxCallBack back = AjaxCallBack.error(e.getMessage());
        return back;
    }

}
