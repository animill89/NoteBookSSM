package edu.cqie.controller;

import edu.cqie.entity.User;
import edu.cqie.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-12-14 16:56:24
 */
@RestController
@RequestMapping
@CrossOrigin
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /*
     * 作者：刘星
     * 2024年12月15日14:34:23
     * 登录逻辑实现
     * */
    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User u = userService.login(user.getUsername(), user.getPassword());
        System.out.print(u);

        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    /*
     * 邮箱登录功能
     * 2024年12月25日11:38:25
     * 作者：Star_Star
     * */
    @RequestMapping("/emailLogin")
    public ResponseEntity<User> emailLogin(User user, HttpSession session) {
        String code = (String) session.getServletContext().getAttribute("captcha");
        System.out.print(code);

        if (code.equals(user.getCode())) {
            // 登录成功后，移除 session 中的验证码
            session.getServletContext().removeAttribute("captcha");
            return ResponseEntity.ok(this.userService.emailLogin(user.getEmail()));
        } else {
            System.out.print("验证码错误");
            return ResponseEntity.ok(null);
        }
    }

    /*
     * 作者：刘星
     * 2024年12月15日14:34:43
     * 注册逻辑实现
     * */

    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user, HttpSession session) {
//
//        System.out.print(user);
        //从session中获取验证码
        String code = (String) session.getServletContext().getAttribute("captcha");
        System.out.print(code);
        String userCode = user.getCode();
        System.out.print(userCode);

        if (code.equals(user.getCode())) {
//            System.out.println("注册成功！！！");
            //清除session
            session.getServletContext().removeAttribute("captcha");
            return ResponseEntity.ok(this.userService.register(user));
        } else {
            System.out.println("验证码错误！！！");
            return ResponseEntity.ok(null);
        }
//        return ResponseEntity.ok(this.userService.register(user));
    }




    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        System.out.print(this.userService.queryById(id));
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping("/userupdate")
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

