package com.zlfund.headstone.core.mongo.documents;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * custinfo集合
 * @author Yang Xiaodong
 * @since: 2017年2月28日
 */
@Document(collection = "custinfo")
public class CustinfoDocument implements Serializable {
    private static final long serialVersionUID = -3211217143838717218L;

    private String id;

    private String custst;

    private String mobileverifist;

    private String idno;

    private String mobileno;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the custst
     */
    public String getCustst() {
        return custst;
    }

    /**
     * @param custst the custst to set
     */
    public void setCustst(String custst) {
        this.custst = custst;
    }

    /**
     * @return the mobileverifist
     */
    public String getMobileverifist() {
        return mobileverifist;
    }

    /**
     * @param mobileverifist the mobileverifist to set
     */
    public void setMobileverifist(String mobileverifist) {
        this.mobileverifist = mobileverifist;
    }

    /**
     * @return the idno
     */
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * @return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

}
