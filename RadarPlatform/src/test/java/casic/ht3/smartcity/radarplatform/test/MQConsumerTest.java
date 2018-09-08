package casic.ht3.smartcity.radarplatform.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import casic.ht3.smartcity.radarplatform.services.MQConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQConsumerTest {
	@Autowired
	private MQConsumer c;
	@Test
	public void gasConsumeTest() {
		//c.receiveGasMsg(text);
	}
}
