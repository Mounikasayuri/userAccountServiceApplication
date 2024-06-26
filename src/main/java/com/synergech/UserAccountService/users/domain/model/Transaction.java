package com.synergech.UserAccountService.users.domain.model;

import com.synergech.UserAccountService.users.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "TransactionData", schema = "user_account")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transId;

    private long fromAccountId;

    private long toAccountId;

    private Date transDateTime;

    private double amount;

    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "from_user_account", nullable = false)
    private UserAccount fromUserAccount;

    @ManyToOne
    @JoinColumn(name = "to__user_account", nullable = false)
    private UserAccount toUserAccount;



}
