package com.synergech.UserAccountService.transaction.domain.model;

import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
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

    private long fromAccountNumber;

    private long toAccountId;

    private Date transDateTime;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private UserAccount userAccount;

}
