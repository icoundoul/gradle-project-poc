package els.eu.sharelibs.gradle.integration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import els.eu.sharelibs.gradle.integration.exception.BussinesException;
import els.eu.sharelibs.gradle.integration.model.dto.WSVersionDTO;
import els.eu.sharelibs.gradle.integration.service.WSConfigurationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/version")
public class VersionAPI extends AbstractAPI {
	
	@Autowired
	private WSConfigurationService configurationService;

	@GetMapping("/")
	public ResponseEntity<WSVersionDTO> getVersion() throws BussinesException {
		try {
			return ResponseEntity.ok(configurationService.getWSVersion());
		} catch (Exception e) {
			throw new BussinesException(WS_VERSION_ERROR_CODE, "Problem while retrieving version");
		}
	}

}
