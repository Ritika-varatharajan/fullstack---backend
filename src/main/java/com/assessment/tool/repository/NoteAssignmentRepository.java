package com.assessment.tool.repository;

import com.assessment.tool.entity.NoteAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteAssignmentRepository extends JpaRepository<NoteAssignment, Long> {
}
