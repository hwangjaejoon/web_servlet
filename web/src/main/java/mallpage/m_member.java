package mallpage;
//회원가입 , 로그인 , 아이디찾기 등 에 사용하는 DTO - getter,setter
// 그냥 일일이 받는게 더 빠른거 같은데
public class m_member {
	String mid,mpass,mname,memail,mtel,event_mail,event_sms;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getEvent_mail() {
		return event_mail;
	}

	public void setEvent_mail(String event_mail) {
		this.event_mail = event_mail;
	}

	public String getEvent_sms() {
		return event_sms;
	}

	public void setEvent_sms(String event_sms) {
		this.event_sms = event_sms;
	}
}
