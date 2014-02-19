/**
 * 
 */
package com.mopelo.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LocaleBean implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -7522609234232367231L;

	/**
	 * Locale.
	 */
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot()
			.getLocale();

	/**
	 * Set language.
	 * 
	 * @param language
	 *            : new language
	 */
	public String setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

		return "product" + "?faces-redirect=true";
	}


	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
