package com.sparta.deal.manager.application;

import com.sparta.deal.manager.domain.Authorization;
import com.sparta.deal.manager.domain.Resource;
import com.sparta.deal.manager.infra.AuthorizationJpaRepository;
import com.sparta.deal.manager.infra.ResourceJpaRepository;
import com.sparta.deal.security.application.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SiteService {

    @Autowired
    private ResourceJpaRepository resourceJpaRepository;

    @Autowired
    private AuthorizationJpaRepository authorizationJpaRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;


    /**
     * @todo 추후, Redis Cache 로 저장하는 형태로 변경
     * @return
     * @throws Exception
     */
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> findRoleResources() {
        LinkedHashMap<String, List<ConfigAttribute>> initData = new LinkedHashMap<>();
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap = new LinkedHashMap<>();
        // DB 조회 권한별리소스 조회
        List<Resource> resources = resourceJpaRepository.findAll();
        if (resources != null) {
            for (Resource resource : resources) {
                List<ConfigAttribute> roles = new LinkedList<>();
                for (Authorization role : resource.getAuthorizations()) {
                    // 리소스에 해당하는 권한 리스트
                    roles.add(new SecurityConfig(role.getName()));
                }
                roles.add(new SecurityConfig("ROLE_ADMIN"));
                initData.put(resource.getName(), roles);

                requestMap.put(new AntPathRequestMatcher(resource.getName()), roles);
            }
        }
        return requestMap;
    }

    /**
     * 리소스 생성
     * @param resources 리소스 목록
     * @throws Exception
     */
    public void createResources(List<Resource> resources) throws Exception {
        resourceJpaRepository.saveAll(resources);
    }

    /**
     * 리소스 생성
     * @param resource 리소스
     * @throws Exception
     */
    public void createResource(Resource resource) throws Exception {
        resourceJpaRepository.save(resource);
    }


    /**
     * 권한 목록을 생성한다.
     * @param authorizations 권한 목록
     */
    public void createAuthorizations(List<Authorization> authorizations) {
        authorizationJpaRepository.saveAll(authorizations);
    }

}
