package com.tenement.api.controller;



import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.UserLogin;
import com.tenement.domain.po.SysMenu;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.SysMenuService;
import com.tenement.service.api.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


/**
 * 用户信息
 */
@RestController
@RequestMapping("/house/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;




    @Autowired
    private RedisLockRegistry redisLockRegistry;

    /**
     * 登陆
     *
     * @param req
     * @param request
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/login")
    public Response login(HttpServletRequest request, @RequestBody @Valid UserLogin req) throws BusinessException {



        SysUserVo sysUser = sysUserService.login(req);
        if (sysUser != null && sysUser.getPassword().equals(req.getPassword())) {
            request.getSession().setAttribute("user", sysUser);
            request.getSession().setMaxInactiveInterval(60 * 60);
            return ResponseUtils.createSuccess();
        }
        return ResponseUtils.createFailure();

    }

    /**
     * 新增用户
     *
     * @param req
     * @return
     */
    @RequestMapping("/addUser")
    public Response addUser(@RequestBody UserLogin req) throws BusinessException {


        sysUserService.addUser(req);

        return ResponseUtils.createSuccess();
    }

    /**
     * 获取菜单
     *
     * @param request
     * @return
     */
    @RequestMapping("/listMenu")
    public Response<List<SysMenu>> getMenu(HttpServletRequest request) throws BusinessException {

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            return ResponseUtils.createFailure();
        }
        List<SysMenu> sysMenuList = sysMenuService.selectByMenuList(sysUserVo.getRoleId());
        if (sysMenuList == null) {
            return ResponseUtils.createFailure();
        }
        return ResponseUtils.createSuccess(sysMenuList);

    }

    @RequestMapping("/logins")
    public Response logins(HttpServletRequest request) {


      Lock lock=redisLockRegistry.obtain("xuzhou1230000");

      try{

          boolean bool=lock.tryLock(10, TimeUnit.SECONDS);
          if(bool){

              String str="adad";
          }
      }catch (Exception e){

          return ResponseUtils.createFailure();

      }finally {
          lock.unlock();
      }

        return ResponseUtils.createFailure();


    }



}
