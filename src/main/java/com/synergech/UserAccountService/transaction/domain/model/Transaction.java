package com.synergech.UserAccountService.transaction.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TransactionData", schema = "user_account")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transId;

    private long fromAccountNumber;

    private long toAccountId;

    private Timestamp transDateTime;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    @JsonIgnore
    private UserAccount userAccount;

}
