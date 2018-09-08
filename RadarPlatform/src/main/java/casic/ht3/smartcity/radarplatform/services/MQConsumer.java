package casic.ht3.smartcity.radarplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MQConsumer {
	@Autowired
	private Gas_AlarmService gService;
	@JmsListener(destination="GasMonitorQ")
	public void receiveGasMsg(String text) {
		String[] arr=text.split("\\s+");
        gService.addGas_Alarm("testT",arr[0],arr[1],arr[4],arr[5],arr[6],arr[7]+" "+arr[8]);
	}
}
