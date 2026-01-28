package com.dev.main.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.main.dto.AnnouncementDto;
import com.dev.main.model.Announcement;
import com.dev.main.model.User;
import com.dev.main.repository.AnnouncementRepository;
import com.dev.main.service.AnnouncementService;
import com.dev.main.service.FileStorageService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	private final AnnouncementRepository announcementRepo;
	private final FileStorageService storageService;

	public AnnouncementServiceImpl(AnnouncementRepository announcementRepo, FileStorageService storageService) {
		super();
		this.announcementRepo = announcementRepo;
		this.storageService = storageService;
	}

	@Override
	public List<Announcement> getAllAnnouncements() {
		return announcementRepo.findAll();
	}
	
	@Override
	public List<Announcement> getFirstFiveAnnouments() {
		return announcementRepo.findTop5ByOrderByUpdatedAtDesc();
	}

	@Override
	public Announcement getAnnouncementById(Long id) {
		return announcementRepo.findById(id).orElse(null);
	}

	@Override
	public void createAnnouncement(AnnouncementDto announcementDto,User user) {
		Announcement announcement = new Announcement();
		announcement.setTitle(announcementDto.getTitle());
		announcement.setContent(announcementDto.getContent());
		announcement.setUrl(announcementDto.getUrl());
		announcement.setUser(user);
		MultipartFile image = announcementDto.getImage();
		if(!Objects.isNull(image) && !image.isEmpty()) {
			String filename = storageService.save(image);
			if(filename != null) announcement.setImageName(filename);
		}
		announcementRepo.save(announcement);
	}

	@Override
	public void editAnnouncement(Long id, AnnouncementDto announcementDto,User user) {
		Announcement announcement = getAnnouncementById(id);
		if(Objects.isNull(announcement) || announcement == null) return;
		announcement.setTitle(announcementDto.getTitle());
		announcement.setContent(announcementDto.getContent());
		announcement.setUrl(announcementDto.getUrl());
		announcement.setUser(user);
		MultipartFile image = announcementDto.getImage();
		if(!Objects.isNull(image) && !image.isEmpty()) {
			storageService.deleteIfExists(announcement.getImageName());
			String filename = storageService.save(image);
			if(filename != null) announcement.setImageName(filename);
		}
		announcementRepo.save(announcement);
	}

	@Override
	public void deleteAnnouncement(Long id) {
		announcementRepo.deleteById(id);
	}
}
