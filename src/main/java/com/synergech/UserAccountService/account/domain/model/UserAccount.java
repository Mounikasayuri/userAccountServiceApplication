package com.synergech.UserAccountService.account.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergech.UserAccountService.account.domain.enums.AccountType;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import com.synergech.UserAccountService.users.domain.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "UserAccountData", schema = "user_account")
public class UserAccount {

    @Id
    private long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String ifscCode;

    private String branch;

    private String mobileNumber;

    private String email;

    private String panCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<Transaction> outgoingTransactions;
}
