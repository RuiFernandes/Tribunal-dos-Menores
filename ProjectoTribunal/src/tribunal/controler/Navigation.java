package tribunal.controler;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.Include;

public class Navigation extends GenericForwardComposer{
Navitem autuar;

public void doAfterCompose (Component comp) throws Exception  {
	super.doAfterCompose(comp);
	if (page.hasFellow("menu")){Clients.showNotification("thisworks");}else{Clients.showNotification("not good");}}
	


public void onClick$autuar () {
	Clients.showNotification("worked");
	((Include)page.getFellow("center")).setSrc("./tribunal/menu.zul");
	
}
}
