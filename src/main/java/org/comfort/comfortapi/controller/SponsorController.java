package org.comfort.comfortapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.comfort.comfortapi.dto.SponsorDto;
import org.comfort.comfortapi.model.Sponsor;
import org.comfort.comfortapi.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

	@Autowired
	private SponsorService sponsorService;

	@GetMapping
	@Cacheable(value = "listaSponsor")
	public List<SponsorDto> listAll(
			@PageableDefault(sort = "firstName", direction = Direction.ASC, page = 0, size = 10) Pageable pageable) {
		return sponsorService.listAll(pageable);
	}

	@PostMapping
	@CacheEvict(value = "listaSponsor", allEntries = true)
	public ResponseEntity<SponsorDto> save(@RequestBody @Valid SponsorDto sponsorDto, UriComponentsBuilder uriBuilder) {
		Sponsor sponsor = sponsorService.save(sponsorDto);
		URI uri = uriBuilder.path("/sponsor/{id}").buildAndExpand(sponsor.getId()).toUri();
		return ResponseEntity.created(uri).body(new SponsorDto(sponsor));
	}

	@GetMapping("/{id}")
	public SponsorDto detail(@PathVariable("id") Long id) {

		return sponsorService.getSponsorById(id);

	}

}
