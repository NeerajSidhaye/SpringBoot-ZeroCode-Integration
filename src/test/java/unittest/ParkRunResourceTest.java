package unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.exception.GlobalExceptionHandler;
import com.xp.springboot.exception.ParkRunException;
import com.xp.springboot.model.ParkRunResponse;
import com.xp.springboot.model.dto.PartialUpdateDTO;
import com.xp.springboot.model.dto.RegisterRunnerDTO;
import com.xp.springboot.resource.ParkRun;
import com.xp.springboot.service.ParkRunnerService;


/**
 * 
 * @author Neeraj Sidhaye
 *
 */

@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkRunResourceTest {
	
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	
	@InjectMocks
	ParkRun parkRunController;
	
	@Mock
	ParkRunnerService parkRunnerService;
	
	@Mock
	ModelMapper modelMapper;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(parkRunController).setControllerAdvice(new GlobalExceptionHandler()).build();
		objectMapper = new ObjectMapper();
	}
	
	@Test
	public void testGetAllParkRunners_for_200() throws Exception {
		
		// GIVEN
		List<ParkRunner>  mockServiceResponse = prepareMockServiceResponse_getAllParkRunners();
		given(parkRunnerService.getAllParkRunners()).willReturn(mockServiceResponse);
		
		//  WHEN
		MockHttpServletResponse  response = this.mockMvc.perform(get("/api/v1/runners")).andReturn().getResponse();
		
		
		//THEN
		
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		List<ParkRunner> allParkRunners = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<ParkRunner>>() {});
		
		assertThat(allParkRunners.size()).isGreaterThan(0);
		assertThat(allParkRunners.get(0).getParkRunId()).isNotNull();
		
	}
	
	@Test
	public void testGetParkRunnerById_WhenRecordExist_thenRespondWith_200() throws Exception{
		
		// GIVEN
		ParkRunner mockServiceResponse = prepareMockServiceResponse_getParkRunnerById();
		given(parkRunnerService.getParkRunnerById(anyLong())).willReturn(mockServiceResponse);
		
		// WHEN
		MockHttpServletResponse  response = this.mockMvc.perform(get("/api/v1/runners/1")).andReturn().getResponse();
		
		//THEN
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		ParkRunner parkRunner = objectMapper.readValue(response.getContentAsString(), new TypeReference<ParkRunner>(){});
		
		assertThat(parkRunner).hasFieldOrProperty("parkRunId").isNotNull();
		
	}
	
	@Test
	public void testGetParkRunnerById_WithRecordNotFound_thenRespondWith_404() throws Exception{
		
		// GIVEN
		given(parkRunnerService.getParkRunnerById(anyLong())).willThrow(new ParkRunException("2","404", "Runner not found"));
		
		// WHEN
		MockHttpServletResponse  response  = this.mockMvc.perform(get("/api/v1/runners/2")).andReturn().getResponse();
		
		// THEN
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
		
		
	}
	
	@Test
	public void testGetParkRunnerById_WithInCorrectIdPattern_thenRespondWith_400() throws Exception {
		
		// WHEN
		MockHttpServletResponse  response  = this.mockMvc.perform(get("/api/v1/runners/ZZ")).andReturn().getResponse();
		
		// THEN
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
		
	}
	
	@Test
	public void testUpdateParkRunner_WithValidId_ThenRespondWith_200() throws Exception {
		
		//GIVEN
		PartialUpdateDTO partialUpdateDTO = new PartialUpdateDTO();
		partialUpdateDTO.setTotalRuns("200");
		
		String requestPayLoad = objectMapper.writeValueAsString(partialUpdateDTO);
		
		ParkRunResponse mockResponse = new ParkRunResponse("Update Success.", "2");
		
		given(parkRunnerService.updateRunnerProfile(anyLong(), any(ParkRunner.class))).willReturn(mockResponse);
		
		
		//WHEN
		MockHttpServletResponse response = this.mockMvc.perform(patch("/api/v1/runners/2").
																							contentType(MediaType.APPLICATION_JSON_UTF8).
																							content(requestPayLoad)).
																							andReturn().getResponse();
		
		//THEN
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
	}
	
	
	@Test
	public void testRegisterParkRunner_WithValidRequest_ThenRespondWith_201() throws Exception {
		
		//GIVEN
		RegisterRunnerDTO registerRunnerDTO = new RegisterRunnerDTO();
		
		registerRunnerDTO.setFirstName("Neeraj");
		registerRunnerDTO.setLastName("Sidhaye");
		registerRunnerDTO.setGender("M");
		registerRunnerDTO.setHomeRun("PUNE RUNNING");
		registerRunnerDTO.setRunningClub("RUNWAY");
		registerRunnerDTO.setPostCode("CW2ZZZ");
		registerRunnerDTO.setEmail("email@email.com");
		
		String requestPayLoad = objectMapper.writeValueAsString(registerRunnerDTO);
		
		ParkRunResponse mockResponse = new ParkRunResponse("Registration Success.", "2");
		
		given(parkRunnerService.registerRunner(any(ParkRunner.class))).willReturn(mockResponse);
		
		
		//WHEN
		MockHttpServletResponse response = this.mockMvc.perform(post("/api/v1/runners").
																							contentType(MediaType.APPLICATION_JSON_UTF8).
																							content(requestPayLoad)).
																							andReturn().getResponse();
		
		//THEN
		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		
	}
	
	private List<ParkRunner> prepareMockServiceResponse_getAllParkRunners() throws Exception {
		
		File allParkRunnersResponse = ResourceUtils.getFile("classpath:reusable_content/response/get_all_parkrunners_response_body.json");
		return objectMapper.readValue(allParkRunnersResponse, new TypeReference<List<ParkRunner>>() {});
		
	}
	
	private ParkRunner prepareMockServiceResponse_getParkRunnerById() throws Exception {
		
		File parkRunnerByIdResponse = ResourceUtils.getFile("classpath:reusable_content/response/get_parkrunner_byId_response_body.json");
		return objectMapper.readValue(parkRunnerByIdResponse, new TypeReference<ParkRunner>(){});
		
	}
	
}
