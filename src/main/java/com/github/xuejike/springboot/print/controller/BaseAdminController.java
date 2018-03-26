package com.github.xuejike.springboot.print.controller;

import com.bidanet.bdcms.core.bean.AjaxCallBack;
import com.bidanet.bdcms.core.bean.ApiResult;
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
    public ApiResult noLogin(){
        ApiResult apiResult = ApiResult.timeout();
        return apiResult;

    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ApiResult errorMsg(BaseException e) {
        ApiResult apiResult = ApiResult.error(e.getMessage());
        return apiResult;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult exception(Exception e){
        e.printStackTrace();
        ApiResult apiResult = ApiResult.error(e.getMessage());
        return apiResult;
    }

}
