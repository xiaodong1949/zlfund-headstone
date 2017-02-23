package com.zlfund.headstone.core.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DB:trade
 * table ： custinfoex
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public class CustInfoExPO implements Serializable {

    private static final long serialVersionUID = -357168964039258873L;

    private String custno;

    private String acctabbr;

    private String addr;

    private BigDecimal age;

    private String answer;

    private String appFrom;

    private String availablydate;

    private String birthday;

    private String cityname;

    private String company;

    private String corpropertiy;

    private String counsellor;

    private Integer counsellorid;

    private String custtitle;

    private String custtp;

    private String delivertype;

    private String deliverway;

    private String edlevel;

    private String faxno;

    private String hometel;

    private String idno15;

    private BigDecimal income;

    private String industrytype;

    private String instrepridno;

    private String instrepridtp;

    private String instreprname;

    private String invest;

    private String marriage;

    private String mySpreadCode;

    private String officetel;

    private String origin;

    private String postcode;

    private Integer promoCode;

    private String provincecode;

    private String pzbsessionkey;

    private String question;

    private String registcapital;

    private String sessionkey;

    private String sex;

    private String shsecacc;

    private String spellshort;

    private String spreadCode;

    private String szsecacc;

    private String telno;

    private Timestamp titletimestamp;

    private String tmpemail;

    private String tmpmobileno;

    private String tmpmobileverifist;

    private String tmppasswd;

    private Timestamp updatetimestamp;

    private String vocation;

    private String voccode;

    /**
     * @return the custno
     */
    public String getCustno() {
        return custno;
    }

    /**
     * @param custno the custno to set
     */
    public void setCustno(String custno) {
        this.custno = custno;
    }

    /**
     * @return the acctabbr
     */
    public String getAcctabbr() {
        return acctabbr;
    }

    /**
     * @param acctabbr the acctabbr to set
     */
    public void setAcctabbr(String acctabbr) {
        this.acctabbr = acctabbr;
    }

    /**
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr the addr to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * @return the age
     */
    public BigDecimal getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(BigDecimal age) {
        this.age = age;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the appFrom
     */
    public String getAppFrom() {
        return appFrom;
    }

    /**
     * @param appFrom the appFrom to set
     */
    public void setAppFrom(String appFrom) {
        this.appFrom = appFrom;
    }

    /**
     * @return the availablydate
     */
    public String getAvailablydate() {
        return availablydate;
    }

    /**
     * @param availablydate the availablydate to set
     */
    public void setAvailablydate(String availablydate) {
        this.availablydate = availablydate;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the cityname
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * @param cityname the cityname to set
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the corpropertiy
     */
    public String getCorpropertiy() {
        return corpropertiy;
    }

    /**
     * @param corpropertiy the corpropertiy to set
     */
    public void setCorpropertiy(String corpropertiy) {
        this.corpropertiy = corpropertiy;
    }

    /**
     * @return the counsellor
     */
    public String getCounsellor() {
        return counsellor;
    }

    /**
     * @param counsellor the counsellor to set
     */
    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }

    /**
     * @return the counsellorid
     */
    public Integer getCounsellorid() {
        return counsellorid;
    }

    /**
     * @param counsellorid the counsellorid to set
     */
    public void setCounsellorid(Integer counsellorid) {
        this.counsellorid = counsellorid;
    }

    /**
     * @return the custtitle
     */
    public String getCusttitle() {
        return custtitle;
    }

    /**
     * @param custtitle the custtitle to set
     */
    public void setCusttitle(String custtitle) {
        this.custtitle = custtitle;
    }

    /**
     * @return the custtp
     */
    public String getCusttp() {
        return custtp;
    }

    /**
     * @param custtp the custtp to set
     */
    public void setCusttp(String custtp) {
        this.custtp = custtp;
    }

    /**
     * @return the delivertype
     */
    public String getDelivertype() {
        return delivertype;
    }

    /**
     * @param delivertype the delivertype to set
     */
    public void setDelivertype(String delivertype) {
        this.delivertype = delivertype;
    }

    /**
     * @return the deliverway
     */
    public String getDeliverway() {
        return deliverway;
    }

    /**
     * @param deliverway the deliverway to set
     */
    public void setDeliverway(String deliverway) {
        this.deliverway = deliverway;
    }

    /**
     * @return the edlevel
     */
    public String getEdlevel() {
        return edlevel;
    }

    /**
     * @param edlevel the edlevel to set
     */
    public void setEdlevel(String edlevel) {
        this.edlevel = edlevel;
    }

    /**
     * @return the faxno
     */
    public String getFaxno() {
        return faxno;
    }

    /**
     * @param faxno the faxno to set
     */
    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    /**
     * @return the hometel
     */
    public String getHometel() {
        return hometel;
    }

    /**
     * @param hometel the hometel to set
     */
    public void setHometel(String hometel) {
        this.hometel = hometel;
    }

    /**
     * @return the idno15
     */
    public String getIdno15() {
        return idno15;
    }

    /**
     * @param idno15 the idno15 to set
     */
    public void setIdno15(String idno15) {
        this.idno15 = idno15;
    }

    /**
     * @return the income
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * @return the industrytype
     */
    public String getIndustrytype() {
        return industrytype;
    }

    /**
     * @param industrytype the industrytype to set
     */
    public void setIndustrytype(String industrytype) {
        this.industrytype = industrytype;
    }

    /**
     * @return the instrepridno
     */
    public String getInstrepridno() {
        return instrepridno;
    }

    /**
     * @param instrepridno the instrepridno to set
     */
    public void setInstrepridno(String instrepridno) {
        this.instrepridno = instrepridno;
    }

    /**
     * @return the instrepridtp
     */
    public String getInstrepridtp() {
        return instrepridtp;
    }

    /**
     * @param instrepridtp the instrepridtp to set
     */
    public void setInstrepridtp(String instrepridtp) {
        this.instrepridtp = instrepridtp;
    }

    /**
     * @return the instreprname
     */
    public String getInstreprname() {
        return instreprname;
    }

    /**
     * @param instreprname the instreprname to set
     */
    public void setInstreprname(String instreprname) {
        this.instreprname = instreprname;
    }

    /**
     * @return the invest
     */
    public String getInvest() {
        return invest;
    }

    /**
     * @param invest the invest to set
     */
    public void setInvest(String invest) {
        this.invest = invest;
    }

    /**
     * @return the marriage
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * @param marriage the marriage to set
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    /**
     * @return the mySpreadCode
     */
    public String getMySpreadCode() {
        return mySpreadCode;
    }

    /**
     * @param mySpreadCode the mySpreadCode to set
     */
    public void setMySpreadCode(String mySpreadCode) {
        this.mySpreadCode = mySpreadCode;
    }

    /**
     * @return the officetel
     */
    public String getOfficetel() {
        return officetel;
    }

    /**
     * @param officetel the officetel to set
     */
    public void setOfficetel(String officetel) {
        this.officetel = officetel;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the promoCode
     */
    public Integer getPromoCode() {
        return promoCode;
    }

    /**
     * @param promoCode the promoCode to set
     */
    public void setPromoCode(Integer promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * @return the provincecode
     */
    public String getProvincecode() {
        return provincecode;
    }

    /**
     * @param provincecode the provincecode to set
     */
    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    /**
     * @return the pzbsessionkey
     */
    public String getPzbsessionkey() {
        return pzbsessionkey;
    }

    /**
     * @param pzbsessionkey the pzbsessionkey to set
     */
    public void setPzbsessionkey(String pzbsessionkey) {
        this.pzbsessionkey = pzbsessionkey;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the registcapital
     */
    public String getRegistcapital() {
        return registcapital;
    }

    /**
     * @param registcapital the registcapital to set
     */
    public void setRegistcapital(String registcapital) {
        this.registcapital = registcapital;
    }

    /**
     * @return the sessionkey
     */
    public String getSessionkey() {
        return sessionkey;
    }

    /**
     * @param sessionkey the sessionkey to set
     */
    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the shsecacc
     */
    public String getShsecacc() {
        return shsecacc;
    }

    /**
     * @param shsecacc the shsecacc to set
     */
    public void setShsecacc(String shsecacc) {
        this.shsecacc = shsecacc;
    }

    /**
     * @return the spellshort
     */
    public String getSpellshort() {
        return spellshort;
    }

    /**
     * @param spellshort the spellshort to set
     */
    public void setSpellshort(String spellshort) {
        this.spellshort = spellshort;
    }

    /**
     * @return the spreadCode
     */
    public String getSpreadCode() {
        return spreadCode;
    }

    /**
     * @param spreadCode the spreadCode to set
     */
    public void setSpreadCode(String spreadCode) {
        this.spreadCode = spreadCode;
    }

    /**
     * @return the szsecacc
     */
    public String getSzsecacc() {
        return szsecacc;
    }

    /**
     * @param szsecacc the szsecacc to set
     */
    public void setSzsecacc(String szsecacc) {
        this.szsecacc = szsecacc;
    }

    /**
     * @return the telno
     */
    public String getTelno() {
        return telno;
    }

    /**
     * @param telno the telno to set
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * @return the titletimestamp
     */
    public Timestamp getTitletimestamp() {
        return titletimestamp;
    }

    /**
     * @param titletimestamp the titletimestamp to set
     */
    public void setTitletimestamp(Timestamp titletimestamp) {
        this.titletimestamp = titletimestamp;
    }

    /**
     * @return the tmpemail
     */
    public String getTmpemail() {
        return tmpemail;
    }

    /**
     * @param tmpemail the tmpemail to set
     */
    public void setTmpemail(String tmpemail) {
        this.tmpemail = tmpemail;
    }

    /**
     * @return the tmpmobileno
     */
    public String getTmpmobileno() {
        return tmpmobileno;
    }

    /**
     * @param tmpmobileno the tmpmobileno to set
     */
    public void setTmpmobileno(String tmpmobileno) {
        this.tmpmobileno = tmpmobileno;
    }

    /**
     * @return the tmpmobileverifist
     */
    public String getTmpmobileverifist() {
        return tmpmobileverifist;
    }

    /**
     * @param tmpmobileverifist the tmpmobileverifist to set
     */
    public void setTmpmobileverifist(String tmpmobileverifist) {
        this.tmpmobileverifist = tmpmobileverifist;
    }

    /**
     * @return the tmppasswd
     */
    public String getTmppasswd() {
        return tmppasswd;
    }

    /**
     * @param tmppasswd the tmppasswd to set
     */
    public void setTmppasswd(String tmppasswd) {
        this.tmppasswd = tmppasswd;
    }

    /**
     * @return the updatetimestamp
     */
    public Timestamp getUpdatetimestamp() {
        return updatetimestamp;
    }

    /**
     * @param updatetimestamp the updatetimestamp to set
     */
    public void setUpdatetimestamp(Timestamp updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    /**
     * @return the vocation
     */
    public String getVocation() {
        return vocation;
    }

    /**
     * @param vocation the vocation to set
     */
    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    /**
     * @return the voccode
     */
    public String getVoccode() {
        return voccode;
    }

    /**
     * @param voccode the voccode to set
     */
    public void setVoccode(String voccode) {
        this.voccode = voccode;
    }

}
