package org.lncr.chatdiscussion.domain.user.repository;

import org.lncr.chatdiscussion.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 사용자 이름으로 사용자 조회    
    User findByUsername(String username);
}
