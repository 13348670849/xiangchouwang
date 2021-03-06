package com.enjoy.api;


import com.enjoy.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="redis-provider")
public interface RedisOperationRemoteService {

    /**
     * 将字符串类型的键值对保存到Redis时调用的远程方法
     * @param normalKey
     * @param normalValue
     * @param timeoutMinute 超时时间（单位：分钟）
     *      -1表示无过期时间
     *      正数表示过期时间分钟数
     *      0和null值不接受
     * @return
     */
    @RequestMapping("/save/normal/string/key/value")
    ResultEntity saveNormalStringKeyValue(@RequestParam("normalKey") String normalKey,
                                          @RequestParam("normalValue") String normalValue,
                                          @RequestParam("timeoutMinute") Integer timeoutMinute);

    /**
     * 根据key查询对应value时调用的远程方法
     * @param normalKey
     * @return
     */
    @RequestMapping("/retrieve/string/value/by/string/key")
    ResultEntity retrieveStringValueByStringKey(@RequestParam("normalKey") String normalKey);

    /**
     * 根据key删除对应value时调用的远程方法
     * @param key
     * @return
     */
    @RequestMapping("/redis/remove/by/key")
    ResultEntity removeByKey(@RequestParam("key") String key);
}
