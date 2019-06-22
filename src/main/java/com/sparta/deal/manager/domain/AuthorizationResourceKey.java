package com.sparta.deal.manager.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuthorizationResourceKey implements Serializable {

    @Column(name = "authorization_id")
    private Integer authorizationId;

    @Column(name = "resource_id")
    private Integer resourceId;

    public AuthorizationResourceKey(Integer authorizationId, Integer resourceId) {
        this.authorizationId = authorizationId;
        this.resourceId = resourceId;
    }
}
