package com.github.zuegi.dddgeschaeftpoc.domain.repository;

import com.github.zuegi.dddgeschaeftpoc.domain.Geschaeft;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftIdentifier;
import com.github.zuegi.dddgeschaeftpoc.domain.GeschaeftSchonErfasstException;
import com.github.zuegi.dddgeschaeftpoc.domain.user.User;
import com.github.zuegi.dddgeschaeftpoc.domain.user.UserId;

import java.util.*;

public class UserRepository {

    Map<UserId, User> userMap = new HashMap<>();

    public void add(User user) {
        this.userMap.put(user.userId(), user);
    }

    public void addAll(Map<UserId, User> map) {
        this.userMap.putAll(map);
    }

    public User get(UserId userId) {
        return this.userMap.get(userId);
    }

    public Collection<User> findAll() {
        return this.userMap.values();
    }
}
