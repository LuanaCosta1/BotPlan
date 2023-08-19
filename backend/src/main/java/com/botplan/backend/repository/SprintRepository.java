package com.botplan.backend.repository;

import com.botplan.backend.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository  extends JpaRepository<Sprint, String> {
    Sprint findBySprintId(Long id);

}
