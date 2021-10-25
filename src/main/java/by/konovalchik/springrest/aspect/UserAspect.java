package by.konovalchik.springrest.aspect;


import by.konovalchik.springrest.entity.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;


@Aspect
@Configuration
public class UserAspect {
    private  final Logger logger = LoggerFactory.getLogger(UserAspect.class.getName());



    @Pointcut(value = "execution(public * by.konovalchik.springrest.controller.UserController.save(..)) && args(user,..) ", argNames = "user")
    public void saveUserAspect(User user){}


    @AfterReturning(value = "saveUserAspect(user)", returning = "flag", argNames = "flag,user")
    public void saveUserCreate(Boolean flag, User user){
        if(flag) {
            logger.info("User {} signed in!", user.getUsername());
        }
    }



    @Pointcut(value = "execution(public * by.konovalchik.springrest.controller.UserController.deleteByUsername(..)) && args(username,..) ", argNames = "username")
    public void deleteUserAspect(String username){}


    @AfterReturning(value = "deleteUserAspect(username)", returning = "flag", argNames = "flag,username")
    public void saveLog(Boolean flag, String username){
        if(flag) {
            logger.info("User {} has been deleted!", username);
        }
    }



    @Pointcut(value = "execution(public * by.konovalchik.springrest.controller.UserController.update(..)) && args(username,user,..) ", argNames = "username, user")
    public void updateUserAspect(String username, User user){}


    @AfterReturning(value = "updateUserAspect(username, user) ", returning = "flag", argNames = "flag,username,user")
    public void saveLog(Boolean flag, String username, User user) {
        if (flag) {
            logger.info("User {} has been updated!", username);
        }

    }






}
