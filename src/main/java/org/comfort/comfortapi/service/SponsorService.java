package org.comfort.comfortapi.service;

import java.util.List;
import java.util.stream.Collectors;



import org.comfort.comfortapi.dto.SponsorDto;
import org.comfort.comfortapi.model.Sponsor;
import org.comfort.comfortapi.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SponsorService {

	@Autowired
	private SponsorRepository repository;

	@Transactional
	public Sponsor save(SponsorDto sponsordto) {
		return repository.save(new Sponsor(sponsordto));

	}

	public List<SponsorDto> listAll(Pageable pageable) {

		return repository.findAll(pageable).stream().map(sponsor -> new SponsorDto(sponsor))
				.collect(Collectors.toList());
	}

	public SponsorDto getSponsorById(Long id) {
		return new SponsorDto(repository.getOne(id));
	}

}
