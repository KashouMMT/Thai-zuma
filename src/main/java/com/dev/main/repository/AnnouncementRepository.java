package com.dev.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.main.model.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long>{
	
	List<Announcement> findTop5ByOrderByUpdatedAtDesc();
}
