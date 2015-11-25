package com.oneops.cms.simple.domain;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.oneops.cms.dj.domain.CmsRfcCIBasic;

/**
 * The Class CmsRfcCISimple.
 */
public class CmsRfcCISimple extends CmsRfcCIBasic implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String,String> ciAttributes = new HashMap<String,String>();
	private Map<String,String> ciBaseAttributes = new HashMap<String,String>();
	private Map<String,Map<String,String>> ciAttrProps = new HashMap<String,Map<String,String>>();
	
	/**
	 * Gets the ci attributes.
	 *
	 * @return the ci attributes
	 */
	public Map<String, String> getCiAttributes() {
		return ciAttributes;
	}
	
	/**
	 * Sets the ci attributes.
	 *
	 * @param ciAttributes the ci attributes
	 */
	public void setCiAttributes(Map<String, String> ciAttributes) {
		this.ciAttributes = ciAttributes;
	}
	
	/**
	 * Adds the ci attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void addCiAttribute(String key, String value) {
		this.ciAttributes.put(key, value);
	}
	
	/**
	 * Sets the ci base attributes.
	 *
	 * @param ciBaseAttributes the ci base attributes
	 */
	public void setCiBaseAttributes(Map<String,String> ciBaseAttributes) {
		this.ciBaseAttributes = ciBaseAttributes;
	}
	
	/**
	 * Gets the ci base attributes.
	 *
	 * @return the ci base attributes
	 */
	public Map<String,String> getCiBaseAttributes() {
		return ciBaseAttributes;
	}
	
	/**
	 * Adds the ci base attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void addCiBaseAttribute(String key, String value) {
		this.ciBaseAttributes.put(key, value);
	}
	
	/**
	 * Sets the ci attr props.
	 *
	 * @param ciAttrProps the ci attr props
	 */
	public void setCiAttrProps(Map<String,Map<String,String>> ciAttrProps) {
		this.ciAttrProps = ciAttrProps;
	}
	
	/**
	 * Gets the ci attr props.
	 *
	 * @return the ci attr props
	 */
	public Map<String,Map<String,String>> getCiAttrProps() {
		return ciAttrProps;
	}
	
	/**
	 * Adds the ci attr prop.
	 *
	 * @param propName the prop name
	 * @param attrName the attr name
	 * @param value the value
	 */
	public void addCiAttrProp(String propName, String attrName, String value) {
		if (ciAttrProps.get(propName) == null) {
			ciAttrProps.put(propName, new HashMap<String,String>());
		}
		if (attrName != null && value != null) {
			ciAttrProps.get(propName).put(attrName, value);
		}
	}

}
