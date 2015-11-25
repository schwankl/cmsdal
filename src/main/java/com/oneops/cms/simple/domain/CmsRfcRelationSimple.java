package com.oneops.cms.simple.domain;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.oneops.cms.dj.domain.CmsRfcRelationBasic;

/**
 * The Class CmsRfcRelationSimple.
 */
public class CmsRfcRelationSimple extends CmsRfcRelationBasic implements Serializable {
	private static final long serialVersionUID = 1L;

	private CmsRfcCISimple fromCi;
	private CmsRfcCISimple toCi;
	
	private Map<String,String> relationAttributes = new HashMap<String,String>();
	private Map<String,String> relationBaseAttributes = new HashMap<String,String>();
	private Map<String,Map<String,String>> relationAttrProps = new HashMap<String,Map<String,String>>();
	
	/**
	 * Gets the relation attributes.
	 *
	 * @return the relation attributes
	 */
	public Map<String, String> getRelationAttributes() {
		return relationAttributes;
	}
	
	/**
	 * Sets the relation attributes.
	 *
	 * @param relationAttributes the relation attributes
	 */
	public void setRelationAttributes(Map<String, String> relationAttributes) {
		this.relationAttributes = relationAttributes;
	}
	
	/**
	 * Adds the relation attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void addRelationAttribute(String key, String value) {
		this.relationAttributes.put(key, value);
	}
	
	/**
	 * Gets the from ci.
	 *
	 * @return the from ci
	 */
	public CmsRfcCISimple getFromCi() {
		return fromCi;
	}
	
	/**
	 * Sets the from ci.
	 *
	 * @param fromCi the new from ci
	 */
	public void setFromCi(CmsRfcCISimple fromCi) {
		this.fromCi = fromCi;
	}
	
	/**
	 * Gets the to ci.
	 *
	 * @return the to ci
	 */
	public CmsRfcCISimple getToCi() {
		return toCi;
	}
	
	/**
	 * Sets the to ci.
	 *
	 * @param toCi the new to ci
	 */
	public void setToCi(CmsRfcCISimple toCi) {
		this.toCi = toCi;
	}
	
	/**
	 * Sets the relation base attributes.
	 *
	 * @param relationBaseAttributes the relation base attributes
	 */
	public void setRelationBaseAttributes(Map<String,String> relationBaseAttributes) {
		this.relationBaseAttributes = relationBaseAttributes;
	}
	
	/**
	 * Gets the relation base attributes.
	 *
	 * @return the relation base attributes
	 */
	public Map<String,String> getRelationBaseAttributes() {
		return relationBaseAttributes;
	}
	
	/**
	 * Adds the relation base attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void addRelationBaseAttribute(String key, String value) {
		this.relationBaseAttributes.put(key, value);
	}
	
	/**
	 * Sets the relation attr props.
	 *
	 * @param relationAttrProps the relation attr props
	 */
	public void setRelationAttrProps(Map<String,Map<String,String>> relationAttrProps) {
		this.relationAttrProps = relationAttrProps;
	}
	
	/**
	 * Gets the relation attr props.
	 *
	 * @return the relation attr props
	 */
	public Map<String,Map<String,String>> getRelationAttrProps() {
		return relationAttrProps;
	}

	/**
	 * Adds the relation attr prop.
	 *
	 * @param propName the prop name
	 * @param attrName the attr name
	 * @param value the value
	 */
	public void addRelationAttrProp(String propName, String attrName, String value) {
		if (relationAttrProps.get(propName) == null) {
			relationAttrProps.put(propName, new HashMap<String,String>());
		}
		if (attrName != null && value != null) {
			relationAttrProps.get(propName).put(attrName, value);
		}
	}

}
