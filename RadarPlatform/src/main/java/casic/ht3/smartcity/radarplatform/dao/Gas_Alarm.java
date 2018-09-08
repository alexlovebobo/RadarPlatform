package casic.ht3.smartcity.radarplatform.dao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="gas_alarm")
public class Gas_Alarm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String taskId;

    private Integer sortNo;
    
    private Integer value;
    
    private String lat;
    
    private String lng;
    
    private String elevation;
    
    private Date time;
    
    public Gas_Alarm(String str1,String str2,String str3,String str4,String str5,String str6,String str7) {
    	this.taskId=str1;
    	this.sortNo=Integer.valueOf(str2);
    	this.value=Integer.valueOf(str3);
    	this.lat=str4;
    	this.lng=str5;
    	this.elevation=str6;
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    ParsePosition pos = new ParsePosition(0);
	    this.time = formatter.parse(str7, pos);
    }

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
    
}
