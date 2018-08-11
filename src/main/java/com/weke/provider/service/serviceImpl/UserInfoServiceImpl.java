package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.User;
import com.weke.provider.domain.UserPermission;
import com.weke.provider.dto.UserPasswordDTo;
import com.weke.provider.exception.UsernameIsExitedException;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.mapper.UserPermissionMapper;
import com.weke.provider.service.UserInfoService;
import com.weke.provider.vo.PhoneEmailVo;
import com.weke.provider.vo.UserInfoVo;
import com.weke.provider.vo.UserParam;
import com.weke.provider.vo.UserPhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Environment environment;

    @Override
    public Boolean registerUser(UserParam userParam) {
        if (!checkSmsCode(userParam.getPhone(),userParam.getCode())) {
            return false;
        }
        User user = userMapper.getUserName(userParam.getUsername());
        if (null!=user) {
            return false;
        }

        userParam.setPassword(BCrypt.hashpw(userParam.getPassword(), BCrypt.gensalt()));
        User uses = new User();
        uses.setUserName(userParam.getUsername());
        uses.setUserPassword(userParam.getPassword());
        uses.setUserPhone(userParam.getPhone());
        userMapper.addUser(uses);

        UserPermission userPermission = new UserPermission();
        userPermission.setUserId(uses.getUserId());
        userPermission.setPermission("User");
        userPermissionMapper.insert(userPermission);
        return true;
    }

    @Override
    public List<UserInfoVo> getUserInfo() {
        List<User> userList = userMapper.getAllUserInfo();

        List<UserInfoVo> userInfoVoList = new ArrayList<>();

        int pos=0;
        for (User user : userList) {
            UserInfoVo userInfoVo = new UserInfoVo();
            UserPermission userPermission = userPermissionMapper.getByUserId(user.getUserId());
            userInfoVo.setKey(pos++);
            userInfoVo.setUserAddress(user.getUserAddress());
            userInfoVo.setUserAdmin(userPermission.getPermission());
            userInfoVo.setUserJob(user.getUserJob());
            userInfoVo.setUserName(user.getUserName());
            userInfoVo.setUserSex(user.getUserSex());
            userInfoVoList.add(userInfoVo);
        }
        return userInfoVoList;
    }

    @Override
    public void setUserAdmin(UserInfoVo userInfoVo) {
        Integer userId = userMapper.getIdByName(userInfoVo.getUserName());
        userPermissionMapper.updateUserAdmin(userId,userInfoVo.getUserAdmin());
    }

    @Override
    public void createSmsCode(String phone) {
        //生成验证码
        String smsCode = (long)(Math.random()*1000000)+"";

        //将验证码存入redis
        redisTemplate.opsForValue().set(phone,smsCode);

        Map<String,String> map = new HashMap<>();
        map.put("phoneNumbers",phone);
        map.put("signName",environment.getProperty("sms.signName"));
        map.put("templateCode",environment.getProperty("sms.templateCode"));

        String templateParam = "{\"number\":" + smsCode +
                "}";

        map.put("templateParam" , templateParam);

        jmsMessagingTemplate.convertAndSend("sms",map);
    }

    @Override
    public boolean checkSmsCode(String phone, String smsCode) {

        String systemCod = (String) redisTemplate.opsForValue().get(phone);
//        System.out.println(smsCode+" "+systemCod);
        if (systemCod == null) {
            return false;
        }

        if (!systemCod.equals(smsCode)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setPassword(UserPasswordDTo userPasswordDTo) {
        User user = userMapper.getUserName(userPasswordDTo.getUserName());
        Boolean isOk = BCrypt.checkpw(userPasswordDTo.getPassword(),user.getUserPassword());

        if (!isOk) {
            return false;
        }
        String currentPassword = BCrypt.hashpw(userPasswordDTo.getCurrentPassword(), BCrypt.gensalt());
        userMapper.updateUserPassword(userPasswordDTo.getUserName(),currentPassword);
        return true;
    }

    @Override
    public UserPhotoVo getUserPhoto(String userName) {
        User user = userMapper.getUserName(userName);
        UserPhotoVo userPhotoVo = new UserPhotoVo();
        userPhotoVo.setPhotoUrl(user.getUserPhoto());
        return userPhotoVo;
    }

    @Override
    public PhoneEmailVo getPhoneEmail(String userName) {
        User user = userMapper.getUserName(userName);
        PhoneEmailVo phoneEmailVo = new PhoneEmailVo();
        phoneEmailVo.setUserEmail(user.getUserEmail());
        phoneEmailVo.setUserPhone(user.getUserPhone());
        return phoneEmailVo;
    }
}
