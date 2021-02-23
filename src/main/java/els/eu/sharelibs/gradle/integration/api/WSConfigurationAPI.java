package els.eu.sharelibs.gradle.integration.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import els.eu.sharelibs.gradle.integration.exception.BussinesException;
import els.eu.sharelibs.gradle.integration.model.dto.WSConfigurationDTO;
import els.eu.sharelibs.gradle.integration.service.WSConfigurationService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/configuration")
public class WSConfigurationAPI extends AbstractAPI {
	@Autowired
	private WSConfigurationService configurationService;

	@GetMapping("/")
	public ResponseEntity<WSConfigurationDTO> getConfiguration() throws BussinesException {
		try {
			return ResponseEntity.ok(configurationService.getConfiguration());

		} catch (Exception e) {
			throw new BussinesException(WS_CONFIGURATION_ERROR_CODE, "problème de la récupération de la configuration");
		}
	}
}
