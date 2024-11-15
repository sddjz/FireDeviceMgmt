package com.example.mybatis_demo.entity.auth;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.mybatis_demo.entity.Logonuser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

//for deserialization
@JsonIgnoreProperties(ignoreUnknown = true,value = {"authorities","enabled"})
public class LoginUser implements UserDetails {
    @JsonProperty("user")
    private Logonuser user;

    @JsonProperty("permissions")
    private List<String> permissions;

    //@JSONField(serialize = false)
    @JsonIgnoreProperties
    private List<GrantedAuthority> authorities;

    @JsonProperty("enabled")
    private boolean enabled;


    public  LoginUser(Logonuser user, List<String> permissions, List<GrantedAuthority> authorities){
        this.user = user;
        this.permissions = permissions;
        this.authorities = authorities;

    }
    //for deserialization
    public  LoginUser(){

    }

    public LoginUser(Logonuser user,List<String> permissions){
        this.user =user;
        this.permissions = permissions;
    }

    public List<String> getPermissions() {
        return permissions;
    }


    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.authorities!=null)
            return this.authorities;
        authorities = this.permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return this.authorities;
    }

    public  void setAuthorities(List<GrantedAuthority> authorities){
        this.authorities = authorities;
    }


    public Logonuser getUser() {
        return user;
    }

    public void setUser(Logonuser user) {
        this.user = user;
    }
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getLogonUser();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
