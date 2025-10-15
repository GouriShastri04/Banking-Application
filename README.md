# Banking Application

A Spring Boot banking application with account management, deposit/withdraw functionality, and automatic transaction logging. Built with Spring Boot, Spring Data JPA, and MySQL.

---

## **Features**

- Create, read, update, and delete bank accounts
- Deposit and withdraw money
- Automatic transaction logging for deposits and withdrawals
- View transaction history per account or for all accounts
- RESTful APIs using Spring Boot and JPA

---

## **Technologies Used**

- Java 17
- Spring Boot 3
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Postman (for testing APIs)

---

## **Directory Structure**
banking-application/
│
├─ src/main/java/com/project/banking/application/
│ ├─ controller/ # REST Controllers (AccountController, TransactionController)
│ ├─ dto/ # Data Transfer Objects
│ ├─ entity/ # JPA Entities (Account, Transaction)
│ ├─ mapper/ # Mapper classes for DTO <-> Entity
│ ├─ repository/ # Spring Data JPA Repositories
│ └─ service/ # Service interfaces and implementations
├─ src/main/resources/
│ └─ application.properties
├─ pom.xml
└─ README.md

---

## **API Endpoints**

### **Account APIs**

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/accounts` | Create a new account | `{ "accountHolderName": "John Doe", "balance": 1000.0 }` |
| GET | `/api/accounts/{id}` | Get account details by ID | N/A |
| PUT | `/api/accounts/{id}/deposit` | Deposit money into account | `{ "amount": 500.0 }` |
| PUT | `/api/accounts/{id}/withdraw` | Withdraw money from account | `{ "amount": 200.0 }` |
| DELETE | `/api/accounts/{id}` | Delete an account by ID | N/A |
| GET | `/api/accounts` | Get all accounts | N/A |

### **Transaction APIs**

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| GET | `/api/accounts/{id}/transactions` | Get all transactions for a specific account | N/A |
| GET | `/api/transactions/all` | Get all transactions across all accounts | N/A |

---

## **Example JSON Response**

**Account Details:**

```json
{
  "id": 1,
  "accountHolderName": "John Doe",
  "balance": 1500.0
}

---

## **Future Enhancements**

- Add user authentication and role-based access (Admin, Customer)
- Integrate email/SMS notifications for transactions
- Add support for fund transfers between accounts
- Add a front-end interface using React or Angular
