package com.num6pj.molamola.manager.presentation.api;

import com.num6pj.molamola.manager.application.SiteService;
import com.num6pj.molamola.manager.domain.Authorization;
import com.num6pj.molamola.manager.domain.Resource;
import com.num6pj.molamola.manager.presentation.vo.ResourceVo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SiteApiController {

    @Autowired
    private SiteService siteService;

    /**
     * 유저 권한 생성
     */
    @PostMapping("/user/authorization/create")
    public void createUserAuthorization() {

    }

    /**
     * 유저 권한 목록
     */
    @GetMapping("/user/authorization/list")
    public void getUserAuthorizations() {

    }

    /**
     * 권한 생성
     * @param authorizations
     * @return
     * @throws Exception
     */
    @PostMapping("/authorization/create")
    public void createAuthorization(@RequestBody List<Authorization> authorizations) throws Exception {
        siteService.createAuthorizations(authorizations);
    }

    /**
     * 리소스 생성
     * @param resources 리소스 목록
     * @throws Exception
     */
    @PostMapping("/resources/create")
    public void create(@RequestBody List<ResourceVo> resources) throws Exception { ;
        siteService.createResources(new ModelMapper().map(resources,
                new TypeToken<List<Resource>>(){}.getType()));
    }

    /**
     * 리소스 생성
     * @param resource 리소스
     * @throws Exception
     */
    @PostMapping("/resource/create")
    public void create(@RequestBody ResourceVo resource) throws Exception {
        siteService.createResource(new ModelMapper().map(
                resource, Resource.class));
    }
}
