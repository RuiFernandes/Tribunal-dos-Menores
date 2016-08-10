package tribunal.controler;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.util.Clients;

public class ViewModel {
private String a="this worked";

public String getA() {
	return a;
}

public void setA(String a) {
	this.a = a;
}

@Init
public void init(){
	Clients.showNotification("it worked");
	setA("worked");
}

	
}
