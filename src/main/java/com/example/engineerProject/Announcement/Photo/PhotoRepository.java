package com.example.engineerProject.Announcement.Photo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {

    void deleteByName(String photoName);
}
