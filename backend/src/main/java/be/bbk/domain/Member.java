package be.bbk.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "Member")
@Getter @Setter
public class Member extends DomainObject {

    @Id
    @SequenceGenerator(name = "MEMBER_GEN", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_GEN")
    private Long id;

    @Column(name = "MEMBERSHIP_NUMBER")
    private String membershipNumber;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGON")
    private Date lastLogon;

    //TODO should be encrypted
    private String password;

    public Member() {

    }

    @PrePersist
    public void onPrePersist() {
        String currentYear = String.valueOf(now().getYear());
        membershipNumber = currentYear + "-" + UUID.randomUUID();
        setCreatedOn(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setLastModifiedOn(new Date());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        final Member other = (Member) object;
        return Objects.equal(membershipNumber, other.membershipNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(membershipNumber);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("membershipNumber", membershipNumber)
                .add("firstName", firstName)
                .add("name", name)
                .toString();
    }
}
