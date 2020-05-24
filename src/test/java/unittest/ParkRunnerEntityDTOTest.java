package unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.xp.springboot.entity.ParkRunner;
import com.xp.springboot.model.dto.PartialUpdateDTO;
import com.xp.springboot.model.dto.RegisterRunnerDTO;

/**
 * 
 * @author Neeraj Sidhaye
 *  
 */

public class ParkRunnerEntityDTOTest {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	
	@Test
	public void testPartialUpdateDTO_ToEntityMapping() {
		
		PartialUpdateDTO partialUpdateDTO = new PartialUpdateDTO();
		
		partialUpdateDTO.setTotalRuns("110");
		
	   ParkRunner parkRunner = modelMapper.map(partialUpdateDTO, ParkRunner.class);
	   assertEquals(partialUpdateDTO.getTotalRuns(), parkRunner.getTotalRuns());
		
	}
	
	
	@Test
	public void testRegisterRunnerDTO_ToEnityMapping(){
		
		RegisterRunnerDTO registerRunnerDTO = new RegisterRunnerDTO();
		
		registerRunnerDTO.setFirstName("Neeraj");
		registerRunnerDTO.setLastName("Sidhaye");
		registerRunnerDTO.setGender("M");
		registerRunnerDTO.setHomeRun("PUNE RUNNING");
		registerRunnerDTO.setRunningClub("RUNWAY");
		registerRunnerDTO.setPostCode("CW2ZZZ");
		registerRunnerDTO.setEmail("email@email.com");
		
		ParkRunner parkRunnerEntity = modelMapper.map(registerRunnerDTO, ParkRunner.class);
		assertEquals(registerRunnerDTO.getFirstName(), parkRunnerEntity.getFirstName());
		assertEquals(registerRunnerDTO.getLastName(), parkRunnerEntity.getLastName());
		assertEquals(registerRunnerDTO.getGender(), parkRunnerEntity.getGender());
		assertEquals(registerRunnerDTO.getHomeRun(), parkRunnerEntity.getHomeRun());
		assertEquals(registerRunnerDTO.getRunningClub(), parkRunnerEntity.getRunningClub());
		assertEquals(registerRunnerDTO.getEmail(), parkRunnerEntity.getEmail());
		
	}
	
}
