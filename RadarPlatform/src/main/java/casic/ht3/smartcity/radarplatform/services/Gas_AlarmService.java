package casic.ht3.smartcity.radarplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casic.ht3.smartcity.radarplatform.dao.Gas_Alarm;
import casic.ht3.smartcity.radarplatform.dao.Gas_AlarmRepository;

@Service
public class Gas_AlarmService {
	@Autowired
	private Gas_AlarmRepository gasAlarmRepository;
	public String addGas_Alarm(String taskId,String sortNo,String value,String lat,String lng,String elevation,String time){
		Gas_Alarm g=new Gas_Alarm(taskId,sortNo,value,lat,lng,elevation,time);
		gasAlarmRepository.save(g);
		return "Saved";
	}
}
