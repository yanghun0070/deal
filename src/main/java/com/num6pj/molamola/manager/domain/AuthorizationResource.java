package com.num6pj.molamola.manager.domain;

import javax.persistence.*;

@Entity
@Table(name = "deal_authorization_resources")
public class AuthorizationResource {

    @EmbeddedId
    private AuthorizationResourceKey id;

    @ManyToOne
    @MapsId("resource_id")
    @JoinColumn(name = "resource_id")
    Resource resource;


    @ManyToOne
    @MapsId("authorization_id")
    @JoinColumn(name = "authorization_id")
    Authorization authorization;

    public AuthorizationResource(AuthorizationResourceKey id, Resource resource, Authorization authorization) {
        this.id = id;
        this.resource = resource;
        this.authorization = authorization;
    }
}
