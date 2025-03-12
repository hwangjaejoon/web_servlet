package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {
	//copyright 정보 Model
	copyright cr = new copyright();
	ArrayList<String> cpdata = null;
	public void fts() {
		this.cpdata = cr.copyright_info();
	}
}
