/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxwelcome;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author kateromanova
 */
public class Domain {
    private Integer id;
    private String webName;
    private String domainName;
    private String ip;
    private Date dateReg;
    private String countryReg;
    private Integer personId;
    private Person person; 

    

    Domain(int id, String webName, String domainName, String ip, Date dateReg, String countryReg, int personId) {
        this.id = id;
        this.webName = webName;
        this.domainName = domainName;
        this.ip = ip;
        this.dateReg = dateReg;
        this.countryReg = countryReg;
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getWebName() {
        return webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getIp() {
        return ip;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public Integer getPersonId() {
        return personId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.webName);
        hash = 29 * hash + Objects.hashCode(this.domainName);
        hash = 29 * hash + Objects.hashCode(this.ip);
        hash = 29 * hash + Objects.hashCode(this.dateReg);
        hash = 29 * hash + Objects.hashCode(this.countryReg);
        hash = 29 * hash + Objects.hashCode(this.personId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domain other = (Domain) obj;
        if (!Objects.equals(this.webName, other.webName)) {
            return false;
        }
        if (!Objects.equals(this.domainName, other.domainName)) {
            return false;
        }
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        if (!Objects.equals(this.countryReg, other.countryReg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateReg, other.dateReg)) {
            return false;
        }
        return Objects.equals(this.personId, other.personId);
    }

    @Override
    public String toString() {
        return "Domain{" + "id=" + id + ", webName=" + webName + ", domainName=" + domainName + ", ip=" + ip + ", dateReg=" + dateReg + ", countryReg=" + countryReg + ", personId=" + personId + '}';
    }
    
    
}

