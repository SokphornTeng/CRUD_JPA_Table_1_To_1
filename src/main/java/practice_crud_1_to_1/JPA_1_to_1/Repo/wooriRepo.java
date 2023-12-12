package practice_crud_1_to_1.JPA_1_to_1.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;

@Repository
public interface wooriRepo extends JpaRepository<wooriBank, Long> {
    boolean existsByStaff(String staff);
}
