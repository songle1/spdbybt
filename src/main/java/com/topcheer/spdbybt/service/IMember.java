package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.Member;

public interface IMember {
    Member login(String name, String passsword) throws Exception;
}
