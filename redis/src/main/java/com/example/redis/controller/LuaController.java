package com.example.redis.controller;

import com.example.redis.lua.LuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author sjw
 * @Description
 * @Date 19:48 2022/10/4
 **/
@Controller
@RequestMapping("/lua")
public class LuaController {
    @Autowired
    LuaService luaService;
    @GetMapping("/updateByLua")
    public String updateByLua(){
        return luaService.updateRedisByLua();
    }
}
