package modules.freeTheme.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Coolest Thing
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class CoolestThing extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "freeTheme";

	/** @hidden */
	public static final String DOCUMENT_NAME = "CoolestThing";

	/** @hidden */
	public static final String namePropertyName = "name";

	/**
	 * Name
	 **/
	private String name;

	@Override
	@XmlTransient
	public String getBizModule() {
		return CoolestThing.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return CoolestThing.DOCUMENT_NAME;
	}

	public static CoolestThing newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage("Coolest Thing - {name}", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof CoolestThing) && 
					this.getBizId().equals(((CoolestThing) o).getBizId()));
	}

	/**
	 * {@link #name} accessor.
	 * @return	The value.
	 **/
	public String getName() {
		return name;
	}

	/**
	 * {@link #name} mutator.
	 * @param name	The new value.
	 **/
	@XmlElement
	public void setName(String name) {
		preset(namePropertyName, name);
		this.name = name;
	}
}
