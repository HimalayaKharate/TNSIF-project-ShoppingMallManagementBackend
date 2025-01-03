# Shopping Mall Management Backend

This project is a backend system for managing the operations of a shopping mall. It provides functionalities to handle various aspects such as store management, employee management, inventory control, and sales tracking.

## Features

- **Store Management**: Add, update, and remove stores within the mall.
- **Employee Management**: Manage employee records, including personal details, job information, and contact information.
- **Inventory Control**: Track products, manage stock levels, and handle product categorization.
- **Sales Tracking**: Monitor sales transactions, generate invoices, and apply discounts.
- **Customer Portal**: Allow customers to view products online, including images and prices.

## Technologies Used

- **Java**: Primary programming language.
- **Spring Boot**: Framework for building the backend application.
- **Maven**: Build automation tool.
- **MySQL**: Relational database management system for data storage.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- MySQL

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/HimalayaKharate/TNSIF-project-ShoppingMallManagementBackend.git
   ```

2. **Navigate to the project directory**:

   ```bash
   cd TNSIF-project-ShoppingMallManagementBackend
   ```

3. **Set up the database**:

   - Create a MySQL database named `shopping_mall_db`.
   - Update the database configuration in `src/main/resources/application.properties` with your MySQL credentials.

4. **Build the project**:

   ```bash
   mvn clean install
   ```

5. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

### Accessing the Application

- The backend services will be accessible at `http://localhost:8080`.
- API documentation can be accessed at `http://localhost:8080/swagger-ui.html` (if Swagger is configured).

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

This project was developed as part of the TNSIF program.

---

For more information, visit the [GitHub repository](https://github.com/HimalayaKharate/TNSIF-project-ShoppingMallManagementBackend/). 
