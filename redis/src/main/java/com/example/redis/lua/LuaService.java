package com.example.redis.lua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sjw
 * @Description
 * @Date 12:19 2022/10/4
 **/
@Service
public class LuaService {

//    @Autowired
//    private JedisCluster jedisCluster;
@Autowired
private Jedis jedis;

    /**
     * 当lua脚本在执行的时候，redis不会有其他脚本和命令同时执行，这种语义类似于 MULTI/EXEC。
     * 从别的客户端的视角来看，一个lua脚本要么不可见，要么已经执行完。
     * 然而这也意味着，执行一个较慢的lua脚本是不建议的，由于脚本的开销非常低，构造一个快速执行的脚本并非难事。
     * 但是要注意到，当你正在执行一个比较慢的脚本时，所以其他的客户端都无法执行命令。
     *
     *  redis 使用lua脚本的优势
     * 高效性：减少网络开销及时延，多次redis服务器网络请求的操作，使用LUA脚本可以用一个请求完成
     * 数据可靠性：Redis会将整个脚本作为一个整体执行，中间不会被其他命令插入（这个很重要）。
     * 复用性：LUA脚本执行后会永久存储在Redis服务器端，其他客户端可以直接复用
     * 便捷性：实现程序热更新
     * 可嵌入性：可嵌入JAVA，C#等多种编程语言，支持不同操作系统跨平台交互
     * 简单强大：小巧轻便，资源占用率低，支持过程化和对象化的编程语言
     * 免费开源：遵循MIT Licence协议，可免费商用化
     */
    public String updateRedisByLua(){
        String script ="if (redis.call('exists',KEYS[1]) == 1) then\n" +
                "    local val = redis.call(\"get\",KEYS[1])\n" +
                "    val = val + 1\n" +
                "    if redis.call(\"set\",KEYS[1], val) then\n" +
                "        return \"update success\"\n" +
                "    else\n" +
                "        return \"update error\"\n" +
                "    end\n" +   
                "else\n" +
                "    return \"key is not found\"\n" +
                "end" ;
        List<String> keys = new ArrayList<>();
        keys.add("detailId");
        List<String> params = new ArrayList<>();
        params.add("1");
        Object res = jedis.eval(script, keys, params);
        System.out.println(res.toString());
        return res.toString();
    }

    public void updateRedis(){
        String script ="";
        String val = jedis.get("key");
        int val_ = Integer.parseInt(val);
        val_++;
        jedis.set("key", val_+"");
    }
}
