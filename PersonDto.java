/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxwelcome;

import java.util.Objects;

/**
 *
 * @author kateromanova
 */
public class PersonDto {
    
    private Integer id;
    private String jobTitle;
    private String firstNameLastName;
    private String phone;
    private String email;
    private Integer domainCount;
    
    public PersonDto(Person person){
        id = person.getId();
        jobTitle = person.getJobTitle();
        firstNameLastName = person.getFirstNameLastName();
        phone = person.getPhone();
        email= person.getEmail();
        domainCount = person.getDomains().size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public void setFirstNameLastName(String firstNameLastName) {
        this.firstNameLastName = firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDomainCount() {
        return domainCount;
    }

    public void setDomainCount(Integer domainCount) {
        this.domainCount = domainCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.jobTitle);
        hash = 89 * hash + Objects.hashCode(this.firstNameLastName);
        hash = 89 * hash + Objects.hashCode(this.phone);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.domainCount);
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
        final PersonDto other = (PersonDto) obj;
        if (!Objects.equals(this.jobTitle, other.jobTitle)) {
            return false;
        }
        if (!Objects.equals(this.firstNameLastName, other.firstNameLastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.domainCount, other.domainCount);
    }

    @Override
    public String toString() {
        return "PersonDto{" + "id=" + id + ", jobTitle=" + jobTitle + ", firstNameLastName=" + firstNameLastName + ", phone=" + phone + ", email=" + email + ", domainCount=" + domainCount + '}';
    }
    
    
}
