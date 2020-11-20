package eredua.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

public class LoginBean {
	private String izena;
	private String pasahitza;
	private Date data;
	private ErabiltzailearenMota mota;
	private static List<ErabiltzailearenMota> motak = new ArrayList<ErabiltzailearenMota>();

	public LoginBean() {
		motak.add(new ErabiltzailearenMota("Ikaslea", 1));
		motak.add(new ErabiltzailearenMota("Irakaslea", 2));

	}

	public ErabiltzailearenMota getMota() {
		return this.mota;
	}

	public void setMota(ErabiltzailearenMota mota) {
		this.mota = mota;
		System.out.println("Erabiltzailearen mota: " + mota.getKodea() + "/" + mota.getErabMota());
	}

	public void setErabiltzailearenMota(ErabiltzailearenMota mota) {
		this.mota = mota;
	}

	public void setMotak(List<ErabiltzailearenMota> motak) {
		LoginBean.motak = motak;
	}

	public List<ErabiltzailearenMota> getMotak() {
		return this.motak;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String egiaztatu() {
		if (izena.length() != pasahitza.length()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Errorea pasahitza eta erabiltzaileak ez dute luzeera berdina"));
			return null;
		}
		if (izena.equals("pirata"))
			return "error";
		else
			return "ok";
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data aukeratua: " + event.getObject()));
	}

	public static ErabiltzailearenMota getObject(String mota) {
		for (ErabiltzailearenMota m : motak) {
			if (mota.equals(m.getErabMota()))
				return m;
		}
		return null;
	}
	public void listener(AjaxBehaviorEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erabiltzailearen mota: "+mota.getKodea()+"/"+mota.getErabMota()));
	}

}
