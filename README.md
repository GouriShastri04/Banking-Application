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

# Banking Application - Future Enhancements

These are planned improvements to make the application more robust and user-friendly:

- Add user authentication and role-based access (Admin, Customer)
- Integrate email/SMS notifications for transactions
- Add support for fund transfers between accounts
- Add a front-end interface using React

---

## **Example JSON Response**

**Account Details:**

```json
{
  "id": 1,
  "accountHolderName": "John Doe",
  "balance": 1500.0
}




