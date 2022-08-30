package com.premukkoji.user.service;

import com.premukkoji.user.VO.Department;
import com.premukkoji.user.VO.ResponseTemplateVO;
import com.premukkoji.user.entity.User;
import com.premukkoji.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser in UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment in UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

}
