package com.enjoy.controller;

import com.enjoy.api.RedisOperationRemoteService;
import com.enjoy.util.CrowdConstant;
import com.enjoy.util.CrowdUtils;
import com.enjoy.util.ResultCode;
import com.enjoy.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private RedisOperationRemoteService redisOperationRemoteService;

    @RequestMapping("/member/manager/send/code")
    public ResultEntity sendCode(@RequestParam("phoneNum") String phoneNum) {

        if (!CrowdUtils.strEffectiveCheck(phoneNum)) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_PHONE_NUM_INVALID);
        }

        // 1.生成验证码
        int length = 4;
        String randomCode = CrowdUtils.randomCode(length);

        // 2.保存到Redis
        Integer timeoutMinute = 15;

        String normalKey = CrowdConstant.REDIS_RANDOM_CODE_PREFIX + phoneNum;

        ResultEntity resultEntity = redisOperationRemoteService.saveNormalStringKeyValue(normalKey, randomCode, timeoutMinute);

        if (ResultCode.SUCCESS.code().equals(resultEntity.getCode())) {
            //发送短信
            // CrowdUtils.sendShortMessage(appcode, randomCode, phoneNum);

        }
        return resultEntity;
    }
}
