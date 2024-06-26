package com.synergech.UserAccountService.users.domain.model;

import com.synergech.UserAccountService.users.domain.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "UserAccountData", schema = "user_account")
public class UserAccount {

    @Id
    private long accountNumber;

    private AccountType accountType;

    private String ifscCode;

    private String branch;

    private String mobileNumber;

    private String email;

    private String panCard;

    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "fromUserAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "toUserAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> incomingTransactions;

}
