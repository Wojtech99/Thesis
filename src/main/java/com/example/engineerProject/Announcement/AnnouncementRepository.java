package com.example.engineerProject.Announcement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
interface AnnouncementRepository extends CrudRepository<Announcement, Long> {

    Set<Announcement> findAllByUser_Id(Long userId);

    @Query(value = "select a from announcement a")
    Set<Announcement> getAll();

    Optional<Announcement> findById(Long announcementId);

    Set<Announcement> findAllByIsHighlighted(@Param("isHighlighted") Boolean status);
}
