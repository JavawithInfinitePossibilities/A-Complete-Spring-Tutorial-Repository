package com.tutorials.sid.spring.repos;

import com.tutorials.sid.spring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kunmu On 25-07-2026
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
